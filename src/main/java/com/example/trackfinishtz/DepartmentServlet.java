package com.example.trackfinishtz;

import com.example.trackfinishtz.beans.DepartmentBean;
import com.example.trackfinishtz.dao.DepartmentDAO;
import com.example.trackfinishtz.data.Department;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "departmentServlet", value = {"/department-servlet", "/createDepartment", "/deleteDepartment", "/updateDepartment", "/showAllDepartment"})
public class DepartmentServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        showAllDepartment(request, response);
    }

    private void showAllDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentDAO departmentDAO = new DepartmentDAO();
        List<Department> departments = departmentDAO.findAllDepartment();
        request.setAttribute("departmentBean", new DepartmentBean(departments));
        request.getRequestDispatcher("/showAllDepartmentResult.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        if (requestURI.contains("/createDepartment")){
            createDepartment(request, response);
        } else if (requestURI.contains("/deleteDepartment")){
            deleteDepartment(request, response);
        } else if (requestURI.contains("/updateDepartment")){
            updateDepartment(request, response);
        }
    }

    private void createDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String departmentName = request.getParameter("departmentName");
        int startWorkTime = Integer.parseInt(request.getParameter("selectStartTime"));
        String synchroDepartmentChoice = request.getParameter("selectSynchroDepartment");
        boolean synchroDepartment = synchroDepartmentChoice.equals("Yes")?true : false;
        String canWorkHomeChoice = request.getParameter("selectWorkTimePermission");
        boolean canWorkHome = canWorkHomeChoice.equals("Yes")?true : false;
        DepartmentDAO departmentDAO = new DepartmentDAO();
        String answer = departmentDAO.addDepartment(departmentName, startWorkTime, synchroDepartment, canWorkHome);
        request.setAttribute("addDepartment", answer);
        request.getRequestDispatcher("/addDepartmentResult.jsp").forward(request, response);
    }

    private void deleteDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String departmentForDelete = request.getParameter("departmentForDelete");
        DepartmentDAO departmentDAO = new DepartmentDAO();
        String answer = departmentDAO.deleteDepartmentByName(departmentForDelete);
        request.setAttribute("deleteDepartment", answer);
        request.getRequestDispatcher("/deleteDepartmentResult.jsp").forward(request, response);
    }

    private void updateDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String departmentName = request.getParameter("departmentForUpdate");
        int startWorkTime = Integer.parseInt(request.getParameter("updateStartTime"));
        String synchroDepartmentChoice = request.getParameter("updateSynchroDepartment");
        boolean synchroDepartment = synchroDepartmentChoice.equals("Yes")?true : false;
        String canWorkHomeChoice = request.getParameter("updateCanChangeWorkTime");
        boolean canWorkHome = canWorkHomeChoice.equals("Yes")?true : false;
        DepartmentDAO departmentDAO = new DepartmentDAO();
        String answer = departmentDAO.updateDepartment(departmentName, startWorkTime, synchroDepartment, canWorkHome);
        request.setAttribute("updateDepartment", answer);
        request.getRequestDispatcher("/updateDepartmentResult.jsp").forward(request, response);
    }

    public void destroy() {
    }
}
