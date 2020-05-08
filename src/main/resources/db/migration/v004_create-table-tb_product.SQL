create table if not exists jdbcSQL.tb_product(
id int primary key not null auto_increment,
name varchar(50),
description varchar(255),
price double,
img_url varchar(255)
);