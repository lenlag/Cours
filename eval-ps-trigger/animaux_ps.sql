-- --------------------------------------------------------
-- Hôte :                        127.0.0.1
-- Version du serveur:           5.5.61-log - MySQL Community Server (GPL)
-- SE du serveur:                Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Export de la structure de la base pour animaux
DROP DATABASE IF EXISTS `animaux`;
CREATE DATABASE IF NOT EXISTS `animaux` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `animaux`;

-- Export de la structure de la table animaux. animal
DROP TABLE IF EXISTS `animal`;
CREATE TABLE IF NOT EXISTS `animal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sexe` char(1) NOT NULL,
  `date_naissance` datetime NOT NULL,
  `nom` varchar(30) NOT NULL,
  `commentaires` text NOT NULL,
  `espece_id` int(11) NOT NULL,
  `race_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- Export de données de la table animaux.animal : ~59 rows (environ)
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
INSERT INTO `animal` (`id`, `sexe`, `date_naissance`, `nom`, `commentaires`, `espece_id`, `race_id`) VALUES
	(1, 'M', '2010-04-05 13:43:00', 'Rox', 'Mordille beaucoup', 1, 1),
	(2, '', '2010-03-24 02:23:00', 'Roucky', '', 2, 0),
	(3, 'F', '2010-09-13 15:02:00', 'Schtroumpfette', '', 2, 4),
	(4, 'F', '2009-08-03 05:12:00', '', '', 3, 0),
	(5, '', '2010-10-03 16:44:00', 'Choupi', 'Ne sans oreille gauche', 2, 0),
	(6, 'F', '2009-06-13 08:17:00', 'Bobosse', 'Carapace bizarre', 3, 0),
	(7, 'F', '2008-12-06 05:18:00', 'Caroline', '', 1, 2),
	(8, 'M', '2008-09-11 15:38:00', 'Bagherra', '', 2, 5),
	(9, '', '2010-08-23 05:18:00', '', '', 3, 0),
	(10, 'M', '2010-07-21 15:41:00', 'Bobo', '', 1, 0),
	(11, 'F', '2008-02-20 15:45:00', 'Canaille', '', 1, 0),
	(12, 'F', '2009-05-26 08:54:00', 'Cali', '', 1, 2),
	(13, 'F', '2007-04-24 12:54:00', 'Rouquine', '', 1, 1),
	(14, 'F', '2009-05-26 08:56:00', 'Fila', '', 1, 2),
	(15, 'F', '2008-02-20 15:47:00', 'Anya', '', 1, 0),
	(16, 'F', '2009-05-26 08:50:00', 'Louya', '', 1, 0),
	(17, 'F', '2008-03-10 13:45:00', 'Welva', '', 1, 3),
	(18, 'F', '2007-04-24 12:59:00', 'Zira', '', 1, 1),
	(19, 'F', '2009-05-26 09:02:00', 'Java', '', 1, 2),
	(20, 'M', '2007-04-24 12:45:00', 'Balou', '', 1, 1),
	(21, 'F', '2008-03-10 13:43:00', 'Pataude', '', 1, 3),
	(22, 'M', '2007-04-24 12:42:00', 'Bouli', '', 1, 1),
	(24, 'M', '2007-04-12 05:23:00', 'Cartouche', '', 1, 0),
	(25, 'M', '2006-05-14 15:50:00', 'Zambo', '', 1, 1),
	(26, 'M', '2006-05-14 15:48:00', 'Samba', '', 1, 1),
	(27, 'M', '2008-03-10 13:40:00', 'Moka', '', 1, 3),
	(28, 'M', '2006-05-14 15:40:00', 'Pilou', '', 1, 1),
	(29, 'M', '2009-05-14 06:30:00', 'Fiero', '', 2, 6),
	(30, 'M', '2007-03-12 12:05:00', 'Zonko', '', 2, 5),
	(31, 'M', '2008-02-20 15:45:00', 'Filou', '', 2, 4),
	(32, 'M', '2007-03-12 12:07:00', 'Farceur', '', 2, 5),
	(33, 'M', '2006-05-19 16:17:00', 'Caribou', '', 2, 4),
	(34, 'M', '2008-04-20 03:22:00', 'Capou', '', 2, 5),
	(35, 'M', '2006-05-19 16:56:00', 'Raccou', 'Pas de queue depuis la naissance', 2, 4),
	(36, 'M', '2009-05-14 06:42:00', 'Boucan', '', 2, 6),
	(37, 'F', '2006-05-19 16:06:00', 'Callune', '', 2, 4),
	(38, 'F', '2009-05-14 06:45:00', 'Boule', '', 2, 6),
	(39, 'F', '2008-04-20 03:26:00', 'Zara', '', 2, 5),
	(40, 'F', '2007-03-12 12:00:00', 'Milla', '', 2, 5),
	(41, 'F', '2006-05-19 15:59:00', 'Feta', '', 2, 4),
	(42, 'F', '2008-04-20 03:20:00', 'Bilba', 'Sourde de l"oreille droite a 80%', 2, 5),
	(43, 'F', '2007-03-12 11:54:00', 'Cracotte', '', 2, 5),
	(44, 'F', '2006-05-19 16:16:00', 'Cawette', '', 2, 4),
	(45, 'F', '2007-04-01 18:17:00', 'Nikki', '', 3, 0),
	(46, 'F', '2009-03-24 08:23:00', 'Tortilla', '', 3, 0),
	(47, 'F', '2009-03-26 01:24:00', 'Scroupy', '', 3, 0),
	(48, 'F', '2006-03-15 14:56:00', 'Lulla', '', 3, 0),
	(49, 'F', '2008-03-15 12:02:00', 'Dana', '', 3, 0),
	(50, 'F', '2009-05-25 19:57:00', 'Cheli', '', 3, 0),
	(51, 'F', '2007-04-01 03:54:00', 'Chicaca', '', 3, 0),
	(52, 'F', '2006-03-15 14:26:00', 'Redbul', 'Insomniaque', 3, 0),
	(53, 'M', '2007-04-02 01:45:00', 'Spoutnik', '', 3, 0),
	(54, 'M', '2008-03-16 08:20:00', 'Bubulle', '', 3, 0),
	(55, 'M', '2008-03-15 18:45:00', 'Relou', 'Surpoids', 3, 0),
	(56, 'M', '2009-05-25 18:54:00', 'Bulbizard', '', 3, 0),
	(57, 'M', '2007-03-04 19:36:00', 'Safran', '', 4, 0),
	(58, 'M', '2008-02-20 02:50:00', 'Gingko', '', 4, 0),
	(59, 'M', '2009-03-26 08:28:00', 'Bavard', '', 4, 0),
	(60, 'F', '2009-03-26 07:55:00', 'Parlotte', '', 4, 0);
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;

-- Export de la structure de la table animaux. espece
DROP TABLE IF EXISTS `espece`;
CREATE TABLE IF NOT EXISTS `espece` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom_courant` varchar(40) NOT NULL,
  `nom_latin` varchar(40) NOT NULL,
  `description` text,
  `prix` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Export de données de la table animaux.espece : ~4 rows (environ)
/*!40000 ALTER TABLE `espece` DISABLE KEYS */;
INSERT INTO `espece` (`id`, `nom_courant`, `nom_latin`, `description`, `prix`) VALUES
	(1, 'Chien', 'Canis canis', 'Bestiole à quatre pattes qui aime les caresses et tire souvent la langue', 500),
	(2, 'Chat', 'Felis silvestris', 'Bestiole à quatre pattes qui saute très haut et grimpe aux arbres', 700),
	(3, 'Tortue d\'Hermann', 'Testudo hermanni', 'Bestiole avec une carapace très dure', 800),
	(4, 'Perroquet amazone', 'Alipiopsitta xanthops', 'Joli oiseau parleur vert et jaune', 200);
/*!40000 ALTER TABLE `espece` ENABLE KEYS */;

-- Export de la structure de la table animaux. race
DROP TABLE IF EXISTS `race`;
CREATE TABLE IF NOT EXISTS `race` (
  `id` smallint(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(40) NOT NULL,
  `espece_id` smallint(5) unsigned NOT NULL,
  `description` text,
  `prix` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Export de données de la table animaux.race : ~7 rows (environ)
/*!40000 ALTER TABLE `race` DISABLE KEYS */;
INSERT INTO `race` (`id`, `nom`, `espece_id`, `description`, `prix`) VALUES
	(1, 'Berger allemand', 1, 'Chien sportif et élégant au pelage dense, noir-marron-fauve, noir ou gris.', 500),
	(2, 'Berger blanc suisse', 1, 'Petit chien au corps compact, avec des pattes courtes mais bien proportionnées et au pelage tricolore ou bicolore.', 1000),
	(3, 'Boxer', 1, 'Chien de taille moyenne, au poil ras de couleur fauve ou bringé avec quelques marques blanches.', 700),
	(4, 'Bleu russe', 2, 'Chat aux yeux verts et à la robe épaisse et argentée.', 800),
	(5, 'Maine coon', 2, 'Chat de grande taille, à poils mi-longs.', 500),
	(6, 'Singapura', 2, 'Chat de petite taille aux grands yeux en amandes.', 250),
	(7, 'Sphynx', 2, 'Chat sans poils.', 300);
/*!40000 ALTER TABLE `race` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
