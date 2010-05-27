-- phpMyAdmin SQL Dump
-- version 2.11.6
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- Généré le : Jeu 27 Mai 2010 à 13:44
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
(1, '2010-05-27 12:11:46', 4, 10),
(2, '2010-05-27 12:12:25', 1, 10),
(3, '2010-05-27 12:13:05', 4, 7),
(4, '2010-05-27 12:13:56', 5, 7),
(5, '2010-05-27 12:18:02', 1, 12),
(6, '2010-05-27 12:20:38', 2, 12),
(8, '2010-05-27 13:21:30', 1, 15),
(9, '2010-05-27 13:22:55', 2, 15);

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
(2, 2),
(5, 2),
(2, 5),
(5, 5),
(8, 5),
(2, 13),
(5, 13),
(8, 13),
(2, 19),
(8, 19),
(5, 21),
(8, 24),
(9, 26),
(6, 28),
(9, 30),
(9, 33),
(6, 35),
(9, 37),
(6, 39),
(6, 44),
(1, 74),
(3, 74),
(3, 77),
(1, 80),
(4, 95),
(4, 98),
(4, 106);

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
-- Structure de la table `question`
--

CREATE TABLE `question` (
  `ID_QUESTION` bigint(8) NOT NULL auto_increment,
  `VERSION` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `LIBELLE` varchar(250) NOT NULL,
  `ID_SUJET` bigint(8) NOT NULL,
  PRIMARY KEY  (`ID_QUESTION`),
  KEY `ID_SUJET` (`ID_SUJET`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=32 ;

--
-- Contenu de la table `question`
--

INSERT INTO `question` (`ID_QUESTION`, `VERSION`, `LIBELLE`, `ID_SUJET`) VALUES
(1, '2010-05-27 11:21:02', 'De combien de membres se compose Coldplay ?', 1),
(2, '2010-05-27 11:21:02', 'Quelle est la dernière chanson de l''album Parachutes ?', 1),
(3, '2010-05-27 11:21:02', 'Comment s''appelle le premier album de Coldplay ?', 1),
(4, '2010-05-27 11:21:02', 'Quel est le nom du chanteur ?', 1),
(5, '2010-05-27 11:21:02', 'Quelle association les Coldplays soutiennent-ils ?', 1),
(6, '2010-05-27 11:21:02', 'De quel instrument joue Jon Buckland ?', 1),
(7, '2010-05-27 11:27:26', 'Qui a interprété le « Pianiste » dans le film de Roman Polanski ?', 2),
(8, '2010-05-27 11:27:26', 'Qui a obtenu la Palme d?Or à Cannes en 2009 ?', 2),
(9, '2010-05-27 11:27:26', 'Qui interprète « Tootsie » dans le film de Sydney Pollack ?', 2),
(10, '2010-05-27 11:27:26', 'En 1993, dans quel film Bill Murray revit-il toujours la même journée ?', 2),
(11, '2010-05-27 11:27:26', 'De quelle infirmité est affecté le super héros Daredevil ?', 2),
(12, '2010-05-27 11:31:55', 'Quel prénom porte l''héroïne de « West Side Story » ?', 3),
(13, '2010-05-27 11:31:55', 'A quel réalisateur doit-on « Le Péril jeune », en 1995 ?', 3),
(14, '2010-05-27 11:31:55', 'Qui a réalisé « Jeanne D?Arc » en 1999 ?', 3),
(15, '2010-05-27 11:31:55', 'Quel est le nom du valet muet mais pas sourd de « Zorro » ?', 3),
(16, '2010-05-27 11:31:55', 'Qui a réalisé le film « Home », sorti le 5 juin 2009 ?', 3),
(17, '2010-05-27 11:31:55', 'Film de Quentin Tarantino sorti au mois d?août 2009 avec Mélanie Laurent et Brad Pitt ?', 3),
(18, '2010-05-27 11:31:55', 'Comment s?appelle le héros de nombreux films de Francis Weber ?', 3),
(19, '2010-05-27 11:52:04', 'Qui a donné la victoire à l''équipe de France contre le Costa Rica le 26 Mai 2010?', 4),
(20, '2010-05-27 11:52:04', 'Qui a marqué 2 buts de la tête à la finale de la coupe du monde 98?', 4),
(21, '2010-05-27 11:52:04', 'Qui porte le numéro 10 actuellement?', 4),
(22, '2010-05-27 11:52:04', 'Parmis ces joueurs qui a marqué lors de sa première sélection?', 4),
(23, '2010-05-27 12:00:23', 'La génoise est :', 5),
(24, '2010-05-27 12:00:23', 'Que veut dire bouchot dans l''appellation moules du bouchot ?', 5),
(25, '2010-05-27 12:00:23', 'Je sers à couper les légumes, je porte le nom d''un instrument de musique ?', 5),
(26, '2010-05-27 12:00:23', 'Le vieux Lille est:', 5),
(27, '2010-05-27 12:00:23', 'On m?utilse pour faire la sauce Hollandaise :', 5),
(28, '2010-05-27 12:03:46', 'Je vis dans l?océan, on me surnomme dormeur qui suis-je ?', 6),
(29, '2010-05-27 12:03:46', 'Un pain typiquement provençal:', 6),
(30, '2010-05-27 13:26:11', 'Extension mapping', 7),
(31, '2010-05-27 13:26:11', 'AAA', 7);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=125 ;

--
-- Contenu de la table `reponse`
--

INSERT INTO `reponse` (`ID_REPONSE`, `VERSION`, `LIBELLE`, `GOODRESPONSE`, `ID_QUESTION`) VALUES
(1, '2010-05-27 11:21:02', '3', 0, 1),
(2, '2010-05-27 11:21:02', '4', 1, 1),
(3, '2010-05-27 11:21:02', '5', 0, 1),
(4, '2010-05-27 11:21:02', '6', 0, 1),
(5, '2010-05-27 11:21:02', 'Don''t Panic', 1, 2),
(6, '2010-05-27 11:21:02', 'Amsterdam', 0, 2),
(7, '2010-05-27 11:21:02', 'Life is for living', 0, 2),
(8, '2010-05-27 11:21:02', 'Planet Rap 2010', 0, 2),
(9, '2010-05-27 11:21:02', 'Safety', 0, 3),
(10, '2010-05-27 11:21:02', 'Parachutes', 1, 3),
(11, '2010-05-27 11:21:02', 'Brothers & Sisters', 0, 3),
(12, '2010-05-27 11:21:02', 'Sing for Absolution', 0, 3),
(13, '2010-05-27 11:21:02', 'Chris Martin', 1, 4),
(14, '2010-05-27 11:21:02', 'Guy Berryman', 0, 4),
(15, '2010-05-27 11:21:02', 'Courtney Taylors', 0, 4),
(16, '2010-05-27 11:21:02', 'Booba', 0, 4),
(17, '2010-05-27 11:21:02', 'S.P.A', 0, 5),
(18, '2010-05-27 11:21:02', 'Greenpeace', 0, 5),
(19, '2010-05-27 11:21:02', 'Make Trade Fair', 1, 5),
(20, '2010-05-27 11:21:02', 'UNICEF', 0, 5),
(21, '2010-05-27 11:21:02', 'Basse', 1, 6),
(22, '2010-05-27 11:21:02', 'Guitare', 0, 6),
(23, '2010-05-27 11:21:02', 'Batterie', 0, 6),
(24, '2010-05-27 11:21:02', 'Armonica', 0, 6),
(25, '2010-05-27 11:27:26', 'Keanu Reeves', 0, 7),
(26, '2010-05-27 11:27:26', 'Ben Affleck', 0, 7),
(27, '2010-05-27 11:27:26', 'Adrien Brody', 1, 7),
(28, '2010-05-27 11:27:26', 'Benicio Del Toro', 0, 7),
(29, '2010-05-27 11:27:26', 'Michael Haneke', 1, 8),
(30, '2010-05-27 11:27:26', 'Anthony Minghella', 0, 8),
(31, '2010-05-27 11:27:26', 'Tim Burton', 0, 8),
(32, '2010-05-27 11:27:26', 'David Lynch', 0, 8),
(33, '2010-05-27 11:27:26', 'Robin Williams', 0, 9),
(34, '2010-05-27 11:27:26', 'Dustin Hoffman', 1, 9),
(35, '2010-05-27 11:27:26', 'Tom Hanks', 0, 9),
(36, '2010-05-27 11:27:26', 'Mel Gibson', 0, 9),
(37, '2010-05-27 11:27:26', 'Lost in Translation', 0, 10),
(38, '2010-05-27 11:27:26', 'La Vie aquatique', 0, 10),
(39, '2010-05-27 11:27:26', 'Un jour sans fin', 1, 10),
(40, '2010-05-27 11:27:26', 'Broken Flowers', 0, 10),
(41, '2010-05-27 11:27:26', 'Il est sourd', 0, 11),
(42, '2010-05-27 11:27:26', 'Il est aveugle', 1, 11),
(43, '2010-05-27 11:27:26', 'Il est unijambiste', 0, 11),
(44, '2010-05-27 11:27:26', 'Il est bossu', 0, 11),
(45, '2010-05-27 11:31:55', 'Julia', 0, 12),
(46, '2010-05-27 11:31:55', 'Rita', 0, 12),
(47, '2010-05-27 11:31:55', 'Nina', 0, 12),
(48, '2010-05-27 11:31:55', 'Maria', 1, 12),
(49, '2010-05-27 11:31:55', 'Patrice Leconte', 0, 13),
(50, '2010-05-27 11:31:55', 'Cédric Klapisch', 1, 13),
(51, '2010-05-27 11:31:55', 'Eric Rohmer', 0, 13),
(52, '2010-05-27 11:31:55', 'Claude Lelouch', 0, 13),
(53, '2010-05-27 11:31:55', 'Jean-Jacques Annaud', 0, 14),
(54, '2010-05-27 11:31:55', 'Alain Resnais', 0, 14),
(55, '2010-05-27 11:31:55', 'Claude Berri', 0, 14),
(56, '2010-05-27 11:31:55', 'Luc Besson', 1, 14),
(57, '2010-05-27 11:31:55', 'Domingo', 0, 15),
(58, '2010-05-27 11:31:55', 'Ricardo', 0, 15),
(59, '2010-05-27 11:31:55', 'Bernardo', 1, 15),
(60, '2010-05-27 11:31:55', 'Ronaldo', 0, 15),
(61, '2010-05-27 11:31:55', 'Nicolas Hulot', 1, 16),
(62, '2010-05-27 11:31:55', 'Yann Arthus Bertrand', 0, 16),
(63, '2010-05-27 11:31:55', 'Nicolas Vanier', 0, 16),
(64, '2010-05-27 11:31:55', 'Michael Gondry', 0, 16),
(65, '2010-05-27 11:31:55', 'Kill Bill', 0, 17),
(66, '2010-05-27 11:31:55', 'Little Miss Sunshine', 0, 17),
(67, '2010-05-27 11:31:55', 'Juno', 0, 17),
(68, '2010-05-27 11:31:55', 'Inglorious Bastard', 1, 17),
(69, '2010-05-27 11:31:55', 'Pierre Brochant', 0, 18),
(70, '2010-05-27 11:31:55', 'François Pignon', 1, 18),
(71, '2010-05-27 11:31:55', 'Juste Leblanc', 0, 18),
(72, '2010-05-27 11:31:55', 'Lucien Cheval', 0, 18),
(73, '2010-05-27 11:52:04', 'Thierry Henry', 0, 19),
(74, '2010-05-27 11:52:04', 'Mathieu Valbuena', 1, 19),
(75, '2010-05-27 11:52:04', 'Bafe Gomis', 0, 19),
(76, '2010-05-27 11:52:04', 'Lionel Messi', 0, 19),
(77, '2010-05-27 11:52:04', 'Zidane', 1, 20),
(78, '2010-05-27 11:52:04', 'Zidanne', 0, 20),
(79, '2010-05-27 11:52:04', 'Zidan', 0, 20),
(80, '2010-05-27 11:52:04', 'Raymond', 0, 20),
(81, '2010-05-27 11:52:04', 'Zidane', 0, 21),
(82, '2010-05-27 11:52:04', 'Govou', 0, 21),
(83, '2010-05-27 11:52:04', 'Valbuena', 1, 21),
(84, '2010-05-27 11:52:04', 'Reveillere', 0, 21),
(85, '2010-05-27 11:52:04', 'Valbuena', 1, 22),
(86, '2010-05-27 11:52:04', 'Toulalan', 0, 22),
(87, '2010-05-27 11:52:04', 'Makelele', 0, 22),
(88, '2010-05-27 11:52:04', 'BAKARI Sagna', 0, 22),
(89, '2010-05-27 12:00:23', 'Une pâtisserie', 1, 23),
(90, '2010-05-27 12:00:23', 'Un plat Italien', 0, 23),
(91, '2010-05-27 12:00:23', 'Un poisson', 0, 23),
(92, '2010-05-27 12:00:23', 'Une petite génisse', 0, 23),
(93, '2010-05-27 12:00:23', 'Origine du nord de la france', 0, 24),
(94, '2010-05-27 12:00:23', 'Attachées à des filets en osier', 0, 24),
(95, '2010-05-27 12:00:23', 'Cuite avant de les vendre', 0, 24),
(96, '2010-05-27 12:00:23', 'Poteaux verticaux couvert de cordes enroulées', 1, 24),
(97, '2010-05-27 12:00:23', 'La mandoline', 1, 25),
(98, '2010-05-27 12:00:23', 'Le biniou', 0, 25),
(99, '2010-05-27 12:00:23', 'La guitare', 0, 25),
(100, '2010-05-27 12:00:23', 'Le triangle', 0, 25),
(101, '2010-05-27 12:00:23', 'Soupe à base de betterave', 0, 26),
(102, '2010-05-27 12:00:23', 'Un fromage', 1, 26),
(103, '2010-05-27 12:00:23', 'Une pâtisserie', 0, 26),
(104, '2010-05-27 12:00:23', 'Un vieux mouton que l on cuit en sauce', 0, 26),
(105, '2010-05-27 12:00:23', 'Jus de tomate', 0, 27),
(106, '2010-05-27 12:00:23', 'Jus de citron', 1, 27),
(107, '2010-05-27 12:00:23', 'Ail haché', 0, 27),
(108, '2010-05-27 12:00:23', 'Du fromage d´hollande', 0, 27),
(109, '2010-05-27 12:03:46', 'L''huitre', 0, 28),
(110, '2010-05-27 12:03:46', 'La sole', 0, 28),
(111, '2010-05-27 12:03:46', 'Le thon', 0, 28),
(112, '2010-05-27 12:03:46', 'Le tourteau', 1, 28),
(113, '2010-05-27 12:03:46', 'La fougas', 1, 29),
(114, '2010-05-27 12:03:46', 'La faluche', 0, 29),
(115, '2010-05-27 12:03:46', 'Le foué', 0, 29),
(116, '2010-05-27 12:03:46', 'Le campagnol', 0, 29),
(117, '2010-05-27 13:26:11', '.hbm.xml', 1, 30),
(118, '2010-05-27 13:26:11', 'klm', 0, 30),
(119, '2010-05-27 13:26:11', 'km', 0, 30),
(120, '2010-05-27 13:26:11', 'kkkkk', 0, 30),
(121, '2010-05-27 13:26:11', 'za', 1, 31),
(122, '2010-05-27 13:26:11', 'aze', 0, 31),
(123, '2010-05-27 13:26:11', 'ea', 0, 31),
(124, '2010-05-27 13:26:11', 'aa', 0, 31);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Contenu de la table `sujet`
--

INSERT INTO `sujet` (`ID_SUJET`, `VERSION`, `TITRE`, `DESCRIPTION`, `DATE_START`, `DATE_END`, `NB_QUESTION_DISPLAY`, `ID_CATEGORY`) VALUES
(1, '2010-05-27 11:21:02', 'Coldplay', '', '2010-05-01', '2011-05-01', 4, 5),
(2, '2010-05-27 11:27:26', 'Cinéma - Débutant', 'Le cinéma...pour les nuls!', '2010-05-01', '2011-05-01', 4, 1),
(3, '2010-05-27 11:31:55', 'Cinéma - Expert', 'Le cinéma...pour les experts!', '2010-05-01', '2011-05-01', 4, 1),
(4, '2010-05-27 11:52:04', 'Les matchs de l''équipe de france', 'Petit questionnaire sur les matchs de l''équipe de France de football', '2010-05-01', '2011-05-01', 2, 6),
(5, '2010-05-27 12:00:23', 'Cusine - Débutant', 'La cuisine...pour les nuls!', '2010-05-01', '2011-05-01', 3, 4),
(6, '2010-05-27 12:07:36', 'Cusine - Expert', 'La cuisine...pour les experts!', '2010-05-01', '2010-05-25', 1, 4),
(7, '2010-05-27 13:26:11', 'Hibernate', 'blabla', '2010-05-01', '2010-05-29', 2, 1);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`ID_UTILISATEUR`, `VERSION`, `NOM`, `PRENOM`, `EMAIL`, `PHOTO`, `PASSWORD`, `ID_PROFIL`) VALUES
(1, '2010-05-26 21:01:08', 'GUIGARD', 'Mathieu', 'guigard.mathieu@gmail.com', NULL, '1404', 1),
(7, '2010-05-27 11:04:34', 'Khamsy', 'Thierry', 'thierry.khamsy@gmail.com', NULL, '1404', 2),
(8, '2010-05-27 11:07:13', 'Renaud', 'Damien', 'damienrenaud@gmail.com', NULL, '1404', 2),
(10, '2010-05-27 12:09:05', 'Jackson', 'Mickael', 'm.jackson@gmail.com', NULL, 'bambi', 2),
(11, '2010-05-27 12:15:19', 'Bourgoin', 'Remy', 'rbourgoin@gmail.com', NULL, '1404', 1),
(12, '2010-05-27 12:16:10', 'Margueritte', 'Pierre', 'mfpierre@gmail.com', NULL, '1404', 2),
(15, '2010-05-27 13:19:13', 'Doussot', 'David', 'ddoussot@gmail.com', NULL, 'abc', 2);

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
