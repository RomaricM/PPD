#include <sys/types.h>
#include <errno.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <wiringSerial.h>

#include "capt.h"

void lireCapteurs(char capteurs[], int serial);
void attendreFinBut1(char capteurs[], int serial);

int main(int nbarg, char *tbarg[]) {
	char capteurs[NB_CAPT];
	int tube, serial;

	//Récupération de tube et serial passés en argument
	sscanf(tbarg[1], "%d", &tube);
	sscanf(tbarg[2], "%d", &serial);
	
	printf("capteurs s'exec\n");

	while (1) {
		lireCapteurs(capteurs, serial);
		if (capteurs[BUT1] == CAPT_DETECT) {
			write(tube, capteurs, NB_CAPT);
			attendreFinBut1(capteurs, serial);
		}
		write(tube, capteurs, NB_CAPT);
	}

	serialClose(serial);
}

void lireCapteurs(char capteurs[], int serial) {
	int i;
	char etatChar;

	// Pour alignement avec saut de ligne
	do {
		etatChar = serialGetchar(serial);
	} while (etatChar != '\n');

	for (i = 0; i < NB_CAPT; ++i) {
		capteurs[i] = serialGetchar(serial);
	}
}

void attendreFinBut1(char capteurs[], int serial) {
	while (capteurs[BUT1] == CAPT_DETECT) {
		lireCapteurs(capteurs, serial);
	}
	printf("Fin attente bouton 1\n");
}

