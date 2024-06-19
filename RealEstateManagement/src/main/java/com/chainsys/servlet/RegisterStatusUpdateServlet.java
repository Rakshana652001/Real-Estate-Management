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


@WebServlet("/RegisterStatusUpdateServlet")
public class RegisterStatusUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     String address, registerStatus;  
     RealEstatePropertyRegister estatePropertyRegister = new RealEstatePropertyRegister();
     List<RealEstatePropertyRegister> list = new ArrayList<RealEstatePropertyRegister>();
     RealEstatePropertyImplementation estatePropertyImplementation = new RealEstatePropertyImplementation();
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		address = request.getParameter("address");
		estatePropertyRegister.setPropertyAddress(address);
		
		registerStatus = request.getParameter("registerStatus");
		estatePropertyRegister.setRegistered(registerStatus);
		
		try
		{
			list = estatePropertyImplementation.updateRegistered(address, registerStatus);
		}
		catch(Exception e)
		{
			System.out.println(e);			
		}		
		request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("RegisteredPropertiesServlet");
        dispatcher.forward(request, response);
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
