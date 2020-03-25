use classicmodels;

-- Lọc ra thông tin các khách hàng có country là USA
select * from customers
where country = 'USA';

-- Lọc ra thông tin các khách hàng có country không phải là USA
select * from customers
where country <> 'USA';

-- Lọc ra thông tin các khách hàng có creadit limit lớn hơn 100000
select * from customers
where creditLimit > 100000;

-- Lọc ra thông tin các khách hàng có creadit limit nhỏ hơn 30000
select * from customers
where creditLimit < 30000;

-- Lọc ra thông tin các khách hàng có creadit limit ít nhất là 50000
select * from customers
where creditLimit >= 50000;

-- Lọc ra thông tin các khách hàng có creadit limit nhiều nhất là 50000
select * from customers
where creditLimit <= 50000;

-- Lọc ra thông tin các khách hàng có creadit limit nằm trong khoảng 50000 tới 100000
select * from customers
where creditLimit between 50000 and 100000;

-- Lọc ra thông tin các khách hàng mà trong tên có hai chữ cái 'l' liên tiếp nhau
select * from customers
where customerName like '%ll%';

-- Lọc ra thông tin các khách hàng ở hai quốc gia là Japan và Germany
select * from customers
where country in ('Japan', 'Germany');

-- Lọc ra thông tin các khách hàng ở Singapore và ở Mỹ với salesRepEmployeeNumber là 1323
select * from customers
where country = 'Singapore' or (country = 'USA' and salesRepEmployeeNumber = 1323);

-- Lọc ra thông tin các khách hàng ở USA trừ NYC
select * from customers
where country = 'USA' and not city = 'NYC'
order by customerName;

-- Truy vấn đến customerNumber, customerName, country, state, orderNumber, orderDate, shippedDate 
-- từ hai bảng customers và orders của khách hàng ở bang CA ở USD
select customers.customerNumber, customerName, country, state, orderNumber, orderDate, shippedDate from customers
inner join orders
on customers.customerNumber = orders.customerNumber
where state = 'CA'
order by customerName desc;

/* Truy vấn đến customerNumber, customerName, country, state, orderNumber, orderDate, shippedDate 
từ hai bảng customers và orders của khách hàng ở bang CA ở USD (lấy tất cả ở bảng customers, 
còn trong bảng orders chỉ lấy các dòng có customerNumber trùng với customerNumber trong bảng customers */
select customers.customerNumber, customerName, country, state, orderNumber, orderDate, shippedDate from customers
left join orders
on customers.customerNumber = orders.customerNumber
where state = 'CA';

/* Truy vấn đến customerNumber, customerName, country, state, orderNumber, orderDate, shippedDate 
từ hai bảng customers và orders của khách hàng ở bang CA ở USD (lấy tất cả ở bảng orders, 
còn trong bảng customers chỉ lấy các dòng có customerNumber trùng với customerNumber trong bảng orders */
select customers.customerNumber, customerName, country, state, orderNumber, orderDate, shippedDate from customers
right join orders
on customers.customerNumber = orders.customerNumber
where state = 'CA';

-- Lọc ra thông tin các khách hàng ở USA
select city, count(city) from customers
group by city
having count(city) >= 3
order by customerName;



