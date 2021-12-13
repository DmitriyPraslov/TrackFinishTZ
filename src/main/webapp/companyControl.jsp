<%--
  Created by IntelliJ IDEA.
  User: Mogromir
  Date: 09.12.2021
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Company Start Page</title>
</head>
    <body>
        <h1>Hello in ${companyBean.name}</h1>
        <br>
        <form action="departmentControl" method="get">
            <input type="submit" value="Department Control">
        </form>
        <br>
        <form action="employeeControl" method="get">
            <input type="submit" value="Employee Control">
        </form>
        <br>
        <form action="positionControl" method="get">
            <input type="submit" value="Position Control">
        </form>
        <br>
        <form action="effectivityControl" method="get">
            <input type="submit" value="Effectivity Control">
        </form>
        <br>
        <form action="index.jsp" method="get">
            <input type="submit" value="Change Company Name">
        </form>
    </body>
</html>
