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
import com.chainsys.dao.RealEstateCustomerImplementation;
import com.chainsys.dao.RealEstatePropertyImplementation;
import com.chainsys.model.CustomerPurchasedProperty;

@WebServlet("/PurchaseServlet")
@MultipartConfig
public class PurchaseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerPurchasedProperty customerPurchasedProperty = new CustomerPurchasedProperty();

        String customerId = request.getParameter("customerId");
        customerPurchasedProperty.setCustomerId(customerId);

        Part file = request.getPart("governmentId");
        String submittedFile = file.getSubmittedFileName();
        String uploadPath = "C:/Users/raks3556/git/repository7/RealEstateManagement/src/main/webapp/GovermentIdProof/" + submittedFile;

        try (InputStream inputStream = file.getInputStream();
             FileOutputStream fileOutputStream = new FileOutputStream(uploadPath)) {

            byte[] data = inputStream.readAllBytes();
            fileOutputStream.write(data);
            customerPurchasedProperty.setGovernmentId(data);

        } catch (Exception e) {
            System.out.println("File upload error: " + e.getMessage());
        }

        String propertyId = request.getParameter("propertyId");
        customerPurchasedProperty.setPropertyId(propertyId);
        
        String sellerId = request.getParameter("sellerId");
        customerPurchasedProperty.setSellerId(sellerId);

        String propertyName = request.getParameter("propertyName");
        customerPurchasedProperty.setPropertyName(propertyName);

        String propertyAddress = request.getParameter("propertyAddress");
        customerPurchasedProperty.setPropertyAddress(propertyAddress);

        String propertyPrice = request.getParameter("propertyPrice");
        long price = Long.parseLong(propertyPrice);
        customerPurchasedProperty.setPropertyPrice(price);
        
        String payableAmount = request.getParameter("payableAmount");
        Double amountFirstPay = Double.parseDouble(payableAmount);
        customerPurchasedProperty.setPayableAmount(amountFirstPay);

        String paymentMethod = request.getParameter("paymentMethod");
        customerPurchasedProperty.setPaymentMethod(paymentMethod);

        HttpSession httpSession = request.getSession();
        RealEstateCustomerImplementation customerImplementation = new RealEstateCustomerImplementation();
        try {
            customerImplementation.saveProperties(customerPurchasedProperty);

            RealEstatePropertyImplementation estatePropertyImplementation = new RealEstatePropertyImplementation();
            estatePropertyImplementation.updateCustomerId(customerId, propertyAddress);
            httpSession.setAttribute("customerId", customerId);
            response.sendRedirect("CustomerWelcomePage.jsp");
        } catch (Exception e) {
            System.out.println("Database save error: " + e.getMessage());
            response.sendRedirect("BuyNowForm.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
