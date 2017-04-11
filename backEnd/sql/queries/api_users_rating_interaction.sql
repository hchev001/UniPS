-- Get a rating
SELECT * FROM `unipsdb`.`rating` AS r
WHERE r.user_id=1 AND r.business_id=8


SELECT `rating`.`rating_id`,
    `rating`.`created_date`,
    `rating`.`rating_value_id`,
    `rating`.`user_id`,
    `rating`.`business_id`
FROM `unipsdb`.`rating`;


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

