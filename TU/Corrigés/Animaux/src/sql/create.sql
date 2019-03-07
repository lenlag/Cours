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


-- Export de la structure de la base pour bestioles
DROP DATABASE IF EXISTS `bestioles`;
CREATE DATABASE IF NOT EXISTS `bestioles` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bestioles`;

-- Export de la structure de la table bestioles. animal
DROP TABLE IF EXISTS `animal`;
CREATE TABLE IF NOT EXISTS `animal` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_SPECIE` int(11) NOT NULL DEFAULT '0',
  `NAME` varchar(50) NOT NULL DEFAULT '0',
  `COLOR` varchar(50) NOT NULL DEFAULT '0',
  `SEX` char(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `FK_animal_specie` (`ID_SPECIE`),
  CONSTRAINT `FK_animal_specie` FOREIGN KEY (`ID_SPECIE`) REFERENCES `specie` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Export de données de la table bestioles.animal : ~5 rows (environ)
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
INSERT INTO `animal` (`ID`, `ID_SPECIE`, `NAME`, `COLOR`, `SEX`) VALUES
	(1, 1, 'Max', 'Gris tacheté', 'M'),
	(2, 2, 'Médor', 'Blanc', 'M'),
	(3, 1, 'Loulou', 'Noir', 'F'),
	(4, 2, 'Zia', 'Brun', 'F'),
	(5, 3, 'Lou', 'Blanc', 'F');
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;

-- Export de la structure de la procédure bestioles. countPS
DROP PROCEDURE IF EXISTS `countPS`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `countPS`()
BEGIN
select * from specie;
END//
DELIMITER ;

-- Export de la structure de la procédure bestioles. mycount
DROP PROCEDURE IF EXISTS `mycount`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `mycount`(
	IN `chaine` VARCHAR(50),
	OUT `thecount` INT


)
BEGIN
select id into @theid from specie where common_name = chaine;
select count(id) INTO thecount from animal where id_specie=@theid;
END//
DELIMITER ;

-- Export de la structure de la procédure bestioles. myproc
DROP PROCEDURE IF EXISTS `myproc`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `myproc`()
BEGIN
SELECT * FROM SPECIE;
END//
DELIMITER ;

-- Export de la structure de la table bestioles. person
DROP TABLE IF EXISTS `person`;
CREATE TABLE IF NOT EXISTS `person` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FIRSTNAME` varchar(50) NOT NULL DEFAULT '0',
  `LASTNAME` varchar(50) NOT NULL DEFAULT '0',
  `AGE` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Export de données de la table bestioles.person : ~6 rows (environ)
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` (`ID`, `FIRSTNAME`, `LASTNAME`, `AGE`) VALUES
	(1, 'Henri', 'Lamarque', 22),
	(2, 'Sylvie', 'Lamarque', 24),
	(3, 'Jean', 'Vintroi', 55),
	(4, 'Paul', 'Demaine', 80),
	(5, 'Sophie', 'Nero', 45),
	(6, 'Pierre', 'Sansane', 17);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;

-- Export de la structure de la table bestioles. person__animal
DROP TABLE IF EXISTS `person__animal`;
CREATE TABLE IF NOT EXISTS `person__animal` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PERSON_ID` int(11) NOT NULL DEFAULT '0',
  `ANIMAL_ID` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `FK_PERSON__ANIMAL_person` (`PERSON_ID`),
  KEY `FK_PERSON__ANIMAL_animal` (`ANIMAL_ID`),
  CONSTRAINT `FK_PERSON__ANIMAL_animal` FOREIGN KEY (`ANIMAL_ID`) REFERENCES `animal` (`ID`),
  CONSTRAINT `FK_PERSON__ANIMAL_person` FOREIGN KEY (`PERSON_ID`) REFERENCES `person` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Export de données de la table bestioles.person__animal : ~7 rows (environ)
/*!40000 ALTER TABLE `person__animal` DISABLE KEYS */;
INSERT INTO `person__animal` (`ID`, `PERSON_ID`, `ANIMAL_ID`) VALUES
	(1, 1, 1),
	(3, 2, 1),
	(4, 1, 5),
	(5, 2, 5),
	(6, 3, 3),
	(8, 4, 2),
	(9, 5, 4);
/*!40000 ALTER TABLE `person__animal` ENABLE KEYS */;

-- Export de la structure de la table bestioles. race
DROP TABLE IF EXISTS `race`;
CREATE TABLE IF NOT EXISTS `race` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(127) NOT NULL DEFAULT '0',
  `price` int(4) NOT NULL DEFAULT '0',
  `comments` varchar(255) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Export de données de la table bestioles.race : ~3 rows (environ)
/*!40000 ALTER TABLE `race` DISABLE KEYS */;
INSERT INTO `race` (`id`, `name`, `price`, `comments`) VALUES
	(1, 'Berger allemand', 200, 'Sale bete'),
	(2, 'Teckel', 300, 'Bas sur patte'),
	(3, 'Jack Russel', 150, '');
/*!40000 ALTER TABLE `race` ENABLE KEYS */;

-- Export de la structure de la table bestioles. specie
DROP TABLE IF EXISTS `specie`;
CREATE TABLE IF NOT EXISTS `specie` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `COMMON_NAME` varchar(50) NOT NULL DEFAULT '0',
  `LATIN_NAME` varchar(127) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Export de données de la table bestioles.specie : ~5 rows (environ)
/*!40000 ALTER TABLE `specie` DISABLE KEYS */;
INSERT INTO `specie` (`ID`, `COMMON_NAME`, `LATIN_NAME`) VALUES
	(1, 'Chat', 'Felis silvestris catus'),
	(2, 'Chien', 'Canis lupus familiaris'),
	(3, 'Lapin', 'Oryctolagus cuniculus'),
	(5, 'LOUP', 'LUPUS'),
	(6, 'Baleine', 'Balenus balenus');
/*!40000 ALTER TABLE `specie` ENABLE KEYS */;

-- Export de la structure de la procédure bestioles. test
DROP PROCEDURE IF EXISTS `test`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `test`(
	OUT `val` INT
)
BEGIN
select count(id) into val from specie;
END//
DELIMITER ;

-- Export de la structure de la table bestioles. _users
DROP TABLE IF EXISTS `_users`;
CREATE TABLE IF NOT EXISTS `_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  `password` varchar(50) NOT NULL DEFAULT '0',
  `isAdmin` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Export de données de la table bestioles._users : ~2 rows (environ)
/*!40000 ALTER TABLE `_users` DISABLE KEYS */;
INSERT INTO `_users` (`id`, `name`, `password`, `isAdmin`) VALUES
	(1, 'admin', 'jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg=', 1),
	(2, 'user', 'BPiZbadjt6lpsQKO4wB1aerzpjVIbdqyEdUSyFud+Ps=', 0);
/*!40000 ALTER TABLE `_users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
