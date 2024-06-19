package com.chainsys.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.RealEstateImplementation;
import com.chainsys.model.RealEstateUserRegister;

@WebServlet("/UpdateAdminServlet")
public class UpdateAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    RealEstateUserRegister estateUserRegister = new RealEstateUserRegister();
    RealEstateImplementation estateImplementation = new RealEstateImplementation();
    @SuppressWarnings("rawtypes")
	List list;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RealEstateUserRegister estateUser = new RealEstateUserRegister();
		
		
		String phoneNumber = request.getParameter("phoneNumber");
		estateUser.setPhoneNumber(Long.parseLong(phoneNumber));
		
		
		String password = request.getParameter("password");
		estateUser.setPassword(password);
		
		String address = request.getParameter("address");
		estateUser.setAddress(address);	
		
		String name1 = request.getParameter("name");
		estateUser.setName(name1);
		
		try
		{
			estateImplementation.updateDetails(estateUser);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		try
		{
			 list = estateImplementation.retriveAdminDetails1(name1);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("AdminProfile.jsp");
        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
