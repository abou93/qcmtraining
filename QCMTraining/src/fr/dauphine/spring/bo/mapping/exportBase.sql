-- phpMyAdmin SQL Dump
-- version 2.11.6
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- Généré le : Mar 25 Mai 2010 à 18:42
-- Version du serveur: 5.0.51
-- Version de PHP: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Base de données: `springproject`
--

-- --------------------------------------------------------

--
-- Structure de la table `category`
--

CREATE TABLE `category` (
  `ID_CATEGORY` bigint(8) NOT NULL,
  `VERSION` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `LIBELLE` varchar(50) NOT NULL,
  PRIMARY KEY  (`ID_CATEGORY`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `category`
--

INSERT INTO `category` (`ID_CATEGORY`, `VERSION`, `LIBELLE`) VALUES
(1, '2010-05-25 13:09:45', 'Cinéma'),
(2, '2010-05-25 13:14:17', 'Histoire'),
(3, '2010-05-25 13:14:17', 'Jeux Vidéo'),
(4, '2010-05-25 13:14:17', 'Cuisine'),
(5, '2010-05-25 13:14:17', 'Musique'),
(6, '2010-05-25 13:14:17', 'Sport'),
(7, '2010-05-25 13:14:17', 'Séries TV'),
(8, '2010-05-25 13:14:17', 'People');

-- --------------------------------------------------------

--
-- Structure de la table `habilitation`
--

CREATE TABLE `habilitation` (
  `ID_HABILITATION` bigint(8) NOT NULL auto_increment,
  `VERSION` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `LIBELLE` varchar(50) NOT NULL,
  `CODE` varchar(8) NOT NULL,
  PRIMARY KEY  (`ID_HABILITATION`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `habilitation`
--

INSERT INTO `habilitation` (`ID_HABILITATION`, `VERSION`, `LIBELLE`, `CODE`) VALUES
(1, '2010-05-16 22:44:14', 'Créer QCM', 'C_QCM'),
(2, '2010-05-16 22:45:13', 'Modifier QCM', 'M_QCM'),
(3, '2010-05-16 22:45:31', 'Supprimer QCM', 'S_QCM'),
(4, '2010-05-16 22:46:23', 'Visualiser QCM', 'V_QCM');

-- --------------------------------------------------------

--
-- Structure de la table `participation`
--

CREATE TABLE `participation` (
  `ID_PARTICIPATION` bigint(8) NOT NULL,
  `VERSION` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `ID_SUJET` bigint(8) NOT NULL,
  `ID_UTILISATEUR` bigint(8) NOT NULL,
  PRIMARY KEY  (`ID_PARTICIPATION`),
  KEY `ID_SUJET` (`ID_SUJET`),
  KEY `ID_UTILISATEUR` (`ID_UTILISATEUR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `participation`
--

INSERT INTO `participation` (`ID_PARTICIPATION`, `VERSION`, `ID_SUJET`, `ID_UTILISATEUR`) VALUES
(1, '2010-05-24 12:57:20', 1, 1),
(2, '2010-05-24 21:31:02', 1, 2),
(3, '2010-05-25 00:22:47', 3, 2),
(5, '2010-05-25 14:29:31', 4, 2),
(6, '2010-05-25 17:51:34', 2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `particpation_reponse`
--

CREATE TABLE `particpation_reponse` (
  `ID_PARTICIPATION` bigint(8) NOT NULL,
  `ID_REPONSE` bigint(8) NOT NULL,
  PRIMARY KEY  (`ID_PARTICIPATION`,`ID_REPONSE`),
  KEY `ID_REPONSE` (`ID_REPONSE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `particpation_reponse`
--

INSERT INTO `particpation_reponse` (`ID_PARTICIPATION`, `ID_REPONSE`) VALUES
(2, 1),
(1, 4),
(2, 5),
(2, 13),
(1, 24),
(1, 28),
(1, 36),
(2, 36),
(2, 38),
(1, 40),
(6, 43),
(3, 47),
(5, 51);

-- --------------------------------------------------------

--
-- Structure de la table `profil`
--

CREATE TABLE `profil` (
  `ID_PROFIL` bigint(8) NOT NULL auto_increment,
  `VERSION` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `LIBELLE` varchar(50) NOT NULL,
  `CODE` int(11) NOT NULL,
  PRIMARY KEY  (`ID_PROFIL`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `profil`
--

INSERT INTO `profil` (`ID_PROFIL`, `VERSION`, `LIBELLE`, `CODE`) VALUES
(1, '2010-05-16 22:42:09', 'ADMINISTRATEUR', 1),
(2, '2010-05-16 22:42:27', 'UTILISATEUR', 2);

-- --------------------------------------------------------

--
-- Structure de la table `profil_habilitation`
--

CREATE TABLE `profil_habilitation` (
  `ID_PROFIL` bigint(8) NOT NULL,
  `ID_HABILITATION` bigint(8) NOT NULL,
  PRIMARY KEY  (`ID_PROFIL`,`ID_HABILITATION`),
  KEY `ID_HABILITATION` (`ID_HABILITATION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `profil_habilitation`
--

INSERT INTO `profil_habilitation` (`ID_PROFIL`, `ID_HABILITATION`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(2, 4);

-- --------------------------------------------------------

--
-- Structure de la table `question`
--

CREATE TABLE `question` (
  `ID_QUESTION` bigint(8) NOT NULL auto_increment,
  `VERSION` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `LIBELLE` varchar(250) NOT NULL,
  `ID_SUJET` bigint(8) NOT NULL,
  PRIMARY KEY  (`ID_QUESTION`),
  KEY `ID_SUJET` (`ID_SUJET`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Contenu de la table `question`
--

INSERT INTO `question` (`ID_QUESTION`, `VERSION`, `LIBELLE`, `ID_SUJET`) VALUES
(1, '2010-05-24 11:41:20', 'Qui est la bête dans La Belle et la Bête de Jean Cocteau ?', 1),
(2, '2010-05-24 11:41:20', 'Qui est ', 1),
(3, '2010-05-24 11:41:20', 'Qui a dit bizarre ?', 1),
(4, '2010-05-24 11:41:20', 'Qui est-ce qui a une ', 1),
(5, '2010-05-24 11:41:20', 'Qui est le garde-chasse dans La Règle du Jeu, de Jean Renoir ?', 1),
(6, '2010-05-24 11:41:20', 'Dans quel film de Bunuel cet acteur joue-t-il également ?', 1),
(7, '2010-05-24 11:41:20', 'Qui travaille Quai des orfèvres ?', 1),
(8, '2010-05-24 11:41:20', 'De qui est l''Atalante ?', 1),
(9, '2010-05-24 11:41:20', 'Qui est clochard dans Boudu Sauvé des Eaux et le devient à la fin de La Chienne, deux films de Jean Renoir ?', 1),
(10, '2010-05-24 11:41:20', 'Qui a écrit les dialogues de Quai des Brumes, de Marcel Carné ?', 1),
(11, '2010-05-24 13:17:50', 'Ingrédient du pain', 2),
(12, '2010-05-25 00:22:25', 'Ingrédient du pain', 3),
(13, '2010-05-25 14:14:32', 'Question test category', 4),
(14, '2010-05-25 14:28:02', 'Question test category', 5),
(15, '2010-05-25 14:31:04', 'Meilleur Jeux sur PS3', 6);

-- --------------------------------------------------------

--
-- Structure de la table `reponse`
--

CREATE TABLE `reponse` (
  `ID_REPONSE` bigint(8) NOT NULL auto_increment,
  `VERSION` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `LIBELLE` varchar(250) NOT NULL,
  `GOODRESPONSE` tinyint(1) NOT NULL default '0',
  `ID_QUESTION` bigint(8) NOT NULL,
  PRIMARY KEY  (`ID_REPONSE`),
  KEY `ID_QUESTION` (`ID_QUESTION`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=61 ;

--
-- Contenu de la table `reponse`
--

INSERT INTO `reponse` (`ID_REPONSE`, `VERSION`, `LIBELLE`, `GOODRESPONSE`, `ID_QUESTION`) VALUES
(1, '2010-05-24 11:41:20', 'Jean Marais', 0, 1),
(2, '2010-05-24 11:41:20', 'Jean Rochefort', 1, 1),
(3, '2010-05-24 11:41:20', 'Jean Gabin', 0, 1),
(4, '2010-05-24 11:41:20', 'Mathieu', 0, 1),
(5, '2010-05-24 11:41:20', 'Michel Simon', 0, 2),
(6, '2010-05-24 11:41:20', 'Simone Renant', 0, 2),
(7, '2010-05-24 11:41:20', 'Simone Signoret', 1, 2),
(8, '2010-05-24 11:41:20', 'Mathieu', 0, 2),
(9, '2010-05-24 11:41:20', 'Louis Jouvet', 0, 3),
(10, '2010-05-24 11:41:20', 'Michel Simon', 1, 3),
(11, '2010-05-24 11:41:20', 'Jean-Louis Barrault', 0, 3),
(12, '2010-05-24 11:41:20', 'Mathieu', 0, 3),
(13, '2010-05-24 11:41:20', 'Arletty', 0, 4),
(14, '2010-05-24 11:41:20', 'Louis Jouvet', 0, 4),
(15, '2010-05-24 11:41:20', 'Paulette Dubost', 1, 4),
(16, '2010-05-24 11:41:20', 'Mathieu', 0, 4),
(17, '2010-05-24 11:41:20', 'Marcel Dalio', 0, 5),
(18, '2010-05-24 11:41:20', 'Carette', 0, 5),
(19, '2010-05-24 11:41:20', 'Gaston Modot', 0, 5),
(20, '2010-05-24 11:41:20', 'Thierry', 1, 5),
(21, '2010-05-24 11:41:20', 'Un chien Andalou', 1, 6),
(22, '2010-05-24 11:41:20', 'L''âge d''or', 0, 6),
(23, '2010-05-24 11:41:20', 'La Voie Lactée', 0, 6),
(24, '2010-05-24 11:41:20', 'Paris', 0, 6),
(25, '2010-05-24 11:41:20', 'Louis Jouvet', 0, 7),
(26, '2010-05-24 11:41:20', 'Michel Simon', 0, 7),
(27, '2010-05-24 11:41:20', 'Jean Gabin', 1, 7),
(28, '2010-05-24 11:41:20', 'Le Pape', 0, 7),
(29, '2010-05-24 11:41:20', 'Jean Vigo', 0, 8),
(30, '2010-05-24 11:41:20', 'Jean Epstein', 1, 8),
(31, '2010-05-24 11:41:20', 'Jean Renoir', 0, 8),
(32, '2010-05-24 11:41:20', 'Moi', 0, 8),
(33, '2010-05-24 11:41:20', 'Serge Reggiani', 0, 9),
(34, '2010-05-24 11:41:20', 'Jean-Louis Barrault', 0, 9),
(35, '2010-05-24 11:41:20', 'Michel Simon', 0, 9),
(36, '2010-05-24 11:41:20', 'Thierry', 1, 9),
(37, '2010-05-24 11:41:20', 'Jacques Prévert', 1, 10),
(38, '2010-05-24 11:41:20', 'Jean Cocteau', 0, 10),
(39, '2010-05-24 11:41:20', 'Jean Genet', 0, 10),
(40, '2010-05-24 11:41:20', 'Jean Jack', 0, 10),
(41, '2010-05-24 13:17:50', 'salade', 0, 11),
(42, '2010-05-24 13:17:50', 'citron', 0, 11),
(43, '2010-05-24 13:17:50', 'farine', 1, 11),
(44, '2010-05-24 13:17:50', 'tomate', 0, 11),
(45, '2010-05-25 00:22:25', 'salade', 0, 12),
(46, '2010-05-25 00:22:25', 'citron', 0, 12),
(47, '2010-05-25 00:22:25', 'farine', 1, 12),
(48, '2010-05-25 00:22:25', 'tomate', 0, 12),
(49, '2010-05-25 14:14:32', 'rep 1', 0, 13),
(50, '2010-05-25 14:14:32', 'rep 2', 0, 13),
(51, '2010-05-25 14:14:32', 'rep 3', 1, 13),
(52, '2010-05-25 14:14:32', 'rep 4', 0, 13),
(53, '2010-05-25 14:28:02', 'rep 1', 0, 14),
(54, '2010-05-25 14:28:02', 'rep 2', 0, 14),
(55, '2010-05-25 14:28:02', 'rep 3', 1, 14),
(56, '2010-05-25 14:28:02', 'rep 4', 0, 14),
(57, '2010-05-25 14:31:04', 'GTA', 0, 15),
(58, '2010-05-25 14:31:04', 'FF', 0, 15),
(59, '2010-05-25 14:31:04', 'COD 6', 1, 15),
(60, '2010-05-25 14:31:04', 'God Of War', 0, 15);

-- --------------------------------------------------------

--
-- Structure de la table `sujet`
--

CREATE TABLE `sujet` (
  `ID_SUJET` bigint(8) NOT NULL auto_increment,
  `VERSION` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `TITRE` varchar(250) NOT NULL,
  `DESCRIPTION` varchar(1000) default NULL,
  `DATE_START` date NOT NULL,
  `DATE_END` date NOT NULL,
  `NB_QUESTION_DISPLAY` int(11) NOT NULL,
  `ID_CATEGORY` bigint(8) NOT NULL default '1',
  PRIMARY KEY  (`ID_SUJET`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Contenu de la table `sujet`
--

INSERT INTO `sujet` (`ID_SUJET`, `VERSION`, `TITRE`, `DESCRIPTION`, `DATE_START`, `DATE_END`, `NB_QUESTION_DISPLAY`, `ID_CATEGORY`) VALUES
(1, '2010-05-24 11:41:20', '20 questions sur le cinéma classique français', '', '2010-05-20', '2011-05-20', 5, 1),
(2, '2010-05-24 13:17:50', 'TEST QCM', '', '2010-05-25', '2011-05-20', 1, 1),
(3, '2010-05-25 00:22:25', 'Bidon', '', '2010-05-20', '2011-05-20', 1, 1),
(4, '2010-05-25 14:14:32', 'Test Category', '', '2010-05-20', '2011-05-20', 1, 1),
(5, '2010-05-25 14:28:02', 'Test Category 2', '', '2011-05-26', '2011-05-26', 1, 5),
(6, '2010-05-25 14:31:04', 'Test sujet one day', '', '2010-05-25', '2010-05-25', 1, 3);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`ID_UTILISATEUR`, `VERSION`, `NOM`, `PRENOM`, `EMAIL`, `PHOTO`, `PASSWORD`, `ID_PROFIL`) VALUES
(1, '2010-05-17 16:20:27', 'GUIGARD', 'Mathieu', 'guigard.mathieu@gmail.com', NULL, '1404', 1),
(2, '2010-05-25 14:28:47', 'Khamsy', 'Thierry', 'thierry.khamsy@gmail.com', NULL, '1404', 2);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `participation`
--
ALTER TABLE `participation`
  ADD CONSTRAINT `participation_ibfk_1` FOREIGN KEY (`ID_SUJET`) REFERENCES `sujet` (`ID_SUJET`),
  ADD CONSTRAINT `participation_ibfk_2` FOREIGN KEY (`ID_UTILISATEUR`) REFERENCES `utilisateur` (`ID_UTILISATEUR`);

--
-- Contraintes pour la table `particpation_reponse`
--
ALTER TABLE `particpation_reponse`
  ADD CONSTRAINT `particpation_reponse_ibfk_1` FOREIGN KEY (`ID_PARTICIPATION`) REFERENCES `participation` (`ID_PARTICIPATION`),
  ADD CONSTRAINT `particpation_reponse_ibfk_2` FOREIGN KEY (`ID_REPONSE`) REFERENCES `reponse` (`ID_REPONSE`);

--
-- Contraintes pour la table `profil_habilitation`
--
ALTER TABLE `profil_habilitation`
  ADD CONSTRAINT `profil_habilitation_ibfk_1` FOREIGN KEY (`ID_PROFIL`) REFERENCES `profil` (`ID_PROFIL`),
  ADD CONSTRAINT `profil_habilitation_ibfk_2` FOREIGN KEY (`ID_HABILITATION`) REFERENCES `habilitation` (`ID_HABILITATION`),
  ADD CONSTRAINT `profil_habilitation_ibfk_3` FOREIGN KEY (`ID_PROFIL`) REFERENCES `profil` (`ID_PROFIL`);

--
-- Contraintes pour la table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `question_ibfk_1` FOREIGN KEY (`ID_SUJET`) REFERENCES `sujet` (`ID_SUJET`);

--
-- Contraintes pour la table `reponse`
--
ALTER TABLE `reponse`
  ADD CONSTRAINT `reponse_ibfk_1` FOREIGN KEY (`ID_QUESTION`) REFERENCES `question` (`ID_QUESTION`);

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `utilisateur_ibfk_1` FOREIGN KEY (`ID_PROFIL`) REFERENCES `profil` (`ID_PROFIL`);
