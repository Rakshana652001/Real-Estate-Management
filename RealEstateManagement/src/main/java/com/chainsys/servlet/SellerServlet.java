package com.chainsys.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.dao.RealEstateImplementation;
import com.chainsys.dao.RealEstatePropertyImplementation;
import com.chainsys.model.RealEstatePropertyRegister;
import com.chainsys.model.RealEstateUserRegister;


@WebServlet("/SellerServlet")
public class SellerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RealEstateUserRegister objectForPojo = new RealEstateUserRegister();
	RealEstateImplementation objectForImplementation = new RealEstateImplementation();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id = request.getParameter("id");
		objectForPojo.setGeneratedUserID(id);
		System.out.println(id);
		
		String password = request.getParameter("password");
		objectForPojo.setPassword(password);
		System.out.println(password);
		
		
		HttpSession httpSession = request.getSession();
		try
		{
			if(id.equals(objectForImplementation.getGeneratedSellerId(id)))
			{
				if(password.equals(objectForImplementation.getsellerPassword(id)))
				{
					System.out.println("Inside session");
					httpSession.setAttribute("id", id);					
					response.sendRedirect("SellerWelcomePage.jsp");
					System.out.println("Successfully Logged In");
				}
				else
				{
					System.out.println("Enter Correct Password");
					response.sendRedirect("SellerLogin.jsp");
				}
			}
			else
			{
				System.out.println("Enter correct id");
				response.sendRedirect("SellerLogin.jsp");
			}
			
		}
		
		catch (Exception e) 
		{
			// TODO: handle exception
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RealEstatePropertyImplementation estatePropertyImplementation = new RealEstatePropertyImplementation();
		RealEstatePropertyRegister estatePropertyRegister = new RealEstatePropertyRegister();
		System.out.println("Do Post");
		String delete = request.getParameter("delete");
        if(delete != null && delete.equals("Delete"))
        {
            String id=request.getParameter("deleteId");
            estatePropertyRegister.setPropertyId(id);
            try
            {
            	estatePropertyImplementation.deleteDetails(estatePropertyRegister);
            	List<RealEstatePropertyRegister> list = estatePropertyImplementation.retriveDetails(id);
            	request.setAttribute("list", list);
            	request.getRequestDispatcher("PropertyRegistrationTable.jsp").forward(request, response);
            	System.out.println("Deleted and displayed");
            	
            }
            catch (Exception e)
            {
            	e.printStackTrace();
			}
        }
	}

}
