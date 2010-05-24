CREATE TABLE `UTILISATEUR` (
  `ID_UTILISATEUR` char(32) NOT NULL,
  `VERSION` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `NOM` varchar(50) NOT NULL,
  `PRENOM` varchar(50) default NULL,
  `EMAIL` varchar(100) NOT NULL,
  `ID_PROFIL` char(32) NOT NULL
)

CREATE TABLE `SUJET` (
  `ID_SUJET` BIGINT(8) NOT NULL,
  `VERSION` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `TITRE` varchar(250) NOT NULL,
  `DESCRIPTION` varchar(1000) default NULL,
  `DATE_START` DATE NOT NULL,
  `DATE_END` DATE NOT NULL,
  `NB_QUESTION_DISPLAY` int NOT NULL,
   Primary Key (ID_SUJET)
)

CREATE TABLE `QUESTION` (
  `ID_QUESTION` BIGINT(8) NOT NULL,
  `VERSION` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `LIBELLE` varchar(250) NOT NULL,
  `ID_SUJET` BIGINT(8) NOT NULL,
   Primary Key (ID_QUESTION),
   Foreign Key (ID_SUJET) references SUJET(ID_SUJET)
)

CREATE TABLE `REPONSE` (
  `ID_REPONSE` BIGINT(8) NOT NULL,
  `VERSION` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `LIBELLE` varchar(250) NOT NULL,
  `GOODRESPONSE` BOOLEAN NOT NULL default false,
  `ID_QUESTION` BIGINT(8) NOT NULL,
   Primary Key (ID_REPONSE),
   Foreign Key (ID_QUESTION) references QUESTION(ID_QUESTION)
)
-- phpMyAdmin SQL Dump
-- version 2.11.6
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- Généré le : Jeu 20 Mai 2010 à 09:34
-- Version du serveur: 5.0.51
-- Version de PHP: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Base de données: `springproject`
--

-- --------------------------------------------------------

--
-- Structure de la table `habilitation`
--

CREATE TABLE `habilitation` (
  `ID_HABILITATION` BIGINT(8) NOT NULL auto_increment,
  `VERSION` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `LIBELLE` varchar(50) NOT NULL,
  `CODE` varchar(8) NOT NULL,
  PRIMARY KEY  (`ID_HABILITATION`)
);

--
-- Contenu de la table `habilitation`
--

INSERT INTO `habilitation` (`ID_HABILITATION`, `VERSION`, `LIBELLE`, `CODE`) VALUES
('1', '2010-05-16 22:44:14', 'Créer QCM', 'C_QCM'),
('2', '2010-05-16 22:45:13', 'Modifier QCM', 'M_QCM'),
('3', '2010-05-16 22:45:31', 'Supprimer QCM', 'S_QCM'),
('4', '2010-05-16 22:46:23', 'Visualiser QCM', 'V_QCM');

-- --------------------------------------------------------

--
-- Structure de la table `profil`
--

CREATE TABLE `profil` (
  `ID_PROFIL` BIGINT(8) NOT NULL auto_increment,
  `VERSION` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `LIBELLE` varchar(50) NOT NULL,
  `CODE` int(11) NOT NULL,
  PRIMARY KEY  (`ID_PROFIL`)
);


--
-- Contenu de la table `profil`
--

INSERT INTO `profil` (`ID_PROFIL`, `VERSION`, `LIBELLE`, `CODE`) VALUES
('1', '2010-05-16 22:42:09', 'ADMINISTRATEUR', 1),
('2', '2010-05-16 22:42:27', 'UTILISATEUR', 2);

-- --------------------------------------------------------

--
-- Structure de la table `profil_habilitation`
--

CREATE TABLE `profil_habilitation` (
  `ID_PROFIL` BIGINT(8) NOT NULL,
  `ID_HABILITATION` BIGINT(8) NOT NULL,
  PRIMARY KEY  (`ID_PROFIL`,`ID_HABILITATION`),
  KEY `ID_HABILITATION` (`ID_HABILITATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `profil_habilitation`
--

INSERT INTO `profil_habilitation` (`ID_PROFIL`, `ID_HABILITATION`) VALUES
('1', '1'),
('1', '2'),
('1', '3'),
('1', '4'),
('2', '4');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `profil_habilitation`
--
ALTER TABLE `profil_habilitation`
  ADD CONSTRAINT `profil_habilitation_ibfk_1` FOREIGN KEY (`ID_PROFIL`) REFERENCES `profil` (`ID_PROFIL`),
  ADD CONSTRAINT `profil_habilitation_ibfk_2` FOREIGN KEY (`ID_HABILITATION`) REFERENCES `habilitation` (`ID_HABILITATION`),
  ADD CONSTRAINT `profil_habilitation_ibfk_3` FOREIGN KEY (`ID_PROFIL`) REFERENCES `profil` (`ID_PROFIL`);

  CREATE TABLE `utilisateur` (
  `ID_UTILISATEUR` bigint(8) NOT NULL auto_increment,
  `VERSION` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `NOM` varchar(50) NOT NULL,
  `PRENOM` varchar(50) default NULL,
  `EMAIL` varchar(100) NOT NULL,
  `PHOTO` blob,
  `PASSWORD` varchar(8) NOT NULL,
  `ID_PROFIL` bigint(8) NOT NULL,
  PRIMARY KEY  (`ID_UTILISATEUR`),
  KEY `ID_PROFIL` (`ID_PROFIL`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`ID_UTILISATEUR`, `VERSION`, `NOM`, `PRENOM`, `EMAIL`, `PHOTO`, `PASSWORD`, `ID_PROFIL`) VALUES
(1, '2010-05-17 16:20:27', 'GUIGARD', 'Mathieu', 'guigard.mathieu@gmail.com', NULL, '1404', '1');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `utilisateur_ibfk_1` FOREIGN KEY (`ID_PROFIL`) REFERENCES `profil` (`ID_PROFIL`);

  CREATE TABLE `PARTICIPATION` (
  `ID_PARTICIPATION` BIGINT(8) NOT NULL,
  `VERSION` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `ID_SUJET` BIGINT(8) NOT NULL,
  `ID_UTILISATEUR` BIGINT(8) NOT NULL,
   Primary Key (ID_PARTICIPATION),
   Foreign Key (ID_SUJET) references SUJET(ID_SUJET),
   Foreign Key (ID_UTILISATEUR) references UTILISATEUR(ID_UTILISATEUR)
)
CREATE TABLE `PARTICPATION_REPONSE` (
  `ID_PARTICIPATION` BIGINT(8) NOT NULL,
  `ID_REPONSE` BIGINT(8) NOT NULL,
   Primary Key (ID_PARTICIPATION, ID_REPONSE),
   Foreign Key (ID_PARTICIPATION) references PARTICIPATION(ID_PARTICIPATION),
   Foreign Key (ID_REPONSE) references REPONSE(ID_REPONSE)
)