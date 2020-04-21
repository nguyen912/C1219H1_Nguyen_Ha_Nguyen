<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 4/22/2020
  Time: 2:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <h1>Currency Converter</h1>
    <form method="post" action="/convert">
      <label>Rate: </label>
      <input type="text" name="rate" value="22000">
      <br>
      <label>USD: </label>
      <input type="text" name="usd">
      <br>
      <input type="submit" value="Convert">
    </form>
  </body>
</html>
