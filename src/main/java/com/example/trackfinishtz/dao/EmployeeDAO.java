package com.example.trackfinishtz.dao;

import com.example.trackfinishtz.data.Department;
import com.example.trackfinishtz.data.Employee;
import com.example.trackfinishtz.data.Position;
import com.example.trackfinishtz.db.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDAO {

    public List<Employee> findAllEmployee(){
        Connection connection = ConnectionManager.getInstance().getConnection();

        List<Employee> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from \"Employee\"");
            while (rs.next()){
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String departmentNameFromBD = rs.getString("departmentName");
                String positionNameFromBD = rs.getString("positionName");
                int salary = rs.getInt("salary");
                int startWorkTime = rs.getInt("startWorkTime");
                boolean workFromHome = rs.getBoolean("workFromHome");
                List<Department> departmentsFromBD = new DepartmentDAO().findAllDepartment().stream().filter(d->d.getDepartmentName().equals(departmentNameFromBD))
                        .collect(Collectors.toList());
                List<Position> positionsFromBD = new PositionDAO().findAllPosition().stream().filter(p->p.getPositionName().equals(positionNameFromBD))
                        .collect(Collectors.toList());

                Employee employee = new Employee(firstName,lastName, departmentsFromBD.get(0), positionsFromBD.get(0),
                        salary, startWorkTime, workFromHome);
                result.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return result;
    }

    public String deleteByFullName(String fullName){
        StringBuilder resultMessage = new StringBuilder("");
        String reason = "";
        int rowCount = 0;
        Connection connection = ConnectionManager.getInstance().getConnection();
        try {
             PreparedStatement ps = connection.prepareStatement("DELETE from \"Employee\" as E\n" +
                     "WHERE CONCAT(E.\"firstName\", ' ', E.\"lastName\") LIKE (?)");
            ps.setString(1, fullName);
            rowCount = ps.executeUpdate();
        } catch (SQLException e) {
            reason = " " + e;
        }
        if (rowCount>0){
            resultMessage.append(fullName).append(" successfully fired");
        } else {
            resultMessage.append(fullName).append(" not found ").append(reason);
        }
        return resultMessage.toString();
    }

    public String addEmployee(String firstName, String lastName, String departmentName, String positionName, int salary, int startWorkTime, boolean workFromHome) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        StringBuilder resultMessage = new StringBuilder("");
        String reason = "";
        int rowCount = 0;
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO \"Employee\" " +
                    "(\"firstName\", \"lastName\", \"departmentName\", \"positionName\", \"salary\", \"startWorkTime\", \"workFromHome\")" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, departmentName);
            ps.setString(4, positionName);
            ps.setInt(5, salary);
            ps.setInt(6, startWorkTime);
            ps.setBoolean(7, workFromHome);
            rowCount = ps.executeUpdate();
        } catch (SQLException e) {
            reason = " " + e;
        }
        if (rowCount>0){
            resultMessage.append(firstName + " " + lastName).append(" was added");
        } else {
            resultMessage.append(firstName + " " + lastName).append(" wasn't add ").append(reason);
        }
        return resultMessage.toString();
    }

    public String updateEmployee(String firstName, String lastName, String departmentName, String positionName, int salary, int startWorkTime, boolean workFromHome) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        StringBuilder resultMessage = new StringBuilder("");
        String reason = "";
        int rowCount = 0;
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE \"Employee\" " +
                    "SET \"firstName\" = ?, \"lastName\" = ?, \"departmentName\" = ?, \"positionName\" = ?, \"salary\" = ?, \"startWorkTime\" = ?, \"workFromHome\" = ?" +
                    "WHERE CONCAT(\"firstName\", ' ', \"lastName\") LIKE ?");
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, departmentName);
            ps.setString(4, positionName);
            ps.setInt(5, salary);
            ps.setInt(6, startWorkTime);
            ps.setBoolean(7, workFromHome);
            ps.setString(8, firstName + " " + lastName);
            rowCount = ps.executeUpdate();
        } catch (SQLException e) {
            reason = " " + e;
        }
        if (rowCount>0){
            resultMessage.append(firstName + " " + lastName).append(" was updated");
        } else {
            resultMessage.append(firstName + " " + lastName).append(" wasn't update ").append(reason);
        }
        return resultMessage.toString();
    }
}
