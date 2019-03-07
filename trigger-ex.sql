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


-- Export de la structure de la base pour trigger
DROP DATABASE IF EXISTS `trigger`;
CREATE DATABASE IF NOT EXISTS `trigger` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `trigger`;

-- Export de la structure de la table trigger. comptage
DROP TABLE IF EXISTS `comptage`;
CREATE TABLE IF NOT EXISTS `comptage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nbinsert` int(11) NOT NULL DEFAULT '0',
  `nbupdate` int(11) NOT NULL DEFAULT '0',
  `nbdelete` int(11) NOT NULL DEFAULT '0',
  `nombre` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Export de données de la table trigger.comptage : ~1 rows (environ)
/*!40000 ALTER TABLE `comptage` DISABLE KEYS */;
INSERT INTO `comptage` (`id`, `nbinsert`, `nbupdate`, `nbdelete`, `nombre`) VALUES
	(1, 0, 0, 0, 0);
/*!40000 ALTER TABLE `comptage` ENABLE KEYS */;

-- Export de la structure de la table trigger. objet
DROP TABLE IF EXISTS `objet`;
CREATE TABLE IF NOT EXISTS `objet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(50) NOT NULL DEFAULT '0',
  `prix` float NOT NULL DEFAULT '0',
  `nombre` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Export de données de la table trigger.objet : ~1 rows (environ)
/*!40000 ALTER TABLE `objet` DISABLE KEYS */;
/*!40000 ALTER TABLE `objet` ENABLE KEYS */;

-- Export de la structure de la table trigger. person
DROP TABLE IF EXISTS `person`;
CREATE TABLE IF NOT EXISTS `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL DEFAULT '0',
  `prenom` varchar(50) NOT NULL DEFAULT '0',
  `age` int(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Export de données de la table trigger.person : ~0 rows (environ)
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
/*!40000 ALTER TABLE `person` ENABLE KEYS */;


/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
