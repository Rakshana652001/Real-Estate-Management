package com.chainsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.dao.RealEstatePropertyImplementation;
import com.chainsys.model.RealEstatePropertyRegister;


@WebServlet("/PropertyServlet")
public class PropertyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    RealEstatePropertyRegister estatePropertyRegister = new RealEstatePropertyRegister();
    RealEstatePropertyImplementation estatePropertyImplementation = new RealEstatePropertyImplementation();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		String sellerId = request.getParameter("sellerId");
		estatePropertyRegister.setSellerId(sellerId);
		
		String propertyName = request.getParameter("propertyName");
		estatePropertyRegister.setPropertyName(propertyName);
		
		String propertyId = request.getParameter("propertyId");
		estatePropertyRegister.setPropertyId(propertyId);
		
		String propertyPrice = request.getParameter("propertyPrice");
		System.out.println(propertyPrice);
		long propertyprice = Long.parseLong(propertyPrice);
		estatePropertyRegister.setPropertyPrice(propertyprice);
		
		
		String propertyAddress = request.getParameter("propertyAddress");
		estatePropertyRegister.setPropertyAddress(propertyAddress);
		
	    String propertyDistrict = request.getParameter("propertyDistrict");
	    estatePropertyRegister.setPropertyDistrict(propertyDistrict);
	    
	    String propertyState = request.getParameter("propertyState");
	    estatePropertyRegister.setPropertyState(propertyState);
	    
	    HttpSession httpSession = request.getSession();
	    try
	    {
	    	estatePropertyImplementation.saveProperties(estatePropertyRegister);
	    	System.out.println("Inside Session");
	    	httpSession.setAttribute("sellerId", sellerId);
	    	response.sendRedirect("SellerWelcomePage.jsp");
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e);
	    	response.sendRedirect("PropertyRegistration.jsp");
	    }
	    
	    
	}
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
