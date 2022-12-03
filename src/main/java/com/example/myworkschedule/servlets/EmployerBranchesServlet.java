package com.example.myworkschedule.servlets;

import com.example.myworkschedule.beans.Branch;
import com.example.myworkschedule.beans.DataOrException;
import com.example.myworkschedule.dao.Branch.BranchDaoImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployerBranchesServlet", value = "/EmployerBranchesServlet")
public class EmployerBranchesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BranchDaoImpl dao = new BranchDaoImpl();
        List<Branch> branches = dao.showEmployerBranches(1);
        request.setAttribute("branches", branches);
        request.getRequestDispatcher("/views/EmployerBranches.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost: EmployerBranchesServlet");
        int employerId = 1;
        String name = req.getParameter("name");
        BranchDaoImpl dao = new BranchDaoImpl();
        Branch branch = new Branch();
        branch.setEmployerId(employerId);
        branch.setName(name);
        DataOrException<Boolean> result = dao.insertBranch(branch);
        if (result.e != null) {
            req.setAttribute("message", "Failed to add branch.");
        } else {
            req.setAttribute("message", "Branch added successfully.");
        }
        doGet(req, resp);
    }
}
