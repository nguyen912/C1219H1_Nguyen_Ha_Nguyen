<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 4/16/2020
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Searching Words</title>
</head>
<body>
    <h1>E-V Dictionary</h1>
    <form method="post" action="/result">
        <label>
            <input type="search" name="keyword">
        </label>
        <input type="submit" value="Search">
    </form>
</body>
</html>
