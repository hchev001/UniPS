-- Get all ratings for business by businessName
SELECT value
FROM `unipsdb`.`rating_value`
WHERE rating_value_id IN (	SELECT rating_value_id
							FROM `unipsdb`.`rating` r
							WHERE r.`business_id` IN (	SELECT user_id
														FROM `unipsdb`.`user` b
														WHERE b.username = 'STARBUCKS'));

-- Get all comments for business by businessName
SELECT c.created_date AS 'Date', c.subject AS 'Subject', c.body AS 'Body', b.username AS 'Business', u.username AS 'Rater'
FROM `unipsdb`.`comment` AS c
LEFT JOIN `unipsdb`.`user` AS u
ON c.user_id = u.user_id
LEFT JOIN `unipsdb`.`user` AS b
ON c.business_id = b.user_id
WHERE b.username = 'optics';


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
							WHERE r.business_id = b.user_id)
WHERE b.username = 'optics';
