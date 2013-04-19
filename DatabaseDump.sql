CREATE DATABASE  IF NOT EXISTS `pizzeria` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `pizzeria`;
-- MySQL dump 10.13  Distrib 5.6.10, for Win64 (x86_64)
--
-- Host: localhost    Database: pizzeria
-- ------------------------------------------------------
-- Server version	5.6.10

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `login` varchar(64) NOT NULL,
  `password_hash` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dish`
--

DROP TABLE IF EXISTS `dish`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dish` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `sort_id` int(10) unsigned zerofill NOT NULL,
  `name` varchar(128) NOT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `ingredients` varchar(512) DEFAULT NULL,
  `pic_path` varchar(256) DEFAULT NULL,
  `weight` int(10) unsigned DEFAULT '0',
  `price` int(10) unsigned DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `dish_dishsort_fk` (`sort_id`),
  CONSTRAINT `dish_dishsort_fk` FOREIGN KEY (`sort_id`) REFERENCES `dish_sort` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dish`
--

LOCK TABLES `dish` WRITE;
/*!40000 ALTER TABLE `dish` DISABLE KEYS */;
INSERT INTO `dish` VALUES (0000000001,0000000001,'\"Тестовая\"','Вкусная тестовая пицца','Колбаса, ветчина, бекон, помидоры','images/pizzas/test.jpg',512,256),(0000000002,0000000001,'Пицца1','Описание Пицца1','Состав Пицца1','images/pizzas/null.jpg',642,193),(0000000003,0000000001,'Пицца2','Описание Пицца2','Состав Пицца2','images/pizzas/null.jpg',50,533),(0000000004,0000000001,'Пицца3','Описание Пицца3','Состав Пицца3','images/pizzas/null.jpg',785,311),(0000000005,0000000001,'Пицца4','Описание Пицца4','Состав Пицца4','images/pizzas/null.jpg',1112,443),(0000000006,0000000001,'Пицца5','Описание Пицца5','Состав Пицца5','images/pizzas/null.jpg',197,64),(0000000007,0000000001,'Пицца6','Описание Пицца6','Состав Пицца6','images/pizzas/null.jpg',118,299),(0000000008,0000000003,'Холодные блюда1','Описание Холодные блюда1','Состав Холодные блюда1','images/pizzas/null.jpg',1014,87),(0000000009,0000000003,'Холодные блюда2','Описание Холодные блюда2','Состав Холодные блюда2','images/pizzas/null.jpg',47,450),(0000000010,0000000003,'Холодные блюда3','Описание Холодные блюда3','Состав Холодные блюда3','images/pizzas/null.jpg',1109,109),(0000000011,0000000003,'Холодные блюда4','Описание Холодные блюда4','Состав Холодные блюда4','images/pizzas/null.jpg',1110,102),(0000000012,0000000003,'Холодные блюда5','Описание Холодные блюда5','Состав Холодные блюда5','images/pizzas/null.jpg',630,170),(0000000013,0000000003,'Холодные блюда6','Описание Холодные блюда6','Состав Холодные блюда6','images/pizzas/null.jpg',1079,56),(0000000014,0000000002,'Горячие блюда1','Описание Горячие блюда1','Состав Горячие блюда1','images/pizzas/null.jpg',64,527),(0000000015,0000000002,'Горячие блюда2','Описание Горячие блюда2','Состав Горячие блюда2','images/pizzas/null.jpg',400,220),(0000000016,0000000002,'Горячие блюда3','Описание Горячие блюда3','Состав Горячие блюда3','images/pizzas/null.jpg',756,277),(0000000017,0000000002,'Горячие блюда4','Описание Горячие блюда4','Состав Горячие блюда4','images/pizzas/null.jpg',1100,138),(0000000018,0000000002,'Горячие блюда5','Описание Горячие блюда5','Состав Горячие блюда5','images/pizzas/null.jpg',268,523),(0000000019,0000000002,'Горячие блюда6','Описание Горячие блюда6','Состав Горячие блюда6','images/pizzas/null.jpg',835,21),(0000000020,0000000004,'Десерты1','Описание Десерты1','Состав Десерты1','images/pizzas/null.jpg',1018,149),(0000000021,0000000004,'Десерты2','Описание Десерты2','Состав Десерты2','images/pizzas/null.jpg',1045,187),(0000000022,0000000004,'Десерты3','Описание Десерты3','Состав Десерты3','images/pizzas/null.jpg',557,303),(0000000023,0000000004,'Десерты4','Описание Десерты4','Состав Десерты4','images/pizzas/null.jpg',677,49),(0000000024,0000000004,'Десерты5','Описание Десерты5','Состав Десерты5','images/pizzas/null.jpg',1006,209),(0000000025,0000000004,'Десерты6','Описание Десерты6','Состав Десерты6','images/pizzas/null.jpg',170,321),(0000000026,0000000005,'Японская кухня1','Описание Японская кухня1','Состав Японская кухня1','images/pizzas/null.jpg',1061,307),(0000000027,0000000005,'Японская кухня2','Описание Японская кухня2','Состав Японская кухня2','images/pizzas/null.jpg',745,150),(0000000028,0000000005,'Японская кухня3','Описание Японская кухня3','Состав Японская кухня3','images/pizzas/null.jpg',1051,352),(0000000029,0000000005,'Японская кухня4','Описание Японская кухня4','Состав Японская кухня4','images/pizzas/null.jpg',58,595),(0000000030,0000000005,'Японская кухня5','Описание Японская кухня5','Состав Японская кухня5','images/pizzas/null.jpg',14,219),(0000000031,0000000005,'Японская кухня6','Описание Японская кухня6','Состав Японская кухня6','images/pizzas/null.jpg',925,221),(0000000032,0000000006,'Напитки1','Описание Напитки1','Состав Напитки1','images/pizzas/null.jpg',364,531),(0000000033,0000000006,'Напитки2','Описание Напитки2','Состав Напитки2','images/pizzas/null.jpg',1106,182),(0000000034,0000000006,'Напитки3','Описание Напитки3','Состав Напитки3','images/pizzas/null.jpg',1185,530),(0000000035,0000000006,'Напитки4','Описание Напитки4','Состав Напитки4','images/pizzas/null.jpg',241,195),(0000000036,0000000006,'Напитки5','Описание Напитки5','Состав Напитки5','images/pizzas/null.jpg',388,529),(0000000037,0000000006,'Напитки6','Описание Напитки6','Состав Напитки6','images/pizzas/null.jpg',203,450);
/*!40000 ALTER TABLE `dish` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dish_sort`
--

DROP TABLE IF EXISTS `dish_sort`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dish_sort` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `pic_path` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dish_sort`
--

LOCK TABLES `dish_sort` WRITE;
/*!40000 ALTER TABLE `dish_sort` DISABLE KEYS */;
INSERT INTO `dish_sort` VALUES (0000000001,'Пицца','images/dish_sorts/pizza.jpg'),(0000000002,'Горячие блюда','images/dish_sorts/hotdish.jpg'),(0000000003,'Холодные блюда','images/dish_sorts/colddish.jpg'),(0000000004,'Десерты','images/dish_sorts/dessert.jpg'),(0000000005,'Японская кухня','images/dish_sorts/japanese.jpg'),(0000000006,'Напитки','images/dish_sorts/drink.jpg');
/*!40000 ALTER TABLE `dish_sort` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(256) NOT NULL,
  `customer_address` varchar(256) NOT NULL,
  `customer_phone` varchar(20) NOT NULL,
  `recieving_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `sending_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_item`
--

DROP TABLE IF EXISTS `order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_item` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` int(10) unsigned NOT NULL,
  `dish_id` int(10) unsigned zerofill NOT NULL,
  `quantity` int(10) unsigned NOT NULL,
  `cost` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `orderitem_dish_fk` (`dish_id`),
  KEY `orderitem_order_fk` (`order_id`),
  CONSTRAINT `orderitem_dish_fk` FOREIGN KEY (`dish_id`) REFERENCES `dish` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `orderitem_order_fk` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_item`
--

LOCK TABLES `order_item` WRITE;
/*!40000 ALTER TABLE `order_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_item` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-04-20  3:56:10
