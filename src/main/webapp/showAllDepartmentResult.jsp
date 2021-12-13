<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mogromir
  Date: 10.12.2021
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Department</title>
</head>
<body>
    <br>
    <form action="companyControl.jsp" method="get">
        <input type="submit" value="Home">
    </form>
    <form action="departmentControl" method="get">
        <input type="submit" value="Back">
    </form>
    <br>
    <jsp:useBean id="departmentBean" scope="request" type="com.example.trackfinishtz.beans.DepartmentBean"/>
    <table>
        <thead>
        <tr>
            <th>Department name</th>
            <th>Start work at</th>
            <th>Is synchronized department</th>
            <th>Can change start-time</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${departmentBean.departments}" var="d">
            <tr>
                <td>${d.departmentName}</td>
                <td>${d.startWorkTime}</td>
                <td>${d.synchroWork}</td>
                <td>${d.changeWorkTimePermission}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
