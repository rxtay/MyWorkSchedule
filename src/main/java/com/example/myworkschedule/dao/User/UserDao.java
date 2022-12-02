package com.example.myworkschedule.dao.User;

import com.example.myworkschedule.beans.User;

import java.util.List;

public interface UserDao {
    User login(String email, String password);
    int insertNewEmployeeId();
    int insertNewEmployerId();
    int registerUser(User user, String role);
    List<User> getEmployeesAssignedShift(int shiftId);


}