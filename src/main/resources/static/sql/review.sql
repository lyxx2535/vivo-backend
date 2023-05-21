use vivo;
create table review(
    `review_id` INT PRIMARY KEY AUTO_INCREMENT ,
    `user_id` INT NOT NULL ,
    `card_id` INT NOT NULL ,
    `title` VARCHAR(40),
    `type` VARCHAR(20),
    `real_time` DATE,
    `review_content` VARCHAR(200) NOT NULL
);