<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mogromir
  Date: 05.12.2021
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee</title>
</head>
<body>
<br>
<form action="companyControl.jsp" method="get">
    <input type="submit" value="Back">
</form>
<br>
<h1>Create Employee</h1>
<br>
<jsp:useBean id="departmentBean" scope="request" type="com.example.trackfinishtz.beans.DepartmentBean"/>
<form action="addEmployee" method="post">
    <label for="firstName">First Name</label>
    <input id="firstName" type="text" name="firstName">
    <label for="lastName">Last Name</label>
    <input id="lastName" type="text" name="lastName">
    <label for="department">Department</label>
        <select name="department" size="1" id="department">
            <c:forEach items="${departmentBean.departments}" var="selDep">
                <option value= "${selDep.departmentName}" >${selDep.departmentName}</option>
            </c:forEach>
        </select>
    <jsp:useBean id="positionBean" scope="request" type="com.example.trackfinishtz.beans.PositionBean"/>
    <label for="position">Position</label>
    <select name="position" size="1" id="position">
        <c:forEach items="${positionBean.positions}" var="setPosition">
            <option value= "${setPosition.positionName}" >${setPosition.positionName}</option>
        </c:forEach>
    </select>
    <label for="salary">Salary</label>
    <input id="salary" type="number" name="salary">
    <label for="startWorkTime">Start work at</label>
    <select name="startWorkTime" size="1" id="startWorkTime">
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
    <label for="workFromHome">Work from home</label>
    <select name="workFromHome" size="1" id="workFromHome">
        <option value ="Yes">Yes</option>
        <option selected value="No">No</option>
    </select>
    <input type="submit" value="Add Employee">
</form>
<br>
<h1>Delete Employee</h1>
<br>
<form action="deleteEmployee" method="post">
    <label for="employeeFullName">Employee Full Name</label>
    <input id="employeeFullName" type="text" name="employeeFullName">
    <input type="submit" value="Delete Employee">
</form>
<br>
<h1>Update Employee</h1>
<form action="updateEmployee" method="post">
    <label for="firstNameUpdate">First Name</label>
    <input id="firstNameUpdate" type="text" name="firstNameUpdate">
    <label for="lastNameUpdate">Last Name</label>
    <input id="lastNameUpdate" type="text" name="lastNameUpdate">
    <label for="departmentUpdate">Department</label>
    <select name="departmentUpdate" size="1" id="departmentUpdate">
        <c:forEach items="${departmentBean.departments}" var="selDep">
            <option value= "${selDep.departmentName}" >${selDep.departmentName}</option>
        </c:forEach>
    </select>
    <label for="positionUpdate">Position</label>
    <select name="positionUpdate" size="1" id="positionUpdate">
        <c:forEach items="${positionBean.positions}" var="selPosition">
            <option value= "${selPosition.positionName}" >${selPosition.positionName}</option>
        </c:forEach>
    </select>
    <label for="salaryUpdate">Salary</label>
    <input id="salaryUpdate" type="number" name="salaryUpdate">
    <label for="startWorkTimeUpdate">Start work at</label>
    <select name="startWorkTimeUpdate" size="1" id="startWorkTimeUpdate">
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
    <label for="workFromHomeUpdate">Work from home</label>
    <select name="workFromHomeUpdate" size="1" id="workFromHomeUpdate">
        <option value ="Yes">Yes</option>
        <option selected value="No">No</option>
    </select>
    <input type="submit" value="Update Employee">
</form>
<br>
<h1>Show All Employee</h1>
<br>
<form action="showAllEmployee" method="get">
    <input type="submit" value="Show All Employee">
</form>
</body>
</html>
