<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mogromir
  Date: 05.12.2021
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Department</title>
</head>
<body>
<br>
<form action="companyControl.jsp" method="get">
    <input type="submit" value="Back">
</form>
<br>
    <h1>Create Department</h1>
<br>
<form action="createDepartment" method="post">
    <label for="departmentName">Department Name</label>
    <input id="departmentName" type="text" name="departmentName">
    <label for="selectStartTime">Start work time</label>
    <select name="selectStartTime" size="1" id="selectStartTime">
        <option value="0">0</option>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option selected value="9">9</option>
        <option value="10">10</option>
        <option value="11">11</option>
        <option value="12">12</option>
        <option value="13">13</option>
        <option value="14">14</option>
        <option value="15">15</option>
    </select>
    <label for="setSynchroDepartment">All workers work synchro?</label>
    <select name="selectSynchroDepartment" size="1" id="setSynchroDepartment">
        <option value ="Yes">Yes</option>
        <option selected value="No">No</option>
    </select>
    <label for="canChangeWorkTime">Can change start work time?</label>
    <select name="selectWorkTimePermission" size="1" id="canChangeWorkTime">
        <option selected value ="Yes">Yes</option>
        <option value="No">No</option>
    </select>
    <input type="submit" value="Create Department">
</form>
<br>
    <h1>Delete Department</h1>
<br>
    <jsp:useBean id="departmentBean" scope="request" type="com.example.trackfinishtz.beans.DepartmentBean"/>
    <form action="deleteDepartment" method="post">
        <select name="departmentForDelete" size="1" id="departmentForDelete">
            <c:forEach items="${departmentBean.departments}" var="delDep">
                <option value= "${delDep.departmentName}" >${delDep.departmentName}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Delete Department">
    </form>
<br>
    <h1>Update Department</h1>
<br>
    <form action="updateDepartment" method="post">
    <select name="departmentForUpdate" size="1" id="departmentForUpdate">
    <c:forEach items="${departmentBean.departments}" var="upDep">
        <option value= "${upDep.departmentName}" >${upDep.departmentName}</option>
    </c:forEach>
    </select>
    <label for="updateStartTime">Start work time</label>
    <select name="updateStartTime" size="1" id="updateStartTime">
        <option value="0">0</option>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option selected value="9">9</option>
        <option value="10">10</option>
        <option value="11">11</option>
        <option value="12">12</option>
        <option value="13">13</option>
        <option value="14">14</option>
        <option value="15">15</option>
    </select>
    <label for="updateSynchroDepartment">All workers work synchro?</label>
    <select name="updateSynchroDepartment" size="1" id="updateSynchroDepartment">
        <option value ="Yes">Yes</option>
        <option selected value="No">No</option>
    </select>
    <label for="updateCanChangeWorkTime">Can change start work time?</label>
    <select name="updateCanChangeWorkTime" size="1" id="updateCanChangeWorkTime">
        <option selected value ="Yes">Yes</option>
        <option value="No">No</option>
    </select>
    <input type="submit" value="Update Department">
    </form>
    <br>
    <h1>Show All Department</h1>
    <br>
    <form action="showAllDepartment" method="get">
        <input type="submit" value="Show All Department">
    </form>
</body>
</html>
