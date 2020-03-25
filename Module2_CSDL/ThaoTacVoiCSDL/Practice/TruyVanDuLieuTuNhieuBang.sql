use classicmodels;
select customers.customerNumber, customerName, phone, paymentDate, amount,city from customers
inner join payments
on customers.customerNumber = payments.customerNumber
where city = 'Las Vegas';