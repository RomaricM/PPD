DROP TABLE UTILISATEUR CASCADE CONSTRAINT PURGE;
DROP TABLE APPAREIL CASCADE CONSTRAINT PURGE;
DROP TABLE ALERTE CASCADE CONSTRAINT PURGE;

CREATE TABLE UTILISATEUR (
	NoUtilisateur INTEGER CONSTRAINT pk_UTILISATEUR PRIMARY KEY,
	Login VARCHAR(30) NOT NULL,
	Mdp VARCHAR(30) NOT NULL,
	Email VARCHAR(50) NOT NULL,
	alertMail INTEGER CHECK (alertMail = 0 OR alertMail = 1),
	alertAppli INTEGER CHECK (alertAppli = 0 OR alertAppli = 1)
);

CREATE TABLE APPAREIL (
	NoApp INTEGER CONSTRAINT pk_Appareil PRIMARY KEY,
	Marque VARCHAR(30) NOT NULL, 
	Modele VARCHAR(30) NOT NULL, 
	Active INTEGER CHECK (Active = 0 OR Active = 1), 
	TypeApp VARCHAR(30) CHECK (TypeApp = 'Camera' OR TypeApp = 'Infrarouge'),
	NoUtilisateur INTEGER
);

CREATE TABLE ALERTE (
	NoAlerte INTEGER CONSTRAINT pk_ALERTE PRIMARY KEY,
	DateAlerte DATETIME,
	NoUtilisateur INTEGER,
	NoApp INTEGER
);

CREATE TABLE IMAGEALERTE (
	NoAlerte INTEGER,
	Image VARCHAR2(50)
);


ALTER TABLE APPAREIL 
	ADD CONSTRAINT fk_NoUtilisateur_Appareil
	FOREIGN KEY(NoUtilisateur) 
	REFERENCES UTILISATEUR(NoUtilisateur)
	ON DELETE CASCADE;
/

ALTER TABLE ALERTE
	ADD CONSTRAINT fk_NoUtilisateur_Alerte 
	FOREIGN KEY(NoUtilisateur) 
	REFERENCES UTILISATEUR(NoUtilisateur)
	ON DELETE CASCADE;

ALTER TABLE ALERTE
	ADD CONSTRAINT fk_NoApp_Alerte
	FOREIGN KEY(NoApp) 
	REFERENCES APPAREIL(NoApp)
	ON DELETE CASCADE;
/

ALTER TABLE IMAGEALERTE
	ADD CONSTRAINT fk_NoAlerte_ImageAlerte
	FOREIGN KEY(NoAlerte) 
	REFERENCES ALERTE(NoAlerte)
	ON DELETE CASCADE;
ALTER TABLE IMAGEALERTE
	ADD CONSTRAINT pk_ImageAlerte
	PRIMARY KEY IMAGEALERTE(NoAlerte, Image)
	ON DELETE CASCADE;
/



DROP SEQUENCE seqUtil;
CREATE SEQUENCE seqUtil START WITH 0 INCREMENT BY 1 MINVALUE 0;

DROP SEQUENCE seqApp;
CREATE SEQUENCE seqApp START WITH 0 INCREMENT BY 1 MINVALUE 0;

DROP SEQUENCE seqAlerte;
CREATE SEQUENCE seqAlerte START WITH 0 INCREMENT BY 1 MINVALUE 0;


insert into UTILISATEUR (NoUtilisateur, Login, Mdp, Email, alertMail,alertAppli ) 
values (seqUtil.nextVal, 'ppd', 'ppd', 'ppd@gmail.fr', 0, 1); 
/* Test de contraintes : Ne Doit pas marcher */
insert into UTILISATEUR (NoUtilisateur, Login, Mdp, Email, alertMail,alertAppli ) 
values (seqUtil.nextVal, 'ppd', 'ppd', 'ppd@gmail.fr', 2, 1); 

insert into APPAREIL(NoApp, Marque, Modele, NoUtilisateur, Active) values (seqApp.nextVal, 'logitec', 'p48rn', 0, 1);
/* Test de contraintes : Ne Doit pas marcher */
insert into APPAREIL(NoApp, Marque, Modele, NoUtilisateur, Active) values (seqApp.nextVal, 'logitec', 'p49rn', 0, 8);
insert into APPAREIL(NoApp, Marque, Modele, NoUtilisateur, Active) values (seqApp.nextVal, 'logitec', 'p49rn', 8000, 8);


insert into ALERTE(NoAlerte, DateAlerte, NoUtilisateur, NoApp) values (seqAlerte.nextVal, '2013-02-12 22:31:42', 0, 0);
insert into ALERTE(NoAlerte, DateAlerte, NoUtilisateur, NoApp) values (seqAlerte.nextVal, '2013-02-12 23:00:00', 0, 0);
insert into ALERTE(NoAlerte, DateAlerte, NoUtilisateur, NoApp) values (seqAlerte.nextVal, '2013-02-16 06:00:00', 0, 0);
/* Test de contraintes : Ne Doit pas marcher car utilisateur n°1 et camera n°1 n'existe pas */
insert into ALERTE(NoAlerte, DateAlerte, HeureAlerte, NoUtilisateur, NoApp) values (seqAlerte.nextVal, '2013-02-19 19:00:00', 1, 0);
insert into ALERTE(NoAlerte, DateAlerte, HeureAlerte, NoUtilisateur, NoApp) values (seqAlerte.nextVal, '2013-02-19 19:00:00', 0, 1);

/* Création d'un trigger pour empêcher que alertAppli et alertMail n'est pas la même valeur */
CREATE OR REPLACE TRIGGER T_Utilisateur BEFORE INSERT OR UPDATE ON UTILISATEUR
FOR EACH ROW
BEGIN
	IF :NEW.alertMail = 0 AND :NEW.alertAppli = 0
	THEN raise_application_error(-20001, 'On ne peut pas désactiver les 2 modes dalertes !!!!');
	END IF;
END;
/

/* Test du trigger */

insert into UTILISATEUR (NoUtilisateur, Login, Mdp, Email, alertMail, alertAppli) 
values (seqUtil.nextVal, 'ppderror', 'ppderror', 'ppderror@gmail.fr', 0, 0); /* Marche pas*/
update UTILISATEUR SET alertAppli = 0 WHERE NoUtilisateur = 0; /* Marche pas*/
