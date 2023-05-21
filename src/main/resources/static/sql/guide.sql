use vivo;
create table guide(
    `guide_id` INT PRIMARY KEY AUTO_INCREMENT ,
    `user_id` INT NOT NULL ,
    `card_id` INT NOT NULL ,
    `type` VARCHAR(20),
    `plan_time` DATE,
    `guide_content` VARCHAR(200) NOT NULL
);
