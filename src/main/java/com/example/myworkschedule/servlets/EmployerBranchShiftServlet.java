package com.example.myworkschedule.servlets;

import com.example.myworkschedule.beans.User;
import com.example.myworkschedule.dao.User.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployerBranchShiftServlet", value = "/EmployerBranchShiftServlet")
public class EmployerBranchShiftServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDaoImpl dao = new UserDaoImpl();
        List<User> users = dao.getEmployeesAssignedShift(2);

        req.setAttribute("users",users);
        req.getRequestDispatcher("/views/EmployerBranchShift.jsp").forward(req,resp);
    }
}
