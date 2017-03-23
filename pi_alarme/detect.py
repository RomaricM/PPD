#! /usr/bin/python

#import httplib
import os, socket, ftplib
from time import sleep

NumCamera = '3'
IP = '172.19.36.93'
Port = 8520

IP_FTP = '172.19.33.241'
UserFTP = 'daemon'
PasswordFTP = 'xampp'
Delai_Camera = 20

#Ouverture du fichier previous pour savoir l'alerte precedente
prevFic = open('previous','r')
prev = prevFic.read()
prevFic.close()

#Recherche de l'alerte actuelle
cmd = os.popen('ls -t /tmp/*.avi')
actu = cmd.read()

if actu != prev:
	fic = open('previous','w')
	fic.write(actu)
	fic.close()

	# Alerte vers carte Arduino+Pi
	print 'Envoi detection carte pi+arduino'
	sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
	sock.connect((IP, Port))
	sock.send(NumCamera)
	### h = httplib.HTTPConnection(IP + '/capteur/alerte/' + NumCapteur)

	# Envoi vers FTP
	sleep(Delai_Camera) # On attend que la video se termine
	video_envoi = actu.split()[0]
	print 'Envoi de ' + video_envoi + ' au serveur ftp'
	ftp = ftplib.FTP(IP_FTP)
	ftp.login(UserFTP, PasswordFTP)
	ftp.cwd('ppdSite/ftp_camera')

	fic = open(video_envoi, 'rb')
	ftp.storbinary('STOR '+video_envoi[5:], fic)
	fic.close()
	ftp.close()
