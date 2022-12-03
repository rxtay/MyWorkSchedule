package com.example.myworkschedule.servlets;

import com.example.myworkschedule.beans.DataOrException;
import com.example.myworkschedule.beans.EmployeeShift;
import com.example.myworkschedule.beans.User;
import com.example.myworkschedule.dao.Employee.EmployeeDaoImpl;
import com.example.myworkschedule.dao.EmployeeShift.EmployeeShiftDao;
import com.example.myworkschedule.dao.EmployeeShift.EmployeeShiftDaoImpl;
import com.example.myworkschedule.dao.User.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmployerBranchShiftServlet", value = "/EmployerBranchShiftServlet")
public class EmployerBranchShiftServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeShiftDaoImpl dao = new EmployeeShiftDaoImpl();
        DataOrException<List<User>> result = dao.GetEmployees(1);
        if (result.e != null) {
            req.setAttribute("message", "Failed to retrieve employees.");
            req.setAttribute("users", new ArrayList<>());
        } else {
            req.setAttribute("users", result.data);
        }
        req.getRequestDispatcher("/views/EmployerBranchShift.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        switch (action) {
            case "/employer/branch/shift/delete": {
                EmployeeShiftDaoImpl dao = new EmployeeShiftDaoImpl();
                int employeeId = Integer.parseInt(req.getParameter("employeeId"));
                EmployeeShift employeeShift = new EmployeeShift();
                employeeShift.setEmployeeId(employeeId);
                employeeShift.setShiftId(1);
                DataOrException<Integer> result = dao.RemoveEmployee(employeeShift);
                if (result.e != null) {
                    req.setAttribute("message", "Failed to remove employee from shift.");
                } else {
                    req.setAttribute("message", "Successfully removed employee from shift.");
                }
                doGet(req, resp);
            }
            case "/": {
                break;
            }
            default: {
                break;
            }
        }
    }
}
