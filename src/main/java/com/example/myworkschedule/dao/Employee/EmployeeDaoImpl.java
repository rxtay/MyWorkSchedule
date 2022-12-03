package com.example.myworkschedule.dao.Employee;

import com.example.myworkschedule.beans.DataOrException;
import com.example.myworkschedule.beans.User;
import com.example.myworkschedule.dao.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public DataOrException<Integer> insertEmployee() {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "INSERT INTO employee values ()";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()){
                if (!generatedKeys.next()){
                    throw new SQLException("Failed to insert new employee.");
                }
                int employeeId = generatedKeys.getInt(1);
                return new DataOrException<Integer>(employeeId, null);
            }
        } catch (SQLException e){
            return new DataOrException<Integer>(null, e);
        }
    }

    @Override
    public DataOrException<List<User>> getEmployees(int branchId) {
        try{
            List<User> users = new ArrayList<>();
            Connection conn = DatabaseConnection.getConnection();
            String sql = "SELECT u.* FROM branchemployee be\n" +
                    "JOIN employee e ON be.employee_employeeId = e.employeeId\n" +
                    "JOIN user u ON u.employeeId = e.employeeId\n" +
                    "WHERE branch_branchId = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,branchId);
            System.out.println(statement);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                int userId = set.getInt("userId");
                String firstName = set.getString("firstName");
                String lastName = set.getString("lastName");
                String email = set.getString("email");
                String password = set.getString("password");
                int employeeId = set.getInt("employeeId");
                User user = new User(userId, firstName, lastName, email, password, employeeId, null);
                users.add(user);
            }
            return new DataOrException<List<User>>(users, null);
        }
        catch (SQLException e){
            return new DataOrException<List<User>>(null, e);
        }
    }
}
