package com.example.myworkschedule.dao.Branch;

import com.example.myworkschedule.beans.Branch;
import com.example.myworkschedule.beans.BranchShift;

import java.util.List;

public interface BranchDao {
    BranchShift getBranch(int branchId);
    List<Branch> getEmployeeBranches(int employeeId);
}
