package com.example.myworkschedule.beans;

public class ShiftDay {
    private Shift shift;
    private Day day;

    public ShiftDay(Shift shift, Day day) {
        this.shift = shift;
        this.day = day;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }
}
