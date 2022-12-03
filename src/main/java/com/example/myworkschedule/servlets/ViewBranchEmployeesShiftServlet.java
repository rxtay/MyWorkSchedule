package com.example.myworkschedule.servlets;

import com.example.myworkschedule.beans.Shift;
import com.example.myworkschedule.dao.Branch.BranchDaoImpl;
import com.example.myworkschedule.dao.EmployeeShift.EmployeeShiftDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ViewBranchEmployeesShiftServlet", value = "/branch/employee/shift")
public class ViewBranchEmployeesShiftServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeShiftDaoImpl dao = new EmployeeShiftDaoImpl();
        List<Shift> shift = dao.GetAssignedShifts(111);
        request.setAttribute("shifts", shift);
        request.getRequestDispatcher("/views/ViewEmployeesShift.jsp").forward(request, response);
    };

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
