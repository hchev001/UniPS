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
CREATE TABLE IF NOT EXISTS `unipsdb`.`user` (
    `user_id` INT(11) NOT NULL AUTO_INCREMENT,
    `created_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `username` VARCHAR(50) NOT NULL,
    `name` VARCHAR(50) NULL,
    `password` VARCHAR(50) NOT NULL,
    `phone` BIGINT(10) NULL,
    `phone_business` BIGINT(10) NULL,
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
    PRIMARY KEY (`user_id`),
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


-- Create the picture table
CREATE TABLE `unipsdb`.`picture` (
    `picture_id` INT(11) NOT NULL AUTO_INCREMENT,
    `picture` VARCHAR(100) NULL,
    `user_id` INT(11) NULL,
    `user_id_referenced` INT(11) NULL,
    PRIMARY KEY (`picture_id`),
    INDEX `user_idx` (`user_id`),
    INDEX `user_referenced_idx` (`user_id_referenced`),
    CONSTRAINT `fk_picture_user_id` FOREIGN KEY (`user_id`)
        REFERENCES `unipsdb`.`user` (`user_id`)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `fk_picture_user_id_referenced` FOREIGN KEY (`user_id_referenced`)
        REFERENCES `unipsdb`.`user` (`user_id`)
        ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=LATIN1;


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
	CONSTRAINT `fk_comment_business_id` FOREIGN KEY(`user_id`)
		REFERENCES `unipsdb`.`user` (`user_id`)
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
		REFERENCES `unipsdb`.`user` (`user_id`)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB DEFAULT CHARACTER SET=LATIN1;



-- ------------------------ --
-- Populate all tables needed --
-- ------------------------ --

-- Add data  to the role types
INSERT INTO `unipsdb`.`role` 
	(`role_id`, `role`) 
VALUES
	(0, 'ROLE_ADMIN'),
	(1, 'ROLE_USER'),
    (2, 'ROLE_BUSINESS');
    
-- Add data  to the user status
INSERT INTO `unipsdb`.`status` 
	(`status_id`, `status`) 
VALUES
	(0, 'DISABLED'),
	(1, 'ACTIVE'),
    (2, 'SUSPENDED'),
    (3, 'BANNED');

-- Add data to the business categories
INSERT INTO `unipsdb`.`business_category` 
	(`business_category_id`, `category`) 
VALUES
	(0, 'RESTAURANT'), 
	(1, 'SHOPING'), 
	(2, 'HEATH'), 
	(3, 'EDUCATION'), 
	(4, 'COFFEE'), 
	(5, 'OTHER');
    
-- Add data to the rating values
INSERT INTO `unipsdb`.`rating_value` 
	(`rating_value_id`, `value`) 
VALUES
	(0, 'BAD'), 
	(1, 'REGULAR'), 
	(2, 'AVERAGE'), 
	(3, 'GOOD'), 
	(4, 'EXCELLENT');
  
  
-- Add data to the comment flag
INSERT INTO `unipsdb`.`comment_flag` 
	(`comment_flag_id`, `flag`) 
VALUES
	(0, 'OK'), 
	(1, 'FLAG');
    

-- Add data for address
INSERT INTO `unipsdb`.`address`
	(`line1`, `line2`, `city`, `state`, `zip`)
VALUES
	('11200 SW 8th St', '', 'Miami', 'FL', 33199), 
	('11000 SW 8th St', 'GC', 'Miami', 'FL', 33174), 
	('11200 SW 8th St', 'Student Health Center (SHC)', 'Mami', 'FL', 33199), 
	('11200 SW 8th St', 'PG 6 -100', 'Miami', 'FL', 33199), 
	('11200 SW 8th St', 'GL', 'Miami', 'FL', 33199), 
	('11200 SW 8th St', 'PG 6 -160', 'Miami', 'FL', 33199);

    

-- Add data for the usernames
-- for users
INSERT INTO `unipsdb`.`user`
	(`username`, `password`, `email`, `question1`, `question2`, `description`, `status_id`, `role_id`) 
VALUES
	('kathy',  '21a4ed0a0cf607e77e93bf7604e2bb1ad07757c5', 'kathy@kathy.com', 'kathy answer 1', 'kathy answer 2', 'I am kathy', 1, 0), 
	('sam',  '904752ad9c4ae4186c4b4897321c517de0618702', 'sam@sam.com', 'sam answer 1', 'sam answer 2', 'I am sam', 1, 1),
    ('sarah',  '904752ad9c4ae4186c4b4897321c517de0618702', 'sarah@sarah.com', 'sarah answer 1', 'sarah answer 2', 'I am sara', 1, 1);
    
-- and data for business
INSERT INTO `unipsdb`.`user`
	(`username`, `password`, `name`, `phone`, `phone_business`, `email`, `question1`, `question2`, `description`, `hours`, `address_id`, `status_id`, `role_id`, `business_category_id`)
VALUES
	('chillis', '5b3a02c900752a8a70f157ce633d37561d6a89cb', 'Chillis', 3053482668, 3053482668, 'chillis@chillis.com', 'chillis answer 1', 'chillis answer 2', 'I am Chillis', '11AM - 10PM', 1, 1, 2, 0), 
	('barnes', 'd57410b6ec1a6a1fd8250a563433c29b3896bdca', 'Barnes & Noble', 3053482691, 3053482691, 'barnes@barnes.com', 'barners answer 1', 'barners answer 2', 'I am Barnes  & Nobel', '8:30AM - 8PM', 2, 1, 2, 1), 
	('health', '4a47d9047c7e15cbfd3e189ca28c9db6cdbaf764', 'FIU Student Health', 3053482401, 3053482401, 'health@health.com', 'health answer 1', 'health answer 2', 'I am Health', 'until - 8:00 PM', 3, 1, 2, 2), 
	('advisor', '76af7efae0d034d1e3335ed1b90f24b6cadf2bf1', 'ECS Advisor Department', 3053487936, 3053487936, 'advisor@advisor.com', 'advisor answer 1', 'advisor answer 2', 'I am Advisor', 'Depends', 4, 1, 2, 3), 
	('starbucks', '904752ad9c4ae4186c4b4897321c517de0618702', 'StarBucks', 3053483072, 3053483072, 'starbucks@starbucks.com', 'starbucks answer 1', 'starbucks answer 2', 'I am Starbucks', '7AM–11PM', 5, 1, 2, 4), 
	('optics', '051823e651318e9768c181fd156c93d7d841bec7', 'College Optical', 3053488439, 3053488439, 'optics@optics.com', 'optics answer 1', 'optics answer 2', 'I am Optics', '9AM–5PM', 6, 1, 2, 5);

    

-- Add data to the user pictures
TRUNCATE `unipsdb`.`picture`;
INSERT INTO `unipsdb`.`picture` 
	(`picture`, `user_id`) 
VALUES
	('F:\pics\users\kathy001.png', 1),
	('F:\pics\users\kathy002.png', 1),
	('F:\pics\users\sam.jpeg', 2),
    ('F:\pics\users\chillis001.png', 4), 
    ('F:\pics\users\barnes001.png', 5),
    ('F:\pics\users\health001.png', 6),
    ('F:\pics\users\advisor001.png', 7),
    ('F:\pics\users\advisor002.png', 7);
    
-- Added by the users to a busniess
INSERT INTO `unipsdb`.`picture` 
	(`picture`, `user_id`, `user_id_referenced`)
VALUES
	('F:\pics\business\starbucks001.png', 8, 1), 
    ('F:\pics\business\mystarbucks.png', 8, 2),
    ('F:\pics\business\optics.png', 9, 2);
    


-- Add data for comments
INSERT INTO `unipsdb`.`comment`
	(`subject`, `body`, `comment_flag_id`,`user_id`,`business_id`)
VALUES
	('Great service', 'The service I received was great.', 0, 1, 5),
    ('Too priecy', 'The service was great but the prices are too high', 0, 2, 8),
    ('I hated it', 'People there are just fucking assholes', 1, 3, 9);


-- Add data to the comments
INSERT INTO `unipsdb`.`rating`
	(`rating_value_id`, `user_id`, `business_id`)
VALUES
	(0, 3, 9),
    (4, 1, 8);

