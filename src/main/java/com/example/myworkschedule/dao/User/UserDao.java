package com.example.myworkschedule.dao.User;

import com.example.myworkschedule.beans.User;

import java.util.List;

public interface UserDao {
    int insertNewEmployeeId();
    int insertNewEmployerId();
    int registerUser(User user, String role);
    List<User> searchBranchEmployee(int branchId);
    User login(String email, String password);
    List<User> getEmployeesAssignedShift(int shiftId);
}
