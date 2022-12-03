package com.example.myworkschedule.dao.User;

import com.example.myworkschedule.beans.DataOrException;
import com.example.myworkschedule.beans.User;

import java.util.List;

public interface UserDao {
    DataOrException<Integer> insertUser(User user);
    User login(String email, String password);
}
