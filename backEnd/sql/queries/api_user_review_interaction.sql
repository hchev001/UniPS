-- Get all user reviews
SELECT *  FROM `unipsdb`.`comment` AS c
WHERE c.user_id=3;


-- Get all reviews from user to business
SELECT * FROM `unipsdb`.`comment` AS c
WHERE c.user_id=3 AND c.business_id=8;

-- Add a new review
INSERT INTO `unipsdb`.`comment`
(`subject`, `body`, `comment_flag_id`, `user_id`, `business_id`)
VALUES
('My Subject', 'My Body', 0, 1, 9);


-- Get review by Subject, body, User, and Business
SELECT * FROM `unipsdb`.`comment`  AS c
WHERE c.subject=? AND c.body=? AND c.user_id=? AND c.business_id=?;


-- Get review by ID
SELECT * FROM `unipsdb`.`comment`  AS c WHERE c.comment_id=?;


-- Update review by id
UPDATE `unipsdb`.`comment`
SET
`subject` =  'My Subject Updated',
`body` = 'My Body updated'
WHERE `comment_id` = 2;


-- Delete review

