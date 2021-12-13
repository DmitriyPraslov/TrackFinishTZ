package com.example.trackfinishtz.dao;

import com.example.trackfinishtz.data.Department;
import com.example.trackfinishtz.db.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {

    public List<Department> findAllDepartment(){
        Connection connection = ConnectionManager.getInstance().getConnection();
        List<Department> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from \"Department\"");
            while (rs.next()){
                String departmentName = rs.getString("DepartmentName");
                int startWorkTime = rs.getInt("StartWorkTime");
                boolean synchroWork = rs.getBoolean("SynchroWork");
                boolean changeWorkTimePermission = rs.getBoolean("ChangeWorkTimePermission");
                Department department = new Department(departmentName,startWorkTime,synchroWork,changeWorkTimePermission);
                result.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String addDepartment(String departmentName, int startWorkTime, boolean synchroWork, boolean changeWorkTimePermission) {
        if (departmentName.length()==0){
            return "Enter correct department name";
        }
        Connection connection = ConnectionManager.getInstance().getConnection();
        StringBuilder resultMessage = new StringBuilder("");
        String reason = "";
        int rowCount = 0;
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO \"Department\" " +
                    "(\"DepartmentName\", \"StartWorkTime\", \"SynchroWork\", \"ChangeWorkTimePermission\")" +
                    "VALUES (?, ?, ?, ?)");
            ps.setString(1, departmentName);
            ps.setInt(2, startWorkTime);
            ps.setBoolean(3, synchroWork);
            ps.setBoolean(4, changeWorkTimePermission);
            rowCount = ps.executeUpdate();
        } catch (SQLException e) {
            reason = " " + e;
        }
        if (rowCount>0){
            resultMessage.append(departmentName).append(" was added");
        } else {
            resultMessage.append(departmentName).append(" wasn't add ").append(reason);
        }
        return resultMessage.toString();
    }

    public String deleteDepartmentByName(String departmentName){
        StringBuilder resultMessage = new StringBuilder("");
        String reason = "";
        int rowCount = 0;
        Connection connection = ConnectionManager.getInstance().getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE from \"Department\"\n" +
                    "WHERE \"DepartmentName\" LIKE (?)");
            ps.setString(1, departmentName);
            rowCount = ps.executeUpdate();
        } catch (SQLException e) {
            reason = " " + e;
        }
        if (rowCount>0){
            resultMessage.append(departmentName).append(" was deleted");
        } else {
            resultMessage.append(departmentName).append(" not found ").append(reason);
        }
        return resultMessage.toString();
    }

    public String updateDepartment(String departmentName, int startWorkTime, boolean synchroWork, boolean changeWorkTimePermission) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        StringBuilder resultMessage = new StringBuilder("");
        String reason = "";
        int rowCount = 0;
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE \"Department\" " +
                    "SET \"DepartmentName\" = ?, \"StartWorkTime\" = ?, \"SynchroWork\" = ?, \"ChangeWorkTimePermission\" = ?" +
                    "WHERE \"DepartmentName\" LIKE ?");
            ps.setString(1, departmentName);
            ps.setInt(2, startWorkTime);
            ps.setBoolean(3, synchroWork);
            ps.setBoolean(4, changeWorkTimePermission);
            ps.setString(5, departmentName);
            rowCount = ps.executeUpdate();
        } catch (SQLException e) {
            reason = " " + e;
        }
        if (rowCount>0){
            resultMessage.append(departmentName).append(" was updated");
        } else {
            resultMessage.append(departmentName).append(" wasn't update ").append(reason);
        }
        return resultMessage.toString();
    }
}
