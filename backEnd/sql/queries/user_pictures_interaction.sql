-- Get all pictures
SELECT * FROM `unipsdb`.`picture`;

-- Get all pictures from user by userName
SELECT picture AS Pictures
FROM `unipsdb`.`picture`
WHERE user_id_referenced IN (SELECT user_id_referenced FROM `unipsdb`.`user` WHERE username = 'kathy');

-- Add picture to user by userID
INSERT INTO `unipsdb`.`picture`
	(`picture`, `user_id`,`user_id_referenced`)
VALUE
	('picture.png', '1','1');
	
-- Get the featured picture of user by userName
SELECT picture_featured
FROM `unipsdb`.`user` 
WHERE username = 'kathy';	
	
-- Modify the featured picture of user by userName
UPDATE `unipsdb`.`user` 
SET picture_featured = 'yeboy.png'
WHERE username = 'kathy';

-- DELETE the featured picture of user by userName
UPDATE `unipsdb`.`user` 
SET picture_featured = NULL
WHERE username = 'kathy';	
	
-- Get picture from user by userName and picture_id
SELECT picture AS Pictures
FROM `unipsdb`.`picture`
WHERE picture_id = '2' AND user_id IN (SELECT user_id FROM `unipsdb`.`user` WHERE username = 'kathy');

-- Modify picture user by userName and picture_id
UPDATE `unipsdb`.`picture`
SET picture = '?'
WHERE user_id = '?' AND picture_id = '?';

-- Deletec picture user by userName and picture_id
UPDATE `unipsdb`.`picture`
SET picture = NULL
WHERE user_id = '?' AND picture_id = '?';
	
-- Get all pictures uploaded by user for business 
-- where user_id = businessName and user_id_referenced = userName
SELECT picture AS Pictures
FROM `unipsdb`.`picture`
WHERE user_id_referenced IN (SELECT user_id FROM `unipsdb`.`user` WHERE username = '?')
AND user_id IN (SELECT user_id FROM `unipsdb`.`user` WHERE username = '?');

-- Add picture to business by userName (user_id = businessName and user_id_referenced = userUploading)
INSERT INTO `unipsdb`.`picture` 
	(`picture`, `user_id`, `user_id_referenced`)
VALUE
	('?', '1', '1');
	
-- Get picture uploaded by user for business given picutre_id
-- where user_id = businessName and user_id_referenced = userName
SELECT picture AS Pictures
FROM `unipsdb`.`picture`
WHERE picture_id = '9'
AND user_id_referenced IN (SELECT user_id FROM `unipsdb`.`user` WHERE username = 'kathy')
AND user_id IN (SELECT user_id FROM `unipsdb`.`user` WHERE username = 'starbucks');	
	
-- Modify picture (uploaded by user for business) given picture_id
UPDATE `unipsdb`.`picture`
SET picture = '?'
WHERE picture_id = '?';	
	
-- Delete picture (uploaded by user for business) given picture_id
UPDATE `unipsdb`.`picture`
SET picture = NULL
WHERE picture_id = '?';