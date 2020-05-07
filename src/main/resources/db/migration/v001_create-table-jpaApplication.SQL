create table if not exists jdbcSQL.user(
id int primary key not null auto_increment ,
name varchar(50),
email varchar(50),
phone varchar(50),
password varchar(50)
);