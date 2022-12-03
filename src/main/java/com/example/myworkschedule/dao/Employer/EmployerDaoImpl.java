package com.example.myworkschedule.dao.Employer;

import com.example.myworkschedule.beans.DataOrException;
import com.example.myworkschedule.dao.DatabaseConnection;
import java.sql.*;

public class EmployerDaoImpl implements EmployerDao {
    @Override
    public DataOrException<Integer> insertEmployer() {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "INSERT INTO employer values ();";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()){
                if (!generatedKeys.next()){
                    throw new SQLException("Creating new employerId failed.");
                }
                int employerId = generatedKeys.getInt(1);
                return new DataOrException<Integer>(employerId, null);
            }
        } catch (SQLException e){
            return new DataOrException<Integer>(null, e);
        }
    }
}