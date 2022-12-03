package com.example.myworkschedule.dao.EmployeeShift;

import com.example.myworkschedule.beans.DataOrException;
import com.example.myworkschedule.beans.EmployeeShift;
import com.example.myworkschedule.beans.Shift;
import com.example.myworkschedule.beans.User;

import java.util.List;

public interface EmployeeShiftDao {
    DataOrException<Integer> RemoveEmployee(EmployeeShift employeeShift);
    List<Shift> GetAssignedShifts(int employeeId);
    DataOrException<List<User>> GetEmployees(int shiftId);
}
