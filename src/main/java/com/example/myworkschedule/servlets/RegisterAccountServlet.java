package com.example.myworkschedule.servlets;

import com.example.myworkschedule.beans.DataOrException;
import com.example.myworkschedule.beans.User;
import com.example.myworkschedule.dao.Employee.EmployeeDaoImpl;
import com.example.myworkschedule.dao.Employer.EmployerDaoImpl;
import com.example.myworkschedule.dao.User.UserDaoImpl;
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
        UserDaoImpl dao = new UserDaoImpl();
        switch (role) {
            case "employer": {
                EmployerDaoImpl employerDao = new EmployerDaoImpl();
                DataOrException<Integer> result = employerDao.insertEmployer();
                if (result.e != null) {
                    req.setAttribute("message", "Failed to insert employer.");
                    doGet(req, resp);
                    break;
                }
                User user = new User(0, firstName, lastName, email, password, null, result.data);
                result = dao.insertUser(user);
                if (result.e != null) {
                    req.setAttribute("message", "Failed to insert user.");
                    doGet(req, resp);
                    break;
                }
            }
            case "employee": {
                EmployeeDaoImpl employerDao = new EmployeeDaoImpl();
                DataOrException<Integer> result = employerDao.insertEmployee();
                if (result.e != null) {
                    req.setAttribute("message", "Failed to insert employee.");
                    doGet(req, resp);
                    break;
                }
                User user = new User(0, firstName, lastName, email, password, result.data, null);
                result = dao.insertUser(user);
                if (result.e != null) {
                    req.setAttribute("message", "Failed to insert user.");
                    doGet(req, resp);
                    break;
                }
            }
            default: {
                req.setAttribute("message", "User role is undefined.");
                doGet(req, resp);
                break;
            }
        }
        doGet(req, resp);
    }
}
