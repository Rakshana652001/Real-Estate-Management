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


@WebServlet("/AllPropertyServlet")
public class AllPropertyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RealEstatePropertyImplementation estatePropertyImplementation = new RealEstatePropertyImplementation();
		String getId;
		List<RealEstatePropertyRegister> list = new ArrayList<RealEstatePropertyRegister>();
		HttpSession httpSession = request.getSession();
		try
		{
			getId = (String)httpSession.getAttribute("id");
			list = estatePropertyImplementation.retriveAllSellerDetails(getId);
			request.setAttribute("list", list);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("RegisteredPropertyAdminView.jsp");
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
