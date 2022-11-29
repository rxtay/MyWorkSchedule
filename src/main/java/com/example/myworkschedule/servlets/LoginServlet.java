package com.example.myworkschedule.servlets;

import com.example.myworkschedule.beans.User;
import com.example.myworkschedule.dao.User.UserDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/Login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserDaoImpl dao = new UserDaoImpl();
        User user = dao.login(email, password);
        if (user == null) {
            request.setAttribute("alert", "Either email or password is incorrect. Please try again.");
        } else {
            request.setAttribute("alert", String.format("Welcome to MyWorkSchedule, %s.", user.getEmail()));
        }
        doGet(request, response);
    }
}
