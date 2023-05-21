use vivo;
create table user(
    user_id int auto_increment key,
    username varchar(20) not null,
    password varchar(100) not null
);