create database bank;
use bank;
create table Customer (
	customer_number int auto_increment primary key,
    fullname nvarchar(50) not null,
    address nvarchar(100),
    email varchar(255) unique,
    phone int(10) unique
);

create table Account (
	account_number int auto_increment primary key,
    date_create date,
    balance bigint,
    customer_number int,
	foreign key (customer_number) references customer(customer_number)
);

create table Transaction (
	tran_number int auto_increment primary key,
    account_number int,
    date_transac date,
    amount bigint,
    descriptions nvarchar(255),
    foreign key (account_number) references account(account_number)
);


    
