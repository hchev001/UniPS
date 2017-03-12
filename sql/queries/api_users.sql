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



SELECT * 
FROM `unipsdb`.`users` AS u
LEFT JOIN `unipsdb`.`user_pictures` AS p
ON u.user_id=p.user_id
WHERE u.username='kathy'

