use vivo;
drop table if exists card;
create table card(
  `card_id` INT AUTO_INCREMENT PRIMARY KEY ,
  `user_id` INT NOT NULL ,
  `city` VARCHAR(20),
  `create_time` DATE
);