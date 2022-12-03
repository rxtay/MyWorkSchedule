package com.example.myworkschedule.dao.User;

import com.example.myworkschedule.beans.DataOrException;
import com.example.myworkschedule.beans.User;
import com.example.myworkschedule.dao.DatabaseConnection;
import com.example.myworkschedule.dao.User.UserDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public DataOrException<Integer> insertUser(User user) {
        try{
            Connection connection = DatabaseConnection.getConnection();
            String query = "INSERT INTO user (firstName, lastName, email, password, employeeId, employer_employerId)values (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            // Check if employeeId is null
            if (user.getEmployeeId() != null) {
                statement.setInt(5, user.getEmployeeId());
            } else {
                statement.setNull(5, Types.NULL);
            }
            // Check if employerId is null
            if (user.getEmployerId() != null) {
                statement.setInt(6, user.getEmployerId());
            } else {
                statement.setNull(6, Types.NULL);
            }
            int result = statement.executeUpdate();
            return new DataOrException<Integer>(result, null);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return new DataOrException<Integer>(null, e);
        }
    }

    @Override
    public User login(String email, String password) {
        try {
            Connection conn  = DatabaseConnection.getConnection();
            String query = "SELECT * FROM myworkschedule.user WHERE email = ? AND password = ? LIMIT 1;";
            PreparedStatement statement = conn.prepareStatement(
                    query,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet set = statement.executeQuery();
            // Move cursor to the last row
            set.last();
            int count  = set.getRow();
            // Check if user with email and password exists
            if (count == 0) {
                return null;
            }
            int userId  = set.getInt("userId");
            String firstName = set.getString("firstName");
            String lastName = set.getString("lastName");
            Integer employeeId = set.getInt("employeeId");
            Integer employerId = set.getInt("employer_employerId");
            return new User(userId, firstName, lastName, email, password, employeeId, employerId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
