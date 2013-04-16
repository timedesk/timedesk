CREATE DATABASE  IF NOT EXISTS `timedesk_beta` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `timedesk_beta`;
-- MySQL dump 10.13  Distrib 5.1.40, for Win32 (ia32)
--
-- Host: localhost    Database: timedesk
-- ------------------------------------------------------
-- Server version	5.1.52-community

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
-- Table structure for table `em_role`
--

DROP TABLE IF EXISTS `em_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `em_role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `role_id` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `em_role`
--

LOCK TABLES `em_role` WRITE;
/*!40000 ALTER TABLE `em_role` DISABLE KEYS */;
INSERT INTO `em_role` VALUES (51,'Software Engineer','SE',1),(102,'Senior Software Engineer','SSE',1),(103,'Quality Assurance Engineer','QAE',1),(104,'Senior Quality Assurance Engineer','SQAE',1);
/*!40000 ALTER TABLE `em_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_leave`
--

DROP TABLE IF EXISTS `employee_leave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_leave` (
  `id` bigint(20) NOT NULL,
  `from_time` datetime DEFAULT NULL,
  `to_time` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `employee_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_leave`
--

LOCK TABLES `employee_leave` WRITE;
/*!40000 ALTER TABLE `employee_leave` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_leave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sequence`
--

DROP TABLE IF EXISTS `sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequence`
--

LOCK TABLES `sequence` WRITE;
/*!40000 ALTER TABLE `sequence` DISABLE KEYS */;
INSERT INTO `sequence` VALUES ('SEQ_GEN','1050');
/*!40000 ALTER TABLE `sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `company_id` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNQ_company_0` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'Timedesk Software Foundation','TD',3);
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `enabled` tinyint(1) DEFAULT '0',
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,1,'admin','admin',2),(153,1,'resourcemanager','resourcemanager',3),(154,1,'projectmanager','projectmanager',3),(201,1,'imesh','imesh',1),(202,1,'chamil','chamil',1),(204,1,'channa','channa',1),(205,1,'thilina','thilina',1),(206,1,'eranga','eranga',1),(207,1,'nilupulee','nilupulee',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `security_role`
--

DROP TABLE IF EXISTS `security_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `security_role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `security_role_id` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `security_role`
--

LOCK TABLES `security_role` WRITE;
/*!40000 ALTER TABLE `security_role` DISABLE KEYS */;
INSERT INTO `security_role` VALUES (1,'Administrator','ADMIN',2),(109,'Project Manager','PM',2),(110,'Resource Manager','RM',2),(111,'Project Member','PMEM',1),(112,'Training Manager','TM',1);
/*!40000 ALTER TABLE `security_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `application_feature`
--

DROP TABLE IF EXISTS `application_feature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `application_feature` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `feature_id` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNQ_application_feature_0` (`feature_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application_feature`
--

LOCK TABLES `application_feature` WRITE;
/*!40000 ALTER TABLE `application_feature` DISABLE KEYS */;
INSERT INTO `application_feature` VALUES (113,'This feature will allow employee information management','Employee Management','EMPMGT',3),(151,'This feature will allow employee leave management','Leave Management','LVMMGT',2),(152,'This feature will allow project information management','Project Management','PRMGT',2),(203,'This feature will allow viewing others employee information','View Employee Information','VEMP',1);
/*!40000 ALTER TABLE `application_feature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill`
--

DROP TABLE IF EXISTS `skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skill` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `skill_id` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill`
--

LOCK TABLES `skill` WRITE;
/*!40000 ALTER TABLE `skill` DISABLE KEYS */;
INSERT INTO `skill` VALUES (11,'Java Web Development','JAVAWEB',4),(12,'Spring MVC Web Development','SPRINGMVC',3),(13,'.NET Windows Application Development','DNETWIN',1),(14,'Java Enterprise Edition Development','JAVAEE',2),(15,'Software Designing','SOFTDESIGN',1);
/*!40000 ALTER TABLE `skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_phase_member`
--

DROP TABLE IF EXISTS `project_phase_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_phase_member` (
  `id` bigint(20) NOT NULL,
  `start_date` datetime DEFAULT NULL,
  `phase_member_id` varchar(255) DEFAULT NULL,
  `allocation` int(11) DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `member_id` varchar(255) DEFAULT NULL,
  `phase_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_phase_member`
--

LOCK TABLES `project_phase_member` WRITE;
/*!40000 ALTER TABLE `project_phase_member` DISABLE KEYS */;
INSERT INTO `project_phase_member` VALUES (751,'2011-02-05 00:00:00','IM',60,'2011-02-08 00:00:00',1,'IMESH','P1');
/*!40000 ALTER TABLE `project_phase_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pm_role`
--

DROP TABLE IF EXISTS `pm_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pm_role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `role_id` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pm_role`
--

LOCK TABLES `pm_role` WRITE;
/*!40000 ALTER TABLE `pm_role` DISABLE KEYS */;
INSERT INTO `pm_role` VALUES (106,'Project Manager','PM',1),(107,'Team Leader','TL',1),(108,'Package Manager','PGM',1);
/*!40000 ALTER TABLE `pm_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_em_role`
--

DROP TABLE IF EXISTS `employee_em_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_em_role` (
  `Employee_id` bigint(20) NOT NULL,
  `employeeRoles_id` bigint(20) NOT NULL,
  PRIMARY KEY (`Employee_id`,`employeeRoles_id`),
  KEY `FK_employee_em_role_employeeRoles_id` (`employeeRoles_id`),
  CONSTRAINT `FK_employee_em_role_employeeRoles_id` FOREIGN KEY (`employeeRoles_id`) REFERENCES `em_role` (`id`),
  CONSTRAINT `FK_employee_em_role_Employee_id` FOREIGN KEY (`Employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_em_role`
--

LOCK TABLES `employee_em_role` WRITE;
/*!40000 ALTER TABLE `employee_em_role` DISABLE KEYS */;
INSERT INTO `employee_em_role` VALUES (3,102),(952,102);
/*!40000 ALTER TABLE `employee_em_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_member_pm_role`
--

DROP TABLE IF EXISTS `project_member_pm_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_member_pm_role` (
  `ProjectMember_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL,
  PRIMARY KEY (`ProjectMember_id`,`roles_id`),
  KEY `FK_project_member_pm_role_roles_id` (`roles_id`),
  CONSTRAINT `FK_project_member_pm_role_ProjectMember_id` FOREIGN KEY (`ProjectMember_id`) REFERENCES `project_member` (`id`),
  CONSTRAINT `FK_project_member_pm_role_roles_id` FOREIGN KEY (`roles_id`) REFERENCES `pm_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_member_pm_role`
--

LOCK TABLES `project_member_pm_role` WRITE;
/*!40000 ALTER TABLE `project_member_pm_role` DISABLE KEYS */;
INSERT INTO `project_member_pm_role` VALUES (452,106),(20,107),(1005,107),(451,108);
/*!40000 ALTER TABLE `project_member_pm_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_skill`
--

DROP TABLE IF EXISTS `employee_skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_skill` (
  `Employee_id` bigint(20) NOT NULL,
  `employeeSkills_id` bigint(20) NOT NULL,
  PRIMARY KEY (`Employee_id`,`employeeSkills_id`),
  KEY `FK_employee_skill_employeeSkills_id` (`employeeSkills_id`),
  CONSTRAINT `FK_employee_skill_employeeSkills_id` FOREIGN KEY (`employeeSkills_id`) REFERENCES `skill` (`id`),
  CONSTRAINT `FK_employee_skill_Employee_id` FOREIGN KEY (`Employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_skill`
--

LOCK TABLES `employee_skill` WRITE;
/*!40000 ALTER TABLE `employee_skill` DISABLE KEYS */;
INSERT INTO `employee_skill` VALUES (16,11),(952,11),(3,12),(16,12),(17,12),(18,12),(3,13),(3,14),(18,15);
/*!40000 ALTER TABLE `employee_skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_phase`
--

DROP TABLE IF EXISTS `project_phase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_phase` (
  `id` bigint(20) NOT NULL,
  `start_date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `phase_id` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `project_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_phase`
--

LOCK TABLES `project_phase` WRITE;
/*!40000 ALTER TABLE `project_phase` DISABLE KEYS */;
INSERT INTO `project_phase` VALUES (253,'2010-12-18 00:00:00','Designing Phase','2010-12-24 00:00:00','P1',1,'OCEAN'),(301,'2010-12-25 00:00:00','Design Review Phase','2011-01-01 00:00:00','P2',1,'OCEAN'),(1006,'2011-02-22 00:00:00','Initial Phase','2011-02-28 00:00:00','INIT',2,'BLUEWAV');
/*!40000 ALTER TABLE `project_phase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_pre_em_role`
--

DROP TABLE IF EXISTS `employee_pre_em_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_pre_em_role` (
  `Employee_id` bigint(20) NOT NULL,
  `preEmployeeRoles_id` bigint(20) NOT NULL,
  PRIMARY KEY (`Employee_id`,`preEmployeeRoles_id`),
  KEY `FK_employee_pre_em_role_preEmployeeRoles_id` (`preEmployeeRoles_id`),
  CONSTRAINT `FK_employee_pre_em_role_Employee_id` FOREIGN KEY (`Employee_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `FK_employee_pre_em_role_preEmployeeRoles_id` FOREIGN KEY (`preEmployeeRoles_id`) REFERENCES `em_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_pre_em_role`
--

LOCK TABLES `employee_pre_em_role` WRITE;
/*!40000 ALTER TABLE `employee_pre_em_role` DISABLE KEYS */;
INSERT INTO `employee_pre_em_role` VALUES (952,104);
/*!40000 ALTER TABLE `employee_pre_em_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_site`
--

DROP TABLE IF EXISTS `company_site`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company_site` (
  `id` bigint(20) NOT NULL,
  `site_id` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `company_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNQ_company_site_0` (`company_id`,`site_id`),
  CONSTRAINT `FK_company_site_company_id` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_site`
--

LOCK TABLES `company_site` WRITE;
/*!40000 ALTER TABLE `company_site` DISABLE KEYS */;
INSERT INTO `company_site` VALUES (2,'CMB','WTC','Colombo','Sri Lanka',1,'TD'),(951,'KND','Kandy Town','Kandy','Sri Lanka',1,'TD');
/*!40000 ALTER TABLE `company_site` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `id` bigint(20) NOT NULL,
  `start_date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `project_id` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `company_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_project_company_id` (`company_id`),
  CONSTRAINT `FK_project_company_id` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (19,'2010-12-18 00:00:00','Timedesk Version 1','Ocean Blue','2011-02-21 00:00:00','OCEAN',1,'TD'),(1002,'2011-02-22 00:00:00','Timedesk Version 2','Project Blue Wave','2011-03-22 00:00:00','BLUEWAV',2,'TD');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_member_feedback`
--

DROP TABLE IF EXISTS `project_member_feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_member_feedback` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `feedback_id` int(11) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `member_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_member_feedback`
--

LOCK TABLES `project_member_feedback` WRITE;
/*!40000 ALTER TABLE `project_member_feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_member_feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_security_role`
--

DROP TABLE IF EXISTS `user_security_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_security_role` (
  `User_id` bigint(20) NOT NULL,
  `securityRoles_id` bigint(20) NOT NULL,
  PRIMARY KEY (`User_id`,`securityRoles_id`),
  KEY `FK_user_security_role_securityRoles_id` (`securityRoles_id`),
  CONSTRAINT `FK_user_security_role_securityRoles_id` FOREIGN KEY (`securityRoles_id`) REFERENCES `security_role` (`id`),
  CONSTRAINT `FK_user_security_role_User_id` FOREIGN KEY (`User_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_security_role`
--

LOCK TABLES `user_security_role` WRITE;
/*!40000 ALTER TABLE `user_security_role` DISABLE KEYS */;
INSERT INTO `user_security_role` VALUES (1,1),(154,109),(153,110),(201,111),(202,111),(204,111),(205,111),(206,111),(207,111);
/*!40000 ALTER TABLE `user_security_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_member`
--

DROP TABLE IF EXISTS `project_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_member` (
  `id` bigint(20) NOT NULL,
  `member_id` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `project_id` varchar(255) DEFAULT NULL,
  `employee_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_member`
--

LOCK TABLES `project_member` WRITE;
/*!40000 ALTER TABLE `project_member` DISABLE KEYS */;
INSERT INTO `project_member` VALUES (20,'IMESH',3,'OCEAN','IMESH'),(451,'CHAMIL',1,'OCEAN','CHAMIL'),(452,'THILINA',1,'OCEAN','THILINA'),(1005,'IM',1,'BLUEWAV','IMESH');
/*!40000 ALTER TABLE `project_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL,
  `employee_id` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `post_code` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `phone_mobile` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone_residence` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `office_extension` varchar(255) DEFAULT NULL,
  `site_id` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `max_allocation` int(10) DEFAULT NULL,
  `current_allocation` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (3,'IMESH','Gunaratne','',9,'Colombo','Sri_Lanka','','','imesh.gunaratne@timedeskonline.com','','Imesh','','CMB','imesh',100,60),(16,'CHAMIL','Disanayake','',5,'Colombo','Sri_Lanka','','Second Street','chamil.disanayake@timedeskonline.com','','Chamil','','CMB','chamil',80,NULL),(17,'THILINA','Ranaweera','',4,'Piliyandala','Sri_Lanka','','First Cross Street','thilina.ranaweera@timedeskonline.com','','Thilina','','CMB','thilina',70,NULL),(18,'CHANNA','Senavirathna','',5,'Kandy','Sri_Lanka','','New Kandy Road','channa.senavirathna@timedeskonline.com','','Channa','','CMB','channa',90,NULL),(501,'ALAIN','Prost','',4,'','United_States','','','alain.prost@timedeskonline.com','','Alain','','CMB','imesh',80,NULL),(952,'ERANGA','Samararathna','',4,'','Sri_Lanka','','','eranga@timedeskonline.com','','Eranga','','CMB','admin',100,NULL),(1001,'NILUPULEE','Nathawitharana','',2,'','Sri_Lanka','','','nilupulee@timedeskonline.com','','Nilupulee','','CMB','nilupulee',100,NULL);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `security_role_application_feature`
--

DROP TABLE IF EXISTS `security_role_application_feature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `security_role_application_feature` (
  `SecurityRole_id` bigint(20) NOT NULL,
  `applicationFeatures_id` bigint(20) NOT NULL,
  PRIMARY KEY (`SecurityRole_id`,`applicationFeatures_id`),
  KEY `securityroleapplicationfeaturepplicationFeaturesid` (`applicationFeatures_id`),
  CONSTRAINT `securityroleapplicationfeaturepplicationFeaturesid` FOREIGN KEY (`applicationFeatures_id`) REFERENCES `application_feature` (`id`),
  CONSTRAINT `security_role_application_feature_SecurityRole_id` FOREIGN KEY (`SecurityRole_id`) REFERENCES `security_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `security_role_application_feature`
--

LOCK TABLES `security_role_application_feature` WRITE;
/*!40000 ALTER TABLE `security_role_application_feature` DISABLE KEYS */;
INSERT INTO `security_role_application_feature` VALUES (110,113),(1,152),(109,152);
/*!40000 ALTER TABLE `security_role_application_feature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_visa`
--

DROP TABLE IF EXISTS `employee_visa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_visa` (
  `id` bigint(20) NOT NULL,
  `valid_to` datetime DEFAULT NULL,
  `valid_from` datetime DEFAULT NULL,
  `visa_id` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `employee_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_visa`
--

LOCK TABLES `employee_visa` WRITE;
/*!40000 ALTER TABLE `employee_visa` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_visa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-02-05  2:11:25
