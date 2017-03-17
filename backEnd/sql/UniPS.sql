DROP DATABASE IF EXISTS unipsdba;

CREATE DATABASE IF NOT EXISTS unipsdba;


CREATE TABLE user(
first_name VARCHAR (30) NOT NULL,
last_name VARCHAR (30) NOT NULL,
password VARCHAR (20) NOT NULL,
email VARCHAR (60) NOT NULL,
phone VARCHAR (20) NULL,
question1 VARCHAR (100) NOT NULL,
question2 VARCHAR (100) NOT NULL,
user_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE admin(
user_id INT UNSIGNED NOT NULL PRIMARY KEY
);


CREATE TABLE business(
business_name VARCHAR (50) NOT NULL,
business_phone VARCHAR (20) NOT NULL,
category ENUM("Restaurants", "Shoping", "Health", "Education", "Coffee") NOT NULL,
business_description VARCHAR (140) NULL,
user_id INT UNSIGNED NOT NULL PRIMARY KEY
);

CREATE TABLE address(
street VARCHAR (50) NOT NULL,
apartment VARCHAR (10) NULL,
city VARCHAR (40) NOT NULL,
state CHAR(2) NOT NULL,
zip MEDIUMINT UNSIGNED NOT NULL,
user_id INT UNSIGNED NOT NULL PRIMARY KEY
);
CREATE TABLE rating(
rater_id INT UNSIGNED NOT NULL,
rated_id INT UNSIGNED NOT NULL,
rating INT NOT NULL CHECK(rating >= 0 AND rating <= 5),
comment VARCHAR (200) NULL,
flag BOOLEAN NOT NULL DEFAULT FALSE,
PRIMARY KEY(rater_id, rated_id)
);

CREATE TABLE image(
image_name VARCHAR (30) NOT NULL,
image_description VARCHAR(60) NULL,
image VARBINARY(MAX) NOT NULL,
image_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE message(
subject VARCHAR (50) NOT NULL,
content VARCHAR (200) NOT NULL,
sender_id INT UNSIGNED NOT NULL,
receiver_id INT UNSIGNED NOT NULL,
PRIMARY KEY(sender_id, receiver_id)
);

CREATE TABLE hours(
open TIME NOT NULL,
close TIME NOT NULL,
day_of_week INT NOT NULL CHECK(rating >= 0 AND rating <= 6),
business_id INT UNSIGNED NOT NULL PRIMARY KEY
);

CREATE TABLE accountstatus(
account_state ENUM("Active", "Diabled", "Suspended", "Banned") NOT NULL DEFAULT "Active"
user_id INT UNSIGNED NOT NULL PRIMARY KEY
);