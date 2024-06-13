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
import com.chainsys.model.CustomerPurchasedProperty;

@WebServlet("/BuyedPropertiesServlet")
public class BuyedPropertiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 List<CustomerPurchasedProperty> list = new ArrayList<CustomerPurchasedProperty>();
	 RealEstateCustomerImplementation customerImplementation = new RealEstateCustomerImplementation();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
	    String customerId = (String) session.getAttribute("customerId");
	    
	    list = customerImplementation.retriveBuyedProperties(customerId);
	    
	    request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("BuyedPropertiesSellerViewTable.jsp");
        dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
