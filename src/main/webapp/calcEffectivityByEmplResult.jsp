<%--
  Created by IntelliJ IDEA.
  User: Mogromir
  Date: 13.12.2021
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Effectivity by Employee</title>
</head>
<body>
    <h1>Employee current profit = ${calcByEmpl}</h1>
    <br>
    <form action="companyControl.jsp" method="get">
        <input type="submit" value="Home">
    </form>
    <form action="effectivityControl" method="get">
        <input type="submit" value="Back">
    </form>
</body>
</html>
