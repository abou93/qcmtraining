CREATE TABLE `UTILISATEUR` (
  `ID_UTILISATEUR` char(32) NOT NULL,
  `VERSION` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `NOM` varchar(50) NOT NULL,
  `PRENOM` varchar(50) default NULL,
  `EMAIL` varchar(100) NOT NULL,
  `ID_PROFIL` char(32) NOT NULL
)

CREATE TABLE `SUJET` (
  `ID_SUJET` char(32) NOT NULL,
  `VERSION` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `TITRE` varchar(250) NOT NULL,
  `DESCRIPTION` varchar(1000) default NULL,
  `DATE_START` DATE NOT NULL,
  `DATE_END` DATE NOT NULL,
   Primary Key (ID_SUJET)
)

CREATE TABLE `QUESTION` (
  `ID_QUESTION` char(32) NOT NULL,
  `VERSION` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `LIBELLE` varchar(250) NOT NULL,
  `ID_SUJET` char(32) NOT NULL,
   Primary Key (ID_QUESTION),
   Foreign Key (ID_SUJET) references SUJET(ID_SUJET)
)

CREATE TABLE `REPONSE` (
  `ID_REPONSE` char(32) NOT NULL,
  `VERSION` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `LIBELLE` varchar(250) NOT NULL,
  `GOODRESPONSE` BOOLEAN NOT NULL default false,
  `ID_QUESTION` char(32) NOT NULL,
   Primary Key (ID_REPONSE),
   Foreign Key (ID_QUESTION) references QUESTION(ID_QUESTION)
)