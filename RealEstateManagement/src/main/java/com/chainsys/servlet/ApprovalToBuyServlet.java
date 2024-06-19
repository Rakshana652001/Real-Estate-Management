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

import com.chainsys.dao.RealEstateCustomerImplementation;
import com.chainsys.model.CustomerPurchasedProperty;


@WebServlet("/ApprovalToBuyServlet")
public class ApprovalToBuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    List<CustomerPurchasedProperty> list = new ArrayList<CustomerPurchasedProperty>();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		CustomerPurchasedProperty customerPurchasedProperty = new CustomerPurchasedProperty();
		String customerId = request.getParameter("customerId");
		customerPurchasedProperty.setCustomerId(customerId);
		
		String approval = request.getParameter("approvalStatus");
		customerPurchasedProperty.setApproval(approval);
		
		RealEstateCustomerImplementation customerImplementation = new RealEstateCustomerImplementation();
		list = customerImplementation.updateApproval(customerId, approval);
		
		request.setAttribute("list", list);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("AdminWelcomePage.jsp");
	    dispatcher.forward(request, response);
	}
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
