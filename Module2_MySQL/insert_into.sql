select * from classicmodels.customers;
update classicmodels.customers set addressLine2 = 'Level 2'
where customerNumber = '112';
insert into classicmodels.customers(customerNumber,customerName,contactLastName,contactFirstName,
phone,addressLine1,city,country)
values (101,'Nguyen Nguyen','Nguyen','Nguyen','0902034385','435 THK','DN','VN');