package com.example.myworkschedule.dao.EmployeeBranch;

import com.example.myworkschedule.beans.DataOrException;
import com.example.myworkschedule.beans.User;
import com.example.myworkschedule.dao.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBranchDaoImpl implements EmployeeBranchDao {
    @Override
    public DataOrException<List<User>> GetEmployeesNotInBranch(int branchId) {
        try {
            List<User> users = new ArrayList<>();
            Connection connection = DatabaseConnection.getConnection();
            String sql = "select * from user where user.employeeId IN (select employee.employeeId from employee where not exists (select * from branchemployee where employee.employeeId in (select branchemployee.employee_employeeId from branchemployee where branchemployee.branch_branchId = ?)));";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, branchId);
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
            return new DataOrException<>(users, null);
        }
        catch (SQLException e){
            return new DataOrException<>(null, e);
        }
    }

    @Override
    public DataOrException<Integer> InsertEmployeeBranch(int employeeId, int branchId) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO myworkschedule.branchemployee VALUES (?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, employeeId);
            statement.setInt(2, branchId);
            int result = statement.executeUpdate();
            return new DataOrException<>(result, null);
        }catch (SQLException e){
            return new DataOrException<>(null, e);
        }
    }
}
