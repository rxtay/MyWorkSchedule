package com.example.myworkschedule.dao.EmployeeShift;

import com.example.myworkschedule.beans.DataOrException;
import com.example.myworkschedule.beans.EmployeeShift;

public interface EmployeeShiftDao {
    DataOrException<Integer> RemoveEmployee(EmployeeShift employeeShift);
}
