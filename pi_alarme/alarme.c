#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include <unistd.h>
#include <errno.h>
#include <sys/poll.h>
#include <wiringSerial.h>

#include "capt.h"

#define NB_CAM 1
#define DELAI_SORTIE 3
#define DELAI_ENTREE 3
#define DELAI_SIRENE 5

enum EtatAlarme {
	DESACTIVE,
	SURVEILLANCE,
	ALERTE,
	TEMP_SORTIE,
	TEMP_ENTREE,
	TEMP_SIRENE
};

struct Zone {
	int maskCapt[NB_CAPT + NB_CAM];
};

/* TODO ~OK
	serveur socket pour connexion camera
	a chaque connexion mettre a DETECT capteurs[CAM]
	pour une duree de ~30s
	-> faire un thread qui sleep(30);

	TODO
	dans le python l'envoi j'ai capte un truc -- OK
	plus envoi image ou video
	a moins que ftp et fichier recupere que si alerte confirmee
*/

int zoneDetect(char capteurs[], struct Zone zone);

int main() {
	enum EtatAlarme etat = DESACTIVE;
	char capteurs[NB_CAPT + NB_CAM], etatChar;
	int i, nbblc = 0, serial = serialOpen("/dev/ttyAMA0", 9600);
	time_t tpsPrev, tpsActu;

	int tubeCam[2], tubeCapt[2];//, nbCharLus;
	char chtube[10], chserial[10], msg[25], lgMsg;
	struct pollfd pollTubes[2];

	pipe(tubeCapt);
	pipe(tubeCam);

	if (fork() == 0) {
		close(tubeCam[0]); // fermeture tubeCam en lecture dans le fils
		sprintf(chtube , "%d", tubeCam[1]); // int -> char
		execl("./recepcam", "recepcam", chtube, NULL);
	}
	if (fork() == 0) {
		close(tubeCapt[0]);
		sprintf(chtube, "%d", tubeCapt[1]);
		sprintf(chserial, "%d", serial);
		execl("./capteurs", "capteurs", chtube, chserial, NULL);
	}

	close(tubeCam[1]);
	close(tubeCapt[1]);

	struct Zone zoneBouton = {{1, 0, 0, 0}},
		zonePorte = {{0, 1, 0, 0}},
		zoneInterne = {{0, 0, 1, 1}};

	while (1) {
		if (!(nbblc++ % 40))
			fprintf(stderr, "boucle\n");


		pollTubes[0].fd = tubeCapt[0];
		pollTubes[0].events = POLLIN;
		pollTubes[1].fd = tubeCam[0];
		pollTubes[1].events = POLLIN;

		poll(pollTubes, 2, -1);

		// Message sur tubeCapt
		if (pollTubes[0].revents & POLLIN) {
			read(tubeCapt[0], msg, NB_CAPT);
			for (i = 0; i < NB_CAPT; ++i) {
				capteurs[i] = msg[i];
			}
		}
		// Message sur tubeCam
		if (pollTubes[1].revents & POLLIN) {
			read(tubeCam[0], &lgMsg, 1);
			read(tubeCam[0], msg, lgMsg);
			sscanf(msg, "%d %c", &i, &etatChar);
			capteurs[i] = etatChar;
			fprintf(stderr, "camera capteurs[%d] = '%c'\n", i, etatChar);
		}

		switch (etat) {
		case DESACTIVE:
			if (zoneDetect(capteurs, zoneBouton) > 0) {
				etat = TEMP_SORTIE;
				printf("Sortie\n");
				tpsPrev = 0;
			}
			break;

		case SURVEILLANCE:
			if (zoneDetect(capteurs, zoneBouton) > 0) {
				etat = DESACTIVE;
				printf("Desactive\n");
			}
			// Temporisation d'entree si la porte est ouverte
			else if (zoneDetect(capteurs, zonePorte) > 0) {
				etat = TEMP_ENTREE; 
				printf("Entree\n");
				tpsPrev = 0;
			}
			// Alerte si au moins 2 capteurs internes sont enclenches
			else if (zoneDetect(capteurs, zoneInterne) >= 2) {
				etat = ALERTE; 
				printf("Alerte\n");
			}
			break;

		case ALERTE:
			if (zoneDetect(capteurs, zoneBouton) > 0) {
				etat = DESACTIVE;
				printf("Desactive\n");
			}
			// TODO Envoyer alerte au site
			system("python envoiAlerte.py");
			etat = TEMP_SIRENE;
			printf("Sirene\n");
			tpsPrev = 0;
			break;

		case TEMP_SORTIE:
			if (zoneDetect(capteurs, zoneBouton) > 0) {
				etat = DESACTIVE;
				printf("Desactive\n");
			}
			else if (tpsPrev == 0) {
				tpsPrev = time(NULL);
				tpsActu = time(NULL);
			}
			else if (tpsActu - tpsPrev < DELAI_SORTIE) {
				tpsActu = time(NULL);
			}
			else {
				etat = SURVEILLANCE;
				printf("Surveillance\n");
			}
			break;

		case TEMP_ENTREE:
			if (tpsPrev == 0) {
				tpsPrev = time(NULL);
				tpsActu = time(NULL);
			}
			else if (tpsActu - tpsPrev < DELAI_ENTREE) {
				if (zoneDetect(capteurs, zoneBouton) > 0) {
					etat = DESACTIVE;
					printf("Desactive\n");
				} else {
					tpsActu = time(NULL);
				}
			}
			else {
				etat = ALERTE;
				printf("Alerte\n");
			}
			break;

		case TEMP_SIRENE:
			if (zoneDetect(capteurs, zoneBouton) > 0) {
				etat = DESACTIVE;
				printf("Desactive\n");
			}
			else if (tpsPrev == 0) {
				tpsPrev = time(NULL);
				tpsActu = time(NULL);
			}
			else if (tpsActu - tpsPrev < DELAI_SIRENE) {
				tpsActu = time(NULL);
			}
			else {
				etat = SURVEILLANCE;
				printf("Surveillance\n");
			}
			break;

		default:
			break;
		}

		serialFlush(serial);
		if (etat == DESACTIVE) {
			serialPutchar(serial, 'D');
		} else if (etat == SURVEILLANCE) {
			serialPutchar(serial, 'S');
		} else if (etat == TEMP_SIRENE) {
			serialPutchar(serial, '^');
		} else if (etat == TEMP_SORTIE) {
			serialPutchar(serial, 'O');
		} else if (etat == TEMP_ENTREE) {
			serialPutchar(serial, 'E');
		} else {
			serialPutchar(serial, 'A');
		}
	}

	close(tubeCam[0]);
	close(tubeCapt[0]);
	serialClose(serial);

	return 0;
}

int zoneDetect(char capteurs[], struct Zone zone) {
	int nbDetection = 0, i;

	for (i = 0; i < NB_CAPT + NB_CAM; ++i) {
		nbDetection += ((capteurs[i] == CAPT_DETECT) && zone.maskCapt[i]);
	}

	return nbDetection;
}
