package com.example.myworkschedule.dao.User;

import com.example.myworkschedule.beans.User;
import com.example.myworkschedule.dao.DatabaseConnection;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<User> searchBranchEmployee(int branchId) {
        User user;
        List<User> users = new ArrayList<>();

        try{
            Connection connection = DatabaseConnection.getConnection();
            String sql = "SELECT u.* FROM branchemployee be\n" +
                    "JOIN employee e ON be.employee_employeeId = e.employeeId\n" +
                    "JOIN user u ON u.employeeId = e.employeeId\n" +
                    "WHERE branch_branchId = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,branchId);
            System.out.println(statement);
            ResultSet set = statement.executeQuery();

            while (set.next()){
                user = new User(0,"","","","",0,0);
                user.setUserId(set.getInt("userId"));
                user.setFirstName(set.getString("firstName"));
                user.setLastName(set.getString("lastName"));
                user.setEmail(set.getString("email"));
                user.setEmployeeId(set.getInt("employeeId"));
                users.add(user);
            }
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return users;
    }
}
