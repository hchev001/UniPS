SELECT u.id id, u.username username, u.password password, a.authority authority
FROM `unipsdb`.`users` AS u
LEFT JOIN `unipsdb`.`authorities` AS a 
ON a.authority_id=u.authority_id
WHERE u.status_id=1 AND u.username='kathy';
