package com.example.myworkschedule.dao.User;

import com.example.myworkschedule.beans.User;

public interface UserDao {
    User login(String email, String password);
}