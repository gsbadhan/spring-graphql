drop database customers_db;
create database customers_db;
use customers_db;

create table `customer`(
`id` integer auto_increment,
`firstname` varchar(20) not null,
`lastname` varchar(20) not null,
`age` integer not null,
primary key (`id`)
);