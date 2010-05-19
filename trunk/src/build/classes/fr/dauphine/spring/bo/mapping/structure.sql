CREATE TABLE `UTILISATEUR` (
  `ID_UTILISATEUR` char(32) NOT NULL,
  `VERSION` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `NOM` varchar(50) NOT NULL,
  `PRENOM` varchar(50) default NULL,
  `EMAIL` varchar(100) NOT NULL,
  `ID_PROFIL` char(32) NOT NULL
)