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

import com.chainsys.dao.RealEstateImplementation;
import com.chainsys.model.RealEstateUserRegister;


@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RealEstateUserRegister objectForPojo = new RealEstateUserRegister();
	RealEstateImplementation objectForImplementation = new RealEstateImplementation();
	List<RealEstateUserRegister> admin = new ArrayList<RealEstateUserRegister>();
	String getId;
	
	RealEstateUserRegister estateUserRegister = new RealEstateUserRegister();
	List<RealEstateUserRegister> list = new ArrayList<RealEstateUserRegister>();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession httpSession = request.getSession();
		try
		{
			System.out.println("Inside httpSession");
			getId = (String)httpSession.getAttribute("id"); 
			retrive(request,response);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	protected void retrive(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try 
		{
			System.out.println("inside the retrive method");
			
			list = objectForImplementation.retriveAdminDetails(getId);
			request.setAttribute("list", list);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("UserRegistrationTable.jsp");
	        dispatcher.forward(request, response);
	        System.out.println(list);
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
