-- sql_test.book definition

CREATE TABLE `book` (
  `id` varchar(100) NOT NULL,
  `book_name` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `book_catagory` varchar(100) DEFAULT NULL,
  `book_author` varchar(100) DEFAULT NULL,
  `create_time_stamp` datetime NOT NULL,
  `update_time_stamp` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `book_book_name_IDX` (`book_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- sql_test.operate_log definition

CREATE TABLE `operate_log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `operate_user` varchar(100) DEFAULT NULL,
  `operate_ip` varchar(100) DEFAULT NULL,
  `operate_url` varchar(100) DEFAULT NULL,
  `operate_time` datetime NOT NULL,
  `operate_method` varchar(100) DEFAULT NULL,
  `createTimeStamp` datetime DEFAULT NULL,
  `updateTimeStamp` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;