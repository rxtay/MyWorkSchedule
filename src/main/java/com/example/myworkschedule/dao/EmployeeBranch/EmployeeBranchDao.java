package com.example.myworkschedule.dao.EmployeeBranch;

import com.example.myworkschedule.beans.DataOrException;
import com.example.myworkschedule.beans.User;
import java.util.List;

public interface EmployeeBranchDao {
    DataOrException<List<User>> GetEmployeesNotInBranch(int branchId);
    DataOrException<Integer> InsertEmployeeBranch(int employeeId, int branchId);
}