<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mogromir
  Date: 09.12.2021
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Effectivity</title>
</head>
<body>
<h1>Company current profit = ${result}</h1>
<br>
<form action="companyControl.jsp" method="get">
    <input type="submit" value="Back">
</form>
<br>
    <form action="calculateProfitByDepartment" method="post">
    <select name="department" size="1" id="department">
        <c:forEach items="${departmentBean.departments}" var="selDep">
            <option value= "${selDep.departmentName}" >${selDep.departmentName}</option>
        </c:forEach>
    </select>
        <input type="submit" value="Calculate profit by department">
    </form>
<br>
    <form action="calculateProfitByEmployee" method="post">
        <label for="employeeFullName">Employee Full Name</label>
        <input id="employeeFullName" type="text" name="employeeFullName">
        <input type="submit" value="Calculate profit by employee">
    </form>
</body>
</html>
