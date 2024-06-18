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
import javax.servlet.http.HttpSession;

import com.chainsys.dao.RealEstateCustomerImplementation;
import com.chainsys.dao.RealEstatePropertyImplementation;
import com.chainsys.model.CustomerPurchasedProperty;


@WebServlet("/PayNowServlet")
public class PayNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CustomerPurchasedProperty customerPurchasedProperty = new CustomerPurchasedProperty();
    List<CustomerPurchasedProperty> list = new ArrayList<CustomerPurchasedProperty>();
    RealEstateCustomerImplementation customerImplementation = new RealEstateCustomerImplementation();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String yourAccount = request.getParameter("yourAccountNumber");
		long accountNumber1 = Long.parseLong(yourAccount);
		customerPurchasedProperty.setYourAccountNumber(accountNumber1);
		
		String senderAccountNumber = request.getParameter("senderAccountNumber");
		long accountNumber2 = Long.parseLong(senderAccountNumber);
		customerPurchasedProperty.setSenderAccountNumber(accountNumber2);
		
		String amount = request.getParameter("amount");
		Double getAmount = Double.parseDouble(amount);
		customerPurchasedProperty.setAmount(getAmount);
		
		HttpSession session = request.getSession();
	    String customerId = (String) session.getAttribute("customerId");
	    customerPurchasedProperty.setCustomerId(customerId);
		try
		{			
			list = customerImplementation.updatePayment(accountNumber1, accountNumber2, customerId);
			
			RealEstatePropertyImplementation estatePropertyImplementation = new RealEstatePropertyImplementation();
			estatePropertyImplementation.updatePaid(customerId);
			
			request.setAttribute("list", list);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("ApprovedPropertyTableToBuy.jsp");
	        dispatcher.forward(request, response);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
