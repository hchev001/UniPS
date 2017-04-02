SELECT * 
FROM `unipsdb`.`user` AS u 
LEFT JOIN (
	SELECT rt.business_id, AVG(rt.rating_value_id) AS rating_average 
    FROM `unipsdb`.`rating` AS rt 
    GROUP BY rt.business_id
    ) AS r ON u.user_id = r.business_id
WHERE u.role_id = 2
AND u.name like '%'
AND u.business_category_id like '%'
AND IFNULL(r.rating_average, 0) >= 0;
