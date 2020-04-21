<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Spiced with Sandwick</h1>
    <c:forEach items='${requestScope["condiment"]}' var="choise">
        <h2 style="color: red">${choise}</h2>
    </c:forEach>
</body>
</html>
