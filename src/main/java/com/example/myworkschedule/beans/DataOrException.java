package com.example.myworkschedule.beans;

import java.sql.SQLException;

public class DataOrException<T> {
    public T data;
    public SQLException e;
    public DataOrException(T data, SQLException e){
        this.data = data;
        this.e = e;
    }
}