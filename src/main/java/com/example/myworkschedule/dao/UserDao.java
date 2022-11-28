package com.example.myworkschedule.dao;

import com.example.myworkschedule.beans.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public List<User> searchBranchEmployee(Integer branchId) {
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
                user = new User(0,"","","",0,0);
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
