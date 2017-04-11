-- Get a rating
SELECT * FROM `unipsdb`.`rating` AS r
WHERE r.user_id=1 AND r.business_id=8;



-- Add a new comment
INSERT INTO `unipsdb`.`rating`
(`rating_value_id`, `user_id`, `business_id`)
VALUES
(3, 1, 9);


-- Update Rating
UPDATE `unipsdb`.`rating` AS r
SET `rating_value_id` = 2
WHERE r.user_id=1 AND r.business_id=9;

