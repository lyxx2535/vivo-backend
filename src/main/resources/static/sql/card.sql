use vivo;
create table card(
  `card_id` INT PRIMARY KEY ,
  `user_id` INT NOT NULL ,
  `city` VARCHAR(20),
  `create_time` DATE
);