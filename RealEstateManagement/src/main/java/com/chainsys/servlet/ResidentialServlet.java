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


@WebServlet("/ResidentialServlet")
public class ResidentialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       String getId;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession httpSession = request.getSession();
		try
		{
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
		List<RealEstatePropertyRegister> list = new ArrayList<RealEstatePropertyRegister>();
		RealEstatePropertyImplementation estatePropertyImplementation = new RealEstatePropertyImplementation();
		try 
		{
			list = estatePropertyImplementation.retriveResidential(getId);
			request.setAttribute("list", list);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("PropertyTableForUserDisplay.jsp");
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
