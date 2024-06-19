package com.chainsys.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.RealEstatePropertyImplementation;
import com.chainsys.model.RealEstatePropertyRegister;


@WebServlet("/ApprovalServlet")
public class ApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String address, approval, register;
    RealEstatePropertyRegister estatePropertyRegister = new RealEstatePropertyRegister();
    List<RealEstatePropertyRegister> list = new ArrayList<RealEstatePropertyRegister>();
    RealEstatePropertyImplementation estatePropertyImplementation = new RealEstatePropertyImplementation();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		address = request.getParameter("address");
		estatePropertyRegister.setPropertyAddress(address);
		
		approval = request.getParameter("approvalStatus");
		estatePropertyRegister.setApproval(approval);

		try
		{
			list = estatePropertyImplementation.updateApproval(address, approval);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ApprovedServlet");
        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
