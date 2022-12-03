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

@WebServlet (name = "EmployeeWithoutBranchServlet" )
public class EmployeeWithoutBranchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDaoImpl dao = new UserDaoImpl();
        List<User> users = dao.searchEmployeeWithoutBranch();
        req.setAttribute("users", users);
        req.getRequestDispatcher("/views/EmployerResult.jsp").forward(req, resp);
    }
}
