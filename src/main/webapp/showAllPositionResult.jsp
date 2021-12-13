<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mogromir
  Date: 11.12.2021
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Position</title>
</head>
<body>
    <br>
    <form action="companyControl.jsp" method="get">
        <input type="submit" value="Home">
    </form>
    <br>
    <form action="positionControl" method="get">
        <input type="submit" value="Back">
    </form>
    <jsp:useBean id="positionBean" scope="request" type="com.example.trackfinishtz.beans.PositionBean"/>
    <table>
        <thead>
        <tr>
            <th>Position Name</th>
            <th>Can Change Work Time</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${positionBean.positions}" var="p">
            <tr>
                <td>${p.positionName}</td>
                <td>${p.changeWorkTimePermission}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
