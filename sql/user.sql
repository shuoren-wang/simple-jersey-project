CREATE DATABASE IF NOT EXISTS test;

USE test;


DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(11) NOT NULL
);


INSERT INTO `user` (`name`) VALUES ('user_1');
INSERT INTO `user` (`name`) VALUES ('user_2');
INSERT INTO `user` (`name`) VALUES ('user_3');
INSERT INTO `user` (`name`) VALUES ('user_4');
