<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mogromir
  Date: 06.12.2021
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
</head>
<body>
<br>
<form action="companyControl.jsp" method="get">
    <input type="submit" value="Home">
</form>
<br>
<form action="employeeControl" method="get">
    <input type="submit" value="Back">
</form>
    <jsp:useBean id="employeeBean" scope="request" type="com.example.trackfinishtz.beans.EmployeeBean"/>
    <table>
        <thead>
        <tr>
            <th>First name</th>
            <th>Last name</th>
            <th>Department</th>
            <th>Position</th>
            <th>Salary</th>
            <th>Start work at</th>
            <th>Work from home</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${employeeBean.employees}" var="e">
                <tr>
                    <td>${e.firstName}</td>
                    <td>${e.lastName}</td>
                    <td>${e.department.departmentName}</td>
                    <td>${e.position.positionName}</td>
                    <td>${e.salary}</td>
                    <td>${e.preference.startWorkTime}</td>
                    <td>${e.preference.workFromHome}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
