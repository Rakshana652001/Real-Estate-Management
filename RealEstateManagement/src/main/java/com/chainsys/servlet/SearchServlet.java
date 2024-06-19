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

import com.chainsys.dao.RealEstateImplementation;
import com.chainsys.model.RealEstateUserRegister;


@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RealEstateImplementation estateImplementation = new RealEstateImplementation();
		RealEstateUserRegister estateUserRegister = new RealEstateUserRegister();
		
		List<RealEstateUserRegister> list = new ArrayList<RealEstateUserRegister>();
		String id = request.getParameter("generatedUserID");
		estateUserRegister.setGeneratedUserID(id);
		
		try
		{
			list = estateImplementation.search(id);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("UsersTable.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}
