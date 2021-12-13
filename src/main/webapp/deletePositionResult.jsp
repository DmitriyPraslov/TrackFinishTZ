<%--
  Created by IntelliJ IDEA.
  User: Mogromir
  Date: 11.12.2021
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Position</title>
</head>
<body>
    <h1>${deletePosition}</h1>
    <br>
    <form action="companyControl.jsp" method="get">
        <input type="submit" value="Home">
    </form>
    <br>
    <form action="positionControl" method="get">
        <input type="submit" value="Back">
    </form>
</body>
</html>
