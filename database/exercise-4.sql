-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: exercise3_v2
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `assignmentbuilding`
--

DROP TABLE IF EXISTS `assignmentbuilding`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `assignmentbuilding` (
  `buildingid` bigint(20) NOT NULL,
  `staffid` bigint(20) NOT NULL,
  KEY `FK5ml77mpq20c7cktnaayqyndi` (`staffid`),
  KEY `FKkk3mdegrmfcdlsxqds1m6q238` (`buildingid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignmentbuilding`
--

LOCK TABLES `assignmentbuilding` WRITE;
/*!40000 ALTER TABLE `assignmentbuilding` DISABLE KEYS */;
INSERT INTO `assignmentbuilding` VALUES (1,3),(1,2),(2,2),(2,3),(3,2),(3,4);
/*!40000 ALTER TABLE `assignmentbuilding` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assignmentcustomer`
--

DROP TABLE IF EXISTS `assignmentcustomer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `assignmentcustomer` (
  `customerid` bigint(20) NOT NULL,
  `staffid` bigint(20) NOT NULL,
  KEY `FKqjgn6avtjckryyksmwrjn474o` (`staffid`),
  KEY `FK4sygo3a6twd6tkay7em8f1lgg` (`customerid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignmentcustomer`
--

LOCK TABLES `assignmentcustomer` WRITE;
/*!40000 ALTER TABLE `assignmentcustomer` DISABLE KEYS */;
INSERT INTO `assignmentcustomer` VALUES (1,3),(1,2),(5,3),(5,2);
/*!40000 ALTER TABLE `assignmentcustomer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `building`
--

DROP TABLE IF EXISTS `building`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `building` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `brokeragefee` decimal(19,2) DEFAULT NULL,
  `carfee` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `decorationtime` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `deposit` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `direction` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `districtcode` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `electricityfee` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `floorarea` int(11) DEFAULT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `level` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `linkofbuilding` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `map` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `moterbikefee` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `namemanager` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `note` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `numberofbasement` int(11) DEFAULT NULL,
  `overtimefee` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `payment` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phonemanager` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rentprice` int(11) DEFAULT NULL,
  `rentpricedescription` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `renttime` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `servicefee` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `street` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `structure` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `types` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ward` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `waterfee` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `building`
--

LOCK TABLES `building` WRITE;
/*!40000 ALTER TABLE `building` DISABLE KEYS */;
INSERT INTO `building` VALUES (1,NULL,NULL,'admin','2022-10-03 23:17:36',NULL,'','','','','Q1','',0,NULL,'',NULL,NULL,'','hoa','',NULL,1,'','','',0,'','','','1','asd','nguyen-can, noi-that','',''),(2,'admin','2022-10-03 22:09:53','admin','2022-10-04 00:21:23',NULL,'','','','','Q4','',0,NULL,'',NULL,NULL,'','123','',NULL,NULL,'','','',0,'','','','','','','',''),(3,'admin','2022-10-04 00:18:33','admin','2022-10-04 00:21:28',NULL,'','','','','Q1','',0,NULL,'',NULL,NULL,'','123','',NULL,NULL,'','','',0,'','','','','','','','');
/*!40000 ALTER TABLE `building` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fullname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,NULL,NULL,'admin','2022-10-03 23:25:57','asd','asd23','a21'),(5,'admin','2022-10-04 00:25:53','admin','2022-10-04 00:26:32','123','123','123');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rentarea`
--

DROP TABLE IF EXISTS `rentarea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rentarea` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `value` int(11) DEFAULT NULL,
  `buildingid` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqhqoxlvm1iblaew5s0v8n3ut4` (`buildingid`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rentarea`
--

LOCK TABLES `rentarea` WRITE;
/*!40000 ALTER TABLE `rentarea` DISABLE KEYS */;
INSERT INTO `rentarea` VALUES (2,'admin','2022-10-03 22:10:40','admin','2022-10-03 22:10:40',123,2),(13,'admin','2022-10-04 00:18:33','admin','2022-10-04 00:18:33',213,3),(12,'admin','2022-10-03 23:17:36','admin','2022-10-03 23:17:36',123,1);
/*!40000 ALTER TABLE `rentarea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `code` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_c36say97xydpmgigg38qv5l2p` (`code`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,NULL,NULL,NULL,NULL,'MANAGER','Quản trị hệ thống'),(2,NULL,NULL,NULL,NULL,'STAFF','Nhan Vien');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `transaction` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `note` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `customerid` bigint(20) DEFAULT NULL,
  `staffid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKldobv9jeuxje0fjqnhrw6e23v` (`customerid`),
  KEY `FKrsenqvwjhwtsiuyw4ht1cgpvp` (`staffid`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1,'admin','2022-10-03 12:32:22','admin','2022-10-03 12:32:22','QTCSKH','123',NULL,NULL),(2,'admin','2022-10-03 12:39:00','admin','2022-10-03 12:39:00','QTCSKH','32',NULL,NULL),(3,'admin','2022-10-03 12:42:13','admin','2022-10-03 12:42:13','DDX','12322',NULL,NULL),(4,'admin','2022-10-03 12:43:23','admin','2022-10-03 12:43:23','DDX','333',1,1),(5,'admin','2022-10-03 13:21:04','admin','2022-10-03 13:21:04','QTCSKH','213',1,1),(6,'admin','2022-10-03 13:27:19','admin','2022-10-03 13:27:19','QTCSKH','23',1,1),(7,'admin','2022-10-03 13:27:38','admin','2022-10-03 13:27:38','QTCSKH','',1,1),(8,'admin','2022-10-03 13:47:20','admin','2022-10-03 13:47:20','DDX','233',1,1),(18,'nguyenvana','2022-10-04 00:26:51','nguyenvana','2022-10-04 00:26:51','QTCSKH','321',5,2),(17,'nguyenvana','2022-10-04 00:26:48','nguyenvana','2022-10-04 00:26:48','DDX','123',5,2),(16,'admin','2022-10-04 00:26:00','admin','2022-10-04 00:26:00','DDX','23',5,1),(15,'admin','2022-10-04 00:25:57','admin','2022-10-04 00:25:57','QTCSKH','123',5,1);
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  KEY `FKj345gk1bovqvfame88rcx7yyx` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1),(2,2),(3,2),(4,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdby` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fullname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `status` int(11) NOT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,NULL,NULL,NULL,NULL,NULL,'admin','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG',1,'admin'),(2,NULL,NULL,NULL,NULL,NULL,'nguyen van a','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG',1,'nguyenvana'),(3,NULL,NULL,NULL,NULL,NULL,'nguyen van b','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG',1,'nguyenvanb'),(4,NULL,NULL,NULL,NULL,NULL,'nguyen van c','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG',1,'nguyenvanc');
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

-- Dump completed on 2022-10-04  0:27:56
