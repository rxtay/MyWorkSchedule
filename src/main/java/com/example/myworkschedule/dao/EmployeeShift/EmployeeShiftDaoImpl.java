package com.example.myworkschedule.dao.EmployeeShift;

import com.example.myworkschedule.beans.DataOrException;
import com.example.myworkschedule.beans.EmployeeShift;
import com.example.myworkschedule.dao.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
