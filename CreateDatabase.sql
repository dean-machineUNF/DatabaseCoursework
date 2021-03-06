-- MySQL dump 10.13  Distrib 5.7.19, for Linux (x86_64)
--
-- Host: localhost    Database: assign2
-- ------------------------------------------------------
-- Server version	5.7.19-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `continent`
--

DROP TABLE IF EXISTS `continent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `continent` (
  `continent_name` varchar(30) NOT NULL,
  `continent_area` int(10) unsigned NOT NULL,
  `connects_to` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`continent_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `continent`
--

LOCK TABLES `continent` WRITE;
/*!40000 ALTER TABLE `continent` DISABLE KEYS */;
INSERT INTO `continent` VALUES ('Africa',11730000,'Asia'),('Alderaan',1200000000,'Hoth'),('Antartica',5400000,NULL),('Asia',17210000,'Africa'),('Australia',2970000,NULL),('Bespin',590000000,'Naboo'),('Corellia',993000000,'Kamino'),('Coruscant',34100000,'Tatooine'),('Dagobah',7800000,NULL),('Endor',400000,'Jakku'),('Europe',3931000,NULL),('Hoth',63800000,'Geonosis'),('Jakku',99900000,'Endor'),('Kamino',6900000,'Corellia'),('Kashyyyk',4280000,NULL),('Naboo',56100000,'Bespin'),('North America',9540000,'South America'),('Polis Massa',93400000,NULL),('Ryloth',6600000,NULL),('South America',6800000,'North America'),('Tatooine',190000,'Coruscant'),('Yavin',29000000,NULL);
/*!40000 ALTER TABLE `continent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `island`
--

DROP TABLE IF EXISTS `island`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `island` (
  `island_name` varchar(30) NOT NULL,
  `island_area` int(11) NOT NULL,
  `ocean_name` varchar(30) NOT NULL,
  PRIMARY KEY (`island_name`),
  KEY `ocean_name` (`ocean_name`),
  CONSTRAINT `island_ibfk_1` FOREIGN KEY (`ocean_name`) REFERENCES `ocean` (`ocean_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `island`
--

LOCK TABLES `island` WRITE;
/*!40000 ALTER TABLE `island` DISABLE KEYS */;
INSERT INTO `island` VALUES ('Achernar',609000,'NGC 6822'),('Acrux',717000,'Ursa Minor'),('Alpha Carinae',30100000,'Messier 83'),('Alpha Centauri A',1560000,'Milky Way'),('Alpha Centauri System',9210000,'BL Lacertae'),('Antares',4900000,'Messier 83'),('Betelgeuse',4018000,'Pegasus Dwarf Irregular'),('Canopus',56300000,'Messier 83'),('Capella',8810000,'Maffei 2'),('Formalhaut',999000,'Milky Way'),('Mimosa',6237000,'Milky Way'),('Pistol Star',1560000,'Andromeda'),('Pleiades',7770000,'Messier 83'),('Polaris',10000000,'Circinus'),('Procyon',10360000,'NGC 6822'),('Rigel',1040000,'Milky Way'),('Rigil Kentaurus',90400000,'Milky Way'),('Sirius',44810000,'BL Lacertae'),('Sun',830000,'Milky Way'),('Vega',99070000,'Cygnus A'),('VY Canis Majoris',910200,'Milky Way'),('Westerland 2',721800,'Large Magellanic');
/*!40000 ALTER TABLE `island` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ocean`
--

DROP TABLE IF EXISTS `ocean`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ocean` (
  `ocean_name` varchar(30) NOT NULL,
  `ocean_area` int(11) NOT NULL,
  PRIMARY KEY (`ocean_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ocean`
--

LOCK TABLES `ocean` WRITE;
/*!40000 ALTER TABLE `ocean` DISABLE KEYS */;
INSERT INTO `ocean` VALUES ('Andromeda',998800000),('Andromeda IX',661000000),('BL Lacertae',770000000),('Centaurus A',9000000),('Circinus',28220000),('Cosmos Redshift 7',99320000),('Cygnus A',812000000),('Large Magellanic',10000000),('Maffei 2',109000000),('Malin 1',629000000),('Messier 81',13200000),('Messier 83',7720000),('Milky Way',49000000),('NGC 6822',337200000),('Pegasus Dwarf Irregular',336000000),('Phoenix Dwarf',788000000),('Pisces Dwarf',106000000),('Sagittarius Dwarf Irregular',561000000),('Small Magellanic',670000),('Triangulum',775800000),('Ursa Minor',199000000),('Virgo Stellar',516000000);
/*!40000 ALTER TABLE `ocean` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `strait`
--

DROP TABLE IF EXISTS `strait`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `strait` (
  `strait_name` varchar(30) NOT NULL,
  `strait_area` int(11) NOT NULL,
  `island_name` varchar(30) NOT NULL,
  `continent_name` varchar(30) NOT NULL,
  PRIMARY KEY (`strait_name`,`island_name`,`continent_name`),
  KEY `seperates` (`island_name`),
  KEY `continent_name` (`continent_name`),
  CONSTRAINT `seperates` FOREIGN KEY (`island_name`) REFERENCES `island` (`island_name`),
  CONSTRAINT `strait_ibfk_1` FOREIGN KEY (`continent_name`) REFERENCES `continent` (`continent_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `strait`
--

LOCK TABLES `strait` WRITE;
/*!40000 ALTER TABLE `strait` DISABLE KEYS */;
INSERT INTO `strait` VALUES ('ARC-170 Starfighter',11579,'Antares','Bespin'),('ARC-170 Starfighter',11578,'Antares','Dagobah'),('ARC-170 Starfighter',11580,'Antares','Endor'),('ARC-170 Starfighter',11581,'Antares','Kashyyyk'),('ARC-170 Starfighter',11576,'Antares','Naboo'),('ARC-170 Starfighter',11577,'Antares','Polis Massa'),('Imperial Star Destroyer',11600,'Polaris','Naboo'),('Imperial Star Destroyer',11599,'Polaris','Yavin'),('Imperial Star Destroyer',11596,'Rigil Kentaurus','Bespin'),('Imperial Star Destroyer',11594,'Rigil Kentaurus','Coruscant'),('Imperial Star Destroyer',11598,'Rigil Kentaurus','Jakku'),('Imperial Star Destroyer',11595,'Rigil Kentaurus','Kamino'),('Imperial Star Destroyer',11597,'Rigil Kentaurus','Ryloth'),('Millenium Falcon',11569,'Rigel','Hoth'),('Millenium Falcon',11567,'Rigel','Jakku'),('Millenium Falcon',11568,'Rigel','Naboo'),('Tantive IV',11585,'Alpha Centauri System','Corellia'),('Tantive IV',11583,'Alpha Centauri System','Hoth'),('Tantive IV',11586,'Alpha Centauri System','Jakku'),('Tantive IV',11582,'Alpha Centauri System','Ryloth'),('Tantive IV',11584,'Alpha Centauri System','Yavin'),('TIE Fighter',11571,'Acrux','Kashyyyk'),('TIE Fighter',11570,'Acrux','Tatooine'),('TIE Fighter',11572,'Polaris','Kamino'),('U-wing',11589,'VY Canis Majoris','Bespin'),('U-wing',11590,'VY Canis Majoris','Endor'),('U-wing',11592,'VY Canis Majoris','Hoth'),('U-wing',11587,'VY Canis Majoris','Jakku'),('U-wing',11588,'VY Canis Majoris','Naboo'),('U-wing',11591,'VY Canis Majoris','Polis Massa'),('U-wing',11593,'VY Canis Majoris','Ryloth'),('X-wing Starfighter',11573,'Polaris','Yavin'),('X-wing Starfighter',11574,'Sirius','Bespin'),('X-wing Starfighter',11575,'Sirius','Coruscant');
/*!40000 ALTER TABLE `strait` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-25 11:02:13
