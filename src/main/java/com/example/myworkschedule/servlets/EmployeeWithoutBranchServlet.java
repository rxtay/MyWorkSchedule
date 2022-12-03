package com.example.myworkschedule.servlets;

import com.example.myworkschedule.beans.DataOrException;
import com.example.myworkschedule.beans.User;
import com.example.myworkschedule.dao.EmployeeBranch.EmployeeBranchDaoImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet (name = "EmployeeWithoutBranchServlet" )
public class EmployeeWithoutBranchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeBranchDaoImpl dao = new EmployeeBranchDaoImpl();
        DataOrException<List<User>> result = dao.GetEmployeesNotInBranch(1);
        if (result.e != null) {
            req.setAttribute("message", "Failed to retrieve employees.");
            req.setAttribute("users", new ArrayList<>());
        } else {
            req.setAttribute("users", result.data);
        }
        req.getRequestDispatcher("/views/EmployerResult.jsp").forward(req, resp);
    }
}
