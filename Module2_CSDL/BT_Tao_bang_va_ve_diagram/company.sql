create database company;
use company;

create table categories (
	id int(11) auto_increment primary key,
    name varchar(50) not null,
    description varchar(500)
);

create table suppliers (
	id int(11) auto_increment primary key,
    name varchar(100) not null,
    email varchar(50) not null,
    phoneNumber varchar(20),
    address varchar(500)
);
    
create table products (
	id int(11) primary key,
    name varchar(50) not null,
    imageUrl varchar(1000) not null,
    price decimal(18,2),
    discount decimal(18,2),
    catagoryId int(11) references catagories(id),
    suppplierId int(11) references suppliers(id),
    description varchar(1000)
);

drop table products;

create table employees (
	id int(11) auto_increment primary key,
    firstName varchar(50) not null,
    lastName varchar(50) not null,
    phoneNumber varchar(20),
    address varchar(500) not null,
    email varchar(50) not null,
    birthday datetime
);

create table customers (
	id int(11) auto_increment primary key,
    firstName varchar(50) not null,
    lastName varchar(50) not null,
    phoneNumber varchar(20),
    address varchar(500) not null,
    email varchar(50) not null,
    birthday date
);

create table orders (
	id int(11) auto_increment primary key,
    createDate datetime not null,
    shippedDate datetime,
    status varchar(50) not null,
    description varchar(1000),
    shippingAddress varchar(500) not null,
    shippingCity varchar(50) not null,
    paymentType varchar(20) not null,
    customerId int(11) references customers(id),
    employeeId int(11) references employees(id)
);

create table orderdetails (
	id int(11) primary key,
    orderId int(11) references orders(id),
    productId int(11) references products(id),
    quantity decimal(18,2)
);


    
