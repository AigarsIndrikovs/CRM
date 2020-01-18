-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: crm
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
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `customerId` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(60) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `RegistrationNumber` varchar(20) DEFAULT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `WebPage` varchar(45) DEFAULT NULL,
  `ContactPerson` varchar(100) DEFAULT NULL,
  `numberInList` int(11) DEFAULT '0',
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'LVPARTS SIA','Dārzciema iela 60, Rīga','40203099262','+371 26159734','aigars@lvparts.lv','lvparts.lv','Aigars Indrikovs',NULL),(2,'Volvo Truck Latvia','Granīta iela, Rumbula','40203366982','+371 26589741','valdis@volvo.com','volvo.lv','Valdis Valainis',NULL),(3,'Anytec Productions SIA','Flotes iela 2a, Rīga','6564862662','+371 61597548','aleksej@anytec.lv','anytec.eu','Aleksejs Larionovs',NULL);
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `events` (
  `eventId` int(11) NOT NULL AUTO_INCREMENT,
  `Customer` int(11) DEFAULT NULL,
  `CustomerName` varchar(45) DEFAULT NULL,
  `Date` varchar(20) DEFAULT NULL,
  `ContactPerson` varchar(45) DEFAULT NULL,
  `Description` varchar(250) DEFAULT NULL,
  `Result` varchar(250) DEFAULT NULL,
  `eventNumber` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`eventId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` VALUES (1,1,'Skandi Motors','2019-12-28','CEO and marketing manager','Discussed pricing and marketing support. Customer need additional catalogues and leaflets','Agreed to start cooperation',NULL),(7,NULL,'Anytec','16.01.2020','Oleg Kronberg','Discussed Marine lighting product range. \nAt the moment using meduim quality lights from several suppliers.\n','Need to prepare offer for all available lights.',NULL);
/*!40000 ALTER TABLE `events` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks`
--

DROP TABLE IF EXISTS `tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tasks` (
  `tasksId` int(11) NOT NULL AUTO_INCREMENT,
  `taskDescription` varchar(100) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `taskNumber` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`tasksId`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
INSERT INTO `tasks` VALUES (9,'Send warning price offer to Unimotors',0,NULL),(11,'ASAP Dometic delivery for boat builder',1,NULL),(12,'New task',1,NULL),(21,'JUnit test',1,NULL),(22,'Jauns uzdevums',1,NULL);
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-18 13:10:05
