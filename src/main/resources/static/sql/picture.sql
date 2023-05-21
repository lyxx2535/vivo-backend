use vivo;
create table picture(
    `picture_id` INT PRIMARY KEY AUTO_INCREMENT ,
    `review_id` INT NOT NULL ,
    `picture_url` VARCHAR(100) NOT NULL
);