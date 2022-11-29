package com.example.myworkschedule.dao.user;

import com.example.myworkschedule.beans.User;

public interface UserDao {

    int insertNewEmployeeId();

    int insertNewEmployerId();

    int registerUser(User user, String role);
}
