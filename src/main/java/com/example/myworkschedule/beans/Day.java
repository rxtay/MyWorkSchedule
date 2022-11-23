package com.example.myworkschedule.beans;

public class Day {
    private int dayId;
    private String day;

    public Day(int dayId, String day) {
        this.dayId = dayId;
        this.day = day;
    }

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
