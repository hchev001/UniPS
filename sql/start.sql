-- --------------------- --
-- Drop the old database --
-- --------------------- --
DROP DATABASE IF EXISTS `unipsdb`;


-- ------------------------ --
-- Create all tables needed --
-- ------------------------ --

-- Create the database
CREATE DATABASE IF NOT EXISTS `unipsdb`;

-- Create a table for the role type 
CREATE TABLE IF NOT EXISTS `unipsdb`.`role` (
    `role_id` TINYINT(1) NOT NULL,
    `role` VARCHAR(15) NOT NULL,
    PRIMARY KEY (`role_id`)
)  ENGINE=INNODB DEFAULT CHARSET=LATIN1;

-- Create table for the user status
CREATE TABLE IF NOT EXISTS `unipsdb`.`status` (
    `status_id` TINYINT(1) NOT NULL,
    `status` VARCHAR(15) NOT NULL,
    PRIMARY KEY (`status_id`)
)  ENGINE=INNODB DEFAULT CHARSET=LATIN1;


-- Create the table for the users
CREATE TABLE IF NOT EXISTS `unipsdb`.`user` (
    `user_id` INT(11) NOT NULL AUTO_INCREMENT,
    `created_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `username` VARCHAR(50) NOT NULL,
    `password` VARCHAR(50) NOT NULL,
    `email` VARCHAR(50) NOT NULL,
    `question1` VARCHAR(50) NOT NULL,
    `question2` VARCHAR(50) NOT NULL,
    `picture_featured` VARCHAR(100) DEFAULT NULL,
    `description` TINYTEXT,
    `status_id` TINYINT(1) NOT NULL,
    `role_id` TINYINT(1) NOT NULL,
    `token` VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY (`user_id`),
    KEY `token` (`token`),
    KEY `role_idx` (`role_id`),
    KEY `status_idx` (`status_id`),
    CONSTRAINT `fk_user_role_id` FOREIGN KEY (`role_id`)
        REFERENCES `unipsdb`.`role` (`role_id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `fk_user_status_id` FOREIGN KEY (`status_id`)
        REFERENCES `unipsdb`.`status` (`status_id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION
)  ENGINE=INNODB DEFAULT CHARSET=LATIN1;


-- Create a table for the pictures
CREATE TABLE IF NOT EXISTS `unipsdb`.`user_picture` (
    `user_picture_id` INT(11) NOT NULL AUTO_INCREMENT,
    `picture` VARCHAR(100) NOT NULL,
    `user_id` INT(11) DEFAULT NULL,
    PRIMARY KEY (`user_picture_id`),
    KEY `user_idx` (`user_id`),
    CONSTRAINT `fk_user_picture_user_id` FOREIGN KEY (`user_id`)
        REFERENCES `unipsdb`.`user` (`user_id`)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB DEFAULT CHARSET=LATIN1;


-- Create Address table
CREATE TABLE IF NOT EXISTS `unipsdb`.`address` (
    `address_id` INT(11) NOT NULL AUTO_INCREMENT,
    `line1` VARCHAR(50) NOT NULL,
    `line2` VARCHAR(50) NULL,
    `city` VARCHAR(50) NOT NULL,
    `state` VARCHAR(2) NOT NULL,
    `zip` INT(5) NOT NULL,
    PRIMARY KEY (`address_id`)
)  ENGINE=INNODB DEFAULT CHARSET=LATIN1;


-- Create business category table
CREATE TABLE IF NOT EXISTS `unipsdb`.`business_category` (
    `business_category_id` TINYINT(2) NOT NULL,
    `category` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`business_category_id`)
)  ENGINE=INNODB DEFAULT CHARSET=LATIN1;


-- Create business table
CREATE TABLE IF NOT EXISTS `unipsdb`.`business` (
    `business_id` INT(11) NOT NULL AUTO_INCREMENT,
    `created_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `username` VARCHAR(50) NOT NULL,
    `password` VARCHAR(50) NOT NULL,
    `phone` INT(10) NULL,
    `phone_business` INT(10) NULL,
    `email` VARCHAR(50) NOT NULL,
    `question1` VARCHAR(50) NOT NULL,
    `question2` VARCHAR(50) NOT NULL,
    `picture_featured` VARCHAR(100) NULL,
    `description` TEXT(400) NULL,
    `hours` TEXT(200) NULL,
    `address_id` INT(11) NULL,
    `status_id` TINYINT(1) NOT NULL,
    `role_id` TINYINT(1) NOT NULL,
    `business_category_id` TINYINT(2) NULL,
    `token` VARCHAR(50) NULL,
    PRIMARY KEY (`business_id`),
    UNIQUE INDEX `username` (`username`),
    INDEX `token` (`token`),
    INDEX `address_idx` (`address_id`),
    INDEX `status_idx` (`status_id`),
    INDEX `role_idx` (`role_id`),
    INDEX `category_idx` (`business_category_id`),
    CONSTRAINT `fk_business_address_id` FOREIGN KEY (`address_id`)
        REFERENCES `unipsdb`.`address` (`address_id`)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `fk_business_status_id` FOREIGN KEY (`status_id`)
        REFERENCES `unipsdb`.`status` (`status_id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `fk_business_role_id` FOREIGN KEY (`role_id`)
        REFERENCES `unipsdb`.`role` (`role_id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `fk_business_category_id` FOREIGN KEY (`business_category_id`)
        REFERENCES `unipsdb`.`business_category` (`business_category_id`)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB DEFAULT CHARSET=LATIN1;


-- Create a table for the flags
CREATE TABLE IF NOT EXISTS `unipsdb`.`comment_flag` (
    `comment_flag_id` TINYINT(1) NOT NULL,
    `flag` VARCHAR(10) NULL,
    PRIMARY KEY (`comment_flag_id`)
)  ENGINE=INNODB DEFAULT CHARACTER SET=LATIN1;


-- Create a comment table
CREATE TABLE IF NOT EXISTS `unipsdb`.`comment` (
    `comment_id` INT(11) NOT NULL AUTO_INCREMENT,
    `created_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `subject` VARCHAR(50) NULL,
    `body` TEXT(200) NULL,
    `comment_flag_id` TINYINT(1) NULL,
    `user_id` INT(11) NULL,
    `business_id` INT(11) NULL,
    PRIMARY KEY (`comment_id`),
    INDEX `user` (`user_id`),
    INDEX `business` (`business_id`),
    INDEX `comment_flag_idx` (`comment_flag_id`),
    CONSTRAINT `fk_comment_comment_flag_id` FOREIGN KEY (`comment_flag_id`)
        REFERENCES `unipsdb`.`comment_flag` (`comment_flag_id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `fk_comment_user_id` FOREIGN KEY (`user_id`)
        REFERENCES `unipsdb`.`user` (`user_id`)
        ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT `fk_comment_business_id` FOREIGN KEY(`business_id`)
		REFERENCES `unipsdb`.`business` (`business_id`)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB DEFAULT CHARACTER SET=LATIN1;


-- Create rating_value table
CREATE TABLE IF NOT EXISTS `unipsdb`.`rating_value` (
    `rating_value_id` TINYINT(1) NOT NULL,
    `value` VARCHAR(10) NULL,
    PRIMARY KEY (`rating_value_id`)
)  ENGINE=INNODB DEFAULT CHARACTER SET=LATIN1;


-- Create a rating table
CREATE TABLE IF NOT EXISTS `unipsdb`.`rating` (
    `rating_id` INT(11) NOT NULL AUTO_INCREMENT,
    `created_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `rating_value_id` TINYINT(1) NULL,
    `user_id` INT(11) NULL,
    `business_id` INT(11) NULL,
    PRIMARY KEY (`rating_id`),
    INDEX `user` (`user_id`),
    INDEX `business` (`business_id`),
    INDEX `rating_value_idx` (`rating_value_id`),
    CONSTRAINT `fk_rating_rating_value_id` FOREIGN KEY (`rating_value_id`)
        REFERENCES `unipsdb`.`rating_value` (`rating_value_id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `fk_rating_user_id` FOREIGN KEY (`user_id`)
        REFERENCES `unipsdb`.`user` (`user_id`)
        ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT `fk_rating_business_id` FOREIGN KEY(`business_id`)
		REFERENCES `unipsdb`.`business` (`business_id`)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB DEFAULT CHARACTER SET=LATIN1;


-- Create a business picture table
CREATE TABLE IF NOT EXISTS `unipsdb`.`business_picture` (
    `business_picture_id` INT(11) NOT NULL AUTO_INCREMENT,
    `picture` VARCHAR(100) NOT NULL,
    `business_id` INT(11) DEFAULT NULL,
    `user_id` INT(11) DEFAULT NULL,
    PRIMARY KEY (`business_picture_id`),
    KEY `business_idx` (`business_id`),
    KEY `user_idx` (`user_id`),
    CONSTRAINT `fk_business_picture_business_id` FOREIGN KEY (`business_id`)
        REFERENCES `unipsdb`.`business` (`business_id`)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `fk_business_picture_user_id` FOREIGN KEY (`user_id`)
        REFERENCES `unipsdb`.`user` (`user_id`)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB DEFAULT CHARSET=LATIN1;



-- ------------------------ --
-- Populate all tables needed --
-- ------------------------ --


-- Add data  to the authorities types
INSERT INTO `unipsdb`.`role` (`role_id`, `role`) VALUES
	(0, 'ROLE_ADMIN'),
	(1, 'ROLE_USER'),
    (2, 'ROLE_BUSINESS');
    
-- Add data  to the user status
INSERT INTO `unipsdb`.`status` (`status_id`, `status`) VALUES
	(0, 'ACTIVE'),
	(1, 'DISABLED'),
    (2, 'SUSPENDED'),
    (3, 'BANNED');

-- Add data for the usernames
INSERT INTO `unipsdb`.`user` (`username`, `password`, `email`,`question1`, `question2`, `status_id`, `role_id`) VALUES
	('kathy', '21a4ed0a0cf607e77e93bf7604e2bb1ad07757c5', 'kathy@kathy.com','blue2','blue2', 0, 0),
	('sam', '904752ad9c4ae4186c4b4897321c517de0618702','sam@sam.com','red2', 'red2', 0, 1),
    ('starbucks', '904752ad9c4ae4186c4b4897321c517de0618702', 'star@star.com', 'green1', 'green2', 0, 2);
    
-- Add data to the pictures
TRUNCATE `unipsdb`.`user_picture`;
INSERT INTO `unipsdb`.`user_picture` (`user_id`, `picture`) VALUES
	(1, 'F:\pics\kathy001.png'),
	(1, 'F:\pics\kathy002.png'),
	(2, 'F:\pics\sam.jpeg'),
	(3, 'F:\pics\starbucks_001.jpeg'),
	(3, 'F:\pics\starbucks_002.jpeg'),
	(3, 'F:\pics\starbucks_003.jpeg'),
	(3, 'F:\pics\starbucks_004.jpeg');
