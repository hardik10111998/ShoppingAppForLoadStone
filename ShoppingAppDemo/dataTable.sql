CREATE TABLE `discount` (
  `discount_id` int NOT NULL AUTO_INCREMENT,
  `discount_amount` float NOT NULL,
  PRIMARY KEY (`discount_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--------------------------------------------
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `discount` float NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` float NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `discount_discount_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmjp5205knr0wxqygmcv6vlmqp` (`discount_discount_id`),
  CONSTRAINT `FKmjp5205knr0wxqygmcv6vlmqp` FOREIGN KEY (`discount_discount_id`) REFERENCES `discount` (`discount_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
