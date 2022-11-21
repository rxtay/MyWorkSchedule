package com.example.myworkschedule.servlets;

import com.example.myworkschedule.beans.BranchShift;
import com.example.myworkschedule.dao.Branch.BranchDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EmployerViewBranchServlet", value = "/EmployerViewBranchServlet")
public class EmployerViewBranchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BranchDaoImpl dao  = new BranchDaoImpl();
        BranchShift branchShift = dao.getBranch(1);
        request.setAttribute("branch", branchShift.getBranch());
        request.setAttribute("shifts", branchShift.getShifts());
        request.getRequestDispatcher("/views/EmployerViewBranch.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
