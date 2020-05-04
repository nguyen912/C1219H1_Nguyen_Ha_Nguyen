<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>Product Management</title>
  </head>
  <body>
    <h1 align="center">Product Management Application</h1>
    <h2 align="center">
      <a href="list">Show product list</a>
      <a href="new">Add new product</a>
    </h2>
    <table align="center" border="1">
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Company</th>
        <th>Options</th>
      </tr>
      <c:forEach var="product" items="${products}">
        <tr>
          <td>${product.getId()}</td>
          <td>${product.getName()}</td>
          <td>${product.getPrice()}</td>
          <td>${product.getDescription()}</td>
          <td>${product.getCompany()}</td>
          <td>
            <a href="">Edit</a>
            <a href="">Delete</a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
