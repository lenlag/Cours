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
USE `tmp_bestioles`;

drop table if exists person__animal;
drop table if exists person;
drop table if exists animal;
drop table if exists specie;

-- Export de la structure de la table bestioles. animal
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

-- Export de la structure de la table bestioles. person
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

-- Export de la structure de la table bestioles. specie
CREATE TABLE IF NOT EXISTS `specie` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `COMMON_NAME` varchar(50) NOT NULL DEFAULT '0',
  `LATIN_NAME` varchar(127) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Export de données de la table bestioles.specie : ~3 rows (environ)
/*!40000 ALTER TABLE `specie` DISABLE KEYS */;
INSERT INTO `specie` (`ID`, `COMMON_NAME`, `LATIN_NAME`) VALUES
	(1, 'Chat', 'Felis silvestris catus'),
	(2, 'Chien', 'Canis lupus familiaris'),
	(3, 'Lapin', 'Oryctolagus cuniculus');
/*!40000 ALTER TABLE `specie` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
