package com.example.myworkschedule.beans;

import java.util.List;

public class BranchShift {
    private Branch branch;
    private List<Shift> shifts;

    public BranchShift(Branch branch, List<Shift> shifts) {
        this.branch = branch;
        this.shifts = shifts;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public List<Shift> getShifts() {
        return shifts;
    }

    public void setShifts(List<Shift> shifts) {
        this.shifts = shifts;
    }
}
