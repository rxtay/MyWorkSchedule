package com.example.myworkschedule.dao.User;

import com.example.myworkschedule.beans.User;
import com.example.myworkschedule.dao.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
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
            User user = new User(userId, firstName, lastName, email, employeeId, employerId);
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
