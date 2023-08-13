-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 103.200.20.215    Database: TechwizDB
-- ------------------------------------------------------
-- Server version	8.0.33-0ubuntu0.20.04.4

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
-- Table structure for table `accessories`
--

DROP TABLE IF EXISTS `accessories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accessories` (
  `id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `description` text COLLATE utf8mb3_unicode_ci,
  `instruction` text COLLATE utf8mb3_unicode_ci,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `type_id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FKodq837xfvgymcsbu7xn580s59` (`type_id`) USING BTREE,
  CONSTRAINT `FKodq837xfvgymcsbu7xn580s59` FOREIGN KEY (`type_id`) REFERENCES `accessories_types` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accessories`
--

LOCK TABLES `accessories` WRITE;
/*!40000 ALTER TABLE `accessories` DISABLE KEYS */;
INSERT INTO `accessories` VALUES ('4','Our Organic Potting Mix gives your plant roots the preferred balance of air, moisture, and nutrition they need. This all-natural soil can be used for all types of indoor houseplants, as well as outdoor plants potted in containers. One medium bag is enough to pot approximately 2-3 small plants. \n\nMedium bag: 100 oz net volume, 2 lb net weight \nLarge bag: 336 oz net volume, 6.7 lb net weight \nIngredients: coir, compost, aged pine bark, rice hulls, earthworm castings \nNot eligible for discounts or promotions ',NULL,'Organic Potting Mix','b8bd9f2c-f137-4e51-a72d-26ac29229e81'),('5','Have a planter with no drainage hole? When placed at the bottom of the planter, lava rocks create a place for excess water to pool away from your plant\'s roots! Lava rocks have the additional bonus of being porous; they can absorb and slowly release excess water over time. \n\nIngredients: organic lava rocks \nBag contains enough lava rocks to line the bottom of 4-5 small 5” diameter planters or 2-3 medium 7” diameter planters \nNot applicable to discounts and promotions ',NULL,'Organic Lava Rocks','b8bd9f2c-f137-4e51-a72d-26ac29229e81'),('6','Our Organic Cacti Mix is here for all your succulents and cacti potting needs. This well-draining, all-natural mix can be used for all types of indoor succulent houseplants and outdoor plants potted in containers. One medium bag is enough to pot approximately 2-3 small plants. \n\nMedium bag: 124 oz net volume, 5.3 lb net weight\nIngredients: expanded shale, rice hulls, coir, sand, compost, soft-wood biochar, earthworm castings \nNot eligible for discounts or promotions ',NULL,'Organic Cacti Mix','b8bd9f2c-f137-4e51-a72d-26ac29229e81');
/*!40000 ALTER TABLE `accessories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `accessories_types`
--

DROP TABLE IF EXISTS `accessories_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accessories_types` (
  `id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `father_type_id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `accessories_types_accessories_types_id_fk` (`father_type_id`) USING BTREE,
  CONSTRAINT `accessories_types_accessories_types_id_fk` FOREIGN KEY (`father_type_id`) REFERENCES `accessories_types` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accessories_types`
--

LOCK TABLES `accessories_types` WRITE;
/*!40000 ALTER TABLE `accessories_types` DISABLE KEYS */;
INSERT INTO `accessories_types` VALUES ('1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5i','Trowels','Larger cutting tools for shrubs and hedges','1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5i'),('1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5j','Watering Equipment','Tools for watering plants and lawns',NULL),('1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5k','Trowels123','Larger cutting tools for shrubs and hedges',NULL),('1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5ka','Gloves','Protective gloves for gardening','1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5k'),('1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5kb','Hats','Sun hats and protective headgear','1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5k'),('1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5kc','Knee pads','Pads for protecting knees during gardening','1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5k'),('1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5kd','Safety glasses','Protective eyewear for gardening','1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5k'),('1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5m','Support Structures','Structures to support plants as they grow',NULL),('1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5p','Planting Aids','Tools to help with planting and labeling',NULL),('1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5q','Storage Solutions','Containers and gear for tool storage',NULL),('1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5s','Additional Accessories','Extra accessories for gardening','1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5i'),('1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5t','Further Accessories','Additional gardening accessories','1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5j'),('1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5u','More Accessories','More gardening accessories','1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5k'),('1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5v','Outdoor Furniture','Furniture for outdoor spaces',NULL),('1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5x','Garden Decor','Decorative items for gardens',NULL),('1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5xa','Garden statues','Decorative statues for garden embellishment','1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5x'),('1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5xb','Fountains','Water features and fountains for gardens','1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5x'),('1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5xc','Decorative lights','Outdoor lighting for garden decoration','1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5x'),('1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5xd','Garden gnomes','Whimsical gnome figurines for garden charm','1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5x'),('1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5y','Trowels98','Larger cutting tools for shrubs and hedges','1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5y'),('1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5ya','Planter boxes','Containers for planting flowers and herbs','1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5y'),('1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5yb','Hanging pots','Pots that can be hung for suspended plant displays','1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5y'),('1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5yc','Ceramic pots','Decorative ceramic pots for plants','1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5y'),('1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5yd','Vertical planters','Planters designed for vertical gardening','1a2b3c4d-5e6f-7a8b-9c0d-1e2f3g4h5y'),('b8bd9f2c-f137-4e51-a72d-26ac29229e81','Rock','Rock',NULL);
/*!40000 ALTER TABLE `accessories_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts` (
  `id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `google_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `password` varchar(70) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `username` varchar(40) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `role_id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FKt3wava8ssfdspnh3hg4col3m1` (`role_id`) USING BTREE,
  CONSTRAINT `FKt3wava8ssfdspnh3hg4col3m1` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES ('1c4a0f6a-dd3f-4ae5-b243-424a87e95a6a',NULL,'$2a$10$a7nEIYmkgU5broJOrM7B.uSIArglSuN.2anpx66J7z33z9jZdnpXy','phuc12345','3a70dd47-38a0-4324-9131-959bc2f1da92'),('301f9a29-f7a7-4ac9-adde-785fd157533a',NULL,'$2a$10$wK.3HI8Wde/tQyHBJggs5uCK7l7zEiytkiojIj75/71NNsMP29lDS','string','3a70dd47-38a0-4324-9131-959bc2f1da92'),('39b606bc-0923-48bb-9065-239e924ed6b0',NULL,'$2a$10$YU5rfkcyTHqevJkgA02eFuLNLEvwcuehSTwAUeb4wYOXg/RkvcvNK','phuc1234','3a70dd47-38a0-4324-9131-959bc2f1da92'),('3d88e735-57c0-4cb7-b8a1-91a6ada0f928',NULL,'$2a$10$/VYcLeRk6kA6bctrnYzyVuzpKVw24srQtZYYNQ6UDUMIxXdNIJcsG','Trong','3a70dd47-38a0-4324-9131-959bc2f1da92'),('625f10a6-911c-41f2-9e82-6cdc66a91a80',NULL,'$2a$10$fIihhcXovrhplsMOtxGMIeGAdFBunobajDquXNm.XAIo0/dItyB6O','trungle1','3a70dd47-38a0-4324-9131-959bc2f1da92'),('751a103e-1f45-4885-a4f1-0fe595b971d2',NULL,'$2a$10$2WUE9oJ4FPgi1d0i1lD3rOp3BQbj6RQKxvbkrxgSKnVb./EZhf2NG','trungle','3a70dd47-38a0-4324-9131-959bc2f1da92'),('81fbf3d8-4ef2-4ff7-84b6-2dd6a4a208d5',NULL,'$2a$10$GrRnR.1mIwmfPrO4rArXKulVzz2EAp3ufv.hS37gooxomuQBd4kB.','admin','349a352a-ee7d-4a70-bc10-e58672d3e5b1'),('9e29a9d7-4e88-43c3-96c2-853f7fa84b5a',NULL,'$2a$10$FNTE/oMTkTaMQyhCHQMFwulgv3KuFZ8GTCRUBUlvlhQF7o6eQ41Ym','nova','3a70dd47-38a0-4324-9131-959bc2f1da92'),('a4181006-a170-4aa8-bee8-68e166537bd6',NULL,'$2a$10$6SQajAvIjKWSWT4IIEO15uszxvjXby3gJ7bWkG4fWP3cK6UIhUdPu','trungle12','3a70dd47-38a0-4324-9131-959bc2f1da92'),('ad10b7be-bbe4-4a6d-9fdf-b7c68e8fc45e',NULL,'$2a$10$gDct21pS0sslkYaM6xGfh.89NjjmYiN9Wc5kilopMPnvBe64VLEk6','nova1','3a70dd47-38a0-4324-9131-959bc2f1da92'),('b5293444-fd1c-4c3b-9639-f6ab34a76544',NULL,'$2a$10$RmIsgFjJjSyYYOVmuf8a3efq3.HSa5A3Hk4wRn/9fs2TnquC.st1K','string1234','3a70dd47-38a0-4324-9131-959bc2f1da92');
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billings`
--

DROP TABLE IF EXISTS `billings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `billings` (
  `id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `full_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `order_date` datetime(6) DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `user_id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `bill_code` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `payment_method` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `payment_status` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `status` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK8pjagxaknj3hq37qw4tysb07` (`user_id`) USING BTREE,
  CONSTRAINT `FK8pjagxaknj3hq37qw4tysb07` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billings`
--

LOCK TABLES `billings` WRITE;
/*!40000 ALTER TABLE `billings` DISABLE KEYS */;
INSERT INTO `billings` VALUES ('047c56ef-ceb4-4b95-91f6-132b7d43198f','string','string','2023-08-09 12:20:49.746000','string',2002,'2911d9a9-dca3-4532-bd87-f99fbddee49c','FCPUD5WW1K','CASH','PENDING','PROCESSING'),('1046b60e-d7a6-4808-b23c-579aadd9216f','22 le loi','trung le','2023-08-09 12:20:49.746000','0373405298',200,'78ae3281-9d90-4986-844a-14a028eeff00','A65PN56UZ9','CASH','PENDING','PROCESSING'),('19c67fd8-3635-4d18-99cb-bada3257c1d5','22 le loi','trung le','2023-08-09 12:20:49.746000','0373405298',241,'78ae3281-9d90-4986-844a-14a028eeff00','NHT4636RKK','CASH','PENDING','PROCESSING'),('29a13b59-f731-4102-875b-6632162fab4b','string','string','2023-08-09 12:20:49.746000','string',0,'2911d9a9-dca3-4532-bd87-f99fbddee49c','IHB5S94NNS','CASH','PENDING','PROCESSING'),('5205c797-1cf2-47dc-bfbb-7151a205bb72','22 le loi','trung le','2023-08-07 19:14:19.100281','0373405298',163,'78ae3281-9d90-4986-844a-14a028eeff00','ED5CS62RPN','CASH','PENDING','PROCESSING'),('b6c577ff-62a4-414c-9900-d9309574f09a','22 le loi','trung le','2023-07-13 19:15:38.975878','0373405298',85,'78ae3281-9d90-4986-844a-14a028eeff00','NCRCY6HLV9','CASH','PENDING','PROCESSING'),('b7aa473f-4fc9-4e72-8602-01d596763bdc','string','string','2023-07-13 19:15:38.975878','string',1962,'2911d9a9-dca3-4532-bd87-f99fbddee49c','BA5D8L2BLP','CASH','PENDING','PROCESSING'),('ca2f9def-e2c5-4818-98eb-10a951af81c4','22 le loi','trung le','2023-07-13 19:15:38.975878','0373405298',234,'78ae3281-9d90-4986-844a-14a028eeff00','SWXCRT1CHF','CASH','PENDING','PROCESSING'),('d547d067-ea9f-45fe-af05-683881502786','22 Le Loi','trung anh le','2023-08-13 16:08:23.337982','0373405298',1232,'78ae3281-9d90-4986-844a-14a028eeff00','BE7OBWC3UY','CASH','PENDING','PROCESSING');
/*!40000 ALTER TABLE `billings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carts`
--

DROP TABLE IF EXISTS `carts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carts` (
  `user_id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `product_id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `quantity` int DEFAULT NULL,
  `product_size_id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `product_type` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`id`,`product_id`,`user_id`) USING BTREE,
  KEY `FKb5o626f86h46m4s7ms6ginnop` (`user_id`) USING BTREE,
  KEY `FKmd2ap4oxo3wvgkf4fnaye532i` (`product_id`) USING BTREE,
  KEY `FKmurb9fubhe79rjr2vc5t0lbxj` (`product_size_id`) USING BTREE,
  CONSTRAINT `FKb5o626f86h46m4s7ms6ginnop` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKmd2ap4oxo3wvgkf4fnaye532i` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKmurb9fubhe79rjr2vc5t0lbxj` FOREIGN KEY (`product_size_id`) REFERENCES `product_sizes` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carts`
--

LOCK TABLES `carts` WRITE;
/*!40000 ALTER TABLE `carts` DISABLE KEYS */;
INSERT INTO `carts` VALUES ('a31949d0-b999-4e7a-a22e-cd1343f868fd','4','23908440-3cfc-4269-91b8-f127d382fab9',1,'4','ACCESSORIES'),('a31949d0-b999-4e7a-a22e-cd1343f868fd','9','441e28d6-f91a-4404-9544-c9a3c347eb95',1,'38','PLANT'),('2911d9a9-dca3-4532-bd87-f99fbddee49c','1','5f3bfc6e-46c8-4d32-8075-a2d64870e2c4',10,'1','PLANT'),('a31949d0-b999-4e7a-a22e-cd1343f868fd','2','67eba425-7063-44f6-803b-9087145e265b',1,'31','PLANT'),('a31949d0-b999-4e7a-a22e-cd1343f868fd','2','6e378c79-ba31-4c82-b5d2-1b2388b20935',1,'2','PLANT'),('2911d9a9-dca3-4532-bd87-f99fbddee49c','2','72f84484-de51-402f-aa2d-5a8cfc5932ae',10,'2','PLANT'),('a31949d0-b999-4e7a-a22e-cd1343f868fd','13','85412896-b082-408b-ad62-d068e55da62b',1,'13','PLANT'),('a31949d0-b999-4e7a-a22e-cd1343f868fd','1','8a86213c-2d03-437a-a573-05333c27602e',1,'1','PLANT'),('78ae3281-9d90-4986-844a-14a028eeff00','1','b3401d0e-a7bd-4588-96db-d5323dd788bd',30,'1','PLANT'),('a31949d0-b999-4e7a-a22e-cd1343f868fd','9','c78415d0-1194-4209-8ac1-3a854890650b',1,'9','PLANT'),('a31949d0-b999-4e7a-a22e-cd1343f868fd','5','d852c7da-c357-4f11-81a7-39bfdd7bdcc8',1,'5','ACCESSORIES'),('a31949d0-b999-4e7a-a22e-cd1343f868fd','6','e3eb4de5-5b28-4a89-a6a0-da3b6ef0f923',1,'35','ACCESSORIES'),('a31949d0-b999-4e7a-a22e-cd1343f868fd','1','fc659872-f1d6-4bd7-a2e0-e4c3e1692a63',1,'20','PLANT');
/*!40000 ALTER TABLE `carts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favorites`
--

DROP TABLE IF EXISTS `favorites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favorites` (
  `id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `user_id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `product_id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `favorites_pk` (`user_id`,`product_id`) USING BTREE,
  KEY `favorites_products_id_fk` (`product_id`) USING BTREE,
  CONSTRAINT `favorites_products_id_fk` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `favorites_users_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorites`
--

LOCK TABLES `favorites` WRITE;
/*!40000 ALTER TABLE `favorites` DISABLE KEYS */;
INSERT INTO `favorites` VALUES ('1','78ae3281-9d90-4986-844a-14a028eeff00','1',NULL),('2','78ae3281-9d90-4986-844a-14a028eeff00','2',NULL),('3','78ae3281-9d90-4986-844a-14a028eeff00','3',NULL);
/*!40000 ALTER TABLE `favorites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `content` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `status` bit(1) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `users_id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_id` (`users_id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES ('12b28fe5-58f1-475f-8b94-7839df375636','string1','2023-08-13 10:22:29.927339',_binary '\0','2023-08-13 10:22:29.927346','2911d9a9-dca3-4532-bd87-f99fbddee49c'),('25d92759-50c9-4f55-9740-12c9afaa32c7','string3','2023-08-13 10:22:34.964179',_binary '\0','2023-08-13 10:22:34.964188','2911d9a9-dca3-4532-bd87-f99fbddee49c'),('2e66a1c8-1098-46b1-9eef-755d0e7ba47e','[Overall Service, Customer Support]','2023-08-13 11:55:18.232482',_binary '\0','2023-08-13 11:55:18.232496','78ae3281-9d90-4986-844a-14a028eeff00'),('39fd7f40-0174-4f3a-92d2-325b291200cb','string','2023-08-13 10:52:23.382219',_binary '\0','2023-08-13 10:52:23.382225','f58ec4e7-1dc1-4520-b2c9-a1ead6a3c1a3'),('48d91411-348a-4711-a55c-0ecbc13a4edf','[Overall Service, Customer Support, Speed and Efficiency]','2023-08-13 11:42:36.125177',_binary '\0','2023-08-13 11:42:36.125192','78ae3281-9d90-4986-844a-14a028eeff00'),('5666c012-f764-4734-a77e-def93a4ee9f6','Overall Service, Customer Support, Speed and Efficiency, 123','2023-08-13 11:56:10.883865',_binary '\0','2023-08-13 11:56:10.883882','78ae3281-9d90-4986-844a-14a028eeff00'),('568312aa-5436-469c-929e-b3267b62195f','string2','2023-08-13 10:22:32.018079',_binary '\0','2023-08-13 10:22:32.018082','2911d9a9-dca3-4532-bd87-f99fbddee49c'),('9a67d56b-62de-4751-93e1-458c2d9c7001','123133131','2023-08-13 11:36:30.529104',_binary '\0','2023-08-13 11:36:30.529116','78ae3281-9d90-4986-844a-14a028eeff00'),('bf00cff7-8f78-424c-a0ce-8ba6816b0157','string','2023-08-13 10:21:41.871270',_binary '\0','2023-08-13 10:21:41.871280','2911d9a9-dca3-4532-bd87-f99fbddee49c'),('d7505a99-7a03-431c-916e-bf194072ccc6','Overall Service, Customer Support, Speed and Efficiency','2023-08-13 11:46:00.385875',_binary '\0','2023-08-13 11:46:00.385890','78ae3281-9d90-4986-844a-14a028eeff00'),('f0052a03-c9aa-4cc6-a0ed-b12ee49fc831','string4','2023-08-13 10:22:37.886648',_binary '\0','2023-08-13 10:22:37.886655','2911d9a9-dca3-4532-bd87-f99fbddee49c');
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `light_requires`
--

DROP TABLE IF EXISTS `light_requires`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `light_requires` (
  `id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `strength` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `orders` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `light_requires`
--

LOCK TABLES `light_requires` WRITE;
/*!40000 ALTER TABLE `light_requires` DISABLE KEYS */;
INSERT INTO `light_requires` VALUES ('3fbc16b5-b015-4532-9ee3-5dad15de6c89','High',2),('40e274a9-42bc-40f2-ab77-32547ff1a9f5','Light',1);
/*!40000 ALTER TABLE `light_requires` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_items`
--

DROP TABLE IF EXISTS `order_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_items` (
  `id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `bill_id` varchar(36) COLLATE utf8mb3_unicode_ci NOT NULL,
  `amount` double DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `product_size_id` varchar(36) COLLATE utf8mb3_unicode_ci NOT NULL,
  `product_type` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`bill_id`,`id`) USING BTREE,
  KEY `FK9gp0n00qkdvf0jnobmixya9dq` (`product_size_id`) USING BTREE,
  CONSTRAINT `FK9gp0n00qkdvf0jnobmixya9dq` FOREIGN KEY (`product_size_id`) REFERENCES `product_sizes` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKixo1dertxk6hhfjdngloyam41` FOREIGN KEY (`bill_id`) REFERENCES `billings` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_items`
--

LOCK TABLES `order_items` WRITE;
/*!40000 ALTER TABLE `order_items` DISABLE KEYS */;
INSERT INTO `order_items` VALUES ('389410f6-5c77-4b0e-96ad-62e8841307a6','1046b60e-d7a6-4808-b23c-579aadd9216f',90,3,0,'11','PLANT'),('4e786938-aea1-4ae9-91d3-d1f69bbc9edb','1046b60e-d7a6-4808-b23c-579aadd9216f',110,2,0,'10','PLANT'),('242138aa-b9ae-4725-b233-115015489ded','19c67fd8-3635-4d18-99cb-bada3257c1d5',78,1,0,'6','ACCESSORIES'),('967cd48e-b13a-4028-b082-8c50b32cbc06','19c67fd8-3635-4d18-99cb-bada3257c1d5',30,1,0,'4','ACCESSORIES'),('9b613e3c-62a3-4a25-ad14-da81b0f5ee67','19c67fd8-3635-4d18-99cb-bada3257c1d5',55,1,0,'5','ACCESSORIES'),('f7518b69-e6b2-4fbb-a938-5ba4e248969f','19c67fd8-3635-4d18-99cb-bada3257c1d5',78,1,0,'7','PLANT'),('21267c07-8f95-4719-9a6b-2295a367988c','5205c797-1cf2-47dc-bfbb-7151a205bb72',55,1,0,'2','PLANT'),('7ffe1271-21d5-4d55-bfa8-948a8eaa0877','5205c797-1cf2-47dc-bfbb-7151a205bb72',78,1,0,'3','PLANT'),('92c1b5cb-d2e3-4223-a98e-7215c691efbc','5205c797-1cf2-47dc-bfbb-7151a205bb72',30,1,0,'1','PLANT'),('0083e029-15cd-4f7d-bec7-cc3df69c8593','b6c577ff-62a4-414c-9900-d9309574f09a',30,1,0,'9','PLANT'),('f7ed951b-c584-4571-9dc1-92d10a051d0f','b6c577ff-62a4-414c-9900-d9309574f09a',55,1,0,'8','PLANT'),('70aa959c-60a3-46b9-9f9b-caa37aee908a','ca2f9def-e2c5-4818-98eb-10a951af81c4',234,3,0,'12','PLANT');
/*!40000 ALTER TABLE `order_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plants`
--

DROP TABLE IF EXISTS `plants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plants` (
  `id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `care_level` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `description` text COLLATE utf8mb3_unicode_ci,
  `instruction` text COLLATE utf8mb3_unicode_ci,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `toxicity` bit(1) DEFAULT NULL,
  `light_require_id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `species_id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK3o3bo53lvmnms6v5l84nnkk7q` (`species_id`) USING BTREE,
  KEY `FKd0oqem10w8vkqeln186l7fda6` (`light_require_id`) USING BTREE,
  CONSTRAINT `FK3o3bo53lvmnms6v5l84nnkk7q` FOREIGN KEY (`species_id`) REFERENCES `species` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKd0oqem10w8vkqeln186l7fda6` FOREIGN KEY (`light_require_id`) REFERENCES `light_requires` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plants`
--

LOCK TABLES `plants` WRITE;
/*!40000 ALTER TABLE `plants` DISABLE KEYS */;
INSERT INTO `plants` VALUES ('1','NORMAL','‘Moonshine’ Snake Plant','\'Moonshine Snake Plant\nAfrica, Madagascar, Asia\nPlant Care\n\nThrives in medium to bright indirect light, but can tolerate low indirect light.\n\nWater every 2-3 weeks, allowing soil to dry out between waterings. Expect to water more often in brighter light and less often in lower light.\n\nYou might be surprised to know the Snake Plant is a drought tolerant succulent.\nSad Plant Signs\nWrinkled leaves, dry potting mix:\nThirsty plant, underwatered\nMushy leaves, wet potting mix:\nOverwatered','‘Moonshine’ Snake Plant',_binary '\0','3fbc16b5-b015-4532-9ee3-5dad15de6c89','12341234-1234-5678-5678-901290129012'),('10','HIGH','With its elegant stems and vibrant white flowers, this Phalaenopsis orchid makes any space feel chicer. You may notice a small number of blooms on your orchid upon delivery. These blooms will open quicker in a warm indoor setting. The Phalaenopsis will typically bloom about once a year for up to three months. After a blooming cycle, the flowers will wilt and fall off. This is the orchid’s way to store up energy to re-bloom again next season.\n\nEach plant is unique; size and shape fluctuate by season so all measurements are shown as a range\nOrchid measures between 20–28\" tall from the soil line to the top of the foliage\nArrives in a nursery grow pot nestled in your planter choice\nThe actual color of blooms may vary slightly from what is pictured','Thrives in bright indirect light, but can tolerate medium indirect light. Direct sun tolerance is species dependant.\n\nWater every 1-2 weeks, allowing potting medium to dry out between waterings. If kept in decorative, cache planter, pour out excess water after watering. Expect to water more often in brighter light and less often in lower light. This plant can benefit from extra humidity.\n\nThis is a pet friendly plant.\n\nMost Orchids are epiphytes fond of tight quarters. Keeping them in their grow pots keeps roots compact, and provides drainage and air circulation.\nSad Plant Signs\nWilting, wrinkling leaves:\nUnderwatered\nYellowing leaves:\nOverwatered, or too much sun\nWilting flowers:\nEnding its yearly blooming cycle, storing up energy to re-bloom','White Orchid',_binary '\0','3fbc16b5-b015-4532-9ee3-5dad15de6c89','12341234-1234-5678-5678-901290129012'),('11','HIGH','Said to bring good luck and fortune, the Money Tree is the perfect plant to add to any room of your home to create good Feng Shui. It is known for its resilience, ease of growth, and fun braided trunk. Sized to ship best, our large money tree arrives with room to grow as it adapts to your home’s conditions.  \n\nEach plant is unique; size and shape fluctuate by season so all measurements are shown as a range\nLarge plant measures between 24–36\" tall from the soil line to the top of the foliage\nArrives in 10\" diameter grow pot\nLarge plants benefit from brighter light to help retain their mature foliage\nLarge plants require less frequent waterings due to their higher volume of soil\nIf you purchase a large plant with a planter, the planter will ship separately','Thrives in bright indirect light, but can tolerate medium indirect light. Direct sun tolerance is species dependant.\n\nWater every 1-2 weeks, allowing potting medium to dry out between waterings. If kept in decorative, cache planter, pour out excess water after watering. Expect to water more often in brighter light and less often in lower light. This plant can benefit from extra humidity.\n\nThis is a pet friendly plant.\n\nMost Orchids are epiphytes fond of tight quarters. Keeping them in their grow pots keeps roots compact, and provides drainage and air circulation.\nSad Plant Signs\nWilting, wrinkling leaves:\nUnderwatered\nYellowing leaves:\nOverwatered, or too much sun\nWilting flowers:\nEnding its yearly blooming cycle, storing up energy to re-bloom','Large Money Tree',_binary '\0','3fbc16b5-b015-4532-9ee3-5dad15de6c89','12341234-1234-5678-5678-901290129012'),('12','HIGH','The Majesty Palm is a popular tropical palm known for its graceful, long green fronds. It is a slow-growing plant, but when well cared for can reach up to 10 feet in height, giving your space instant jungle vibes. Sized to ship best, our large Majesty Palm arrives with room to grow as it adapts to your home’s conditions. \n\nEach plant is unique; size and shape fluctuate by season so all measurements are shown as a range\nLarge plant measures between 36–48\" tall from the soil line to the top of the foliage\nArrives in 10\" diameter grow pot\nLarge plants benefit from brighter light to help retain their mature foliage\nLarge plants require less frequent waterings due to their higher volume of soil\nIf you purchase a large plant with a planter, the planter will ship separately','Thrives in bright indirect light, but can tolerate medium indirect light. Direct sun tolerance is species dependant.\n\nWater every 1-2 weeks, allowing potting medium to dry out between waterings. If kept in decorative, cache planter, pour out excess water after watering. Expect to water more often in brighter light and less often in lower light. This plant can benefit from extra humidity.\n\nThis is a pet friendly plant.\n\nMost Orchids are epiphytes fond of tight quarters. Keeping them in their grow pots keeps roots compact, and provides drainage and air circulation.\nSad Plant Signs\nWilting, wrinkling leaves:\nUnderwatered\nYellowing leaves:\nOverwatered, or too much sun\nWilting flowers:\nEnding its yearly blooming cycle, storing up energy to re-bloom','Large Majesty Palm',_binary '\0','3fbc16b5-b015-4532-9ee3-5dad15de6c89','12341234-1234-5678-5678-901290129012'),('13','HIGH','With its broad vibrant green leaves, the Bird of Paradise brings a touch of the tropics to any room. It\'s named after its unique flowers, which resemble brightly colored birds in flight. The Bird of Paradise thrives in warmer conditions with plenty of sunlight. Sized to ship best, our large Bird of Paradise arrives with room to grow as it adapts to your home’s conditions.\n\nThe Bird of Paradise has leaf splitting which is a normal adaptive precaution to help the plant bear strong winds in its native habitat\nEach plant is unique; size and shape fluctuate by season so all measurements are shown as a range\nLarge plant measures between 24-30\" tall from the soil line to the top of the foliage\nArrives in 10\" diameter grow pot\nLarge plants benefit from brighter light to help retain their mature foliage\nLarge plants require less frequent waterings due to their higher volume of soil\nIf you purchase a large plant with a planter, the planter will ship separately ','Thrives in bright indirect to direct light.\n\nWater every 1-2 weeks, allowing soil to dry out between waterings. Expect to water more often in brighter light and less often in lower light. This plant can benefit from extra humidity. Bird of Paradise can be sensitive to hard tap water. Try using filtered water or leaving water out overnight before using.\n\nThe Bird of Paradise is named after the colorful, crane-like flowers it produces in its native environment.\nSad Plant Signs\nSplits along sides of leaves:\nNormal adaptive precaution to help plant bear strong winds in its native habitat\nYellowing lower leaves, wet potting mix:\nOverwatered\nWilting, curling leaves, dry potting mix:\nThirsty plant, underwatered','Large Bird of Paradise',_binary '\0','3fbc16b5-b015-4532-9ee3-5dad15de6c89','12341234-1234-5678-5678-901290129012'),('14','HIGH','The Fiddle Leaf Fig, or Ficus lyrata, is famous for its broad green leaves with prominent veining. It is sometimes described as “fickle” but will thrive in an environment with stable temps and bright light. Sized to ship best, our large Fiddle Leaf Fig arrives with room to grow as it adapts to your home’s conditions.\n\nEach plant is unique; size and shape fluctuate by season so all measurements are shown as a range\nLarge plant measures between 42–50\" tall from the soil line to the top of the foliage\nArrives in 10\" diameter grow pot\nLarge plants benefit from brighter light to help retain their mature foliage\nLarge plants require less frequent waterings due to their higher volume of soil \nIf you purchase a large plant with a planter, the planter will ship separately ','Thrives in bright indirect light, but can tolerate medium indirect light. Direct sun tolerance is species dependant.\n\nWater every 1-2 weeks, allowing potting medium to dry out between waterings. If kept in decorative, cache planter, pour out excess water after watering. Expect to water more often in brighter light and less often in lower light. This plant can benefit from extra humidity.\n\nThis is a pet friendly plant.\n\nMost Orchids are epiphytes fond of tight quarters. Keeping them in their grow pots keeps roots compact, and provides drainage and air circulation.\nSad Plant Signs\nWilting, wrinkling leaves:\nUnderwatered\nYellowing leaves:\nOverwatered, or too much sun\nWilting flowers:\nEnding its yearly blooming cycle, storing up energy to re-bloom','Large Fiddle Leaf Fig Tree',_binary '\0','3fbc16b5-b015-4532-9ee3-5dad15de6c89','12341234-1234-5678-5678-901290129012'),('15','HIGH','The Snake Plant Laurentii, or Sansevieria trifasciata \'Laurentii\', is a succulent plant characterized by its upright sword-like leaves with vibrant yellow edges. It is popular for its incredibly easy-going nature (it can tolerate low light and drought) and its air-purifying capabilities. The easiest way to kill this plant is to overcare for it.\n\nEach plant is unique; size and shape fluctuate by season so all measurements are shown as a range\nSmall plant measures between 6–12\" tall from the soil line to the top of the foliage\nMedium plant measures between 16–24\" tall from the soil line to the top of the foliage\nLarge plant measures between 24–36\" tall from the soil line to the top of the foliage\nArrives in a nursery grow pot nestled in your planter choice; except for large planters, which ship separately from large plants ','Thrives in bright indirect light, but can tolerate medium indirect light. Direct sun tolerance is species dependant.\n\nWater every 1-2 weeks, allowing potting medium to dry out between waterings. If kept in decorative, cache planter, pour out excess water after watering. Expect to water more often in brighter light and less often in lower light. This plant can benefit from extra humidity.\n\nThis is a pet friendly plant.\n\nMost Orchids are epiphytes fond of tight quarters. Keeping them in their grow pots keeps roots compact, and provides drainage and air circulation.\nSad Plant Signs\nWilting, wrinkling leaves:\nUnderwatered\nYellowing leaves:\nOverwatered, or too much sun\nWilting flowers:\nEnding its yearly blooming cycle, storing up energy to re-bloom','Snake Plant Laurentii',_binary '\0','3fbc16b5-b015-4532-9ee3-5dad15de6c89','12341234-1234-5678-5678-901290129012'),('16','HIGH','The ZZ Plant is characterized by its waxy green leaves above the surface of its potting mix, and its large potato-like rhizomes underneath. These rhizomes store water, making the ZZ a hardy, drought-tolerant houseplant that only needs water every few weeks.\n\nSmall plants measure between 9\"-12\" tall\nArrives in a nursery grow pot nestled in your planter choice; except for large planters, which ship separately from large plants','Thrives in bright indirect light, but can tolerate medium indirect light. Direct sun tolerance is species dependant.\n\nWater every 1-2 weeks, allowing potting medium to dry out between waterings. If kept in decorative, cache planter, pour out excess water after watering. Expect to water more often in brighter light and less often in lower light. This plant can benefit from extra humidity.\n\nThis is a pet friendly plant.\n\nMost Orchids are epiphytes fond of tight quarters. Keeping them in their grow pots keeps roots compact, and provides drainage and air circulation.\nSad Plant Signs\nWilting, wrinkling leaves:\nUnderwatered\nYellowing leaves:\nOverwatered, or too much sun\nWilting flowers:\nEnding its yearly blooming cycle, storing up energy to re-bloom','ZZ Plant',_binary '\0','3fbc16b5-b015-4532-9ee3-5dad15de6c89','12341234-1234-5678-5678-901290129012'),('17','HIGH','With their small, silvery, gray-green leaves, olive trees (this specific variety is the Common Olive Tree) make beautiful houseplants. These Mediterranean plants need a lot of bright, direct sunlight. South and west facing windows are ideal. Pet friendly. (Pro-tip: Olive branches make beautiful additions to bouquets, something to keep in mind as yours grows for years to come.)  \n\nEach plant is unique; size and shape fluctuate by season so all measurements are shown as a range\nSmall plant measures between 5-10\" tall from soil line to the top of the foliage\nMedium plant measures between 8\"-16\" tall from the soil line to the top of the foliage \nArrives in a nursery grow pot nestled in your planter choice\nThis product cannot be shipped to Arizona','Thrives in bright indirect light, but can tolerate medium indirect light. Direct sun tolerance is species dependant.\n\nWater every 1-2 weeks, allowing potting medium to dry out between waterings. If kept in decorative, cache planter, pour out excess water after watering. Expect to water more often in brighter light and less often in lower light. This plant can benefit from extra humidity.\n\nThis is a pet friendly plant.\n\nMost Orchids are epiphytes fond of tight quarters. Keeping them in their grow pots keeps roots compact, and provides drainage and air circulation.\nSad Plant Signs\nWilting, wrinkling leaves:\nUnderwatered\nYellowing leaves:\nOverwatered, or too much sun\nWilting flowers:\nEnding its yearly blooming cycle, storing up energy to re-bloom','Olive Tree',_binary '\0','3fbc16b5-b015-4532-9ee3-5dad15de6c89','12341234-1234-5678-5678-901290129012'),('18','HIGH','Enjoy fresh orchids every month for three months! With their elegant stems and vibrant white flowers, Phalaenopsis orchids — which are lovingly referred to as \"beginner orchids\" because they\'re easy to care for — makes any space feel chicer.\n\nYou may notice a small number of blooms on your orchid upon delivery. These blooms will open quicker in a warm indoor setting. This type of orchid will typically bloom about once a year, for up to three months. After a blooming cycle, the flowers will wilt and fall off. This is the orchid’s way to store up energy to re-bloom again next season.\n\nOrchid measures between 20-28\" tall from the soil line to the top of the foliage\nArrives in a nursery grow pot nestled in a white ceramic planter\nSubscriptions do not auto-renew; no need to worry about unforeseen charges, or remembering to pause or cancel your box','Thrives in bright indirect light, but can tolerate medium indirect light. Direct sun tolerance is species dependant.\n\nWater every 1-2 weeks, allowing potting medium to dry out between waterings. If kept in decorative, cache planter, pour out excess water after watering. Expect to water more often in brighter light and less often in lower light. This plant can benefit from extra humidity.\n\nThis is a pet friendly plant.\n\nMost Orchids are epiphytes fond of tight quarters. Keeping them in their grow pots keeps roots compact, and provides drainage and air circulation.\nSad Plant Signs\nWilting, wrinkling leaves:\nUnderwatered\nYellowing leaves:\nOverwatered, or too much sun\nWilting flowers:\nEnding its yearly blooming cycle, storing up energy to re-bloom','Orchid Subscription',_binary '\0','3fbc16b5-b015-4532-9ee3-5dad15de6c89','12341234-1234-5678-5678-901290129012'),('19','HIGH','The Vriesea The Vriesea Intenso Orange, or flaming sword houseplant, is one of the showiest bromeliads known for its bright orange spike, lasting as long as 3–6 months. It is a colorful, easy indoor plant that will brighten up any space. Added bonus, it’s non-toxic, making it safe to keep around curious pets.\n            \n            Each plant is unique; size and shape fluctuate by season so all measurements are shown as a range\n            Small plant measures between 14–18\" tall from the soil line to the top of the foliage\n            Arrives in a nursery grow pot nestled in your planter choice Orange','Thrives in bright indirect light, but can tolerate medium indirect light. Direct sun tolerance is species dependant.\n\nWater every 1-2 weeks, allowing potting medium to dry out between waterings. If kept in decorative, cache planter, pour out excess water after watering. Expect to water more often in brighter light and less often in lower light. This plant can benefit from extra humidity.\n\nThis is a pet friendly plant.\n\nMost Orchids are epiphytes fond of tight quarters. Keeping them in their grow pots keeps roots compact, and provides drainage and air circulation.\nSad Plant Signs\nWilting, wrinkling leaves:\nUnderwatered\nYellowing leaves:\nOverwatered, or too much sun\nWilting flowers:\nEnding its yearly blooming cycle, storing up energy to re-bloom','Bromeliad Vriesea Intenso Orange',_binary '\0','3fbc16b5-b015-4532-9ee3-5dad15de6c89','12341234-1234-5678-5678-901290129012'),('2','NORMAL','Embrace color with this unique Aglaonema cultivar, Wishes. A fitting name since the Aglaonema is said to bring luck, fortune, and general positivity to those who grow it. Whether you believe in its hidden powers or not, there’s no denying this colorful plant will bring joy to your space.\n\nEach plant is unique; size and shape fluctuate by season so all measurements are shown as a range\nMedium plant measures between 9-14\" tall from the soil line to the top of the foliage \nArrives in a 6\" nursery grow pot nestled in your planter choice','Aglaonema Wishes\nSoutheast Asia\nPlant Care\n\nThrives in medium to bright indirect light. Can tolerate low light conditions. Not suited for direct sun.\n\nWater every 1-2 weeks, allowing soil to dry out between waterings. Expect to water more often in brighter light and less often in lower light.\nSad Plant Signs\nYellow leaves, wet potting mix:\nOverwatering\nLeaf drop:\nLow light, moisture-stress\nDrooping, leaf curl, dry potting mix:\nunderwatering','Aglaonema Wishes',_binary '\0','3fbc16b5-b015-4532-9ee3-5dad15de6c89','12341234-1234-5678-5678-901290129012'),('3','NORMAL','Juncus effusus \'Spiralis,\' commonly referred to as Corkscrew Rush, is an unusual eye-catching evergreen cultivar with coiled, leafless stems. This versatile, low-maintenance plant is perfect for beginners. It loves moist soil and can grow up to three feet tall.\n\nEach plant is unique; size and shape fluctuate by season so all measurements are shown as a range\nSmall plant measures between 5- to 8-inches tall from the soil line to the top of the foliage\nArrives in a nursery grow pot nestled in your planter choice','\nThrives in bright indirect light, but can tolerate medium indirect light. Avoid direct sun.\n\nWater every 1-2 weeks, allowing soil to dry out between waterings. Expect to water more often in brighter light and less often in lower light. This plant can benefit from extra humidity.\n\nThe Anthurium\'s blooms aren\'t actual flowers, but modified waxy leaves known as spathes. After about a month, spathes will start to fade with age.','Corkscrew Rush',_binary '\0','3fbc16b5-b015-4532-9ee3-5dad15de6c89','12341234-1234-5678-5678-901290129012'),('7','NORMAL','The Coral Anthurium (Anthurium andraeanum), often known as the \'flamingo flower\', is valued for its glossy, vibrant coloring. Anthuriums are recognized as the world\'s longest blooming houseplant. Each bloom can last up to eight weeks, and new ones frequently appear. The \'blooms\' are not actual flowers, but a type of modified leaf structure called a spathe; the flowers are tiny blooms along the central spadix. Anthuriums thrive and bloom best in bright, indirect light. Each plant is unique; size and shape fluctuate by season. Small plant measures between 12–16\\\" tall from the soil line to the top of the foliage. Arrives in a nursery grow pot nestled in your planter choice.','\nThrives in bright indirect light, but can tolerate medium indirect light. Avoid direct sun.\n\nWater every 1-2 weeks, allowing soil to dry out between waterings. Expect to water more often in brighter light and less often in lower light. This plant can benefit from extra humidity.\n\nThe Anthurium\'s blooms aren\'t actual flowers, but modified waxy leaves known as spathes. After about a month, spathes will start to fade with age.','Coral Anthurium',_binary '','3fbc16b5-b015-4532-9ee3-5dad15de6c89','12341234-1234-5678-5678-901290129012'),('76f5c3d6-3013-45fd-95e7-77665d2c122b','AMATEUR','12312','34124','12312',_binary '','40e274a9-42bc-40f2-ab77-32547ff1a9f5','1a2b3c4d-5e6f-7890-a1b2-c3d4e5f6a7b'),('8','HIGH','This bright pink Anthurium lives up to its nickname, the flamingo flower. Rarely without their showy blooms, Anthuriums are known as the world’s longest blooming houseplant. Each bloom can last up to eight weeks, and new ones will pop up often. These aren’t actual flowers, but modified waxy leaves. Anthuriums flourish and bloom best in bright indirect light.\n\nEach plant is unique; size and shape fluctuate by season so all measurements are shown as a range\nSmall plant measures between 12–16\" tall from the soil line to the top of the foliage\nArrives in a nursery grow pot nestled in your planter choice','Plant Care\n\nThrives in bright indirect light, but can tolerate medium indirect light. Avoid direct sun.\n\nWater every 1-2 weeks, allowing soil to dry out between waterings. Expect to water more often in brighter light and less often in lower light. This plant can benefit from extra humidity.\n\nThe Anthurium\'s blooms aren\'t actual flowers, but modified waxy leaves known as spathes. After about a month, spathes will start to fade with age.\nSad Plant Signs\nYellowing leaves:\nToo much direct sunlight\nNew flowers are green instead of red or pink:\nToo much sunlight\nFlowers are turning pale green:\nUnderwatering, or temperature stress\nLeaf elongation:\nNot enough light, or too far away from the light source','Pink Anthurium',_binary '','3fbc16b5-b015-4532-9ee3-5dad15de6c89','12341234-1234-5678-5678-901290129012'),('9','HIGH','The \'pink\' in Bromeliad Antonio Pink describes the fuchsia bracts found in this cultivar, which sometimes produce short-blooming purple flowers. Its vibrant bract also gives it its nickname, the Pink Quill Plant. This plant is pet-friendly!\n\nEach plant is unique; size and shape fluctuate by season so all measurements are shown as a range\nSmall plant measures between 12–16\" tall from the soil line to the top of the foliage\nArrives in a nursery grow pot nestled in your planter choice','Thrives in bright indirect light, but can tolerate a few hours of direct sun.\n\nMist the plant regularly (2-3 times a week) and water the soil every 1–2 weeks, allowing it to dry out halfway between waterings. Expect to water more often in brighter light and less often in lower light. Bromeliads can be sensitive to hard tap water. Try using filtered water or leaving water out overnight before using. For best results, provide an additional source of humidity like a pebble tray or humidifier.\n\nThis plant is pet-friendly.\n\nBromeliad blooms can last anywhere from 3-6 months. Cut back blooms after they are done so the plant can focus its energy on new growth and future pups.','Bromeliad Antonio Pink',_binary '\0','3fbc16b5-b015-4532-9ee3-5dad15de6c89','12341234-1234-5678-5678-901290129012'),('abf4c5c5-c895-4eee-be61-3a0c2d2c6044','AMATEUR','124124','1241242','sp moi',_binary '','40e274a9-42bc-40f2-ab77-32547ff1a9f5','1a2b3c4d-5e6f-7890-a1b2-c3d4e5f6a7b'),('fa65e458-d2d1-431a-8ae6-71d9372e82a5','AMATEUR','12312','34124','12312',_binary '','40e274a9-42bc-40f2-ab77-32547ff1a9f5','1a2b3c4d-5e6f-7890-a1b2-c3d4e5f6a7b');
/*!40000 ALTER TABLE `plants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_images`
--

DROP TABLE IF EXISTS `product_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_images` (
  `id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `product_id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `product_image` varchar(500) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `is_thumbnail` bit(1) DEFAULT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `product_images_products_id_fk` (`product_id`) USING BTREE,
  CONSTRAINT `product_images_products_id_fk` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_images`
--

LOCK TABLES `product_images` WRITE;
/*!40000 ALTER TABLE `product_images` DISABLE KEYS */;
INSERT INTO `product_images` VALUES ('1','1','https://cdn.shopify.com/s/files/1/0150/6262/files/the-sill_Medium-Snake-Moonshine_Medium_Hyde_Cream_Variant.jpg?v=1686664154',_binary '',0),('10','4','https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_potting-mix_medium_variant.jpg?v=1659985220&width=150',_binary '',0),('11','4','https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_hyde-stone_potting-mix_celtic-farm_gallery_all_all_03.jpg?v=1659985220',_binary '\0',0),('12','5','https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_lava-rocks_featured.jpg?v=1571254326&w',_binary '',0),('13','5','https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_lava-rocks_gallery_01.jpg?v=1572635351',_binary '\0',0),('14','5','https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_lava-rocks_gallery_02.jpg?v=1574624668',_binary '\0',0),('15','6','https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_cacti-mix_medium_variant.jpg?v=1659559',_binary '',0),('16','6','https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_cacti-mix_medium_gallery_02.jpg?v=1659',_binary '\0',0),('17','6','https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_cacti-mix_medium_gallery_01.jpg?v=1659',_binary '\0',0),('18','7','https://cdn.shopify.com/s/files/1/0150/6262/products/the_sill-variant-white_gloss-anthurium_coral.jpg?v=1680539003',_binary '',0),('19','7','https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_coral_anthurium_gallery_01_83770a77-2561-4d47-879c-a25610285d45.jpg?v=1680539003',_binary '\0',0),('2','1','https://cdn.shopify.com/s/files/1/0150/6262/files/the-sill_snake-plant-moonshine_gallery_medium_all_all_03.jpg?v=1686664154',_binary '\0',0),('20','8','https://cdn.shopify.com/s/files/1/0150/6262/products/the_sill-variant-white_gloss-anthurium_pink.jpg?v=1680539203',_binary '',0),('21','8','https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_anthurium-pink_gallery_small_all_all_02_cef2f3f5-ac12-4d55-92cc-91f5cd7ca91f.jpg?v=1680539203',_binary '\0',0),('22','8','https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_pink-anthurium_gallery_all_all_02_646c1e30-ea14-4ca3-a6c0-8806c4ba7ecf.jpg?v=1680539203',_binary '\0',0),('23','9','https://cdn.shopify.com/s/files/1/0150/6262/products/the_sill-variant-white_gloss-bromeliad_pink.jpg?v=1680539579&width=150',_binary '',0),('24','9','https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_bromeliad-pink-antonio_small_gallery_01_1f3a0bcc-2479-4015-8607-754e994f1d94.jpg?v=1680571735&width=150',_binary '\0',0),('25','9','https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_bromeliad-antonio-pink_kent_white_gallery_all_all_02_b8d7204f-f672-4042-ab5e-3608a8828e72.jpg?v=1680571735',_binary '\0',0),('26','10','https://cdn.shopify.com/s/files/1/0150/6262/products/the_sill-variant-white_gloss-orchid_white.jpg?v=1681923981',_binary '',0),('27','10','https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_white-orchid_gallery_01_cf9c90e5-c472-4c65-88bb-f7dbf470b164.jpg?v=1681923981',_binary '\0',0),('28','11','https://cdn.shopify.com/s/files/1/0150/6262/files/the-sill_Money-Tree_Large_Mexia_Black_Variant.jpg?v=1687308983',_binary '',0),('29','11','https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_money-tree_gallery_all_03.jpg?v=1687308983',_binary '\0',0),('3','1','https://cdn.shopify.com/s/files/1/0150/6262/files/the-sill_snake-plant-moonshine_gallery_medium_all_all_04.jpg',_binary '\0',0),('30','12','https://cdn.shopify.com/s/files/1/0150/6262/files/the-sill_Majesty-Palm_Large_Pallas_Cream_Variant.jpg?v=1688569810',_binary '',0),('31','12','https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_majesty-palm_gallery_all_02.png?v=1688569810',_binary '\0',0),('32','13','https://cdn.shopify.com/s/files/1/0150/6262/files/the-sill_Large-Bird-of-Paradise_Large_Balboa_Blush_Variant.jpg?v=1688570327',_binary '',0),('33','13','https://cdn.shopify.com/s/files/1/0150/6262/files/the-sill_Large-Bird-of-Paradise_Large_Trio_Variant.jpg?v=1688570334',_binary '\0',0),('34','14','https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_fiddle-leaf-fig_large_growpot_variant.jpg?v=1687308956',_binary '',0),('35','14','https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_fiddle-leaf-fig_bird-of-paradise_fan-palm_large_gallery_all_all_01.jpg?v=1687308956',_binary '\0',0),('36','15','https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_snake-plant-laurentii_variant_small_grant_black.jpg?v=1686263548',_binary '',0),('37','15','https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_snake-plant-laurentii_gallery_small_all_all_01.jpg?v=1686263548',_binary '\0',0),('38','16','https://cdn.shopify.com/s/files/1/0150/6262/products/the_sill-variant-white_gloss-zz_plant.jpg?v=1680548849',_binary '',0),('39','16','https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_zz-plant_large_gallery_all_all_02_175b6bd9-7ee7-4ab3-89e0-9da22325e683.jpg?v=1680548849',_binary '\0',0),('4','2','https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_aglaonema-wishes_medium_upcycled-saucer_cream.jpg?v=1678485612&width=150',_binary '',0),('40','17','https://cdn.shopify.com/s/files/1/0150/6262/products/The-Sill_Olive-Tree_Small_Hyde_Cream_Variant.jpg?v=1687298782',_binary '',0),('41','17','https://cdn.shopify.com/s/files/1/0150/6262/products/The-Sill_OliveTree_Medium_gallery_01.jpg?v=1687298782',_binary '\0',0),('42','18','https://cdn.shopify.com/s/files/1/0150/6262/products/the_sill-variant-orchid_subscription.jpg?v=1681836368',_binary '',0),('43','18','https://cdn11.bigcommerce.com/s-f41fa/products/68/images/8587/Paph._William_Lewis_Group2__17626.1679338016.450.800.jpg?c=2',_binary '\0',0),('44','19','https://cdn.shopify.com/s/files/1/0150/6262/products/the_sill-variant-white_gloss-bromeliad_orange.jpg?v=1680540029',_binary '',0),('45','19','https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_bromeliad-vrisea-intenso-orange_small_gallery_01_312269dd-f10c-4511-80a0-ab37a29c5146.jpg?v=1680540029',_binary '\0',0),('5','2','https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_aglaonema-wishes_medium_grant_mint.jpg?v=1678485669&width=150',_binary '\0',0),('6','2','https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_aglaonema-wishes_medium_hyde_cream.jpg?v=1678485669&width=150',_binary '\0',0),('7','3','https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_Corkscrew-Rush_Small_Grant_Black.jpg?v',_binary '',0),('8','3','https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_Corkscrew-Rush_small_Trio.jpg?v=168736',_binary '\0',0),('9','4','https://cdn.shopify.com/s/files/1/0150/6262/products/the-sill_potting-mix_medium_variant.jpg?v=16599',_binary '\0',0);
/*!40000 ALTER TABLE `product_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_sizes`
--

DROP TABLE IF EXISTS `product_sizes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_sizes` (
  `id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `product_id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `size_id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `width` int DEFAULT NULL,
  `height` int DEFAULT NULL,
  `made_on_date` date DEFAULT NULL,
  `price` double DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `UK1cs8c7edyjg5upxsuok04u2ur` (`product_id`,`size_id`) USING BTREE,
  KEY `FK3bqabm2nc8yyl9to7fo8trak4` (`size_id`) USING BTREE,
  CONSTRAINT `FK3bqabm2nc8yyl9to7fo8trak4` FOREIGN KEY (`size_id`) REFERENCES `sizes` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK4isa0j51hpdn7cx04m831jic4` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_sizes`
--

LOCK TABLES `product_sizes` WRITE;
/*!40000 ALTER TABLE `product_sizes` DISABLE KEYS */;
INSERT INTO `product_sizes` VALUES ('1','1','1',10,20,'2022-08-12',30,'PLANT',0),('10','10','2',20,50,'2023-08-17',55,'PLANT',0),('11','11','1',10,20,'2022-08-12',30,'PLANT',0),('12','12','3',10,70,'2023-08-13',78,'PLANT',0),('13','13','1',10,20,'2022-08-12',30,'PLANT',0),('14','14','3',10,70,'2023-08-13',78,'PLANT',0),('15','15','2',20,50,'2023-08-13',55,'PLANT',0),('16','16','1',10,20,'2022-08-12',30,'PLANT',0),('17','17','2',20,50,'2023-08-13',55,'PLANT',0),('18','18','3',10,70,'2023-08-13',78,'PLANT',0),('19','19','1',10,20,'2022-08-12',30,'PLANT',0),('2','2','2',20,50,'2023-08-13',55,'PLANT',0),('20','1','2',20,50,'2023-08-13',55,'PLANT',0),('21','10','3',10,70,'2023-08-13',78,'PLANT',0),('22','11','2',20,50,'2023-08-13',55,'PLANT',0),('23','12','2',20,50,'2023-08-13',55,'PLANT',0),('24','13','2',20,50,'2023-08-13',55,'PLANT',0),('25','14','2',20,50,'2023-08-13',55,'PLANT',0),('26','15','3',10,70,'2023-08-13',78,'PLANT',0),('27','16','2',20,50,'2023-08-13',55,'PLANT',0),('28','17','3',10,70,'2023-08-13',78,'PLANT',0),('29','18','2',20,50,'2023-08-13',55,'PLANT',0),('3','3','3',10,70,'2023-08-13',78,'PLANT',0),('30','19','2',20,50,'2023-08-13',55,'PLANT',0),('31','2','3',10,70,'2023-08-13',78,'PLANT',0),('32','3','2',20,50,'2023-08-13',55,'PLANT',0),('33','4','2',20,50,'2023-08-13',55,'ACCESSORIES',0),('34','5','3',10,70,'2023-08-13',78,'ACCESSORIES',0),('35','6','2',20,50,'2023-08-13',55,'ACCESSORIES',0),('36','7','2',20,50,'2023-08-13',55,'PLANT',0),('37','8','3',10,70,'2023-08-13',78,'PLANT',0),('38','9','3',10,70,'2023-08-13',78,'PLANT',0),('4','4','1',10,20,'2022-08-12',30,'ACCESSORIES',0),('5','5','2',20,50,'2023-08-13',55,'ACCESSORIES',0),('6','6','3',10,70,'2023-08-13',78,'ACCESSORIES',0),('7','7','3',10,70,'2023-08-13',78,'PLANT',0),('8','8','2',20,50,'2023-08-13',55,'PLANT',0),('9','9','1',10,20,'2022-08-12',30,'PLANT',0);
/*!40000 ALTER TABLE `product_sizes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `description` text COLLATE utf8mb3_unicode_ci,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `type` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES ('1','The Moonshine Snake Plant (Dracaena trifasciata \'Moonshine\'), is adored its upright, broad leaves that boast a silvery overtone and dark green edges. Snake plants are known for being drought-tolerant, and for their superior air-purifying capabilities. But please note: unlike other Snake plants, the Moonshine needs brighter light to retain its silvery pigmentation.\n\nEach plant is unique; size and shape fluctuate by season so all measurements are shown as a range\nMedium plant measures between 7–14\" tall from the soil line to the top of the foliage\nArrives in a nursery grow pot nestled in your planter choice. ','\'Moonshine\' Snake Plant','PLANT'),('10','With its elegant stems and vibrant white flowers, this Phalaenopsis orchid makes any space feel chicer. You may notice a small number of blooms on your orchid upon delivery. These blooms will open quicker in a warm indoor setting. The Phalaenopsis will typically bloom about once a year for up to three months. After a blooming cycle, the flowers will wilt and fall off. This is the orchid’s way to store up energy to re-bloom again next season.\n\nEach plant is unique; size and shape fluctuate by season so all measurements are shown as a range\nOrchid measures between 20–28\" tall from the soil line to the top of the foliage\nArrives in a nursery grow pot nestled in your planter choice\nThe actual color of blooms may vary slightly from what is pictured','White Orchid','PLANT'),('11','Said to bring good luck and fortune, the Money Tree is the perfect plant to add to any room of your home to create good Feng Shui. It is known for its resilience, ease of growth, and fun braided trunk. Sized to ship best, our large money tree arrives with room to grow as it adapts to your home’s conditions.  \n\nEach plant is unique; size and shape fluctuate by season so all measurements are shown as a range\nLarge plant measures between 24–36\" tall from the soil line to the top of the foliage\nArrives in 10\" diameter grow pot\nLarge plants benefit from brighter light to help retain their mature foliage\nLarge plants require less frequent waterings due to their higher volume of soil\nIf you purchase a large plant with a planter, the planter will ship separately','Large Money Tree','PLANT'),('12','The Majesty Palm is a popular tropical palm known for its graceful, long green fronds. It is a slow-growing plant, but when well cared for can reach up to 10 feet in height, giving your space instant jungle vibes. Sized to ship best, our large Majesty Palm arrives with room to grow as it adapts to your home’s conditions. \n\nEach plant is unique; size and shape fluctuate by season so all measurements are shown as a range\nLarge plant measures between 36–48\" tall from the soil line to the top of the foliage\nArrives in 10\" diameter grow pot\nLarge plants benefit from brighter light to help retain their mature foliage\nLarge plants require less frequent waterings due to their higher volume of soil\nIf you purchase a large plant with a planter, the planter will ship separately','Large Majesty Palm','PLANT'),('13','With its broad vibrant green leaves, the Bird of Paradise brings a touch of the tropics to any room. It\'s named after its unique flowers, which resemble brightly colored birds in flight. The Bird of Paradise thrives in warmer conditions with plenty of sunlight. Sized to ship best, our large Bird of Paradise arrives with room to grow as it adapts to your home’s conditions.\n\nThe Bird of Paradise has leaf splitting which is a normal adaptive precaution to help the plant bear strong winds in its native habitat\nEach plant is unique; size and shape fluctuate by season so all measurements are shown as a range\nLarge plant measures between 24-30\" tall from the soil line to the top of the foliage\nArrives in 10\" diameter grow pot\nLarge plants benefit from brighter light to help retain their mature foliage\nLarge plants require less frequent waterings due to their higher volume of soil\nIf you purchase a large plant with a planter, the planter will ship separately ','Large Bird of Paradise','PLANT'),('14','The Fiddle Leaf Fig, or Ficus lyrata, is famous for its broad green leaves with prominent veining. It is sometimes described as “fickle” but will thrive in an environment with stable temps and bright light. Sized to ship best, our large Fiddle Leaf Fig arrives with room to grow as it adapts to your home’s conditions.\n\nEach plant is unique; size and shape fluctuate by season so all measurements are shown as a range\nLarge plant measures between 42–50\" tall from the soil line to the top of the foliage\nArrives in 10\" diameter grow pot\nLarge plants benefit from brighter light to help retain their mature foliage\nLarge plants require less frequent waterings due to their higher volume of soil \nIf you purchase a large plant with a planter, the planter will ship separately ','Large Fiddle Leaf Fig Tree','PLANT'),('15','The Snake Plant Laurentii, or Sansevieria trifasciata \'Laurentii\', is a succulent plant characterized by its upright sword-like leaves with vibrant yellow edges. It is popular for its incredibly easy-going nature (it can tolerate low light and drought) and its air-purifying capabilities. The easiest way to kill this plant is to overcare for it.\n\nEach plant is unique; size and shape fluctuate by season so all measurements are shown as a range\nSmall plant measures between 6–12\" tall from the soil line to the top of the foliage\nMedium plant measures between 16–24\" tall from the soil line to the top of the foliage\nLarge plant measures between 24–36\" tall from the soil line to the top of the foliage\nArrives in a nursery grow pot nestled in your planter choice; except for large planters, which ship separately from large plants ','Snake Plant Laurentii','PLANT'),('16','The ZZ Plant is characterized by its waxy green leaves above the surface of its potting mix, and its large potato-like rhizomes underneath. These rhizomes store water, making the ZZ a hardy, drought-tolerant houseplant that only needs water every few weeks.\n\nSmall plants measure between 9\"-12\" tall\nArrives in a nursery grow pot nestled in your planter choice; except for large planters, which ship separately from large plants','ZZ Plant','PLANT'),('17','With their small, silvery, gray-green leaves, olive trees (this specific variety is the Common Olive Tree) make beautiful houseplants. These Mediterranean plants need a lot of bright, direct sunlight. South and west facing windows are ideal. Pet friendly. (Pro-tip: Olive branches make beautiful additions to bouquets, something to keep in mind as yours grows for years to come.)  \n\nEach plant is unique; size and shape fluctuate by season so all measurements are shown as a range\nSmall plant measures between 5-10\" tall from soil line to the top of the foliage\nMedium plant measures between 8\"-16\" tall from the soil line to the top of the foliage \nArrives in a nursery grow pot nestled in your planter choice\nThis product cannot be shipped to Arizona','Olive Tree','PLANT'),('18','Enjoy fresh orchids every month for three months! With their elegant stems and vibrant white flowers, Phalaenopsis orchids — which are lovingly referred to as \"beginner orchids\" because they\'re easy to care for — makes any space feel chicer.\n\nYou may notice a small number of blooms on your orchid upon delivery. These blooms will open quicker in a warm indoor setting. This type of orchid will typically bloom about once a year, for up to three months. After a blooming cycle, the flowers will wilt and fall off. This is the orchid’s way to store up energy to re-bloom again next season.\n\nOrchid measures between 20-28\" tall from the soil line to the top of the foliage\nArrives in a nursery grow pot nestled in a white ceramic planter\nSubscriptions do not auto-renew; no need to worry about unforeseen charges, or remembering to pause or cancel your box','Orchid Subscription','PLANT'),('19','The Vriesea The Vriesea Intenso Orange, or flaming sword houseplant, is one of the showiest bromeliads known for its bright orange spike, lasting as long as 3–6 months. It is a colorful, easy indoor plant that will brighten up any space. Added bonus, it’s non-toxic, making it safe to keep around curious pets.\n            \n            Each plant is unique; size and shape fluctuate by season so all measurements are shown as a range\n            Small plant measures between 14–18\" tall from the soil line to the top of the foliage\n            Arrives in a nursery grow pot nestled in your planter choice Orange','Bromeliad Vriesea Intenso Orange','PLANT'),('2','Embrace color with this unique Aglaonema cultivar, Wishes. A fitting name since the Aglaonema is said to bring luck, fortune, and general positivity to those who grow it. Whether you believe in its hidden powers or not, there’s no denying this colorful plant will bring joy to your space.\n\nEach plant is unique; size and shape fluctuate by season so all measurements are shown as a range\nMedium plant measures between 9-14\" tall from the soil line to the top of the foliage \nArrives in a 6\" nursery grow pot nestled in your planter choice','Aglaonema Wishes','PLANT'),('3','Juncus effusus \'Spiralis,\' commonly referred to as Corkscrew Rush, is an unusual eye-catching evergreen cultivar with coiled, leafless stems. This versatile, low-maintenance plant is perfect for beginners. It loves moist soil and can grow up to three feet tall.\n\nEach plant is unique; size and shape fluctuate by season so all measurements are shown as a range\nSmall plant measures between 5- to 8-inches tall from the soil line to the top of the foliage\nArrives in a nursery grow pot nestled in your planter choice','Corkscrew Rush','PLANT'),('4','Our Organic Potting Mix gives Rock your plant roots the preferred balance of air, moisture, and nutrition they need. This all-natural soil can be used for all types of indoor houseplants, as well as outdoor plants potted in containers. One medium bag is enough to pot approximately 2-3 small plants. \n\nMedium bag: 100 oz net volume, 2 lb net weight \nLarge bag: 336 oz net volume, 6.7 lb net weight \nIngredients: coir, compost, aged pine bark, rice hulls, earthworm castings \nNot eligible for discounts or promotions ','Organic Potting Mix','ACCESSORIES'),('5','Have a planter with no drainage hole? When placed at the bottom of the planter, lava rocks create a place for excess water to pool away from your plant\'s roots! Lava rocks have the additional bonus of being porous; they can absorb and slowly release excess water over time. \n\nIngredients: organic lava rocks \nBag contains enough lava rocks to line the bottom of 4-5 small 5” diameter planters or 2-3 medium 7” diameter planters \nNot applicable to discounts and promotions ','Organic Lava Rocks','ACCESSORIES'),('6','Our Organic Cacti Mix is here for all your succulents and cacti potting needs. This well-draining, all-natural mix can be used for all types of indoor succulent houseplants and outdoor plants potted in containers. One medium bag is enough to pot approximately 2-3 small plants. \n\nMedium bag: 124 oz net volume, 5.3 lb net weight\nIngredients: expanded shale, rice hulls, coir, sand, compost, soft-wood biochar, earthworm castings \nNot eligible for discounts or promotions ','Organic Cacti Mix','ACCESSORIES'),('7','The Coral Anthurium (Anthurium andraeanum), often known as the \'flamingo flower\', is valued for its glossy, vibrant coloring. Anthuriums are recognized as the world\'s longest blooming houseplant. Each bloom can last up to eight weeks, and new ones frequently appear. The \'blooms\' are not actual flowers, but a type of modified leaf structure called a spathe; the flowers are tiny blooms along the central spadix. Anthuriums thrive and bloom best in bright, indirect light. Each plant is unique; size and shape fluctuate by season. Small plant measures between 12–16\\\" tall from the soil line to the top of the foliage. Arrives in a nursery grow pot nestled in your planter choice.','Coral Anthurium','PLANT'),('8','This bright pink Anthurium lives up to its nickname, the flamingo flower. Rarely without their showy blooms, Anthuriums are known as the world’s longest blooming houseplant. Each bloom can last up to eight weeks, and new ones will pop up often. These aren’t actual flowers, but modified waxy leaves. Anthuriums flourish and bloom best in bright indirect light.\n\nEach plant is unique; size and shape fluctuate by season so all measurements are shown as a range\nSmall plant measures between 12–16\" tall from the soil line to the top of the foliage\nArrives in a nursery grow pot nestled in your planter choice','Pink Anthurium','PLANT'),('9','The \'pink\' in Bromeliad Antonio Pink describes the fuchsia bracts found in this cultivar, which sometimes produce short-blooming purple flowers. Its vibrant bract also gives it its nickname, the Pink Quill Plant. This plant is pet-friendly!\n\nEach plant is unique; size and shape fluctuate by season so all measurements are shown as a range\nSmall plant measures between 12–16\" tall from the soil line to the top of the foliage\nArrives in a nursery grow pot nestled in your planter choice','Bromeliad Antonio Pink','PLANT');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `role_type` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES ('349a352a-ee7d-4a70-bc10-e58672d3e5b1','ADMIN'),('3a70dd47-38a0-4324-9131-959bc2f1da92','USER'),('5550147d-246b-48ca-8408-a4d5e889ee4d','1');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sizes`
--

DROP TABLE IF EXISTS `sizes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sizes` (
  `id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `size_type` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sizes`
--

LOCK TABLES `sizes` WRITE;
/*!40000 ALTER TABLE `sizes` DISABLE KEYS */;
INSERT INTO `sizes` VALUES ('1','S'),('2','M'),('3','L');
/*!40000 ALTER TABLE `sizes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `species`
--

DROP TABLE IF EXISTS `species`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `species` (
  `id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `description` text COLLATE utf8mb3_unicode_ci,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `species`
--

LOCK TABLES `species` WRITE;
/*!40000 ALTER TABLE `species` DISABLE KEYS */;
INSERT INTO `species` VALUES ('12341234-1234-5678-5678-901290129012','Enchanted Forest species','Moss Fern'),('1a2b3c4d-5e6f-7890-a1b2-c3d4e5f6a7b','Morning Dew species','Bluebell'),('1c9e6b74-8a55-4e6a-b80d-4c8f0a5e7d20','Yellow Charm species','Daffodil'),('27182818-2818-2818-4590-671234567890','Midnight Velvet species','Black Velvet Petunia'),('2e7452f8-89e7-4b2e-9a9c-5f3e04d29c81','Spiky Green species','Cactus'),('31415926-5358-9793-2384-626433832795','Sunny Disposition species','Marigold'),('31427182-8182-7182-9182-614261426142','Scarlet Majesty species','Scarlet Sage'),('3fbc16b5-b015-4532-9ea3-5dad15ae6c89','Smal Big species','Sunflower'),('3fbc16b5-b015-4532-9ee3-5dad15ae6c89','Big Big species','Rose'),('43214321-4321-8765-8765-210921092109','Amber Glow species','Autumn Joy Sedum'),('45671234-5678-1234-6789-123456789012','Ruby Gem species','Geranium'),('4c2a7d91-6a55-4b67-bd8d-8a320a4d9a9e','Tall Fern species','Fern'),('54325432-5432-4321-4321-321032103210','Silver Lining species','Lamb\'s Ear'),('56785678-6789-7890-8901-901234567890','Harmony Bells species','Lily of the Valley'),('5a8d47e2-349c-4f2b-8ac0-73c186cfa82a','Sweet Aroma species','Jasmine'),('6f3e9c18-11c7-42dd-a21f-7e52e2d1bb35','Shady Elegance species','Hosta'),('7fb3f7d6-45a1-4d8e-bd23-86226dfab35d','Delicate Vine species','Ivy'),('81818181-8181-8181-8181-818181818181','Azure Dreams species','Hydrangea'),('8b96a0c7-45d7-4189-986f-d2bda45c1b10','Blooming Majesty species','Tulip'),('98765432-10ab-cdef-0123-456789abcdef','Copper Hues species','Autumn Blaze Maple'),('98769876-9876-9876-9876-987698769876','Blazing Star species','Liatris'),('9d8e5f72-6b10-4a9f-a97b-0a4987b1e9c5','Purple Beauty species','Lavender'),('a9b8c7d6-e5f4-4321-9876-1a2b3c4d5e6f','Silver Veil species','Dusty Miller'),('b6a2e5f4-8cb7-41ca-8e6b-aa1394d7a28b','Gentle Breeze species','Chrysanthemum'),('c0d1e2f3-a4b5-c6d7-e8f9-0123cc5bb2c7','Graceful Arch species','Rainbow Eucalyptus'),('c8a95f6e-2ad4-4e7f-99a8-74b7cc5bb2c7','Blue Skies species','Forget-Me-Not'),('d6e7b914-c73d-4b0f-83da-6ffbd4f9d8a1','Whimsical Whirl species','Helicopter Plant'),('e5f0d94e-79df-4c46-8a4f-4d95c1638e3b','White Cascade species','Orchid'),('f0dbeda3-2a76-4e05-987e-b77e6c87e3e8','Golden Glow species','Marigold'),('f2d3c4b1-91d2-4f5e-a15c-c1db4d4b9e3d','Crimson Splendor species','Red Maple');
/*!40000 ALTER TABLE `species` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stocks`
--

DROP TABLE IF EXISTS `stocks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stocks` (
  `product_sizes_id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`,`product_sizes_id`) USING BTREE,
  KEY `FKefsfn7fppilyd2w9xuqrqj5gf` (`product_sizes_id`) USING BTREE,
  CONSTRAINT `stocks_product_sizes_id_fk` FOREIGN KEY (`product_sizes_id`) REFERENCES `product_sizes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stocks`
--

LOCK TABLES `stocks` WRITE;
/*!40000 ALTER TABLE `stocks` DISABLE KEYS */;
INSERT INTO `stocks` VALUES ('1','1','2023-08-13 19:19:38.000000',4,NULL),('10','10','2023-08-13 19:19:38.000000',3,NULL),('11','11','2023-08-13 19:19:38.000000',2,NULL),('12','12','2023-08-13 19:19:38.000000',2,NULL),('13','13','2023-08-13 19:19:38.000000',5,NULL),('14','14','2023-08-13 19:19:38.000000',5,NULL),('15','15','2023-08-13 19:19:38.000000',5,NULL),('16','16','2023-08-13 19:19:38.000000',5,NULL),('17','17','2023-08-13 19:19:38.000000',5,NULL),('18','18','2023-08-13 19:19:38.000000',5,NULL),('19','19','2023-08-13 19:19:38.000000',5,NULL),('2','2','2023-08-13 19:19:38.000000',4,NULL),('20','20','2023-08-13 19:19:38.000000',7,NULL),('21','21','2023-08-13 19:19:38.000000',7,NULL),('22','22','2023-08-13 19:19:38.000000',7,NULL),('23','23','2023-08-13 19:19:38.000000',7,NULL),('24','24','2023-08-13 19:19:38.000000',7,NULL),('25','25','2023-08-13 19:19:38.000000',7,NULL),('26','26','2023-08-13 19:19:38.000000',7,NULL),('27','27','2023-08-13 19:19:38.000000',7,NULL),('28','28','2023-08-13 19:19:38.000000',7,NULL),('29','29','2023-08-13 19:19:38.000000',7,NULL),('3','3','2023-08-13 19:19:38.000000',4,NULL),('30','30','2023-08-13 19:19:38.000000',7,NULL),('31','31','2023-08-13 19:19:38.000000',7,NULL),('32','32','2023-08-13 19:19:38.000000',7,NULL),('33','33','2023-08-13 19:19:38.000000',7,NULL),('34','34','2023-08-13 19:19:38.000000',7,NULL),('35','35','2023-08-13 19:19:38.000000',7,NULL),('36','36','2023-08-13 19:19:38.000000',7,NULL),('37','37','2023-08-13 19:19:38.000000',7,NULL),('38','38','2023-08-13 19:19:38.000000',7,NULL),('4','4','2023-08-13 19:19:38.000000',4,NULL),('5','5','2023-08-13 19:19:38.000000',4,NULL),('6','6','2023-08-13 19:19:38.000000',4,NULL),('7','7','2023-08-13 19:19:38.000000',4,NULL),('8','8','2023-08-13 19:19:38.000000',4,NULL),('9','9','2023-08-13 19:19:38.000000',4,NULL);
/*!40000 ALTER TABLE `stocks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tokens`
--

DROP TABLE IF EXISTS `tokens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tokens` (
  `id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `expiry_time` datetime(6) DEFAULT NULL,
  `token` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `token_type` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `account_id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FKkxd4xsavefdtlpkvnxpgojn6` (`account_id`) USING BTREE,
  CONSTRAINT `FKkxd4xsavefdtlpkvnxpgojn6` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tokens`
--

LOCK TABLES `tokens` WRITE;
/*!40000 ALTER TABLE `tokens` DISABLE KEYS */;
INSERT INTO `tokens` VALUES ('022b731b-94b2-44ca-b38a-bc53848fdf80','2023-08-13 16:50:28.994561','2024-06-08 16:50:28.938000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2OTE5MjAyMjg5MzgsImV4cCI6MTcxNzg0MDIyOH0.Dq3shYV6whdQNAcB_kKgAgcQ4TKasDTLSFB7sbuQtcw','REFRESH_TOKEN','301f9a29-f7a7-4ac9-adde-785fd157533a'),('05b37cc3-1e67-432f-a346-b87764cfde96','2023-08-13 09:05:25.032740','2023-08-16 09:05:25.027000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0cnVuZ2xlIiwiaWF0IjoxNjkxODkyMzI1MDI3LCJleHAiOjE2OTIxNTE1MjV9.NVbXTL2jdl1PXibX165grNgWmnT0Vz0ibJHJMKaVcDs','REFRESH_TOKEN','751a103e-1f45-4885-a4f1-0fe595b971d2'),('06baf462-dd42-40c5-af8d-1c590bb6a6cc','2023-08-13 09:09:05.593925','2023-08-16 09:09:05.589000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0cnVuZ2xlIiwiaWF0IjoxNjkxODkyNTQ1NTg5LCJleHAiOjE2OTIxNTE3NDV9.D-y_6PP0XkIfE7otnFrHyUDLweXBnTbaQ4aC4arHnjg','REFRESH_TOKEN','751a103e-1f45-4885-a4f1-0fe595b971d2'),('0cf7be01-03e5-4d96-ab28-e91b4f32e688','2023-08-13 02:12:45.439075','2023-08-16 02:12:45.426000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJub3ZhMSIsImlhdCI6MTY5MTg2NzU2NTQyNiwiZXhwIjoxNjkyMTI2NzY1fQ.QN-xw5wVY1vcxtbqCruFIJisWq88flkTrYu96ISoRSA','REFRESH_TOKEN','ad10b7be-bbe4-4a6d-9fdf-b7c68e8fc45e'),('0d1b4486-d8fb-4abc-a77e-6f95bf0bf6c0','2023-08-13 16:49:45.951116','2024-06-08 16:49:45.935000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2OTE5MjAxODU5MzUsImV4cCI6MTcxNzg0MDE4NX0.GN5VQFG88IM78fGmIzurq1_Ys7-6cYn_A6ZWQeoqqnU','REFRESH_TOKEN','301f9a29-f7a7-4ac9-adde-785fd157533a'),('0d2ff740-e49e-4118-a563-e86411616926','2023-08-13 19:00:54.929908','2023-08-16 19:00:54.917000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0cnVuZ2xlIiwiaWF0IjoxNjkxOTI4MDU0OTE3LCJleHAiOjE2OTIxODcyNTR9.B_MXlogu17Wz2Dw8EMvcbHW0hgc0d9xPl4Ss5OgfCU8','REFRESH_TOKEN','751a103e-1f45-4885-a4f1-0fe595b971d2'),('0ea4c3e9-0c7d-4cf8-9a8e-d14f16fe8fba','2023-08-13 10:51:56.848091','2023-08-16 10:51:56.839000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmcxMjM0IiwiaWF0IjoxNjkxODk4NzE2ODM5LCJleHAiOjE2OTIxNTc5MTZ9.lfzoR_e5Dqkwz4F2WC6a4HRG1wevv80NzJelbydTiV0','REFRESH_TOKEN','b5293444-fd1c-4c3b-9639-f6ab34a76544'),('11abdd62-fa57-4cf0-ae41-f314ccf8f0f3','2023-08-13 16:01:21.417621','2023-08-16 16:01:21.385000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0cnVuZ2xlIiwiaWF0IjoxNjkxOTE3MjgxMzg1LCJleHAiOjE2OTIxNzY0ODF9.8-auPvhACUDeH5xY23i0E9ih4J7hXISfYC1VK2lvHHI','REFRESH_TOKEN','751a103e-1f45-4885-a4f1-0fe595b971d2'),('14753d0b-ed58-4f0a-8036-bfe3a72be15b','2023-08-13 20:35:07.524777','2024-06-08 20:35:07.500000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2OTE5MzM3MDc1MDAsImV4cCI6MTcxNzg1MzcwN30.0BUCK9i7PJINMBWR2RSx4aCyDVcnz-sWSridFz30ffY','REFRESH_TOKEN','301f9a29-f7a7-4ac9-adde-785fd157533a'),('18d57ede-8d94-4d13-ac25-b912f539fe5c','2023-08-12 21:17:35.090551','2023-08-15 21:17:35.083000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJub3ZhMSIsImlhdCI6MTY5MTg0OTg1NTA4MywiZXhwIjoxNjkyMTA5MDU1fQ.mZ85wj7-qdRRWsbQLhMVmiCw9wjxqD-wPVFNFGJ26Ew','REFRESH_TOKEN','ad10b7be-bbe4-4a6d-9fdf-b7c68e8fc45e'),('19a1526d-718f-4c05-8a1f-c938a640327c','2023-08-13 09:03:44.002211','2023-08-16 09:03:43.998000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2OTE4OTIyMjM5OTgsImV4cCI6MTY5MjE1MTQyM30.wj8poIF122gJKIt1our2OwrDkZEJeNVGGsFTqLQm44M','REFRESH_TOKEN','301f9a29-f7a7-4ac9-adde-785fd157533a'),('1c22091f-03ce-458b-b02e-1854c15b5212','2023-08-13 00:10:27.363154','2023-08-16 00:10:27.358000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJub3ZhMSIsImlhdCI6MTY5MTg2MDIyNzM1OCwiZXhwIjoxNjkyMTE5NDI3fQ.qFrPEYnXp07_UxB_8MSA5by-R6bDUvkgYWrJSho60UA','REFRESH_TOKEN','ad10b7be-bbe4-4a6d-9fdf-b7c68e8fc45e'),('1d9bf026-ab63-4208-99c2-1153610d3312','2023-08-13 14:14:26.480998','2023-08-16 14:14:26.477000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0cnVuZ2xlIiwiaWF0IjoxNjkxOTEwODY2NDc3LCJleHAiOjE2OTIxNzAwNjZ9.xrAnahqzP8BYmGUYiRko0lwqyNgHbALpx_qv_zbFvxE','REFRESH_TOKEN','751a103e-1f45-4885-a4f1-0fe595b971d2'),('1fd0fc28-b4b0-419f-b1d5-0989b016ded5','2023-08-12 22:28:38.536324','2023-08-15 22:28:38.529000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJub3ZhMSIsImlhdCI6MTY5MTg1NDExODUyOSwiZXhwIjoxNjkyMTEzMzE4fQ.uu1yJsTN-jAd0l9VIz5rwH49-rqq8jOQLiTKqATdtmY','REFRESH_TOKEN','ad10b7be-bbe4-4a6d-9fdf-b7c68e8fc45e'),('29c537bd-3910-456d-89a5-dc031aeeb63d','2023-08-13 15:27:41.893360','2023-08-16 15:27:41.890000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0cnVuZ2xlIiwiaWF0IjoxNjkxOTE1MjYxODkwLCJleHAiOjE2OTIxNzQ0NjF9.9-9BrmCqzUOdvkIqpX4ceKMRi2hmPjV8xfufP9zh_uc','REFRESH_TOKEN','751a103e-1f45-4885-a4f1-0fe595b971d2'),('2b45f947-b6aa-4318-b622-f89b8ebe83e0','2023-08-13 14:27:26.285830','2023-08-16 14:27:26.265000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0cnVuZ2xlIiwiaWF0IjoxNjkxOTExNjQ2MjY1LCJleHAiOjE2OTIxNzA4NDZ9.sGw4JSOv3EZlsEIErL8_rnt1w3So3YRXQ4T7d6W6VYs','REFRESH_TOKEN','751a103e-1f45-4885-a4f1-0fe595b971d2'),('2c28f8ae-6f48-47aa-92d7-50ab51800c44','2023-08-13 11:39:43.434373','2023-08-16 11:39:43.425000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2OTE5MDE1ODM0MjUsImV4cCI6MTY5MjE2MDc4M30.yWUfjJ9XDlf0ZvW8bnh1J05JcSZSjnZEkEkpejwbrRY','REFRESH_TOKEN','301f9a29-f7a7-4ac9-adde-785fd157533a'),('2c6ca3f0-9635-43f2-92c9-db4117457918','2023-08-13 11:42:26.766423','2023-08-16 11:42:26.758000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0cnVuZ2xlIiwiaWF0IjoxNjkxOTAxNzQ2NzU4LCJleHAiOjE2OTIxNjA5NDZ9.DZVsGxAni2VnyWXklvARj7v7XTAxeLJOBVbVDVkKG8s','REFRESH_TOKEN','751a103e-1f45-4885-a4f1-0fe595b971d2'),('2e2e25b5-74b6-4cd3-82b3-89b596ef295b','2023-08-13 09:03:42.542978','2023-08-16 09:03:42.537000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2OTE4OTIyMjI1MzcsImV4cCI6MTY5MjE1MTQyMn0.pkG3415yi63OGFEPVpt1FME3dNjdg-MrAVMT8eoIGV0','REFRESH_TOKEN','301f9a29-f7a7-4ac9-adde-785fd157533a'),('30452190-924e-4331-a1ea-ae8251a43c43','2023-08-13 10:21:25.769517','2023-08-16 10:21:25.761000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2OTE4OTY4ODU3NjEsImV4cCI6MTY5MjE1NjA4NX0.b6JDe5nEcfFilY9B7It4u2J5OB6CTttQ0PkRpdAwiL4','REFRESH_TOKEN','301f9a29-f7a7-4ac9-adde-785fd157533a'),('329a52b9-6f39-4290-b02d-dd9aee8381d5','2023-08-13 22:16:06.434918','2024-06-08 22:16:06.430000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0cnVuZ2xlIiwiaWF0IjoxNjkxOTM5NzY2NDMwLCJleHAiOjE3MTc4NTk3NjZ9.4DNuZnxBoLc08bO_3knfdRz9vN_RRUItB5OLtSDexUI','REFRESH_TOKEN','751a103e-1f45-4885-a4f1-0fe595b971d2'),('34acf9c4-e1e6-45be-b552-b3d708f4a961','2023-08-13 01:20:56.488820','2023-08-16 01:20:56.394000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2OTE4NjQ0NTYzOTQsImV4cCI6MTY5MjEyMzY1Nn0.6FpG51KDDbju-V-LUZyvVrOEI7JD7T7bXwr4d4oWIHw','REFRESH_TOKEN','301f9a29-f7a7-4ac9-adde-785fd157533a'),('39c10ef6-eed9-437f-bda3-cda7365cc4f3','2023-08-13 08:14:48.366034','2023-08-16 08:14:48.359000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2OTE4ODkyODgzNTksImV4cCI6MTY5MjE0ODQ4OH0.J7CWvJc3j0Z5vQo0mHRBJ_iHcyO7QWefw2E7amj-eJM','REFRESH_TOKEN','301f9a29-f7a7-4ac9-adde-785fd157533a'),('40f64bc4-fa7d-4562-92e8-dff6c9c78e53','2023-08-13 09:13:09.788652','2023-08-16 09:13:09.777000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2OTE4OTI3ODk3NzcsImV4cCI6MTY5MjE1MTk4OX0.zjeFrRNGAJpWThaY06FtTegTEHx-fDh0lHVsXRE2N5s','REFRESH_TOKEN','301f9a29-f7a7-4ac9-adde-785fd157533a'),('412ead6b-9adb-4af2-aaa3-94c1753af11f','2023-08-13 02:46:05.635685','2023-08-16 02:46:05.629000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2OTE4Njk1NjU2MjksImV4cCI6MTY5MjEyODc2NX0.hWY0grcd5TvZgN3A7B46bH4SaUwa5xLhIy_oZDXGfSU','REFRESH_TOKEN','301f9a29-f7a7-4ac9-adde-785fd157533a'),('452b394c-a575-4eb1-8aff-86fc417f2a5b','2023-08-13 13:18:56.597277','2023-08-16 13:18:56.588000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2OTE5MDc1MzY1ODgsImV4cCI6MTY5MjE2NjczNn0.yLBuqoyIEi3m_edlly822G-QuGlohKlEaaARoI8u1pM','REFRESH_TOKEN','301f9a29-f7a7-4ac9-adde-785fd157533a'),('45e66c32-8d2b-4c64-bf19-14df841afbc5','2023-08-13 11:58:04.765104','2023-08-16 11:58:04.758000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2OTE5MDI2ODQ3NTgsImV4cCI6MTY5MjE2MTg4NH0.XWxLhOjHHP_fq3Lwaf29YzRrqSNAIkjqVyoYP4Sta4A','REFRESH_TOKEN','301f9a29-f7a7-4ac9-adde-785fd157533a'),('4a379597-edce-4e63-84b3-fda78ac44d54','2023-08-13 21:40:25.304245','2023-08-16 21:40:25.265000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0cnVuZ2xlIiwiaWF0IjoxNjkxOTM3NjI1MjY1LCJleHAiOjE2OTIxOTY4MjV9.iet0Nr5UF8y0aRR4M8ApK5CFDU3_izILj1VhKtiuez0','REFRESH_TOKEN','751a103e-1f45-4885-a4f1-0fe595b971d2'),('4de43e8f-8e02-4d92-a3eb-064d726d98e7','2023-08-13 02:52:56.553480','2023-08-16 02:52:56.534000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2OTE4Njk5NzY1MzQsImV4cCI6MTY5MjEyOTE3Nn0.6BLyzW3QRlyujJNq2P2fEYZBGh-l1YjNRzKiNHQYlPM','REFRESH_TOKEN','301f9a29-f7a7-4ac9-adde-785fd157533a'),('5982a0ad-8f5a-49e7-b1b6-00c5bd826d03','2023-08-12 20:15:30.670196','2023-08-15 20:15:30.646000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2OTE4NDYxMzA2NDYsImV4cCI6MTY5MjEwNTMzMH0.4xVDvswscAhYTOSC_bsqEl8TvW28XqeQLikg0iU5E18','REFRESH_TOKEN','301f9a29-f7a7-4ac9-adde-785fd157533a'),('6136429b-ae09-4ca4-8b06-7ccc11f5994a','2023-08-13 08:28:19.340677','2023-08-16 08:28:19.336000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2OTE4OTAwOTkzMzYsImV4cCI6MTY5MjE0OTI5OX0.vJBraOyhkhPEW2B3QaY6XlI1Du8yL0nkq1nJLi511kw','REFRESH_TOKEN','301f9a29-f7a7-4ac9-adde-785fd157533a'),('63ffe8b7-f447-4e65-b3c3-c19768b67fe6','2023-08-13 14:12:58.176255','2023-08-16 14:12:58.172000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2OTE5MTA3NzgxNzIsImV4cCI6MTY5MjE2OTk3OH0.JaI6YAIVeYuqI0ULJX7aA2h-d1L9aMRQu3q3mcbWo7I','REFRESH_TOKEN','301f9a29-f7a7-4ac9-adde-785fd157533a'),('693e577c-bae1-468f-a0d8-2a23568ad21c','2023-08-13 11:35:22.789973','2023-08-16 11:35:22.777000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0cnVuZ2xlIiwiaWF0IjoxNjkxOTAxMzIyNzc3LCJleHAiOjE2OTIxNjA1MjJ9.JU8Q-b8aToHB5iYOYTUCj0mf63HO0d13zrExY2MK4a8','REFRESH_TOKEN','751a103e-1f45-4885-a4f1-0fe595b971d2'),('6b025d88-9db5-4832-88e5-247455706b3e','2023-08-13 11:54:54.129464','2023-08-16 11:54:54.092000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0cnVuZ2xlIiwiaWF0IjoxNjkxOTAyNDk0MDkyLCJleHAiOjE2OTIxNjE2OTR9.wl6EA0FQ4eyKs53as8QByUEjKDqeIHqaBaLY_1HFzt4','REFRESH_TOKEN','751a103e-1f45-4885-a4f1-0fe595b971d2'),('7766bba0-b0ee-4ea7-a8f0-359e3bf565db','2023-08-13 11:21:43.536554','2023-08-16 11:21:43.529000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmcxMjM0IiwiaWF0IjoxNjkxOTAwNTAzNTI5LCJleHAiOjE2OTIxNTk3MDN9.OBE2AJRpDNJcU3H_llrKidAGNMHm2oLYu-V9uulTUlw','REFRESH_TOKEN','b5293444-fd1c-4c3b-9639-f6ab34a76544'),('78bb8bcb-5848-46f7-9513-15c0a4c14eff','2023-08-13 17:05:03.345491','2024-06-08 17:05:03.288000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2OTE5MjExMDMyODgsImV4cCI6MTcxNzg0MTEwM30.AuycPbRAiPPuXDNfOL5dZ060tsBk-tnRw_E4TS10_RI','REFRESH_TOKEN','301f9a29-f7a7-4ac9-adde-785fd157533a'),('79021c4d-7759-4f17-bcb0-86838702f885','2023-08-13 10:49:16.732117','2023-08-16 10:49:16.694000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2OTE4OTg1NTY2OTQsImV4cCI6MTY5MjE1Nzc1Nn0.njOPpQzoWPOFnYfOjR5Fb4QjKdtZDcX5A2xkghGnvaA','REFRESH_TOKEN','301f9a29-f7a7-4ac9-adde-785fd157533a'),('799dcac4-ad38-4ed7-9ff8-7d272eff3663','2023-08-13 11:43:08.973294','2023-08-16 11:43:08.953000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0cnVuZ2xlIiwiaWF0IjoxNjkxOTAxNzg4OTUzLCJleHAiOjE2OTIxNjA5ODh9.MeZnwnjE1iH4rHKz_TKdYOTMrdANhZhewljE9VZzLwg','REFRESH_TOKEN','751a103e-1f45-4885-a4f1-0fe595b971d2'),('8490010f-8583-46b5-83cf-9f76c26ab28e','2023-08-13 14:29:15.569603','2023-08-16 14:29:15.555000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2OTE5MTE3NTU1NTUsImV4cCI6MTY5MjE3MDk1NX0.kHc9BUFqsxJzoh_ajNHMGO8dPlryXHhxA6Uzbnb3tyo','REFRESH_TOKEN','301f9a29-f7a7-4ac9-adde-785fd157533a'),('8684261e-a54d-4f00-b38d-57edf126fa97','2023-08-13 17:23:54.856165','2024-06-08 17:23:54.838000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJub3ZhMSIsImlhdCI6MTY5MTkyMjIzNDgzOCwiZXhwIjoxNzE3ODQyMjM0fQ.HTw0t4bJZt6qR96dBcyJgH5fQSvvxMuElOuOP4qO9CU','REFRESH_TOKEN','ad10b7be-bbe4-4a6d-9fdf-b7c68e8fc45e'),('8b5b7bd8-7e81-40b0-8cc2-7b3b3ce6c8a5','2023-08-13 15:56:44.781690','2023-08-16 15:56:44.749000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0cnVuZ2xlIiwiaWF0IjoxNjkxOTE3MDA0NzQ5LCJleHAiOjE2OTIxNzYyMDR9.zwwPnM9Bvi3VCfXwQWNU2YAXlxLKAwCqah3AgLZSuwA','REFRESH_TOKEN','751a103e-1f45-4885-a4f1-0fe595b971d2'),('8d1604a2-b5f9-4c4a-9c19-3a32b1a26577','2023-08-13 10:49:27.400307','2023-08-16 10:49:27.386000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2OTE4OTg1NjczODYsImV4cCI6MTY5MjE1Nzc2N30.iBPnkoKQ3E0n5hio9InqpyFk6WyyRTJUI-I6Anu0G0c','REFRESH_TOKEN','301f9a29-f7a7-4ac9-adde-785fd157533a'),('8d21f784-498b-42be-a278-c31e4dfe94d0','2023-08-13 08:16:44.357998','2023-08-16 08:16:44.352000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2OTE4ODk0MDQzNTIsImV4cCI6MTY5MjE0ODYwNH0.Wv79rdFJzFnI1UxC-vW4gqRNshyooca_C5Qp292um1A','REFRESH_TOKEN','301f9a29-f7a7-4ac9-adde-785fd157533a'),('8de804a4-c956-42b3-a72a-abc3920e21d8','2023-08-13 17:00:23.880072','2024-06-08 17:00:23.868000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0cnVuZ2xlIiwiaWF0IjoxNjkxOTIwODIzODY4LCJleHAiOjE3MTc4NDA4MjN9.iVf2uxHeZGzWJtnPXdpE4ZR0UZhJkKIHG98iR5qWsVU','REFRESH_TOKEN','751a103e-1f45-4885-a4f1-0fe595b971d2'),('9120e304-cd7a-4779-8f59-2bc1e4692548','2023-08-13 11:37:36.455206','2023-08-16 11:37:36.445000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2OTE5MDE0NTY0NDUsImV4cCI6MTY5MjE2MDY1Nn0.UjhpgKFUiCRSCZsG2SKg0G2MD8uduRwtWXaGDjlatJE','REFRESH_TOKEN','301f9a29-f7a7-4ac9-adde-785fd157533a'),('91235b9a-6da3-4734-9294-9f7220eb8117','2023-08-13 17:01:43.537604','2024-06-08 17:01:43.529000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0cnVuZ2xlIiwiaWF0IjoxNjkxOTIwOTAzNTI5LCJleHAiOjE3MTc4NDA5MDN9.TkZi6QLdJ1dxsaajmXYpIpHRTLgA5Mu_d7JD1etHXfU','REFRESH_TOKEN','751a103e-1f45-4885-a4f1-0fe595b971d2'),('92265fa6-6287-47ed-8e1a-52749200035c','2023-08-13 14:26:02.848900','2023-08-16 14:26:02.846000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0cnVuZ2xlIiwiaWF0IjoxNjkxOTExNTYyODQ2LCJleHAiOjE2OTIxNzA3NjJ9.PuHucfw9Rqg_rmnBZ7OJiafwaeDcwkR63pcTs8UjLPE','REFRESH_TOKEN','751a103e-1f45-4885-a4f1-0fe595b971d2'),('99bc972d-89fe-457a-87f9-fe3e31da2b37','2023-08-13 10:46:12.528338','2023-08-16 10:46:12.495000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2OTE4OTgzNzI0OTUsImV4cCI6MTY5MjE1NzU3Mn0.elDhVkwpoa1FqLQkhXqn74not8MCcADKGzqrzRwqpKw','REFRESH_TOKEN','301f9a29-f7a7-4ac9-adde-785fd157533a'),('ac172485-f8bb-4e79-b99d-3a120d0da9d3','2023-08-12 23:27:02.634665','2023-08-15 23:27:02.601000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJub3ZhMSIsImlhdCI6MTY5MTg1NzYyMjYwMSwiZXhwIjoxNjkyMTE2ODIyfQ.fHZQHt_83Acb2g0jqS8vzm-rZvvmKHmbCFCkD4V3npo','REFRESH_TOKEN','ad10b7be-bbe4-4a6d-9fdf-b7c68e8fc45e'),('b00d51b7-f8f7-423a-a973-c2aa75d2ccfb','2023-08-13 01:41:25.514098','2023-08-16 01:41:25.506000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2OTE4NjU2ODU1MDYsImV4cCI6MTY5MjEyNDg4NX0.JfMUqDEfJOuqcxrhuEPMhhXU-Cazk7mfvuMZrB2YsS0','REFRESH_TOKEN','301f9a29-f7a7-4ac9-adde-785fd157533a'),('b5ffcde2-2b38-49c8-ae05-dbc3ec647f5c','2023-08-13 03:35:26.970716','2023-08-16 03:35:26.963000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJub3ZhMSIsImlhdCI6MTY5MTg3MjUyNjk2MywiZXhwIjoxNjkyMTMxNzI2fQ.bC1VcvlReXgnbI-8Qtpzd3c6ADrTOKmXU3oZdA5SRqE','REFRESH_TOKEN','ad10b7be-bbe4-4a6d-9fdf-b7c68e8fc45e'),('ba3d08da-6e77-4b04-aa25-3073bf03d6ef','2023-08-12 22:25:45.555578','2023-08-15 22:25:45.539000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2OTE4NTM5NDU1MzksImV4cCI6MTY5MjExMzE0NX0.JFmFtQqdyN7hYT0pzJko0FZiV7_QfE68l_kYWqCpquQ','REFRESH_TOKEN','301f9a29-f7a7-4ac9-adde-785fd157533a'),('baa3178b-b1ad-45dc-8477-5cba2402f1a3','2023-08-13 22:20:03.744513','2024-06-08 22:20:03.732000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwaHVjMTIzNCIsImlhdCI6MTY5MTk0MDAwMzczMiwiZXhwIjoxNzE3ODYwMDAzfQ.oOnxX52V72VGY97cnWaKKmRdle3WMCUNU3ImNR4o7JQ','REFRESH_TOKEN','39b606bc-0923-48bb-9065-239e924ed6b0'),('c02540c3-5a76-4f34-8f88-f801916e1674','2023-08-13 10:45:02.179365','2023-08-16 10:45:02.162000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2OTE4OTgzMDIxNjIsImV4cCI6MTY5MjE1NzUwMn0.Nql1Z8wM7JYDn4P6AL9Xe3GeUIwS8iPavGJPzbEUPwI','REFRESH_TOKEN','301f9a29-f7a7-4ac9-adde-785fd157533a'),('c0907f72-5c15-4039-93a7-b6a43c3f4554','2023-08-13 14:14:13.753134','2023-08-16 14:14:13.750000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0cnVuZ2xlIiwiaWF0IjoxNjkxOTEwODUzNzUwLCJleHAiOjE2OTIxNzAwNTN9.FRyvas5C3HRDXm6YZH7BbaPmxwtR-_GYni1vDma7GQQ','REFRESH_TOKEN','751a103e-1f45-4885-a4f1-0fe595b971d2'),('cff0046f-552b-4bea-80f3-418117e8a1fa','2023-08-13 02:57:11.530756','2023-08-16 02:57:11.489000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJub3ZhMSIsImlhdCI6MTY5MTg3MDIzMTQ4OSwiZXhwIjoxNjkyMTI5NDMxfQ.2nzfoqA5L6r7WSh2MQAWkuoF7Ne9HwLOr-j4gc884NI','REFRESH_TOKEN','ad10b7be-bbe4-4a6d-9fdf-b7c68e8fc45e'),('d87f8f1c-73f3-4893-8a33-1b42c414fb85','2023-08-13 20:35:06.032234','2024-06-08 20:35:06.026000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2OTE5MzM3MDYwMjYsImV4cCI6MTcxNzg1MzcwNn0.HtWCeDaL7l2mjFAE5Hr7w3UVm4vkdzJEv5l6MtySfVw','REFRESH_TOKEN','301f9a29-f7a7-4ac9-adde-785fd157533a'),('ddfb2aac-8562-4d9a-a933-dacb7c11be32','2023-08-13 16:52:15.122772','2024-06-08 16:52:15.118000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2OTE5MjAzMzUxMTgsImV4cCI6MTcxNzg0MDMzNX0.lWLKwnKhXCvuVzhXT-LK0afidXwoOrOXRxxFJrHeZyo','REFRESH_TOKEN','301f9a29-f7a7-4ac9-adde-785fd157533a'),('e430878d-93ef-4250-809b-a4758894ccb7','2023-08-13 17:59:02.894787','2024-06-08 17:59:02.889000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJUcm9uZyIsImlhdCI6MTY5MTkyNDM0Mjg4OSwiZXhwIjoxNzE3ODQ0MzQyfQ.3m-pNdTSovvsXtghG8qhterIl-1GcYntna5gMacj3Yk','REFRESH_TOKEN','3d88e735-57c0-4cb7-b8a1-91a6ada0f928'),('e61ee7d5-07b3-462a-8a68-1dd6080cbf95','2023-08-13 13:30:50.437111','2023-08-16 13:30:50.428000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmciLCJpYXQiOjE2OTE5MDgyNTA0MjgsImV4cCI6MTY5MjE2NzQ1MH0.Usn9WlF43AhS5HqJiP_DraTPJD5DE2yYXIaH2jDcfKU','REFRESH_TOKEN','301f9a29-f7a7-4ac9-adde-785fd157533a'),('e6d39dc4-7754-4355-ab81-701b666ef95d','2023-08-13 10:23:43.670303','2023-08-16 10:23:43.658000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJub3ZhMSIsImlhdCI6MTY5MTg5NzAyMzY1OCwiZXhwIjoxNjkyMTU2MjIzfQ.67mb3op2K0GRXk6lUtbCptJFGXZb_XWd0PFG-D5QfkM','REFRESH_TOKEN','ad10b7be-bbe4-4a6d-9fdf-b7c68e8fc45e'),('e7d1cac7-788f-4413-9002-176754976ef5','2023-08-13 12:29:59.733066','2023-08-16 12:29:59.725000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0cnVuZ2xlIiwiaWF0IjoxNjkxOTA0NTk5NzI1LCJleHAiOjE2OTIxNjM3OTl9.wtgwft7cPvq2P5Gs-tpwJ3-xP0b3210eoZtryD6RXV8','REFRESH_TOKEN','751a103e-1f45-4885-a4f1-0fe595b971d2'),('ef0a6421-d5e1-4736-b52c-9f0b6bd39041','2023-08-13 22:20:17.540741','2024-06-08 22:20:17.535000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY5MTk0MDAxNzUzNSwiZXhwIjoxNzE3ODYwMDE3fQ.6LgFSMzS0cHXlfry0Hw_KAW-9ohNpjxHP8O6fIxqNzs','REFRESH_TOKEN','81fbf3d8-4ef2-4ff7-84b6-2dd6a4a208d5'),('f3b72dfa-71fb-4ddb-83bf-16f372cef86d','2023-08-13 11:35:24.239741','2023-08-16 11:35:24.230000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0cnVuZ2xlIiwiaWF0IjoxNjkxOTAxMzI0MjMwLCJleHAiOjE2OTIxNjA1MjR9.uaw6X-0sVdpECs9l18wc-t_P8VB0wBp8DAtNYXCsDq4','REFRESH_TOKEN','751a103e-1f45-4885-a4f1-0fe595b971d2'),('f51b2490-3ba2-48ae-8af4-d7cbce11a0d4','2023-08-12 14:42:41.269549','2023-08-15 14:42:41.267000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0cnVuZ2xlIiwiaWF0IjoxNjkxODI2MTYxMjY3LCJleHAiOjE2OTIwODUzNjF9.1xYujDK-Q29UpjELvaDrb5Eo60tiXVqfyhbUNWv2yO0','REFRESH_TOKEN','751a103e-1f45-4885-a4f1-0fe595b971d2'),('fae4bd7f-2ac0-484a-b1b1-44892922c0c5','2023-08-12 15:10:29.969832','2023-08-15 15:10:29.967000','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0cnVuZ2xlIiwiaWF0IjoxNjkxODI3ODI5OTY3LCJleHAiOjE2OTIwODcwMjl9.8lIZyHmNIZ_VGoD_SeMaves9VunN2S7vXkxazB4TXVk','REFRESH_TOKEN','751a103e-1f45-4885-a4f1-0fe595b971d2');
/*!40000 ALTER TABLE `tokens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `age` int DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(40) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `full_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `gender` bit(1) DEFAULT NULL,
  `is_activated` bit(1) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `phone` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `account_id` varchar(36) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FKfm8rm8ks0kgj4fhlmmljkj17x` (`account_id`) USING BTREE,
  CONSTRAINT `FKfm8rm8ks0kgj4fhlmmljkj17x` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('2911d9a9-dca3-4532-bd87-f99fbddee49c','string',NULL,'string','2023-08-12','string@gmail.com','string',_binary '',NULL,_binary '\0','string','301f9a29-f7a7-4ac9-adde-785fd157533a'),('3cbb382c-ed6b-4410-b7b4-33e42a4f00fa','22 Le Loi',NULL,'string','2023-08-13','csvobaogenshin5@gmail.com','trungle1',_binary '',NULL,_binary '\0','0373405298','a4181006-a170-4aa8-bee8-68e166537bd6'),('6e282fde-5534-476c-b2f7-234df94724f8','hcm',NULL,NULL,'2023-08-13','kirito3175@gmail.com','Trần Lê Thiên Phúc',_binary '\0',NULL,_binary '\0','0794766248','39b606bc-0923-48bb-9065-239e924ed6b0'),('707a5bff-97ff-4738-a1a5-c7e521c706ed','string',NULL,'string','2023-08-13','admin@gmail.com','nguyen van bao',_binary '',NULL,_binary '\0','string','81fbf3d8-4ef2-4ff7-84b6-2dd6a4a208d5'),('78ae3281-9d90-4986-844a-14a028eeff00','string',NULL,'string','2023-08-12','trungle@gmail.com','string',_binary '',NULL,_binary '\0','string','751a103e-1f45-4885-a4f1-0fe595b971d2'),('8b1c1a24-6643-41d0-a55d-e53f8fc83426','22 Le Loi',NULL,'string','2023-08-13','leanhtrung97@gmail.com','trungle1',_binary '',NULL,_binary '\0','0373405298','625f10a6-911c-41f2-9e82-6cdc66a91a80'),('9207dcbb-ae0f-428f-ae55-31187e351f29','Nhà Bè. Hồ Chí Minh',NULL,NULL,'2003-08-16','trong123@gmail.com','Nguyễn Trần Trọng',_binary '\0',NULL,_binary '\0','0987123564','3d88e735-57c0-4cb7-b8a1-91a6ada0f928'),('a31949d0-b999-4e7a-a22e-cd1343f868fd','jdjdjdhdhdj',NULL,NULL,'2023-08-12','nova@gmail.com','tmkssfddd',_binary '',NULL,_binary '\0','09383837443','ad10b7be-bbe4-4a6d-9fdf-b7c68e8fc45e'),('ebb58526-c74f-41d3-a71a-842ce59a9d24','hcm',NULL,NULL,'2023-08-13','kirito3175@gmail.com','Trần Lê Thiên Phúc',_binary '\0',NULL,_binary '\0','0794766248','1c4a0f6a-dd3f-4ae5-b243-424a87e95a6a'),('f58ec4e7-1dc1-4520-b2c9-a1ead6a3c1a3','string',NULL,'string','2023-08-13','string@gmail.com','string111111',_binary '',NULL,_binary '\0','string','b5293444-fd1c-4c3b-9639-f6ab34a76544'),('ff865a3c-2384-4d33-890c-67874b732386','71 hiệp bình chánh',NULL,NULL,'2023-08-12','nova1x1996@gmail.com','aaaass',_binary '\0',NULL,_binary '\0','0997777434','9e29a9d7-4e88-43c3-96c2-853f7fa84b5a');
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

-- Dump completed on 2023-08-13 22:25:59
