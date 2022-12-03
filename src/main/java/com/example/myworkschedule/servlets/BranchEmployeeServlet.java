package com.example.myworkschedule.servlets;

import com.example.myworkschedule.beans.DataOrException;
import com.example.myworkschedule.beans.User;
import com.example.myworkschedule.dao.Employee.EmployeeDaoImpl;
import com.example.myworkschedule.dao.EmployeeBranch.EmployeeBranchDaoImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet (name = "ViewBranchEmployee" , value = "/ViewBranchEmployee")
public class BranchEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        EmployeeBranchDaoImpl employeeBranchDao = new EmployeeBranchDaoImpl();
        DataOrException<List<User>> result = employeeDao.getEmployees(1);
        DataOrException<List<User>> employees = employeeBranchDao.GetEmployeesNotInBranch(1);
        String message;
        // Format error messages if any
        if (result.e != null) {
            message = "Failed to retrieve employees.";
        } else {
            message = "Failed to retrieve employees to add.";
        }
        // Error handling
        if (result.e != null || employees.e != null) {
            req.setAttribute("message", message);
            req.setAttribute("usersBranchless", new ArrayList<>());
            req.setAttribute("users", new ArrayList<>());
            req.getRequestDispatcher("/views/EmployerResult.jsp").forward(req, resp);
            return;
        }
        req.setAttribute("usersBranchless", employees.data);
        req.setAttribute("users", result.e);
        req.getRequestDispatcher("/views/EmployerResult.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int employeeId = Integer.parseInt(req.getParameter("employeeId"));
        EmployeeBranchDaoImpl dao = new EmployeeBranchDaoImpl();
        DataOrException<Integer> result = dao.InsertEmployeeBranch(employeeId,1);
        if (result.e != null) {
            req.setAttribute("message", "Failed to add employee to branch.");
        }
        doGet(req,resp);
    }
}
