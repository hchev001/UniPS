-- Get information about all businesses. All needed to create an object
(SELECT * 
FROM `unipsdb`.`user` AS u
LEFT JOIN `unipsdb`.`picture` AS p
ON u.user_id = p.user_id
WHERE u.role_id = '2')
UNION
(SELECT * 
FROM `unipsdb`.`user` AS u
RIGHT JOIN `unipsdb`.`picture` AS p
ON u.user_id = p.user_id
WHERE u.role_id = '2');


-- Get all the comments
SELECT *
FROM `unipsdb`.`comment`;


-- Get the address
SELECT *
FROM `unipsdb`.`address`;


-- Get information from one business by businessName
SELECT * 
FROM `unipsdb`.`user` AS U
LEFT JOIN `unipsdb`.`picture` AS p
ON u.user_id=p.user_id
WHERE username = 'chillis' AND u.role_id = '2';

-- Insert a new business
INSERT INTO `unipsdb`.`user`
	(`username`, `password`, `phone`, `phone_business`, `email`, `question1`, `question2`, `picture_featured`, `description`, `hours`, `address_id`, `status_id`, `role_id`, `business_category_id`, `token`)
VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '2', ?, ?);

-- Get businessName by token
SELECT * FROM `unipsdb`.`user` WHERE token = 'toke' AND role_id = '2';

-- Update business status by businessName
UPDATE `unipsdb`.`user` 
SET status_id = ? 
WHERE username = ? AND role_id = '2';

-- Update business by businessName
UPDATE `unipsdb`.`user`
SET username = ?, 
	password = ?,
	phone = ?,
	phone_business = ?,
    email = ?,
    question1 = ?,
    question2 = ?,
	picture_featured = ?,
	description = ?,
	hours = ?,
	address_id = ?,
	status_id = ?,
	role_id = ?,
	business_category_id = ?,
	token = ?
WHERE username = ?;

-- Delete business by businessName
DELETE FROM `unipsdb`.`user`
WHERE username = ?;