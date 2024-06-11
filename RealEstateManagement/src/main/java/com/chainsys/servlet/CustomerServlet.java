package com.chainsys.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.dao.RealEstateImplementation;
import com.chainsys.model.RealEstateUserRegister;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    RealEstateUserRegister estateUserRegister = new RealEstateUserRegister();
    RealEstateImplementation estateImplementation = new RealEstateImplementation();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id = request.getParameter("id");
		estateUserRegister.setGeneratedUserID(id);
		
		String password = request.getParameter("password");
		estateUserRegister.setPassword(password);
		
		HttpSession httpSession = request.getSession();
		try
		{
			if(id.equals(estateImplementation.getCustomerGeneratedId(id)))
			{
				if(password.equals(estateImplementation.getCustomerPassword(id)))
				{
					httpSession.setAttribute("id", id);
					response.sendRedirect("CustomerWelcomePage.jsp");
				}
				else
				{
					response.sendRedirect("CustomerLogin.jsp");
				}
			}
			else
			{
				response.sendRedirect("CustomerLogin.jsp");
			}
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
