-- Get all admins
SELECT *
FROM `unipsdb`.`user`
WHERE role_id = 0;

-- Get admin by userName
SELECT *
FROM `unipsdb`.`user`
WHERE role_id = 0 AND username= '?';

-- Add a new admin
INSERT INTO `unipsdb`.`user` 
(`username`, `password`, `email`,`question1`, `question2`, `status_id`, `role_id`, `token`)
VALUES (?, ?, ?, ?, ?, ?, 0, ?);

-- Get admin by token
SELECT * FROM `unipsdb`.`user` WHERE token = '?' AND role_id = 0;

-- Upate admin by username
UPDATE `unipsdb`.`user`
SET username = ?, 
	password = ?,
    email = ?,
    question1 = ?,
    question2 = ?,
	status_id = ?,
	role_id = 0,
	token = ?	
WHERE username = ? AND role_id = 0;

-- Delete admin by username
DELETE FROM `unipsdb`.`user`
WHERE username = '?' AND role_id = 0;