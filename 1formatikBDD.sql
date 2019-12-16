CREATE DATABASE  IF NOT EXISTS `1formatikBdd` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `1formatikBdd`;
-- MySQL dump 10.13  Distrib 8.0.18, for macos10.14 (x86_64)
--
-- Host: localhost    Database: 1formatikBdd
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `adresse`
--

DROP TABLE IF EXISTS `adresse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adresse` (
  `id` int(3) unsigned NOT NULL AUTO_INCREMENT,
  `numero` int(3) DEFAULT NULL,
  `rue` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `ville` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `codePostal` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adresse`
--

LOCK TABLES `adresse` WRITE;
/*!40000 ALTER TABLE `adresse` DISABLE KEYS */;
INSERT INTO `adresse` VALUES (1,4,'rue de la civilisation','Liège',4000),(2,23,'avenue des Combattants','Bruxelles',1000),(3,40,'rue du peuple','Louvain-la-Neuve',1348);
/*!40000 ALTER TABLE `adresse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `implantation`
--

DROP TABLE IF EXISTS `implantation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `implantation` (
  `id` int(2) unsigned NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `adresseId` int(3) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_implantation_adresse` (`adresseId`),
  CONSTRAINT `fk_implantation_adresse` FOREIGN KEY (`adresseId`) REFERENCES `adresse` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `implantation`
--

LOCK TABLES `implantation` WRITE;
/*!40000 ALTER TABLE `implantation` DISABLE KEYS */;
INSERT INTO `implantation` VALUES (1,'TECH',1),(2,'TITI',2),(3,'PHILA',3);
/*!40000 ALTER TABLE `implantation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `intervention`
--

DROP TABLE IF EXISTS `intervention`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `intervention` (
  `id` int(3) unsigned NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL DEFAULT '',
  `commentaires` varchar(100) DEFAULT NULL,
  `localId` int(3) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_intervention_local` (`localId`),
  CONSTRAINT `fk_intervention_local` FOREIGN KEY (`localId`) REFERENCES `local` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `intervention`
--

LOCK TABLES `intervention` WRITE;
/*!40000 ALTER TABLE `intervention` DISABLE KEYS */;
INSERT INTO `intervention` VALUES (1,'Acheter des craies','de toutes les couleurs',11),(2,'Acheter marqueurs','pour le tableau  blanc',25);
/*!40000 ALTER TABLE `intervention` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `local`
--

DROP TABLE IF EXISTS `local`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `local` (
  `id` int(3) unsigned NOT NULL AUTO_INCREMENT,
  `nom` char(3) NOT NULL DEFAULT '',
  `implantationId` int(3) unsigned NOT NULL,
  `localInformatique` binary(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_local_implantation` (`implantationId`),
  CONSTRAINT `fk_local_implantation` FOREIGN KEY (`implantationId`) REFERENCES `implantation` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `local`
--

LOCK TABLES `local` WRITE;
/*!40000 ALTER TABLE `local` DISABLE KEYS */;
INSERT INTO `local` VALUES (1,'L01',1,_binary '0'),(2,'L02',1,_binary '1'),(3,'L03',1,_binary '1'),(4,'L04',1,_binary '1'),(5,'L05',1,_binary '0'),(6,'L06',1,_binary '0'),(7,'L07',1,_binary '0'),(8,'L08',1,_binary '0'),(9,'L09',1,_binary '0'),(10,'L10',1,_binary '0'),(11,'L01',2,_binary '0'),(12,'L02',2,_binary '0'),(13,'L03',2,_binary '1'),(14,'L04',2,_binary '1'),(15,'L05',2,_binary '0'),(16,'L05',2,_binary '0'),(17,'L06',2,_binary '0'),(18,'L07',2,_binary '0'),(19,'L08',2,_binary '0'),(20,'L09',2,_binary '0'),(21,'L10',2,_binary '0'),(22,'L01',3,_binary '0'),(23,'L02',3,_binary '0'),(24,'L03',3,_binary '0'),(25,'L04',3,_binary '0'),(26,'L04',3,_binary '0'),(27,'L05',3,_binary '1'),(28,'L06',3,_binary '0'),(29,'L07',3,_binary '0'),(30,'L08',3,_binary '0'),(31,'L09',3,_binary '0'),(32,'L10',3,_binary '0');
/*!40000 ALTER TABLE `local` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materiels`
--

DROP TABLE IF EXISTS `materiels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materiels` (
  `id` int(3) unsigned NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL DEFAULT '',
  `neuf` int(3) NOT NULL,
  `bon` int(3) NOT NULL,
  `use` int(3) NOT NULL,
  `critique` int(3) NOT NULL,
  `localId` int(3) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_materiels_local` (`localId`),
  CONSTRAINT `fk_materiels_local` FOREIGN KEY (`localId`) REFERENCES `local` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materiels`
--

LOCK TABLES `materiels` WRITE;
/*!40000 ALTER TABLE `materiels` DISABLE KEYS */;
INSERT INTO `materiels` VALUES (1,'chaises',15,0,0,0,1),(2,'tables',10,0,0,0,1),(3,'chaises',20,0,0,0,2),(4,'tables',15,0,0,0,2),(5,'chaises',10,0,0,0,3),(6,'tables',5,0,0,0,3),(7,'chaises',25,0,0,0,4),(8,'tables',10,0,0,0,4),(9,'chaises',25,0,0,0,5),(10,'tables',15,0,0,0,5),(11,'chaises',25,0,0,0,6),(12,'tables',15,0,0,0,6),(13,'chaises',25,0,0,0,7),(14,'tables',15,0,0,0,7),(15,'chaises',30,0,0,0,8),(16,'tables',20,0,0,0,8),(17,'chaises',40,0,0,0,9),(18,'tables',20,0,0,0,9),(19,'chaises',55,0,0,0,10),(20,'tables',30,0,0,0,10),(21,'chaises',40,0,0,0,11),(22,'tables',20,0,0,0,11),(23,'chaises',30,0,0,0,12),(24,'tables',15,0,0,0,12),(25,'chaises',20,0,0,0,13),(26,'tables',10,0,0,0,13),(27,'chaises',20,0,0,0,14),(28,'tables',10,0,0,0,14),(29,'chaises',20,0,0,0,15),(30,'tables',10,0,0,0,15),(31,'chaises',10,0,0,0,16),(32,'tables',5,0,0,0,16),(33,'chaises',40,0,0,0,17),(34,'tables',25,0,0,0,17),(35,'chaises',40,0,0,0,18),(36,'tables',25,0,0,0,18),(37,'chaises',35,0,0,0,19),(38,'tables',25,0,0,0,19),(39,'chaises',30,0,0,0,20),(40,'tables',20,0,0,0,20),(41,'chaises',30,0,0,0,21),(42,'tables',20,0,0,0,21),(43,'chaises',14,0,0,0,22),(44,'tables',5,0,0,0,22),(45,'chaises',20,0,0,0,23),(46,'tables',10,0,0,0,23),(47,'chaises',20,0,0,0,24),(48,'tables',10,0,0,0,24),(49,'chaises',20,0,0,0,25),(50,'tables',10,0,0,0,25),(51,'chaises',40,0,0,0,26),(52,'tables',20,0,0,0,26),(53,'chaises',15,0,0,0,27),(54,'tables',8,0,0,0,27),(55,'chaises',15,0,0,0,28),(56,'tables',8,0,0,0,28),(57,'chaises',25,0,0,0,29),(58,'tables',15,0,0,0,29),(59,'chaises',25,0,0,0,30),(60,'tables',15,0,0,0,30),(61,'chaises',25,0,0,0,31),(62,'tables',15,0,0,0,31),(63,'chaises',34,0,0,0,32),(64,'tables',28,0,0,0,32);
/*!40000 ALTER TABLE `materiels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materielSpecial`
--

DROP TABLE IF EXISTS `materielSpecial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materielSpecial` (
  `id` int(3) unsigned NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL DEFAULT '',
  `etat` varchar(50) NOT NULL DEFAULT '',
  `localId` int(3) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_materielSpecial_local` (`localId`),
  CONSTRAINT `fk_materielSpecial_local` FOREIGN KEY (`localId`) REFERENCES `local` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materielSpecial`
--

LOCK TABLES `materielSpecial` WRITE;
/*!40000 ALTER TABLE `materielSpecial` DISABLE KEYS */;
INSERT INTO `materielSpecial` VALUES (1,'Projecteur','Neuf',11),(2,'Fenêtre','Cassée',11),(3,'Tableau Blanc','Neuf',25);
/*!40000 ALTER TABLE `materielSpecial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pc`
--

DROP TABLE IF EXISTS `pc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pc` (
  `id` int(3) unsigned NOT NULL AUTO_INCREMENT,
  `nom` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `localId` int(3) unsigned NOT NULL,
  `type` varchar(50) NOT NULL DEFAULT '',
  `tour` varchar(50) NOT NULL DEFAULT '',
  `ecran` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `clavier` varchar(50) NOT NULL DEFAULT '',
  `souris` varchar(50) NOT NULL DEFAULT '',
  `commentaires` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pc_local` (`localId`),
  CONSTRAINT `fk_pc_local` FOREIGN KEY (`localId`) REFERENCES `local` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pc`
--

LOCK TABLES `pc` WRITE;
/*!40000 ALTER TABLE `pc` DISABLE KEYS */;
INSERT INTO `pc` VALUES (1,'PC007',2,'fixe','Neuf','Neuf','Bon','Critique',''),(2,'PC432',14,'fixe','Usé','Bon','Neuf','Neuf','');
/*!40000 ALTER TABLE `pc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utilisateur` (
  `id` int(3) unsigned NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL DEFAULT '',
  `prenom` varchar(50) NOT NULL DEFAULT '',
  `grade` int(1) NOT NULL,
  `pseudo` varchar(50) NOT NULL DEFAULT '',
  `mdp` varchar(50) NOT NULL DEFAULT '',
  `implantationId` int(2) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_utilisateur_implantation` (`implantationId`),
  CONSTRAINT `fk_utilisateur_implantation` FOREIGN KEY (`implantationId`) REFERENCES `implantation` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilisateur`
--

LOCK TABLES `utilisateur` WRITE;
/*!40000 ALTER TABLE `utilisateur` DISABLE KEYS */;
INSERT INTO `utilisateur` VALUES (1,'Térieur','Alain',3,'al','123',1),(2,'Afritt','Barack',3,'ba','123',1),(3,'Collick','Al',3,'ac','123',1),(4,'Troisjours','Adam',3,'at','123',2),(5,'Onette','Camille',3,'co','123',2),(6,'Ception','Alex',3,'ac','123',2),(7,'Danlmur','Alphonse',3,'ad','123',3),(8,'Tomie','Anna',3,'at','123',3),(9,'Mâle','Annie',3,'am','123',3),(10,'Bambois','Jean',3,'jb','123',2);
/*!40000 ALTER TABLE `utilisateur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database '1formatikBdd'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-16 15:27:34
