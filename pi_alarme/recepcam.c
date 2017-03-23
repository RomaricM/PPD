#include <sys/types.h>
#include <errno.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

#include <sys/socket.h>
#include <netinet/in.h> // pour struct sockaddr_in
#include <arpa/inet.h> // pour htons et inet_aton

#include "capt.h"

#define PORT 8520
#define DUREE_CAMERA 20

void traitementCamera(int socket, int tube);

int main(int nbarg, char *tbarg[]) {
	int tube;
	sscanf(tbarg[1], "%d", &tube); // On récupère tube

	int socketEcoute, socketConnectee;
	struct sockaddr_in adresse; // adresse d’attachement locale
	socklen_t longueurAdr;

	socketEcoute = socket(AF_INET, SOCK_STREAM, 0);
	if(socketEcoute < 0) {
		perror("socket");
		exit(-1);
	}
	printf("Socket creee avec succes ! (%d)\n", socketEcoute);

	// On prépare l’adresse d’attachement locale
	longueurAdr = sizeof(struct sockaddr_in);
	memset(&adresse, 0x00, longueurAdr);
	adresse.sin_family = AF_INET;
	adresse.sin_addr.s_addr = htonl(INADDR_ANY);
	adresse.sin_port = htons(PORT);

	// On demande l’attachement local de la socket
	if (( bind(socketEcoute, (struct sockaddr*) &adresse, longueurAdr) ) < 0) {
		perror("bind");
		exit(-2);
	}
	printf("Socket attachee avec succes !\n");

	// La taille de la file d’attente est fixee a 5
	if (listen(socketEcoute, 5) < 0) {
		perror("listen");
		exit(-3);
	}
	printf("Socket placee en ecoute passive ...\n");
	while (1) {
		socketConnectee = accept(socketEcoute, (struct sockaddr*) &adresse, &longueurAdr);
		switch (fork()) {
		case 0 : //fils
			close(socketEcoute);
			traitementCamera(socketConnectee, tube);
			exit(EXIT_SUCCESS);
		case -1 :
			perror("fork");
			return(-1);
		default : //pere
			close(socketConnectee);
		}
	}

	// On ferme la ressource avant de quitter
	close(socketEcoute);
	close(tube);
}

void traitementCamera(int socket, int tube) {
	char msgCamRecep[25], msgProg[25], lgMsg;
	int numeroCam;
	lgMsg = read(socket, msgCamRecep, 24);
	//msgCamRecep[lgMsg] = '\0';
	sscanf(msgCamRecep, "%d", &numeroCam);

	sprintf(msgProg, "%d %c", numeroCam, CAPT_DETECT);
	printf("camera deb : %s\n", msgProg);
	
	lgMsg = strlen(msgProg);
	write(tube, &lgMsg, 1);
	if (write(tube, msgProg, strlen(msgProg)) < 0) {
		printf("err write\n");
	}

	sleep(DUREE_CAMERA);

	sprintf(msgProg, "%d %c", numeroCam, CAPT_NODETECT);
	printf("camera fin : %s\n", msgProg);
	lgMsg = strlen(msgProg);
	write(tube, &lgMsg, 1);
	write(tube, msgProg, strlen(msgProg));
}

