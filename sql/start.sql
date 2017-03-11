-- Drop the old database
DROP DATABASE IF EXISTS `unipsdb`;

-- Create the database
CREATE DATABASE IF NOT EXISTS `unipsdb`;


-- Crate the table for the users
CREATE TABLE IF NOT EXISTS `unipsdb`.`users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `status_id` tinyint(1) NOT NULL,
  `authority_id` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- Create a table for the authorities type 
CREATE TABLE IF NOT EXISTS `unipsdb`.`authorities` (
  `id` tinyint(1) NOT NULL,
  `authority` varchar(15) NOT NULL,
  primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Create table for the user status
CREATE TABLE IF NOT EXISTS `unipsdb`.`status` (
  `id` tinyint(1) NOT NULL,
  `status` varchar(15) NOT NULL,
  primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Add data  to the authorities types
TRUNCATE `unipsdb`.`authorities`;
INSERT INTO `unipsdb`.`authorities` (`id`, `authority`) VALUES
	(0, 'ROLE_ADMIN'),
	(1, 'ROLE_USER'),
    (2, 'ROLE_BUSINESS');
    
-- Add data  to the user status
TRUNCATE `unipsdb`.`status`;
INSERT INTO `unipsdb`.`status` (`id`, `status`) VALUES
	(0, 'ACTIVE'),
	(1, 'DISABLED'),
    (2, 'SUSPENDED'),
    (3, 'BANNED');

-- Add data for the usernames
TRUNCATE `unipsdb`.`users`;
INSERT INTO `unipsdb`.`users` (`username`, `password`, `status_id`, `authority_id`) VALUES
	('kathy', '21a4ed0a0cf607e77e93bf7604e2bb1ad07757c5', 1, 0),
	('sam', '904752ad9c4ae4186c4b4897321c517de0618702', 1, 1),
    ('starbucks', '904752ad9c4ae4186c4b4897321c517de0618702', 1, 2);