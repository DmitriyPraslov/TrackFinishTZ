<%--
  Created by IntelliJ IDEA.
  User: Mogromir
  Date: 10.12.2021
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Department</title>
</head>
<body>
    <h1>${updateDepartment}</h1>
    <br>
    <form action="companyControl.jsp" method="get">
        <input type="submit" value="Home">
    </form>
    <form action="departmentControl" method="get">
        <input type="submit" value="Back">
    </form>
</body>
</html>
