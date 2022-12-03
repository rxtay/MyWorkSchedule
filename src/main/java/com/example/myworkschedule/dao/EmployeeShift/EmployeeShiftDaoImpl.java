package com.example.myworkschedule.dao.EmployeeShift;

import com.example.myworkschedule.beans.DataOrException;
import com.example.myworkschedule.beans.EmployeeShift;
import com.example.myworkschedule.beans.Shift;
import com.example.myworkschedule.beans.User;
import com.example.myworkschedule.dao.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeShiftDaoImpl implements EmployeeShiftDao {
    @Override
    public DataOrException<Integer> RemoveEmployee(EmployeeShift employeeShift) {
        try {
            String query = "DELETE FROM myworkschedule.employeeshift WHERE employee_employeeId = ? AND shift_shiftId = ?;";
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, employeeShift.employeeId);
            statement.setInt(2, employeeShift.shiftId);
            int result = statement.executeUpdate();
            return new DataOrException<Integer>(result, null);
        } catch (SQLException e) {
            return new DataOrException<Integer>(null, e);
        }
    }

    @Override
    public List<Shift> GetAssignedShifts(int employeeId) {
        Shift shift;
        List<Shift> shifts = new ArrayList<>();
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "SELECT b.* FROM employeeshift be " +
                    "JOIN shift b ON be.shift_shiftId = b.shiftId " +
                    "WHERE employee_employeeId = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, employeeId);
            ResultSet set = statement.executeQuery();
            System.out.println(set);
            while (set.next()){
                int shiftId = set.getInt("shiftId");
                String content = set.getString("content");
                Timestamp startTime = set.getTimestamp("startTime");
                Timestamp endTime = set.getTimestamp("endTime");
                int rate = set.getInt("rate");
                int branchId = set.getInt("branchId");
                shift = new Shift(shiftId, content, startTime, endTime, rate, branchId);
                shifts.add(shift);
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return shifts;
    }

    @Override
    public DataOrException<List<User>> GetEmployees(int shiftId) {
        try{
            List<User> users = new ArrayList<>();
            Connection connection = DatabaseConnection.getConnection();
            String sql= "SELECT u.* FROM shift s \n" +
                    "JOIN employeeshift es ON es.shift_shiftId = s.shiftId \n" +
                    "JOIN user u ON es.employee_employeeId = u.employeeId WHERE s.shiftId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, shiftId);
            ResultSet set = statement.executeQuery();
            while(set.next()) {
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
        }catch (SQLException e){
            return new DataOrException<>(null, e);
        }
    }
}
