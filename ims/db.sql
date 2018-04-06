CREATE DATABASE  IF NOT EXISTS `imsdb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `imsdb`;
-- MySQL dump 10.13  Distrib 5.5.59, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: imsdb
-- ------------------------------------------------------
-- Server version	5.5.59-0ubuntu0.14.04.1

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
-- Table structure for table `Authorities`
--

DROP TABLE IF EXISTS `Authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Authorities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1223 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Authorities`
--

LOCK TABLES `Authorities` WRITE;
/*!40000 ALTER TABLE `Authorities` DISABLE KEYS */;
INSERT INTO `Authorities` VALUES (16,'ROLE_VIEW_USER'),(1,'ROLE_SUPER_ADMIN'),(15,'ROLE_CREATE_USER'),(2,'ROLE_DASHBOARD'),(3,'ROLE_SITE_SETUP'),(4,'ROLE_SITE_CONTENT_MANAGMENT'),(5,'ROLE_STUDENT'),(6,'ROLE_STUDENT_ADMINISTRATION'),(7,'ROLE_STUDENT_FACULTY'),(8,'ROLE_HR'),(9,'ROLE_PROGRAMME_ADMINSTRAION'),(10,'ROLE_FTS_ADMIN'),(11,'ROLE_LIB_ADMIN'),(12,'ROLE_INVENTORY_MANAGMENT'),(13,'ROLE_HOSTEL_ADMINSTRATION'),(14,'ROLE_AUTHENTICATION_MANAGMENT');
/*!40000 ALTER TABLE `Authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DivDetails`
--

DROP TABLE IF EXISTS `DivDetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DivDetails` (
  `divId` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` char(1) DEFAULT NULL,
  `dateOfEntry` datetime DEFAULT NULL,
  `dateOfModification` datetime DEFAULT NULL,
  `divContent` varchar(255) DEFAULT NULL,
  `divName` varchar(255) DEFAULT NULL,
  `siteId` int(11) DEFAULT NULL,
  PRIMARY KEY (`divId`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DivDetails`
--

LOCK TABLES `DivDetails` WRITE;
/*!40000 ALTER TABLE `DivDetails` DISABLE KEYS */;
INSERT INTO `DivDetails` VALUES (1,'Y','2018-03-06 14:09:13','2018-03-20 16:17:06','eqwewqekhbjk7yi69967896798','wqewq',1),(2,'Y','2018-03-06 14:09:13','2018-03-20 16:17:06','wewewedddd233231111','wqewq',1);
/*!40000 ALTER TABLE `DivDetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ImageDetails`
--

DROP TABLE IF EXISTS `ImageDetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ImageDetails` (
  `imageId` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` char(1) DEFAULT NULL,
  `dateOfEntry` datetime DEFAULT NULL,
  `dateOfModification` datetime DEFAULT NULL,
  `imageSequence` int(11) DEFAULT NULL,
  `imageType` varchar(255) DEFAULT NULL,
  `imageUrl` varchar(255) DEFAULT NULL,
  `siteId` int(11) DEFAULT NULL,
  PRIMARY KEY (`imageId`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ImageDetails`
--

LOCK TABLES `ImageDetails` WRITE;
/*!40000 ALTER TABLE `ImageDetails` DISABLE KEYS */;
INSERT INTO `ImageDetails` VALUES (1,'Y','2018-03-20 16:14:18',NULL,2,'','image?path=%2F3%2F1%2FslidingImage2.jpg',1);
/*!40000 ALTER TABLE `ImageDetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Menu`
--

DROP TABLE IF EXISTS `Menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Menu` (
  `menuId` int(11) NOT NULL AUTO_INCREMENT,
  `MenuGroup` int(11) DEFAULT NULL,
  `authorityId` int(11) DEFAULT NULL,
  `enabled` int(11) DEFAULT NULL,
  `menuName` varchar(255) DEFAULT NULL,
  `orederNo` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`menuId`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Menu`
--

LOCK TABLES `Menu` WRITE;
/*!40000 ALTER TABLE `Menu` DISABLE KEYS */;
INSERT INTO `Menu` VALUES (1,1,2,1,'Home',1,'dashboard'),(2,2,1,1,'Site Registration',2,'/site/SiteRegistration'),(3,3,3,1,'Choose Template',3,'/site/admin/ChooseTemplate'),(4,3,3,1,'Site Data',4,'/site/admin/siteTemplateSetupG'),(5,4,4,1,'Div Content',5,'/site/content/contentDetail'),(6,4,4,1,'Upload Site Images',6,'/site/content/SiteImagesForm'),(7,4,4,1,'Upload Logo',7,'/site/content/uploadLogo'),(8,5,3,1,'Location Level 1',8,'/site/admin/ChooseLocationLevel1'),(9,5,3,1,'Location Level 2',9,'/site/admin/ChooseLocationLevel2'),(10,5,3,1,'Location Level 3',10,'/site/admin/ChooseLocationLevel3'),(11,5,3,1,'Location Level 4',11,'/site/admin/ChooseLocationLevel4'),(12,6,1,1,'Create Role',12,'/auth/createModifyRole'),(13,6,1,1,'ViewRoles',13,'/auth/viewRoles'),(14,6,15,1,'Create User',14,'/auth/createUser'),(15,6,16,1,'View User',15,'/auth/viewUser'),(16,5,8,1,'Department Master',16,'/hr/departmentForm');
/*!40000 ALTER TABLE `Menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MenuDetails`
--

DROP TABLE IF EXISTS `MenuDetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MenuDetails` (
  `menuId` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` char(1) DEFAULT NULL,
  `dateOfEntry` datetime DEFAULT NULL,
  `dateOfModification` datetime DEFAULT NULL,
  `menuName` varchar(255) DEFAULT NULL,
  `menuUrl` varchar(255) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `siteId` int(11) DEFAULT NULL,
  PRIMARY KEY (`menuId`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MenuDetails`
--

LOCK TABLES `MenuDetails` WRITE;
/*!40000 ALTER TABLE `MenuDetails` DISABLE KEYS */;
INSERT INTO `MenuDetails` VALUES (21,'Y','2018-03-20 16:16:47','2018-03-20 16:16:47','Courses','',0,1),(20,'Y','2018-03-20 16:16:47','2018-03-20 16:16:47','About Us','',0,1),(19,'Y','2018-03-20 16:16:47','2018-03-20 16:16:47','HOme','',0,1);
/*!40000 ALTER TABLE `MenuDetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MenuGroup`
--

DROP TABLE IF EXISTS `MenuGroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MenuGroup` (
  `groupId` int(11) NOT NULL AUTO_INCREMENT,
  `enabled` int(11) DEFAULT NULL,
  `orederNo` int(11) DEFAULT NULL,
  `menuGroupName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`groupId`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MenuGroup`
--

LOCK TABLES `MenuGroup` WRITE;
/*!40000 ALTER TABLE `MenuGroup` DISABLE KEYS */;
INSERT INTO `MenuGroup` VALUES (1,1,1,'Dashboard'),(2,1,2,'Site Registration'),(3,1,3,'Site Setup'),(4,1,4,'Site Content'),(5,1,5,'Masters'),(6,1,6,'Users and Roles');
/*!40000 ALTER TABLE `MenuGroup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MstCountry`
--

DROP TABLE IF EXISTS `MstCountry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MstCountry` (
  `countryId` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` char(1) DEFAULT NULL,
  `countryCode` int(11) DEFAULT NULL,
  `countryName` varchar(255) DEFAULT NULL,
  `enteredBy` int(11) DEFAULT NULL,
  `entryDate` datetime DEFAULT NULL,
  `modifiedBy` int(11) DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  PRIMARY KEY (`countryId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MstCountry`
--

LOCK TABLES `MstCountry` WRITE;
/*!40000 ALTER TABLE `MstCountry` DISABLE KEYS */;
/*!40000 ALTER TABLE `MstCountry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MstLocationLevel1`
--

DROP TABLE IF EXISTS `MstLocationLevel1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MstLocationLevel1` (
  `locLevel1Id` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` char(1) DEFAULT NULL,
  `countryId` int(11) DEFAULT NULL,
  `enteredBy` int(11) DEFAULT NULL,
  `entryDate` datetime DEFAULT NULL,
  `locLevel1Code` int(11) DEFAULT NULL,
  `locLevel1Name` varchar(255) DEFAULT NULL,
  `modifiedBy` int(11) DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  PRIMARY KEY (`locLevel1Id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MstLocationLevel1`
--

LOCK TABLES `MstLocationLevel1` WRITE;
/*!40000 ALTER TABLE `MstLocationLevel1` DISABLE KEYS */;
/*!40000 ALTER TABLE `MstLocationLevel1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MstLocationLevel2`
--

DROP TABLE IF EXISTS `MstLocationLevel2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MstLocationLevel2` (
  `locLevel2Id` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` char(1) DEFAULT NULL,
  `countryId` int(11) DEFAULT NULL,
  `enteredBy` int(11) DEFAULT NULL,
  `entryDate` datetime DEFAULT NULL,
  `locLevel1Id` int(11) DEFAULT NULL,
  `locLevel2Code` int(11) DEFAULT NULL,
  `locLevel2Name` varchar(255) DEFAULT NULL,
  `modifiedBy` int(11) DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  PRIMARY KEY (`locLevel2Id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MstLocationLevel2`
--

LOCK TABLES `MstLocationLevel2` WRITE;
/*!40000 ALTER TABLE `MstLocationLevel2` DISABLE KEYS */;
/*!40000 ALTER TABLE `MstLocationLevel2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MstLocationLevel3`
--

DROP TABLE IF EXISTS `MstLocationLevel3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MstLocationLevel3` (
  `locLevel3Id` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` char(1) DEFAULT NULL,
  `countryId` int(11) DEFAULT NULL,
  `enteredBy` int(11) DEFAULT NULL,
  `entryDate` datetime DEFAULT NULL,
  `locLevel1Id` int(11) DEFAULT NULL,
  `locLevel2Id` int(11) DEFAULT NULL,
  `locLevel3Code` int(11) DEFAULT NULL,
  `locLevel3Name` varchar(255) DEFAULT NULL,
  `modifiedBy` int(11) DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  PRIMARY KEY (`locLevel3Id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MstLocationLevel3`
--

LOCK TABLES `MstLocationLevel3` WRITE;
/*!40000 ALTER TABLE `MstLocationLevel3` DISABLE KEYS */;
/*!40000 ALTER TABLE `MstLocationLevel3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MstLocationLevel4`
--

DROP TABLE IF EXISTS `MstLocationLevel4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MstLocationLevel4` (
  `locLevel4Id` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` char(1) DEFAULT NULL,
  `countryId` int(11) DEFAULT NULL,
  `enteredBy` int(11) DEFAULT NULL,
  `entryDate` datetime DEFAULT NULL,
  `locLevel1Id` int(11) DEFAULT NULL,
  `locLevel2Id` int(11) DEFAULT NULL,
  `locLevel3Id` int(11) DEFAULT NULL,
  `locLevel4Code` int(11) DEFAULT NULL,
  `locLevel4Name` varchar(255) DEFAULT NULL,
  `modifiedBy` int(11) DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  PRIMARY KEY (`locLevel4Id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MstLocationLevel4`
--

LOCK TABLES `MstLocationLevel4` WRITE;
/*!40000 ALTER TABLE `MstLocationLevel4` DISABLE KEYS */;
/*!40000 ALTER TABLE `MstLocationLevel4` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MstRole`
--

DROP TABLE IF EXISTS `MstRole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MstRole` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MstRole`
--

LOCK TABLES `MstRole` WRITE;
/*!40000 ALTER TABLE `MstRole` DISABLE KEYS */;
INSERT INTO `MstRole` VALUES (1,'SUPER_ADMIN'),(2,'SITE_ADMIN'),(3,'EMPLOYEE'),(6,'SUPER_ADMIN'),(7,'testrole'),(9,'11'),(10,'112'),(11,'22'),(12,'323'),(13,'we'),(14,'wew'),(15,'HUMAN_RESOURCE_MANAGER'),(16,'testrole4'),(17,'testrole'),(18,'testrole'),(19,'testrole'),(20,'FACULTY'),(21,'testrole22');
/*!40000 ALTER TABLE `MstRole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MstState`
--

DROP TABLE IF EXISTS `MstState`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MstState` (
  `stateId` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` char(1) DEFAULT NULL,
  `countryCode` int(11) DEFAULT NULL,
  `countryId` int(11) DEFAULT NULL,
  `entryDate` datetime DEFAULT NULL,
  `stateCode` int(11) DEFAULT NULL,
  `stateName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`stateId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MstState`
--

LOCK TABLES `MstState` WRITE;
/*!40000 ALTER TABLE `MstState` DISABLE KEYS */;
/*!40000 ALTER TABLE `MstState` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RoleAuthorities`
--

DROP TABLE IF EXISTS `RoleAuthorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RoleAuthorities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `CreatedDate` datetime DEFAULT NULL,
  `ModifiedDate` datetime DEFAULT NULL,
  `authorityId` int(11) DEFAULT NULL,
  `createdBy` int(11) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `modifiedBy` int(11) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=76 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RoleAuthorities`
--

LOCK TABLES `RoleAuthorities` WRITE;
/*!40000 ALTER TABLE `RoleAuthorities` DISABLE KEYS */;
INSERT INTO `RoleAuthorities` VALUES (68,'2018-03-15 16:44:16',NULL,7,1,'',NULL,1),(67,'2018-03-15 16:44:16',NULL,6,1,'',NULL,1),(66,'2018-03-15 16:44:16',NULL,5,1,'',NULL,1),(65,'2018-03-15 16:44:16',NULL,3,1,'',NULL,1),(64,'2018-03-15 16:44:16',NULL,4,1,'',NULL,1),(63,'2018-03-15 16:44:16',NULL,9,1,'',NULL,1),(62,'2018-03-15 16:44:16',NULL,11,1,'',NULL,1),(61,'2018-03-15 16:44:16',NULL,12,1,'',NULL,1),(60,'2018-03-15 16:44:16',NULL,8,1,'',NULL,1),(59,'2018-03-15 16:44:16',NULL,13,1,'',NULL,1),(58,'2018-03-15 16:44:16',NULL,10,1,'',NULL,1),(57,'2018-03-15 16:44:16',NULL,2,1,'',NULL,1),(56,'2018-03-15 16:44:16',NULL,15,1,'',NULL,1),(55,'2018-03-15 16:44:16',NULL,14,1,'',NULL,1),(39,'2018-03-09 12:45:29',NULL,6,1,'',NULL,9),(38,'2018-03-09 12:45:29',NULL,5,1,'',NULL,9),(37,'2018-03-09 12:35:47',NULL,8,1,'',NULL,7),(36,'2018-03-09 12:35:47',NULL,1,1,'',NULL,7),(48,'2018-03-14 16:38:39',NULL,10,1,'',NULL,16),(72,'2018-03-15 16:44:30',NULL,2,1,'',NULL,15),(71,'2018-03-15 16:44:30',NULL,15,1,'',NULL,15),(45,'2018-03-12 13:58:15',NULL,3,1,'',NULL,2),(44,'2018-03-12 13:58:15',NULL,4,1,'',NULL,2),(43,'2018-03-12 13:58:15',NULL,2,1,'',NULL,2),(42,'2018-03-09 12:47:10',NULL,2,1,'',NULL,14),(41,'2018-03-09 12:46:52',NULL,3,1,'',NULL,13),(40,'2018-03-09 12:45:35',NULL,9,1,'',NULL,10),(49,'2018-03-14 16:50:31',NULL,8,1,'',NULL,17),(50,'2018-03-14 17:28:32',NULL,12,1,'',NULL,18),(51,'2018-03-14 17:31:56',NULL,12,1,'',NULL,19),(52,'2018-03-15 16:21:56',NULL,2,1,'',NULL,20),(53,'2018-03-15 16:21:56',NULL,9,1,'',NULL,20),(54,'2018-03-15 16:21:56',NULL,7,1,'',NULL,20),(69,'2018-03-15 16:44:16',NULL,1,1,'',NULL,1),(70,'2018-03-15 16:44:16',NULL,16,1,'',NULL,1),(73,'2018-03-15 16:44:30',NULL,8,1,'',NULL,15),(74,'2018-03-15 16:44:30',NULL,16,1,'',NULL,15),(75,'2018-03-15 17:05:28',NULL,12,1,'',NULL,21);
/*!40000 ALTER TABLE `RoleAuthorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SiteData`
--

DROP TABLE IF EXISTS `SiteData`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SiteData` (
  `siteId` int(11) NOT NULL,
  `activeFlag` char(1) DEFAULT NULL,
  `dateOfEntry` datetime DEFAULT NULL,
  `dateOfModification` datetime DEFAULT NULL,
  `enteredBy` int(11) DEFAULT NULL,
  `locLevel1` varchar(255) DEFAULT NULL,
  `locLevel2` varchar(255) DEFAULT NULL,
  `locLevel3` varchar(255) DEFAULT NULL,
  `locLevel4` varchar(255) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `modifiedBy` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `noOfDivs` int(11) DEFAULT NULL,
  `noOfHierarchyLevels` int(11) DEFAULT NULL,
  `noOfMenu` int(11) DEFAULT NULL,
  `noOfSlidingImg` int(11) DEFAULT NULL,
  `templateId` int(11) DEFAULT NULL,
  `urlName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`siteId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SiteData`
--

LOCK TABLES `SiteData` WRITE;
/*!40000 ALTER TABLE `SiteData` DISABLE KEYS */;
INSERT INTO `SiteData` VALUES (1,'Y',NULL,'2018-03-20 16:16:47',3,'State','District','','','image?path=%2F3%2F1%2Flogo.jpg',NULL,'Custrom Main Heading',4,2,NULL,NULL,1,'site1');
/*!40000 ALTER TABLE `SiteData` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SiteRegistrationDetail`
--

DROP TABLE IF EXISTS `SiteRegistrationDetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SiteRegistrationDetail` (
  `siteId` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` char(1) DEFAULT NULL,
  `addressCity` varchar(255) DEFAULT NULL,
  `addressCountry` varchar(255) DEFAULT NULL,
  `addressLine1` varchar(255) DEFAULT NULL,
  `addressLine2` varchar(255) DEFAULT NULL,
  `addressState` varchar(255) DEFAULT NULL,
  `pincode` int(11) DEFAULT NULL,
  `adminId` int(11) DEFAULT NULL,
  `contactEmail` varchar(255) DEFAULT NULL,
  `contactNumber` varchar(255) DEFAULT NULL,
  `dateOfEntry` datetime DEFAULT NULL,
  `dateOfModification` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `registeredBy` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`siteId`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SiteRegistrationDetail`
--

LOCK TABLES `SiteRegistrationDetail` WRITE;
/*!40000 ALTER TABLE `SiteRegistrationDetail` DISABLE KEYS */;
INSERT INTO `SiteRegistrationDetail` VALUES (1,NULL,'Delhi','India','B-7/17 Krishna Nagar ,Delhi','','Delhi',110051,3,'anujashridhar@gmail.com','9650147272','2018-03-05 14:27:09',NULL,'Anuja shridhar',NULL);
/*!40000 ALTER TABLE `SiteRegistrationDetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `StudentRegistrationdetails`
--

DROP TABLE IF EXISTS `StudentRegistrationdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `StudentRegistrationdetails` (
  `studentid` int(11) NOT NULL AUTO_INCREMENT,
  `studentcontactnumber` varchar(255) NOT NULL,
  `studentemailid` varchar(255) NOT NULL,
  `studentname` varchar(255) NOT NULL,
  `studentpassword` varchar(255) NOT NULL,
  PRIMARY KEY (`studentid`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `StudentRegistrationdetails`
--

LOCK TABLES `StudentRegistrationdetails` WRITE;
/*!40000 ALTER TABLE `StudentRegistrationdetails` DISABLE KEYS */;
INSERT INTO `StudentRegistrationdetails` VALUES (1,'9540998275','vibhatare@gmail.com','adadad','Aa123456'),(2,'9540998275','vibhatare@gmail.com','adasdasd','Aa123456'),(3,'9090909090','nit@ghm.com','Nitin','aA1aaaaa'),(4,'09999999999','anujashridhar@gmail.com','Anuja shridhar','Cdac@123');
/*!40000 ALTER TABLE `StudentRegistrationdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SubMenuDetails`
--

DROP TABLE IF EXISTS `SubMenuDetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SubMenuDetails` (
  `subMenuId` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` char(1) DEFAULT NULL,
  `dateOfEntry` datetime DEFAULT NULL,
  `dateOfModification` datetime DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `siteId` int(11) DEFAULT NULL,
  `subMenuName` varchar(255) DEFAULT NULL,
  `subMenuUrl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`subMenuId`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SubMenuDetails`
--

LOCK TABLES `SubMenuDetails` WRITE;
/*!40000 ALTER TABLE `SubMenuDetails` DISABLE KEYS */;
INSERT INTO `SubMenuDetails` VALUES (26,'Y','2018-03-20 16:16:47','2018-03-20 16:16:47',21,1,'Phd22',NULL),(25,'Y','2018-03-20 16:16:47','2018-03-20 16:16:47',21,1,'Mtech',NULL),(24,'Y','2018-03-20 16:16:47','2018-03-20 16:16:47',20,1,'ww',NULL),(23,'Y','2018-03-20 16:16:47','2018-03-20 16:16:47',20,1,'eewe',NULL);
/*!40000 ALTER TABLE `SubMenuDetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TemplateDetails`
--

DROP TABLE IF EXISTS `TemplateDetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TemplateDetails` (
  `templateElementId` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` char(1) DEFAULT NULL,
  `cssClass` varchar(255) DEFAULT NULL,
  `dateOfEntry` datetime DEFAULT NULL,
  `dateOfModification` datetime DEFAULT NULL,
  `parentDiv` varchar(255) DEFAULT NULL,
  `templateElementName` varchar(255) DEFAULT NULL,
  `templateElementType` varchar(255) DEFAULT NULL,
  `templateId` int(11) NOT NULL,
  PRIMARY KEY (`templateElementId`),
  KEY `FKouodpe96dp82u9amtkwctjob4` (`templateId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TemplateDetails`
--

LOCK TABLES `TemplateDetails` WRITE;
/*!40000 ALTER TABLE `TemplateDetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `TemplateDetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TemplateMaster`
--

DROP TABLE IF EXISTS `TemplateMaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TemplateMaster` (
  `templateId` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` char(1) DEFAULT NULL,
  `dateOfEntry` datetime DEFAULT NULL,
  `dateOfModification` datetime DEFAULT NULL,
  `templateName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`templateId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TemplateMaster`
--

LOCK TABLES `TemplateMaster` WRITE;
/*!40000 ALTER TABLE `TemplateMaster` DISABLE KEYS */;
/*!40000 ALTER TABLE `TemplateMaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TemplateModifier`
--

DROP TABLE IF EXISTS `TemplateModifier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TemplateModifier` (
  `templateModId` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` char(1) DEFAULT NULL,
  `attribute` varchar(255) DEFAULT NULL,
  `cssClass` varchar(255) DEFAULT NULL,
  `dateOfEntry` datetime DEFAULT NULL,
  `dateOfModification` datetime DEFAULT NULL,
  `templateElementId` int(11) DEFAULT NULL,
  `templateId` int(11) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`templateModId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TemplateModifier`
--

LOCK TABLES `TemplateModifier` WRITE;
/*!40000 ALTER TABLE `TemplateModifier` DISABLE KEYS */;
/*!40000 ALTER TABLE `TemplateModifier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tocken`
--

DROP TABLE IF EXISTS `Tocken`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tocken` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `disabledDate` datetime DEFAULT NULL,
  `generatedDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `tocken` varchar(255) DEFAULT NULL,
  `typeOfTocken` varchar(255) DEFAULT NULL,
  `validFlag` char(1) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tocken`
--

LOCK TABLES `Tocken` WRITE;
/*!40000 ALTER TABLE `Tocken` DISABLE KEYS */;
INSERT INTO `Tocken` VALUES (1,NULL,'2018-03-13 15:55:40',NULL,'N','w0K7IvKjOiQNdIqPpC5w3yPd6XsBQz','Email Verification Tocken',NULL,NULL),(2,NULL,'2018-03-14 14:49:24',NULL,'N','NxY3P4QhPqe4fxGWKUtuTgpVHpwbYr','Email Verification Tocken',NULL,NULL),(3,NULL,'2018-03-14 15:56:13',NULL,'N','ycEc7AQHrUZdGdafgNWvk7sYyG3t1u','Email Verification Tocken',NULL,NULL),(4,NULL,'2018-03-14 15:59:18',NULL,'N','aiv9Vq28NpOmURCyjBJFWPLhCl9K84','Email Verification Tocken',NULL,NULL),(5,NULL,'2018-03-14 16:03:36',NULL,'N','XyrEFAna3CsvAFM6YLBSLDw6FqhDVy','Email Verification Tocken',NULL,NULL),(6,NULL,'2018-03-14 16:09:21',NULL,'N','eRhJN4i0ZhhVM91tvz4w7tWDuaIa45','Email Verification Tocken',NULL,NULL),(7,NULL,'2018-03-14 16:11:27',NULL,'N','uDoEU7APL0nXfuxMxC4MZQgoMyKXc8','Email Verification Tocken',NULL,NULL),(8,NULL,'2018-03-14 16:35:54',NULL,'N','lCR8i79tNMhXxT9YKTqJYNoEraQUf6','Email Verification Tocken',NULL,NULL),(9,NULL,'2018-03-14 16:38:03',NULL,'N','Ia1du24xEb4lJ7FpQhwo6nmpxfrMGK','Email Verification Tocken',NULL,NULL),(10,NULL,'2018-03-15 16:33:19',NULL,'N','cEhfpw2ibaOzfIweSYcObVCFKMO8RL','Email Verification Tocken',NULL,NULL),(11,NULL,'2018-03-15 17:08:49',NULL,'N','bgNGWWk5XkQwQyKbK1rqnCWjvYBpol','Email Verification Tocken',NULL,NULL),(12,NULL,'2018-03-15 17:10:13',NULL,'N','WdJ0hYFPJbdlbw5i4mm9ypwxWRfHxp','Email Verification Tocken',NULL,NULL);
/*!40000 ALTER TABLE `Tocken` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` char(1) DEFAULT NULL,
  `addressCity` varchar(255) DEFAULT NULL,
  `addressCountry` varchar(255) DEFAULT NULL,
  `addressLine1` varchar(255) DEFAULT NULL,
  `addressLine2` varchar(255) DEFAULT NULL,
  `addressState` varchar(255) DEFAULT NULL,
  `pincode` varchar(20) DEFAULT NULL,
  `dateOfModification` datetime DEFAULT NULL,
  `dateofEntry` datetime DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `siteId` int(11) DEFAULT NULL,
  `userContactNo` varchar(255) DEFAULT NULL,
  `userEmail` varchar(255) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `userType` varchar(255) DEFAULT NULL,
  `modifiedBy` int(11) DEFAULT NULL,
  `registeredBy` int(11) DEFAULT NULL,
  `departmentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1,'1','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'test123',0,NULL,'anujashridhar2@gmail.com','mary','1',NULL,NULL,NULL),(2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'test123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'Y','Delhi','India','B-7/17 Krishna Nagar ,Delhi','','Delhi','110051','2018-03-05 14:27:09','2018-03-05 14:27:09','test123',1,'9650147272','anujashridhar21@gmail.com','Anuja shridhar','2',NULL,NULL,NULL),(9,'0','','','','','','110051',NULL,'2018-03-13 15:54:54','test123',NULL,'9999999999','anujashridhar@gmail.com','ADSDee','3',NULL,1,NULL),(16,'0','','','','','','',NULL,'2018-03-14 16:35:54','test123',NULL,'1111111111','nitinbahri111@gmail.com','ADSDee','3',NULL,1,NULL),(17,'0','','','','','','',NULL,'2018-03-14 16:38:03','test123',NULL,'2222222222','shambhavishridhar@gmail.com','ADSDee','3',NULL,1,NULL),(18,'0','','','','','','',NULL,'2018-03-15 16:33:19','test123',NULL,'0000077777','anujashridhar.data@gmail.com','Nitin','15',NULL,1,NULL),(20,'0','','','','','','',NULL,'2018-03-15 17:10:13','test123',NULL,'4333333333','nitinbahri11@gmail.com','sdffsdfsdfsd','15',NULL,1,NULL);
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UserRole`
--

DROP TABLE IF EXISTS `UserRole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UserRole` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enabled` char(1) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UserRole`
--

LOCK TABLES `UserRole` WRITE;
/*!40000 ALTER TABLE `UserRole` DISABLE KEYS */;
INSERT INTO `UserRole` VALUES (1,'1',1,1),(2,'1',2,1),(3,'1',2,3),(15,'1',3,17),(14,'1',3,16),(7,'1',3,9),(16,'1',15,18),(18,'1',15,20);
/*!40000 ALTER TABLE `UserRole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'imsdb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-28 12:59:15
