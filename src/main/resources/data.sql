CREATE SCHEMA IF NOT EXISTS myapp;

SET search_path TO myapp;

CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START 1;


create table IF NOT EXISTS  myapp.product
(
    product_id varchar(120) not null,
    name  varchar(200) not null,
    catalogy varchar(200) not null,
    seller varchar(250) null,
    price   varchar(250) not null,
    primary key (product_id)
);

create table IF NOT EXISTS myapp.user
(
  user_name VARCHAR(20) not null,
  password  VARCHAR(128) not null,
) ;

create table IF NOT EXISTS  myapp.basket
(
    basket_id varchar(120) not null,
    product_id  varchar(200) not null,
    primary key (basket_id),
    foreign_key (product_id)
);


commit;
