package com.chainsys.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import com.chainsys.dao.RealEstatePropertyImplementation;
import com.chainsys.model.RealEstatePropertyRegister;


@WebServlet("/PropertyServlet")
@MultipartConfig
public class PropertyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    RealEstatePropertyRegister estatePropertyRegister = new RealEstatePropertyRegister();
    RealEstatePropertyImplementation estatePropertyImplementation = new RealEstatePropertyImplementation();

    @SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	byte[] data=null;
        String sellerId = request.getParameter("sellerId");
        estatePropertyRegister.setSellerId(sellerId);

        String propertyName = request.getParameter("propertyName");
        estatePropertyRegister.setPropertyName(propertyName);

        String propertyId = request.getParameter("propertyId");
        estatePropertyRegister.setPropertyId(propertyId);

        String propertyPrice = request.getParameter("propertyPrice");
        long propertyprice = Long.parseLong(propertyPrice);
        estatePropertyRegister.setPropertyPrice(propertyprice);

        
        Part file=request.getPart("propertyImage");
        String imageFilename=file.getSubmittedFileName();
        String uploadPath = "C:/Users/raks3556/git/repository7/RealEstateManagement/src/main/webapp/Images" + imageFilename;
        
        try
        {
            FileOutputStream fos=new FileOutputStream(uploadPath);
            InputStream is=file.getInputStream();

            data=new byte[(is.available())];
            is.read(data);
            fos.write(data);
            fos.close();
            
        }
        catch(NumberFormatException e)
        {
            e.printStackTrace();
        }
        estatePropertyRegister.setPropertyImages(data);

              
       
        String propertyAddress = request.getParameter("propertyAddress");
        estatePropertyRegister.setPropertyAddress(propertyAddress);

        String propertyDistrict = request.getParameter("propertyDistrict");
        estatePropertyRegister.setPropertyDistrict(propertyDistrict);

        String propertyState = request.getParameter("propertyState");
        estatePropertyRegister.setPropertyState(propertyState);
        
        String approve = "Not Approved";

        HttpSession httpSession = request.getSession();

        try 
        {
            estatePropertyImplementation.saveProperties(approve);
            System.out.println("Inside Session");
            httpSession.setAttribute("sellerId", sellerId);
            response.sendRedirect("SellerWelcomePage.jsp");
        }
        catch (Exception e) 
        {
            System.out.println(e);
            response.sendRedirect("PropertyRegistration.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
