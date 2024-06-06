package com.chainsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.dao.RealEstateImplementation;
import com.chainsys.model.RealEstateUserRegister;


@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RealEstateImplementation objectForImplementation = new RealEstateImplementation();
	
	
	RealEstateUserRegister estateUserRegister = new RealEstateUserRegister();
	List<RealEstateUserRegister> list = new ArrayList<RealEstateUserRegister>();
	public static String id;
	
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			PrintWriter out = response.getWriter();
			
			id = request.getParameter("id");
			estateUserRegister.setGeneratedUserID(id);
			System.out.println(id);
			
			String password = request.getParameter("password");
			estateUserRegister.setPassword(password);
			System.out.println(password);
			
			
			HttpSession httpSession = request.getSession();
			try
			{
				if(id.equals(objectForImplementation.getAdminId(id)))
				{
					if(password.equals(objectForImplementation.getAdminpassword(id)))
					{
						System.out.println("Inside session");
						httpSession.setAttribute("id", id);					
						response.sendRedirect("AdminWelcomePage.jsp");
						System.out.println("Successfully Logged In");
					}
					else
					{
						System.out.println("Enter Correct Password");
						response.sendRedirect("AdminLogin.jsp");
					}
				}
				else
				{
					System.out.println("Enter correct id");
					response.sendRedirect("AdminLogin.jsp");
				}
				
			}
			
			catch (Exception e) 
			{
				// TODO: handle exception
			}
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
	}

}
