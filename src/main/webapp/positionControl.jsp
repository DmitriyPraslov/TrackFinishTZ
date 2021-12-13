<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mogromir
  Date: 09.12.2021
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Position</title>
</head>
<body>
    <br>
    <form action="companyControl.jsp" method="get">
        <input type="submit" value="Back">
    </form>
    <br>
    <h1>Create Position</h1>
    <br>
    <form action="createPosition" method="post">
        <label for="positionName">Position</label>
        <input id="positionName" type="text" name="positionName">
        <label for="canChangeWorkTime">Can change start work time?</label>
        <select name="canChangeWorkTime" size="1" id="canChangeWorkTime">
            <option selected value ="Yes">Yes</option>
            <option value="No">No</option>
        </select>
        <input type="submit" value="Create Position">
    </form>

    <br>
    <h1>Delete Position</h1>
    <br>
    <jsp:useBean id="positionBean" scope="request" type="com.example.trackfinishtz.beans.PositionBean"/>
    <form action="deletePosition" method="post">
        <select name="selectPosition" size="1" id="selectPosition">
            <c:forEach items="${positionBean.positions}" var="delPosition">
                <option value= "${delPosition.positionName}">${delPosition.positionName}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Delete Position">
    </form>

    <br>
    <h1>Update Position</h1>
    <br>
    <form action="updatePosition" method="post">
        <select name="updatePosition" size="1" id="updatePosition">
            <c:forEach items="${positionBean.positions}" var="updatePosition">
            <option value= "${updatePosition.positionName}" >${updatePosition.positionName}</option>
            </c:forEach>
        </select>
        <label for="updateCanChangeWorkTime">Can change start work time?</label>
        <select name="updateCanChangeWorkTime" size="1" id="updateCanChangeWorkTime">
            <option selected value ="Yes">Yes</option>
            <option value="No">No</option>
        </select>
        <input type="submit" value="Update Position">
    </form>

    <br>
    <h1>Show All Position</h1>
    <br>
    <form action="showAllPosition" method="get">
        <input type="submit" value="Show All Position">
    </form>
</body>
</html>
