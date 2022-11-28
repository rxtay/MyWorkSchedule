package com.example.myworkschedule.dao.Branch;

import com.example.myworkschedule.beans.*;
import com.example.myworkschedule.dao.DatabaseConnection;

import java.sql.*;
import java.util.*;

public class BranchDaoImpl implements BranchDao {
    @Override
    public BranchShift getBranch(int branchId) {
        Branch branch = new Branch();
        List<ShiftDay> shiftHasDay = new ArrayList<ShiftDay>();
        Map<Integer, Shift> map = new HashMap<Integer, Shift>();
        try {
            String query = "SELECT b.name, b.employerId, s.*, d.* FROM shiftday sd " +
                    "JOIN day d ON d.dayId = sd.dayId " +
                    "JOIN shift s ON s.shiftId = sd.shiftId " +
                    "JOIN branch b ON b.branchId = s.branchId " +
                    String.format("WHERE sd.shiftId IN (SELECT shiftId FROM shift WHERE branchId = %s) ", branchId) +
                    "ORDER BY d.day;";
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();
            ResultSet set = statement.executeQuery(query);
            while (set.next()) {
                if (set.isFirst()) {
                    String name = set.getString("name");
                    int employerId = set.getInt("employerId");
                    branch.setBranchId(branchId);
                    branch.setName(name);
                    branch.setEmployerId(employerId);
                }

                int dayId = set.getInt("dayId");
                String dayName= set.getString("day");
                Day day = new Day(dayId, dayName);

                int shiftId = set.getInt("shiftId");
                String content = set.getString("content");
                Timestamp startTime = set.getTimestamp("startTime");
                Timestamp endTime = set.getTimestamp("endTime");
                int rate = set.getInt("rate");
                Shift shift = new Shift(shiftId, content, startTime, endTime, rate, branchId);
                ShiftDay shiftDay = new ShiftDay(shift, day);
                shiftHasDay.add(shiftDay);
            }

            for (ShiftDay shiftDay: shiftHasDay) {
                int shiftId = shiftDay.getShift().getShiftId();
                int dayId = shiftDay.getDay().getDayId();
                String dayName = shiftDay.getDay().getDay();
                if (map.containsKey(shiftId)) {
                    map.get(shiftDay.getShift().getShiftId()).getDays().add(new Day(dayId, dayName));
                } else {
                    shiftDay.getShift().getDays().add(shiftDay.getDay());
                    map.put(shiftId, shiftDay.getShift());
                }
            }
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
        return new BranchShift(branch, new ArrayList(map.values()));
    }

    @Override
    public List<Branch> getEmployeeBranches(int employeeId) {
        Branch branch = null;
        List<Branch> branches = new ArrayList<>();
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "SELECT b.* FROM branchemployee be JOIN branch b ON be.branch_branchId = b.branchId WHERE employee_employeeId = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, employeeId);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                branch = new Branch();
                int branchId = set.getInt("branchId");
                String name = set.getString("name");
                int employerId = set.getInt("employerId");
                branch.setBranchId(branchId);
                branch.setName(name);
                branch.setEmployerId(employerId);
                branches.add(branch);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return branches;
    }
}
