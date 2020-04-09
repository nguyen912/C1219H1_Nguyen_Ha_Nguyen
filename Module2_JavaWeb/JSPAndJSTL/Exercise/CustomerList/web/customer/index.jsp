<%@ page import="java.util.ArrayList" %>
  Created by IntelliJ IDEA.
  User: nguye
  Date: 4/8/2020
  Time: 9:55 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Customer List</title>
  </head>
  <body>
    <div style="text-align: center">
      <table border="1">
        <tr>
          <th>ID</th>
          <th>NAME</th>
          <th>BIRTHDAY</th>
          <th>ADDRESS</th>
        </tr>
        <c:forEach var="customer" items="${customerList}">
          <tr>
            <td><c:out value="${customer.getId()}"></c:out></td>
            <td><c:out value="${customer.getName()}"></c:out></td>
            <td><c:out value="${customer.getBirthday()}"></c:out></td>
            <td><c:out value="${customer.getAddress()}"></c:out></td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </body>
</html>
