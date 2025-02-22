-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: spring_project
-- ------------------------------------------------------
-- Server version	8.0.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin_logs`
--

DROP TABLE IF EXISTS `admin_logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_logs` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `action` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  `entity_id` bigint DEFAULT NULL,
  `entity_type` varchar(255) DEFAULT NULL,
  `admin_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoix4xxbvhimiroqel44k3h7uk` (`admin_id`),
  CONSTRAINT `FKoix4xxbvhimiroqel44k3h7uk` FOREIGN KEY (`admin_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_logs`
--

LOCK TABLES `admin_logs` WRITE;
/*!40000 ALTER TABLE `admin_logs` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin_logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_metrics`
--

DROP TABLE IF EXISTS `admin_metrics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_metrics` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `metric_date` datetime(6) DEFAULT NULL,
  `metric_name` varchar(255) DEFAULT NULL,
  `metric_value` bigint DEFAULT NULL,
  `recorded_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_metrics`
--

LOCK TABLES `admin_metrics` WRITE;
/*!40000 ALTER TABLE `admin_metrics` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin_metrics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `celestial_events`
--

DROP TABLE IF EXISTS `celestial_events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `celestial_events` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `event_date` datetime NOT NULL,
  `event_type` varchar(255) DEFAULT NULL,
  `visibility_location` varchar(255) DEFAULT NULL,
  `duration` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `celestial_events`
--

LOCK TABLES `celestial_events` WRITE;
/*!40000 ALTER TABLE `celestial_events` DISABLE KEYS */;
INSERT INTO `celestial_events` VALUES (1,'Lunar Eclipse','A total lunar eclipse visible across Asia','2025-03-14 20:00:00','Eclipse','Asia','3 hours','/images/lunar-eclipse.jpg'),(2,'Perseid Meteor Shower','Annual meteor shower with up to 60 meteors per hour','2025-08-12 22:00:00','Meteor Shower','Northern Hemisphere','Peak lasting 2 days','/images/perseids.jpg');
/*!40000 ALTER TABLE `celestial_events` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planet_change_history`
--

DROP TABLE IF EXISTS `planet_change_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `planet_change_history` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `change_type` varchar(255) DEFAULT NULL,
  `changed_at` datetime(6) DEFAULT NULL,
  `changed_fields` varchar(255) DEFAULT NULL,
  `new_values` varchar(255) DEFAULT NULL,
  `old_values` varchar(255) DEFAULT NULL,
  `changed_by` bigint DEFAULT NULL,
  `planet_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK81ys0kh47v93kr4nve5ifqnqp` (`changed_by`),
  KEY `FKm8hhp6foiredakk07gxdut3vp` (`planet_id`),
  CONSTRAINT `FK81ys0kh47v93kr4nve5ifqnqp` FOREIGN KEY (`changed_by`) REFERENCES `users` (`id`),
  CONSTRAINT `FKm8hhp6foiredakk07gxdut3vp` FOREIGN KEY (`planet_id`) REFERENCES `planets` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planet_change_history`
--

LOCK TABLES `planet_change_history` WRITE;
/*!40000 ALTER TABLE `planet_change_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `planet_change_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planets`
--

DROP TABLE IF EXISTS `planets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `planets` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `distance_from_sun` double DEFAULT NULL,
  `diameter` double DEFAULT NULL,
  `orbital_period` double DEFAULT NULL,
  `moons` int DEFAULT NULL,
  `gravity` double DEFAULT NULL,
  `atmosphere_composition` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planets`
--

LOCK TABLES `planets` WRITE;
/*!40000 ALTER TABLE `planets` DISABLE KEYS */;
INSERT INTO `planets` VALUES (1,'Mercury','Smallest and closest to the Sun.','/images/mercury.jpeg',57.91,4879,87.97,0,3.7,'Oxygen, Sodium, Hydrogen, Helium, Potassium'),(2,'Venus','Second planet with a thick, hot atmosphere.','/images/venus.jpeg',108.2,12104,224.7,0,8.87,'Carbon Dioxide, Nitrogen, Sulfur Dioxide'),(3,'Earth','The only planet known to support life.','/images/earth.jpeg',149.6,12742,365.25,1,9.81,'Nitrogen, Oxygen, Argon, Carbon Dioxide'),(4,'Mars','The red planet with potential past water.','/images/mars.jpeg',227.9,6779,687,2,3.71,'Carbon Dioxide, Nitrogen, Argon'),(5,'Jupiter','Largest planet with a giant storm.','/images/jupiter.jpeg',778.5,139820,4331,80,24.79,'Hydrogen, Helium, Methane, Ammonia'),(6,'Saturn','Gas giant with iconic rings.','/images/saturn.jpeg',1433.5,116460,10747,82,10.44,'Hydrogen, Helium, Methane, Ammonia'),(7,'Uranus','Ice giant with extreme tilt and rings.','/images/uranus.jpeg',2872.5,50724,30589,27,8.69,'Hydrogen, Helium, Methane'),(8,'Neptune','Farthest planet with strong winds.','/images/neptune.jpeg',4495.1,49528,59800,14,11.15,'Hydrogen, Helium, Methane');
/*!40000 ALTER TABLE `planets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_profiles`
--

DROP TABLE IF EXISTS `user_profiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_profiles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `favorite_planet` varchar(255) DEFAULT NULL,
  `bio` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_profiles_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_profiles`
--

LOCK TABLES `user_profiles` WRITE;
/*!40000 ALTER TABLE `user_profiles` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_profiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `user_id` bigint NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  KEY `FKhfh9dx7w3ubf1co1vdev94g3f` (`user_id`),
  CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (6,'ROLE_ADMIN'),(9,'ROLE_ADMIN');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (6,'admin','hk','admin@example.com',1),(9,'hemant','hk','hk@hk',1);
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

-- Dump completed on 2025-02-22 13:48:39
