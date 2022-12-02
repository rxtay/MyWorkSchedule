package com.example.myworkschedule.dao.Branch;

import com.example.myworkschedule.beans.Branch;
import com.example.myworkschedule.beans.BranchShift;
import com.example.myworkschedule.beans.DataOrException;
import com.example.myworkschedule.beans.Shift;

import java.util.List;

public interface BranchDao {
    BranchShift getBranch(int branchId);
    List<Branch> getEmployeeBranches(int employeeId);
    List<Shift> getEmployeeShift(int employeeId);
    void insertBranch(Branch branch);
    DataOrException<Boolean> insertBranch(Branch branch);
}
