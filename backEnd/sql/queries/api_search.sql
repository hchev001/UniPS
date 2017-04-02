SELECT * 
FROM `unipsdb`.`user` AS u 
where u.role_id = 2
AND u.name like '%'
AND u.business_category_id like '%';


