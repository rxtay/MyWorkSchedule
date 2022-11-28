package com.example.myworkschedule.servlets;

import com.example.myworkschedule.beans.Branch;
import com.example.myworkschedule.dao.Branch.BranchDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "EmployeeBranchServlet", value = "/EmployeeBranchServlet")
public class EmployeeBranchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BranchDaoImpl dao = new BranchDaoImpl();
        List<Branch> branch = dao.getEmployeeBranches(111);
        System.out.println(branch);

        request.setAttribute("branches",branch);
        request.getRequestDispatcher("/views/EmployeeBranch.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

