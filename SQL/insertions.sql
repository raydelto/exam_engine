-- MySQL dump 10.13  Distrib 5.6.20, for Win32 (x86)
--
-- Host: localhost    Database: exams
-- ------------------------------------------------------
-- Server version	5.6.17

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
-- Dumping data for table `answers`
--

LOCK TABLES `answers` WRITE;
/*!40000 ALTER TABLE `answers` DISABLE KEYS */;
INSERT INTO `answers` VALUES (1,1,1,'Is a blueprint for creating objects',1),(2,0,2,'Is an object',1),(3,0,3,'It\'s an abstract data type for manipulate lists',1),(4,0,1,'It\'s a class',2),(5,1,2,'It\'s a concrete instance of a class',2),(6,0,3,'Is a primitive data type',2),(7,0,1,'int',3),(8,0,2,'short',3),(9,1,3,'byte',3);
/*!40000 ALTER TABLE `answers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `exams`
--

LOCK TABLES `exams` WRITE;
/*!40000 ALTER TABLE `exams` DISABLE KEYS */;
INSERT INTO `exams` VALUES (1,'This is a basic test with the objective of measuring your Java Standard Edition Skills',2,'Java test',70,100);
/*!40000 ALTER TABLE `exams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `exams_questions`
--

LOCK TABLES `exams_questions` WRITE;
/*!40000 ALTER TABLE `exams_questions` DISABLE KEYS */;
INSERT INTO `exams_questions` VALUES (1,1),(1,2),(1,3);
/*!40000 ALTER TABLE `exams_questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,0,1,'What is a class?',1),(2,0,2,'What is an object?',1),(3,0,3,'Which is the smallest integer data type?',1);
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `questions_answers`
--

LOCK TABLES `questions_answers` WRITE;
/*!40000 ALTER TABLE `questions_answers` DISABLE KEYS */;
INSERT INTO `questions_answers` VALUES (1,1),(1,2),(1,3),(2,4),(2,5),(2,6),(3,7),(3,8),(3,9);
/*!40000 ALTER TABLE `questions_answers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `results`
--

LOCK TABLES `results` WRITE;
/*!40000 ALTER TABLE `results` DISABLE KEYS */;
INSERT INTO `results` VALUES (1,'2015-07-06 07:29:39',33,1,4),(2,'2015-07-06 08:33:59',0,1,4),(3,'2015-07-06 08:36:43',100,1,4),(4,'2015-07-06 08:41:48',0,1,4),(5,'2015-07-06 08:43:20',100,1,4),(6,'2015-07-06 08:48:11',66,1,4),(7,'2015-07-06 08:49:22',66,1,4),(8,'2015-07-06 08:53:31',33,1,4),(9,'2015-07-06 08:54:06',66,1,4),(10,'2015-07-06 09:02:03',100,1,4),(11,'2015-07-06 09:03:10',33,1,4),(12,'2015-07-06 09:05:28',33,1,4),(13,'2015-07-06 10:23:28',100,1,4);
/*!40000 ALTER TABLE `results` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'firstName','lastName','9fe0f49b15a4927de43ee0a431034f83b43f6382a19f2c7f8b8757284d62c339766b6a44d3c83eed09bc15f7e6693e866bfc8aa554f88a94a5040884350df208','uno'),(2,'Raydelto','Hernandez','9fe0f49b15a4927de43ee0a431034f83b43f6382a19f2c7f8b8757284d62c339766b6a44d3c83eed09bc15f7e6693e866bfc8aa554f88a94a5040884350df208','dos'),(3,'Miguel','Arcadito','9fe0f49b15a4927de43ee0a431034f83b43f6382a19f2c7f8b8757284d62c339766b6a44d3c83eed09bc15f7e6693e866bfc8aa554f88a94a5040884350df208','tres'),(4,'Parsio','Lora','9fe0f49b15a4927de43ee0a431034f83b43f6382a19f2c7f8b8757284d62c339766b6a44d3c83eed09bc15f7e6693e866bfc8aa554f88a94a5040884350df208','arca');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-07-06 10:25:09
