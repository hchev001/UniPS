(SELECT * 
FROM `unipsdb`.`users` AS u
LEFT JOIN `unipsdb`.`user_pictures` AS p
ON u.id = p.user_id)
UNION
(SELECT * 
FROM `unipsdb`.`users` AS u
RIGHT JOIN `unipsdb`.`user_pictures` AS p
ON u.id = p.user_id);