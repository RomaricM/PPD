[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

![Logo de PPD](https://raw.githubusercontent.com/Ciramort/PPD/master/ressources/images/logos_ppd/logo_ppd_v1.png)

# À propos

## Les alarmes

Une alarme est un mécanisme permettant d’avertir d’un éventuel danger. Il existe divers types d’alarmes. Dans notre projet, l’alarme est capable de repérer une infraction : on parlera donc d’alarme anti-infraction. En effet, une alerte est déclenchée grâce à quelques dispositifs tels qu’un détecteur de mouvement, un détecteur infrarouge et un détecteur d’ouverture de porte. Le fait de mettre plusieurs moyens de détection d’intrusion pour notre alarme permet de rendre l’alerte plus précise et correcte : avoir moins de fausse alerte.

Dans notre projet, il s’agit d’une alarme distribuée. Autrement dit, il peut y avoir plusieurs alarmes et elles sont toutes indépendantes les unes des autres. De ce fait, il est possible d’ajouter ou enlever des alarmes sans que cela engendre des problèmes éventuels.

## Les nano-ordinateurs

### Raspberry Pi

Les progrès en miniaturisation nous permettent, depuis peu, d’équiper des systèmes monocarte de composants développant une puissance considérable. Ainsi, il est possible de créer de véritables nano-ordinateurs pouvant accueillir un système d’exploitation. Par conséquent, il est possible d’utiliser les couches réseau ou de gérer des entrées/sorties.

La démocratisation des appareils connectés et systèmes embarqués découle directement de cette montée en puissance des nanosystèmes. Depuis peu, il est même possible d’acquérir dans le commerce des nano-ordinateurs monocartes fonctionnant généralement avec un processeur ARM.

Le Raspberry Pi (voir figure 1) faisant la taille d’une carte de crédit se présente comme tel. Il a été conçu par le créateur de jeux vidéo David Braben pour sa fondation caritative du même nom. Les premiers prototypes sont développés à partir de 2006, et la sortie officielle du Raspberry Pi date de février 2012.

La version A proposait une mémoire vive de 256 Mo tandis que la version B offre désormais 512 Mo. Cet ordinateur permet l’exécution de plusieurs variantes du système d’exploitation libre GNU/Linux et des logiciels compatibles.

De base, le Raspberry Pi est fourni sans boîtier, alimentation, clavier, souris, ni écran. Ceci dans le but de minimiser les couts et de pouvoir recycler d'autres matériels. Mais sa puissance (ARM 700 MHz) et sa connectique diversifiée (2xUSB 2, HDMI, RCA, Ethernet, E/S GPIO…) en font un nano-ordinateur apte à supporter de nombreuses utilisations.

Offrant des fonctionnalités et une taille parfaite pour notre projet d’alarme distribuée, nous avons donc utilisé le Raspberry Pi.

### Arduino

Tout autant rattachées aux systèmes embarqués, mais pas dotés des mêmes fonctionnalités, certaines cartes permettent d’étendre les applications réalisables avec des nano-ordinateurs. C’est le cas pour l’Arduino que nous utilisons également dans notre projet.

Arduino est un projet créé par une équipe de développeurs, composée de six individus. Cette équipe a créé le "système Arduino". C’est un circuit intégré contenant principalement un microcontrôleur qu’il est possible de programmer pour analyser et produire des signaux électriques afin de créer des systèmes électriques plus ou moins complexes.

Le système Arduino permet de réaliser un grand nombre d’applications dans de nombreux domaines :

- Contrôler les appareils domestiques
- Fabriquer votre propre robot
- Faire un jeu de lumière
- Communiquer avec l'ordinateur
- Concevoir un système d’alarme
- Télécommander un appareil mobile (modélisme)

Son prix abordable, sa flexibilité, et la communauté gigantesque autour d’Arduino en font une carte agréable à utiliser et tout à fait adaptée à notre concept d’alarme distribuée.
