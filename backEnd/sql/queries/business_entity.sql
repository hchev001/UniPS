-- Get information about all businesses. All needed to create an object
SELECT * 
FROM `unipsdb`.`user` AS u
LEFT JOIN `unipsdb`.`address` AS a
ON u.address_id = a.address_id
LEFT JOIN `unipsdb`.`picture` AS p
ON u.user_id = p.user_id
RIGHT JOIN `unipsdb`.`picture` AS p1
ON u.user_id = p1.user_id
LEFT JOIN `unipsdb`.`comment` AS c
ON u.user_id = c.business_id
WHERE u.role_id = 2;


-- Get information from one business by businessName
SELECT * 
FROM `unipsdb`.`user` AS u
LEFT JOIN `unipsdb`.`address` AS a
ON u.address_id = a.address_id
LEFT JOIN `unipsdb`.`picture` AS p
ON u.user_id = p.user_id
RIGHT JOIN `unipsdb`.`picture` AS p1
ON u.user_id = p1.user_id
LEFT JOIN `unipsdb`.`comment` AS c
ON u.user_id = c.business_id
WHERE u.role_id = 2 AND u.username='starbucks';


-- Insert a new business
 INSERT INTO `unipsdb`.`user`
(`username`, `password`, `email`, `name`, `phone`, `phone_business`, `question1`, `question2`, `status_id`, `role_id`, `business_category_id`, `token`)
VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);

-- Get businessName by token
SELECT * FROM `unipsdb`.`user` WHERE token = 'toke' AND role_id = '2';

-- Update business status by businessName
UPDATE `unipsdb`.`user` 
SET status_id = ? 
WHERE username = ? AND role_id = '2';

-- Update business by businessName
UPDATE `unipsdb`.`user` u 
SET u.username = ?, u.password = ?, u.name = ?, u.phone = ?, u.phone_business = ?, 
	u.email = ?, u.question1 = ?, u.question2 = ?, u.description = ?, u.hours = ?, 
    u.business_category_id = ?
WHERE u.username = ?;

-- Delete business by businessName
DELETE FROM `unipsdb`.`user`
WHERE username = ?;