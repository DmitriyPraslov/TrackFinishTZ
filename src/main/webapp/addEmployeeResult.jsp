<%--
  Created by IntelliJ IDEA.
  User: Mogromir
  Date: 08.12.2021
  Time: 00:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Employee Result</title>
</head>
<body>
    <h1>${addEmployee}</h1>
    <br>
    <form action="index.jsp" method="get">
        <input type="submit" value="Home">
    </form>
    <form action="employeeControl" method="get">
        <input type="submit" value="Back">
    </form>
</body>
</html>
