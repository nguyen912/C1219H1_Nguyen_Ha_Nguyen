<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 4/16/2020
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Product Detail</title>
</head>
<body>
    <form action="/display-discount" method="post">
        <label>Product Description: </label>
        <input type="text" name="description">
        <label>List Price: </label>
        <input type="text" name="price">
        <label>Discount Percent: </label>
        <input type="text" name="discount_percent">
        <input type="submit" value="Calculate Discount">
    </form>
</body>
</html>
