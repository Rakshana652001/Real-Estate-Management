package com.chainsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.chainsys.model.RealEstatePropertyRegister;
import com.chainsys.model.RealEstateUserRegister;


@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RealEstateUserRegister estateUserRegister = new RealEstateUserRegister();
	RealEstateImplementation objectForImplementation = new RealEstateImplementation();
	List<RealEstateUserRegister> list = new ArrayList<RealEstateUserRegister>();
	
	
	
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		estateUserRegister.setName(name);
		
		String designation = request.getParameter("designation");
		estateUserRegister.setDesignation(designation);
		
		String emailID = request.getParameter("emailID");
		estateUserRegister.setEmailID(emailID);
		
		String phoneNumber = request.getParameter("phoneNumber");
		long phonenumber = Long.parseLong(phoneNumber);
		estateUserRegister.setPhoneNumber(phonenumber);
		
		String password = request.getParameter("password");
		estateUserRegister.setPassword(password);
		
		String address = request.getParameter("address");
		estateUserRegister.setAddress(address);
		
		String district = request.getParameter("district");
		estateUserRegister.setDistrict(district);
		
		String state = request.getParameter("state");
		estateUserRegister.setState(state);
		
		String generatedUserID = request.getParameter("generatedUserID");
		estateUserRegister.setGeneratedUserID(generatedUserID);
		
		HttpSession httpSession = request.getSession();
		try
		{
			System.out.println("Inside session");
			httpSession.setAttribute("userData", estateUserRegister);
			objectForImplementation.userRegistration(estateUserRegister);
			response.sendRedirect("AfterRegister.jsp");
				
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("Do Post");
		String delete = request.getParameter("delete");
        if(delete != null && delete.equals("Delete"))
        {
            String name=request.getParameter("deleteName");
            estateUserRegister.setName(name);
            try
            {
            	objectForImplementation.deleteDetails(estateUserRegister);
            	List<RealEstateUserRegister> list = objectForImplementation.retriveUserDetails(estateUserRegister);
            	request.setAttribute("list", list);
            	request.getRequestDispatcher("UserRegistrationTable.jsp").forward(request, response);
            	System.out.println("Deleted and displayed");
            	
            }
            catch (Exception e)
            {
            	e.printStackTrace();
			}
        }	
        
	}

}
