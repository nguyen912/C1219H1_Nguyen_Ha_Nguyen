<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 4/22/2020
  Time: 2:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <h1>E-V Dictionary</h1>
    <form action="/dictionary" method="post">
      <input type="text" name="keyword">
      <input type="submit" value="Search"><br>
      <h3>Result: ${word} ${error}</h3>
    </form>
  </body>
</html>
