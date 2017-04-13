-- Get all user reviews
SELECT *  FROM `unipsdb`.`comment` AS c
WHERE c.user_id=3;



-- Get all reviews from user to business
SELECT * FROM `unipsdb`.`comment` AS c
WHERE c.user_id=3 AND c.business_id=8;

