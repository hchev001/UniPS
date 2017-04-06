-- Get flag for a review
SELECT c.comment_flag_id
FROM `unipsdb`.`comment` AS c
WHERE c.comment_id = 4;

-- Update a flag
UPDATE `unipsdb`.`comment` AS c
SET c.comment_flag_id = 1
WHERE c.comment_id = 2;

