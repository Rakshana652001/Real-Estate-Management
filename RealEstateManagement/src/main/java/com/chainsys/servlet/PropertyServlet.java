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

@MultipartConfig
@WebServlet("/PropertyServlet")
public class PropertyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    RealEstatePropertyRegister estatePropertyRegister = new RealEstatePropertyRegister();
    RealEstatePropertyImplementation estatePropertyImplementation = new RealEstatePropertyImplementation();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sellerId = request.getParameter("sellerId");
        estatePropertyRegister.setSellerId(sellerId);

        String propertyName = request.getParameter("propertyName");
        estatePropertyRegister.setPropertyName(propertyName);

        String propertyId = request.getParameter("propertyId");
        estatePropertyRegister.setPropertyId(propertyId);

        String propertyPrice = request.getParameter("propertyPrice");
        long propertyprice = Long.parseLong(propertyPrice);
        estatePropertyRegister.setPropertyPrice(propertyprice);

        // File upload handling
        Part filePart = request.getPart("propertyImages");
        String fileName = filePart.getSubmittedFileName();
        String uploadPath = "C:/Users/raks3556/git/repository7/RealEstateManagement/src/main/webapp/Images/"
                + fileName; // Adjust this path as per your project structure

        try (InputStream fileContent = filePart.getInputStream();
             FileOutputStream fileOutputStream = new FileOutputStream(uploadPath)) {
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileContent.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            // Handle file upload exception
            e.printStackTrace();
        }

        // Set property images
        estatePropertyRegister.setPropertyImages(fileName.getBytes()); // Example, adjust this based on your actual requirement

        String propertyAddress = request.getParameter("propertyAddress");
        estatePropertyRegister.setPropertyAddress(propertyAddress);

        String propertyDistrict = request.getParameter("propertyDistrict");
        estatePropertyRegister.setPropertyDistrict(propertyDistrict);

        String propertyState = request.getParameter("propertyState");
        estatePropertyRegister.setPropertyState(propertyState);

        HttpSession httpSession = request.getSession();

        try {
            estatePropertyImplementation.saveProperties(estatePropertyRegister);
            System.out.println("Inside Session");
            httpSession.setAttribute("sellerId", sellerId);
            response.sendRedirect("SellerWelcomePage.jsp");
        } catch (Exception e) {
            System.out.println(e);
            response.sendRedirect("PropertyRegistration.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
