package com.example.myworkschedule.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
public class Shift implements Serializable {
    private int shiftId;
    private String content;
    private Timestamp startTime;
    private Timestamp endTime;
    private int rate;
    private int branchId;
    private List<Day> days;

    public Shift(int shiftId, String content, Timestamp startTime, Timestamp endTime, int rate, int branchId) {
        this.shiftId = shiftId;
        this.content = content;
        this.startTime = startTime;
        this.endTime = endTime;
        this.rate = rate;
        this.branchId = branchId;
        this.days = new ArrayList<>();
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    public int getShiftId() {
        return shiftId;
    }

    public void setShiftId(int shiftId) {
        this.shiftId = shiftId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getFormattedDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm a");
        return simpleDateFormat.format(this.startTime).toString() + " - " + simpleDateFormat.format(this.endTime).toString();
    }

    public String getFormattedDays() {
        return this.days.stream()
                .map(day -> day.getDay())
                .reduce("", (accu, current) -> accu + " " + current);
    }
}
