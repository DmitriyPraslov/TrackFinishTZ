package com.example.trackfinishtz;

import com.example.trackfinishtz.beans.EmployeeBean;
import com.example.trackfinishtz.dao.EmployeeDAO;
import com.example.trackfinishtz.data.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "employeeServlet", value = {"/employee-servlet", "/addEmployee", "/deleteEmployee", "/updateEmployee", "/showAllEmployee"})
public class EmployeeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Employee> employees = new EmployeeDAO().findAllEmployee();
        request.setAttribute("employeeBean", new EmployeeBean(employees));
        request.getRequestDispatcher("/showAllEmployeeResult.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        if (requestURI.contains("/addEmployee")){
            addEmployee(request, response);
        } else if (requestURI.contains("/updateEmployee")){
            updateEmployee(request, response);
        } else {
            deleteEmployee(request, response);
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String firstName = request.getParameter("firstNameUpdate");
        String lastName = request.getParameter("lastNameUpdate");
        String departmentName = request.getParameter("departmentUpdate");
        String positionName = request.getParameter("positionUpdate");
        int salary = request.getParameter("salaryUpdate").length()==0?0:Integer.parseInt(request.getParameter("salaryUpdate"));
        int startWork = Integer.parseInt(request.getParameter("startWorkTimeUpdate"));
        String workFromHomeChoice = request.getParameter("workFromHomeUpdate");
        boolean workFromHome = workFromHomeChoice.equals("Yes")?true:false;
        EmployeeDAO empDAO = new EmployeeDAO();
        String result = empDAO.updateEmployee(firstName, lastName, departmentName, positionName,salary,startWork,workFromHome);
        request.setAttribute("updateEmployee", result);
        request.getRequestDispatcher("/updateEmployeeResult.jsp").forward(request, response);
    }

    private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String departmentName = request.getParameter("department");
        String positionName = request.getParameter("position");
        int salary = request.getParameter("salary").length()==0?0:Integer.parseInt(request.getParameter("salary"));
        int startWork = Integer.parseInt(request.getParameter("startWorkTime"));
        String workFromHomeChoice = request.getParameter("workFromHome");
        boolean workFromHome = workFromHomeChoice.equals("Yes")?true:false;
        EmployeeDAO empDAO = new EmployeeDAO();
        String result = empDAO.addEmployee(firstName, lastName, departmentName, positionName,salary,startWork,workFromHome);
        request.setAttribute("addEmployee", result);
        request.getRequestDispatcher("/addEmployeeResult.jsp").forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("employeeFullName");
        EmployeeDAO empDAO = new EmployeeDAO();
        String result = empDAO.deleteByFullName(fullName);
        request.setAttribute("deleteEmployee", result);
        request.getRequestDispatcher("/deleteEmployeeResult.jsp").forward(request, response);
    }

    public void destroy() {
    }
}
