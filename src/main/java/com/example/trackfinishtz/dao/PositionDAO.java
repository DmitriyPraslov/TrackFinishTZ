package com.example.trackfinishtz.dao;

import com.example.trackfinishtz.data.Position;
import com.example.trackfinishtz.db.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PositionDAO {

    public List<Position> findAllPosition(){
        Connection connection = ConnectionManager.getInstance().getConnection();
        List<Position> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from \"Role\"");
            while (rs.next()){
                String positionName = rs.getString("positionName");
                boolean changeWorkTimePermission = rs.getBoolean("changeWorkTimePermission");
                Position position = new Position(positionName, changeWorkTimePermission);
                result.add(position);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String addPosition(String positionName, boolean changeWorkTimePermission) {
        if (positionName.length()==0){
            return "Enter correct position name";
        }
        Connection connection = ConnectionManager.getInstance().getConnection();
        StringBuilder resultMessage = new StringBuilder("");
        String reason = "";
        int rowCount = 0;
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO \"Role\" " +
                    "(\"positionName\", \"changeWorkTimePermission\")" +
                    "VALUES (?, ?)");
            ps.setString(1, positionName);
            ps.setBoolean(2, changeWorkTimePermission);
            rowCount = ps.executeUpdate();
        } catch (SQLException e) {
            reason = " " + e;
        }
        if (rowCount>0){
            resultMessage.append(positionName).append(" was added");
        } else {
            resultMessage.append(positionName).append(" wasn't add ").append(reason);
        }
        return resultMessage.toString();
    }

    public String deletePositionByName(String positionName){
        StringBuilder resultMessage = new StringBuilder("");
        String reason = "";
        int rowCount = 0;
        Connection connection = ConnectionManager.getInstance().getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE from \"Role\"\n" +
                    "WHERE \"positionName\" LIKE (?)");
            ps.setString(1, positionName);
            rowCount = ps.executeUpdate();
        } catch (SQLException e) {
            reason = " " + e;
        }
        if (rowCount>0){
            resultMessage.append(positionName).append(" was deleted");
        } else {
            resultMessage.append(positionName).append(" not found ").append(reason);
        }
        return resultMessage.toString();
    }

    public String updatePosition(String positionName, boolean changeWorkTimePermission) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        StringBuilder resultMessage = new StringBuilder("");
        String reason = "";
        int rowCount = 0;
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE \"Role\" " +
                    "SET \"changeWorkTimePermission\" = ?" +
                    "WHERE \"positionName\" LIKE ?");
            ps.setBoolean(1, changeWorkTimePermission);
            ps.setString(2, positionName);
            rowCount = ps.executeUpdate();
        } catch (SQLException e) {
            reason = " " + e;
        }
        if (rowCount>0){
            resultMessage.append(positionName).append(" was updated");
        } else {
            resultMessage.append(positionName).append(" wasn't update ").append(reason);
        }
        return resultMessage.toString();
    }
}
