-- Drop the old database
DROP DATABASE IF EXISTS `unipsdb`;

-- Create the database
CREATE DATABASE IF NOT EXISTS `unipsdb`;


-- Crate the table for the users
CREATE TABLE IF NOT EXISTS `unipsdb`.`users` (
    `user_id` INT(11) NOT NULL AUTO_INCREMENT,
    `createdDate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `username` VARCHAR(50) NOT NULL,
    `password` VARCHAR(50) NOT NULL,
    `email` VARCHAR(50) NOT NULL,
    `question1` VARCHAR(50) NOT NULL,
    `question2` VARCHAR(50) NOT NULL,
    `pictureFeatured` VARCHAR(100),
    `description` BLOB(200),
    `status_id` TINYINT(1) NOT NULL,
    `authority_id` TINYINT(1) NOT NULL,
    PRIMARY KEY (`user_id`)
)  ENGINE=INNODB DEFAULT CHARSET=LATIN1;


-- Create a table for the authorities type 
CREATE TABLE IF NOT EXISTS `unipsdb`.`authorities` (
    `authority_id` TINYINT(1) NOT NULL,
    `authority` VARCHAR(15) NOT NULL,
    PRIMARY KEY (`authority_id`)
)  ENGINE=INNODB DEFAULT CHARSET=LATIN1;

-- Create table for the user status
CREATE TABLE IF NOT EXISTS `unipsdb`.`status` (
    `status_id` TINYINT(1) NOT NULL,
    `status` VARCHAR(15) NOT NULL,
    PRIMARY KEY (`status_id`)
)  ENGINE=INNODB DEFAULT CHARSET=LATIN1;

-- Create a table for the pictures
CREATE TABLE IF NOT EXISTS `unipsdb`.`user_pictures` (
	`user_picture_id` INT(11) NOT NULL AUTO_INCREMENT, 
    `picture` VARCHAR(100) NOT NULL,
    `user_id` INT(11),
     PRIMARY KEY (`user_picture_id`)
) ENGINE=INNODB DEFAULT CHARSET=LATIN1;

-- Add data  to the authorities types
TRUNCATE `unipsdb`.`authorities`;
INSERT INTO `unipsdb`.`authorities` (`authority_id`, `authority`) VALUES
	(0, 'ROLE_ADMIN'),
	(1, 'ROLE_USER'),
    (2, 'ROLE_BUSINESS');
    
-- Add data  to the user status
TRUNCATE `unipsdb`.`status`;
INSERT INTO `unipsdb`.`status` (`status_id`, `status`) VALUES
	(0, 'ACTIVE'),
	(1, 'DISABLED'),
    (2, 'SUSPENDED'),
    (3, 'BANNED');

-- Add data for the usernames
TRUNCATE `unipsdb`.`users`;
INSERT INTO `unipsdb`.`users` (`username`, `password`, `email`,`question1`, `question2`, `status_id`, `authority_id`) VALUES
	('kathy', '21a4ed0a0cf607e77e93bf7604e2bb1ad07757c5', 'kathy@kathy.com','blue2','blue2', 1, 0),
	('sam', '904752ad9c4ae4186c4b4897321c517de0618702','sam@sam.com','red2', 'red2', 1, 1),
    ('starbucks', '904752ad9c4ae4186c4b4897321c517de0618702', 'star@star.com', 'green1', 'green2', 1, 2);
    
-- Add data to the pictures
TRUNCATE `unipsdb`.`user_pictures`;
INSERT INTO `unipsdb`.`user_pictures` (`user_id`, `picture`) VALUES
	(1, 'F:\pics\kathy001.png'),
	(1, 'F:\pics\kathy002.png'),
	(2, 'F:\pics\sam.jpeg'),
	(3, 'F:\pics\starbucks_001.jpeg'),
	(3, 'F:\pics\starbucks_002.jpeg'),
	(3, 'F:\pics\starbucks_003.jpeg'),
	(3, 'F:\pics\starbucks_004.jpeg');
