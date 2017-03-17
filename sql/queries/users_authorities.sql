SELECT u.user_id id, u.username username, u.password password, a.role role
FROM `unipsdb`.`user` AS u
LEFT JOIN `unipsdb`.`role` AS a 
ON a.role_id=u.role_id
WHERE u.status_id=1 AND u.username='kathy';


Select * from unipsdb.business;