-- Get all Rating from user with userName
SELECT value
FROM `unipsdb`.`rating_value`
WHERE rating_value_id IN (	SELECT rating_value_id
							FROM `unipsdb`.`rating` r
							WHERE r.`user_id` IN (	SELECT user_id
														FROM `unipsdb`.`user` u
														WHERE u.username = 'kathy'));
                                                        
-- Get all comments from user for business by userName
SELECT *
FROM `unipsdb`.`comment` AS c
LEFT JOIN `unipsdb`.`user` AS u
ON c.user_id = u.user_id
LEFT JOIN `unipsdb`.`user` AS b
ON c.business_id = b.user_id
WHERE u.username = 'kathy';

-- Get both Rating and Comment for business by businessName
SELECT c.created_date AS 'Date', v.value AS 'Value', c.subject AS 'Subject', c.body AS 'Body', b.username AS 'Business', u.username AS 'Rater'
FROM `unipsdb`.`comment` AS c
LEFT JOIN `unipsdb`.`user` AS u
ON c.user_id = u.user_id
LEFT JOIN `unipsdb`.`user` AS b
ON c.business_id = b.user_id
LEFT JOIN `unipsdb`.`rating_value` AS v
ON v.rating_value_id IN (	SELECT rating_value_id
							FROM `unipsdb`.`rating` r
							WHERE r.user_id = u.user_id)
WHERE u.username = 'kathy';