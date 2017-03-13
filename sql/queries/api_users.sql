-- Get information about all users. All needed to create an object
(SELECT * 
FROM `unipsdb`.`users` AS u
LEFT JOIN `unipsdb`.`user_pictures` AS p
ON u.user_id = p.user_id)
UNION
(SELECT * 
FROM `unipsdb`.`users` AS u
RIGHT JOIN `unipsdb`.`user_pictures` AS p
ON u.user_id = p.user_id);

-- Get information from one user by username
SELECT * 
FROM `unipsdb`.`users` AS u
LEFT JOIN `unipsdb`.`user_pictures` AS p
ON u.user_id=p.user_id
WHERE u.username='kathy';

-- Insert a new User.
INSERT INTO `unipsdb`.`users` 
(`username`, `password`, `email`,`question1`, `question2`, `status_id`, `authority_id`, `token`)
VALUES (?, ?, ?, ?, ?, ?, ?, ?);


-- Get User by token
SELECT username FROM `unipsdb`.`users` u WHERE u.token=?;

-- Update User status by username
UPDATE `unipsdb`.`users` u 
SET u.status_id=? WHERE u.username=?;

-- Upate User 
UPDATE `unipsdb`.`users` u
SET u.username = ?, 
	u.password = ?,
    u.email = ?,
    u.question1 = ?,
    u.question2 = ?
WHERE u.username = ?;

-- Delete user
DELETE FROM `unipsdb`.`users`
WHERE username = ?