-- Get a rating
SELECT * FROM 
	(SELECT r.*, u.username AS 'user', b.username AS 'business' 
	FROM `unipsdb`.`rating` AS r
	LEFT JOIN `unipsdb`.`user` AS u ON u.user_id=r.user_id
	LEFT JOIN `unipsdb`.`user` AS b ON b.user_id=r.business_id) AS res
WHERE res.user='kathy' AND res.business='starbucks';


-- Add a new comment
INSERT INTO `unipsdb`.`rating`
(`rating_value_id`, `user_id`, `business_id`)
VALUES
(1, 
(SELECT u.user_id FROM `unipsdb`.`user` AS u WHERE u.username='kathy'), 
(SELECT b.user_id FROM `unipsdb`.`user` AS b WHERE b.username='starbucks'));


-- Update Rating
UPDATE `unipsdb`.`rating` AS r
SET r.rating_value_id = 0
WHERE r.user_id = (SELECT u.user_id FROM `unipsdb`.`user` AS u WHERE u.username='kathy') 
AND r.business_id = (SELECT u.user_id FROM `unipsdb`.`user` AS u WHERE u.username='starbucks')

