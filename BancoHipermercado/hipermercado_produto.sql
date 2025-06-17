CREATE DATABASE  IF NOT EXISTS `hipermercado` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hipermercado`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hipermercado
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `produto` varchar(100) DEFAULT NULL,
  `qtd` int NOT NULL,
  `preco` double(9,2) DEFAULT NULL,
  `total` double(9,2) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'Arroz',10,5.50,55.00,1),(2,'Feijão Mulatinho',5,6.80,34.00,0),(3,'Macarrão',20,3.20,64.00,1),(4,'Leite',12,4.50,54.00,1),(5,'Carne Bovina',8,22.90,183.20,1),(6,'Farinha Mandioca',2,3.00,6.00,1),(7,'Bandeja de Ovos c/ 30und',30,0.56,16.80,1),(8,'Oléo de Soja',2,7.99,15.98,1),(9,'Feijão Preto',3,7.68,23.04,1),(10,'Macarrão Talharin',5,2.97,14.85,1),(11,'Macarrão Parafuso',3,2.93,8.80,1),(12,'Miojo Nissin',6,2.33,13.98,1),(13,'Açucar',1,4.90,4.90,1),(14,'Charque Pa',1,37.00,37.00,1),(15,'Carne Paleta',1,0.00,0.00,1),(16,'Carne Bisteca',1,0.00,0.00,1),(17,'Carne Paleta',1,0.00,0.00,1),(18,'Carne Chambaril',1,0.00,0.00,1),(19,'Carne Costela',1,0.00,0.00,1),(20,'Carne Chã De Dentro',1,0.00,0.00,1),(21,'Bolacha Creme Craker',1,0.00,0.00,1),(22,'Biscoito Maizena',1,0.00,0.00,1),(23,'Biscoito Maizena Maria',1,0.00,0.00,1),(24,'Bolacha Coquinho',1,0.00,0.00,1),(25,'Margarina',5,5.00,25.00,1),(26,'Vinagre',1,0.00,0.00,0),(27,'Pão Frances',1,10.99,10.99,1),(28,'Oleó De Cocô',1,20.00,20.00,0),(29,'Molho De Pimenta',1,7.99,7.99,1),(30,'Molho Inglês',1,9.90,9.90,0),(31,'Molho Shoyo',1,10.54,10.54,0),(32,'Sal Cisne',1,2.00,2.00,1);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-17 16:14:53
