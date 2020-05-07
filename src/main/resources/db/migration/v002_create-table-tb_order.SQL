create table if not exists jdbcSQL.tb_order(
id int primary key not null auto_increment ,
moment date,
order_status int,
client_id int
);