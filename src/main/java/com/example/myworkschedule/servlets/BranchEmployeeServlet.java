package com.example.myworkschedule.servlets;

import com.example.myworkschedule.beans.User;
import com.example.myworkschedule.dao.User.UserDaoImpl;
import com.example.myworkschedule.dao.UserDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "ViewBranchEmployee" , value = "/ViewBranchEmployee")
public class BranchEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDaoImpl dao1 = new UserDaoImpl();
        UserDao dao = new UserDao();
        List<User> users = dao.searchBranchEmployee(1);
        List<User> usersBranchless = dao1.searchEmployeeWithoutBranch();
        req.setAttribute("usersBranchless", usersBranchless);
        req.setAttribute("users", users);
        req.getRequestDispatcher("/views/EmployerBranchMembers.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int employeeId = Integer.parseInt(req.getParameter("employeeId"));
        System.out.println(req.getParameter("employeeId"));

        UserDaoImpl dao = new UserDaoImpl();
        int affectedrows = dao.addEmployeeToBranch(employeeId,1);
        doGet(req,resp);
    }
}
