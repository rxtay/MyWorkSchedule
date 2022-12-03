package com.example.myworkschedule.dao.Employee;

import com.example.myworkschedule.beans.DataOrException;
import com.example.myworkschedule.beans.User;

import java.util.List;

public interface EmployeeDao {
    DataOrException<Integer> insertEmployee();
    DataOrException<List<User>> getEmployees(int branchId);
}