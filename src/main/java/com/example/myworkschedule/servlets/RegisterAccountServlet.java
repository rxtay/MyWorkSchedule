package com.example.myworkschedule.servlets;

import com.example.myworkschedule.beans.User;
import com.example.myworkschedule.dao.user.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterAccountServlet", value = "/RegisterAccountServlet")
public class RegisterAccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/RegisterAccount.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        User user = new User(0, firstName, lastName, email, password, 0,0);

        UserDaoImpl dao = new UserDaoImpl();
        int affectedRows = dao.registerUser(user,role);
        req.getRequestDispatcher("/views/RegisterAccount.jsp").forward(req,resp);
    }
}
