package com.example.myworkschedule.dao.user;

import com.example.myworkschedule.beans.User;
import com.example.myworkschedule.dao.DatabaseConnection;


import javax.servlet.http.HttpServlet;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    @Override
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
    @Override
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
    @Override
    public int registerUser(User user, String role){

        Connection connection = DatabaseConnection.getConnection();
        int rowsaffected;
        int employeeId;
        int employerId;
        System.out.println(role);
        try{
            if(role.equals("employee")){
                employeeId = insertNewEmployeeId();
                String query = "INSERT INTO user (firstName, lastName, email,password, employeeId)values (?,?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1,user.getFirstName());
                statement.setString(2,user.getLastName());
                statement.setString(3, user.getEmail());
                statement.setString(4, user.getPassword());
                statement.setInt(5,employeeId);

                rowsaffected = statement.executeUpdate();
            }else if (role.equals("employer")){
                employerId = insertNewEmployerId();

                String query = "INSERT INTO user (firstName, lastName, email,password ,employer_employerId)values (?,?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1,user.getFirstName());
                statement.setString(2,user.getLastName());
                statement.setString(3, user.getEmail());
                statement.setString(4, user.getPassword());
                statement.setInt(5,employerId);

                rowsaffected = statement.executeUpdate();
            }else{
                rowsaffected = 0;
            }
        }catch(SQLException e) {
            throw  new RuntimeException(e);
        }
        return rowsaffected;
    }
}
