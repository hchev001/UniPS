-- Drop the old database
DROP DATABASE IF EXISTS `unipsdb`;

-- Create the database
CREATE DATABASE IF NOT EXISTS `unipsdb`;


-- Crate the table for the users
CREATE TABLE `unipsdb`.`users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `authority_id` int(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- Create a table for the authorities type 
CREATE TABLE IF NOT EXISTS `unipsdb`.`authorities` (
  `id` int(2) NOT NULL,
  `authority` varchar(15) NOT NULL,
  primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- Add data  to the authorities types
INSERT INTO `unipsdb`.`authorities` (`id`, `authority`) VALUES
	(1, 'ROLE_ADMIN'),
	(2, 'ROLE_USER'),
    (3, 'ROLE_BUSINESS');

-- Add data for the usernames
INSERT INTO `unipsdb`.`users` (`username`, `password`, `enabled`, `authority_id`) VALUES
	('kathy', '21a4ed0a0cf607e77e93bf7604e2bb1ad07757c5', 1, 1),
	('sam', '904752ad9c4ae4186c4b4897321c517de0618702', 1, 2),
    ('startbucks', '904752ad9c4ae4186c4b4897321c517de0618702', 1, 3);