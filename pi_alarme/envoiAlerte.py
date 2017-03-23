#! /usr/bin/python

import urllib, sys

IP = '172.19.33.241'
IdUser = '1'
Capt = '1'

import urllib
params = urllib.urlencode({'id_user': IdUser, 'num_capteur': Capt})
f = urllib.urlopen("http://" + IP + "/ppdSite/index.php/alerte", params)

print('alerte (user:'+ IdUser + ', capt:' + Capt + ') envoyee au site')
print f.read()

#h = httplib.HTTPConnection(IP + '/capteur/alerte/' + *lesparams*)
