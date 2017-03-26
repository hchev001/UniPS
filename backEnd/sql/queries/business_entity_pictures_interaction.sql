-- Get all pictures
SELECT * FROM `unipsdb`.`picture`;

-- Get all pictures from business by businessName
SELECT picture AS Pictures
FROM `unipsdb`.`picture`
WHERE user_id IN (SELECT user_id FROM `unipsdb`.`user` WHERE username = 'starbucks');

-- Add picture to business by businessName
INSERT INTO `unipsdb`.`picture` 
	(`picture`, `user_id`, `user_id_referenced`)
VALUE
	('1', '1', '1');
	
-- Get all pictures uploaded by user of business 
-- by user_id = businessName and user_id_referenced = userName
SELECT picture AS Pictures
FROM `unipsdb`.`picture`
WHERE user_id_referenced = '?' AND user_id IN (SELECT user_id FROM `unipsdb`.`user` b WHERE b.username = '?');

-- Get the featured picture of business by businessName
SELECT picture_featured
FROM `unipsdb`.`user` 
WHERE username = '?';

-- Modify the featured picture of business by businessName
UPDATE `unipsdb`.`user` b
SET picture_featured = '?'
WHERE username = '?';

-- DELETE the featured picture of business by businessName
UPDATE `unipsdb`.`user` 
SET picture_featured = NULL
WHERE username = '?';

-- Get picture from business by businessName and picture_id
SELECT picture AS Pictures
FROM `unipsdb`.`picture`
WHERE picture_id = '?' AND user_id IN (SELECT user_id FROM `unipsdb`.`user` WHERE username = '?');

-- Modify picture from business by businessName and picture_id
UPDATE `unipsdb`.`picture`
SET picture = '?'
WHERE user_id = '?' AND picture_id = '?';

-- Deletec picture from business by businessName and picture_id
UPDATE `unipsdb`.`picture`
SET picture = NULL
WHERE user_id = '?' AND picture_id = '?';