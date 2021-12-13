package com.example.trackfinishtz;

import com.example.trackfinishtz.beans.CompanyBean;
import com.example.trackfinishtz.beans.DepartmentBean;
import com.example.trackfinishtz.beans.PositionBean;
import com.example.trackfinishtz.dao.DepartmentDAO;
import com.example.trackfinishtz.dao.EmployeeDAO;
import com.example.trackfinishtz.dao.PositionDAO;
import com.example.trackfinishtz.data.Company;
import com.example.trackfinishtz.data.Department;
import com.example.trackfinishtz.data.Employee;
import com.example.trackfinishtz.data.Position;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "companyServlet", value = {"/company-servlet", "/createCompany", "/departmentControl",
        "/employeeControl", "/positionControl", "/effectivityControl", "/calculateProfitByDepartment", "/calculateProfitByEmployee"})
public class CompanyServlet extends HttpServlet{
    List<Department> departments;
    List<Employee> employees;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String uri = request.getRequestURI();
        if (uri.contains("createCompany")) {
            setCompanyName(request, response);
        } else if (uri.contains("departmentControl")){
            request = loadDepartments(request);
            request.getRequestDispatcher("/departmentControl.jsp").forward(request, response);
        } else if (uri.contains("employeeControl")){
            loadPosition(request);
            request = loadDepartments(request);
            request = loadPosition(request);
            request.getRequestDispatcher("/employeeControl.jsp").forward(request, response);
        } else if (uri.contains("positionControl")){
            request = loadPosition(request);
            request.getRequestDispatcher("/positionControl.jsp").forward(request, response);
        } else if (uri.contains("/effectivityControl")){
            String companyName = request.getParameter("companyName");
            Company company = new Company(companyName);
            departments = new DepartmentDAO().findAllDepartment();
            employees = new EmployeeDAO().findAllEmployee();
            for (Employee employeeTemp : employees){
                for (Department departmentTemp : departments) {
                    if (departmentTemp.getDepartmentName().equals(employeeTemp.getDepartment().getDepartmentName())) {
                        departmentTemp.addEmployee(employeeTemp);
                    }
                }
            }
            company.setDepartments(departments);
            double result = company.getEffectivityWorkTimeByCompany() * 10;
            request.setAttribute("result", result);
            request = loadDepartments(request);
            request.getRequestDispatcher("/effectivityControl.jsp").forward(request, response);
        }
    }

    private HttpServletRequest loadPosition(HttpServletRequest request) {
        PositionDAO positionDAO = new PositionDAO();
        List<Position> positions = positionDAO.findAllPosition();
        request.setAttribute("positionBean", new PositionBean(positions));
        return request;
    }

    private HttpServletRequest loadDepartments(HttpServletRequest request) throws ServletException, IOException {
        DepartmentDAO departmentDAO = new DepartmentDAO();
        List<Department> departments = departmentDAO.findAllDepartment();
        request.setAttribute("departmentBean", new DepartmentBean(departments));
        return request;
    }

    private void setCompanyName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String companyName = request.getParameter("companyName");
        HttpSession session = request.getSession();
        session.setAttribute("companyBean", new CompanyBean(companyName));
        request.getRequestDispatcher("/companyControl.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/calculateProfitByDepartment")) {
            double result = 0;
            String departmentName = request.getParameter("department");
            for (Department departmentTemp : departments) {
                if (departmentTemp.getDepartmentName().equals(departmentName)) {
                    result = departmentTemp.getEffectivityWorkTimeByDepartment() * 10;
                }
            }
            request.setAttribute("calcByDep", result);
            request.getRequestDispatcher("/calcEffectivityByDepResult.jsp").forward(request, response);
        } else {
            double result = 0;
            String employeeFullName = request.getParameter("employeeFullName");
            for (Employee employeeTemp : employees){
                if (employeeTemp.getEmployeeFullName().equals(employeeFullName)){
                    result = employeeTemp.getEffectivityWorkTime() * 10;
                }
            }
            request.setAttribute("calcByEmpl", result);
            request.getRequestDispatcher("/calcEffectivityByEmplResult.jsp").forward(request, response);
        }
    }

    public void destroy() {
    }
}
