-- Create the database
CREATE DATABASE IF NOT EXISTS `unipsdb`;


-- Crate the table for the users
CREATE TABLE `unipsdb`.`users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `authority_id` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_users_id` (`id`),
  UNIQUE KEY `idx_users_username` (`username`),
  CONSTRAINT `fk_users_authorities_id` FOREIGN KEY (`authority_id`) REFERENCES `unipsdb`.`authorities` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- Create a table for the authorities type 
CREATE TABLE IF NOT EXISTS `unipsdb`.`authorities` (
  `id` int(2) NOT NULL,
  `authority` varchar(15) NOT NULL,
  primary key (`id`),
  unique key `idx_authorities_id` (`id`),
  unique key `idx_authorities_authority` (`authority`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- Add data  to the authorities types
INSERT INTO `unipsdb`.`authorities` (`id`, `authority`) VALUES
	(1, 'ROLE_ADMIN'),
	(2, 'ROLE_USER'),
    (3, 'ROLE_BUSINESS');

-- Dumping data for table concretepage.comp_users: ~2 rows (approximately)
INSERT INTO `comp_users` (`username`, `password`, `enabled`) VALUES
	('krishna', '21a4ed0a0cf607e77e93bf7604e2bb1ad07757c5', 1),
	('sudama', '904752ad9c4ae4186c4b4897321c517de0618702', 1);