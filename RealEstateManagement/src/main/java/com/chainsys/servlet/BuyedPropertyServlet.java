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

import com.chainsys.dao.RealEstatePropertyImplementation;
import com.chainsys.model.RealEstatePropertyRegister;

@WebServlet("/BuyedPropertyServlet")
public class BuyedPropertyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<RealEstatePropertyRegister> list = new ArrayList<RealEstatePropertyRegister>();
	RealEstatePropertyImplementation estatePropertyImplementation = new RealEstatePropertyImplementation();
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
	    String propertyAddress = (String) session.getAttribute("sellerId");
	    
	    list = estatePropertyImplementation.retriveBuyedProperties(propertyAddress);
	    
	    request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("BuyedPropertiesCustomerViewTable.jsp");
        dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
