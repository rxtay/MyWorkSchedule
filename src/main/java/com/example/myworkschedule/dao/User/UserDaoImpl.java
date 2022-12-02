package com.example.myworkschedule.dao.User;

import com.example.myworkschedule.beans.User;
import com.example.myworkschedule.dao.DatabaseConnection;
import com.example.myworkschedule.dao.User.UserDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public int insertNewEmployeeId(){
        int employeeId;
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "INSERT INTO employee values ()";
            PreparedStatement statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()){
                if (generatedKeys.next()){
                    employeeId = generatedKeys.getInt(1);
                }else {
                    throw new SQLException("Creating new employeeId failed.");
                }
            }
        } catch (SQLException e){
            throw  new RuntimeException(e);
        }
        return employeeId;
    }
    @Override
    public int insertNewEmployerId(){
        int employerId;
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "INSERT INTO employer values ()";
            PreparedStatement statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()){
                if (generatedKeys.next()){
                    employerId = generatedKeys.getInt(1);
                }else {
                    throw new SQLException("Creating new employerId failed.");
                }
            }
        } catch (SQLException e){
            throw  new RuntimeException(e);
        }
        return employerId;
    }
    @Override
    public int registerUser(User user, String role){

        Connection connection = DatabaseConnection.getConnection();
        int rowsaffected;
        int employeeId;
        int employerId;
        System.out.println(role);
        try{
            if(role.equals("employee")){
                employeeId = insertNewEmployeeId();
                String query = "INSERT INTO user (firstName, lastName, email,password, employeeId)values (?,?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1,user.getFirstName());
                statement.setString(2,user.getLastName());
                statement.setString(3, user.getEmail());
                statement.setString(4, user.getPassword());
                statement.setInt(5,employeeId);

                rowsaffected = statement.executeUpdate();
            }else if (role.equals("employer")){
                employerId = insertNewEmployerId();

                String query = "INSERT INTO user (firstName, lastName, email,password ,employer_employerId)values (?,?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1,user.getFirstName());
                statement.setString(2,user.getLastName());
                statement.setString(3, user.getEmail());
                statement.setString(4, user.getPassword());
                statement.setInt(5,employerId);

                rowsaffected = statement.executeUpdate();
            }else{
                rowsaffected = 0;
            }
        }catch(SQLException e) {
            throw  new RuntimeException(e);
        }
        return rowsaffected;
    }
    @Override
    public User login(String email, String password) {
        try {
            Connection conn  = DatabaseConnection.getConnection();
            String query = "SELECT * FROM myworkschedule.user WHERE email = ? AND password = ? LIMIT 1;";
            PreparedStatement statement = conn.prepareStatement(
                    query,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet set = statement.executeQuery();
            // Move cursor to the last row
            set.last();
            int count  = set.getRow();
            // Check if user with email and password exists
            if (count == 0) {
                return null;
            }
            int userId  = set.getInt("userId");
            String firstName = set.getString("firstName");
            String lastName = set.getString("lastName");
            Integer employeeId = set.getInt("employeeId");
            Integer employerId = set.getInt("employer_employerId");
            return new User(userId, firstName, lastName, email, password, employeeId, employerId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getEmployeesAssignedShift(int shiftId){
        User user;
        List<User> users = new ArrayList<>();
        try{
            Connection connection = DatabaseConnection.getConnection();
            String sql= "SELECT u.firstName, u.lastName FROM shift s \n" +
                    "JOIN employeeshift es ON shift_shiftId = s.shiftId \n" +
                    "JOIN user u ON employee_employeeId = employeeId WHERE s.shiftId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,shiftId);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                String firstName = set.getString("firstName");
                String lastName = set.getString("lastName");
                user = new User(0, firstName,lastName,null,null,null ,null );
                users.add(user);
            }

        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
        return users;
    }
    public List<User> searchEmployeeWithoutBranch() {
        User user;
        List<User> users = new ArrayList<>();

        try {
            Connection connection = DatabaseConnection.getConnection();
            String sql = "select * from user where user.employeeId IN (select employee.employeeId \n" +
                    "from employee\n" +
                    "where not exists (select * from branchemployee where employee.employeeId = branchemployee.employee_employeeId))";
            PreparedStatement statement = connection.prepareStatement(sql);
            System.out.println(statement);
            ResultSet set = statement.executeQuery();

            while (set.next()){
                user = new User(0,"","","","",0,0);
                user.setUserId(set.getInt("userId"));
                user.setFirstName(set.getString("firstName"));
                user.setLastName(set.getString("lastName"));
                user.setEmail(set.getString("email"));
                user.setEmployeeId(set.getInt("employeeId"));
                users.add(user);
            }
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return users;
    }
    public int  addEmployeeToBranch(int employeeId, int branchId){
        System.out.println("addEmployeeToBranch");
        int rowsAffected;
        try {
            Connection connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO myworkschedule.branchemployee VALUES (?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,employeeId);
            statement.setInt(2,branchId);
            rowsAffected = statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return rowsAffected;
    }
}
