<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 4/21/2020
  Time: 9:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <form action="calculate" method="post">
      <label>First Operand:</label>
      <input type="text" name="first_operand"><br>
      <label>Operator:</label>
      <select name="operator">
        <option value="plus">plus</option>
        <option value="minus">minus</option>
        <option value="multiply">multiply</option>
        <option value="divide">divide</option>
      </select><br>
      <label>Second Operand:</label>
      <input type="text" name="second_operand"><br>
      <input type="submit" value="Calculate">
    </form>
  </body>
</html>
