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


@WebServlet("/PaidServlet")
public class PaidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    List<CustomerPurchasedProperty> list = new ArrayList<CustomerPurchasedProperty>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession httpSession = request.getSession();
		try
		{
			String getAddress = (String)httpSession.getAttribute("id"); 
			RealEstateCustomerImplementation customerImplementation = new RealEstateCustomerImplementation();
			list = customerImplementation.retriveProperties(getAddress);
			
			request.setAttribute("list", list);
		    RequestDispatcher dispatcher = request.getRequestDispatcher("PaidTable.jsp");
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
