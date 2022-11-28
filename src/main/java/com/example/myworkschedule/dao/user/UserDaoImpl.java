package com.example.myworkschedule.dao.user;

import com.example.myworkschedule.beans.User;
import com.example.myworkschedule.dao.DatabaseConnection;


import javax.servlet.http.HttpServlet;

import java.sql.*;

public class UserDaoImpl extends HttpServlet {

    public int insertNewEmployeeId(){
        int employeeId =0;
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "INSERT INTO employee values ()";
            PreparedStatement statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()){
                if (generatedKeys.next()){
                    employeeId = generatedKeys.getInt(1);
                }else {
                    throw new SQLException("Creating new employeeId failed.");
                }
            }
        } catch (SQLException e){
            throw  new RuntimeException(e);
        }
        return employeeId;
    }

    public int insertNewEmployerId(){
        int employerId =0 ;
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "INSERT INTO employer values ()";
            PreparedStatement statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()){
                if (generatedKeys.next()){
                    employerId = generatedKeys.getInt(1);
                }else {
                    throw new SQLException("Creating new employerId failed.");
                }
            }
        } catch (SQLException e){
            throw  new RuntimeException(e);
        }
        return employerId;
    }

    public int registerUser(User user, String role){
        Connection connection = DatabaseConnection.getConnection();
        int rowsaffected;
        int employeeId;
        int employerId;
        try{
            if(role == "employee"){
                employeeId = insertNewEmployeeId();
                String query = "INSERT INTO user (firstName, lastName, email, employeeId)values (?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1,user.getFirstName());
                statement.setString(2,user.getLastName());
                statement.setString(3, user.getEmail());
                statement.setInt(4,employeeId);

                rowsaffected = statement.executeUpdate();
            }else if (role == "employer"){
                employerId = insertNewEmployerId();

                String query = "INSERT INTO user (firstName, lastName, email, employer_employerId)values (?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1,user.getFirstName());
                statement.setString(2,user.getLastName());
                statement.setString(3, user.getEmail());
                statement.setInt(4,employerId);

                rowsaffected = statement.executeUpdate();
            }else{
                throw new SQLException();
            }
        }catch(SQLException e) {
            throw  new RuntimeException(e);
        }
        return rowsaffected;
    }
}
