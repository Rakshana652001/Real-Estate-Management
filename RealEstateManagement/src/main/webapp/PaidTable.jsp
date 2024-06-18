<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.chainsys.model.CustomerPurchasedProperty" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="xml:lang">
<head>
<meta charset="ISO-8859-1">
<title>Registered Properties Still Not Approved</title>

</head>
<body>
<h3>Saled Properties (Contact Customer for further document registration process)</h3>
<table border="1">
    <thead>
        <tr>
            <th>Customer ID</th>
            <th>Property Address</th>
            <th>Government Id</th>
            <th>Property Total Amount</th>
            <th>Payment Method</th>
            <th>Approval Status</th>
            <th>Payment Status</th>
        </tr>
    </thead>
    <tbody>
        <% 
        ArrayList<CustomerPurchasedProperty> list = (ArrayList<CustomerPurchasedProperty>) request.getAttribute("list");
       	for (CustomerPurchasedProperty object : list)
             {
                 byte[] images = object.getGovernmentId();
                 String getImage;
                 getImage = Base64.getEncoder().encodeToString(images);
             
         %>
             <tr>
                 <td><%= object.getCustomerId() %></td>
                 <td><%=object.getPropertyAddress() %></td>
                 <td> 
                	<img alt="Residential" src="data:image/jpeg;base64,<%= getImage %> ">      
                 </td>
                 <td><%= object.getPropertyPrice() %></td>
                 <td><%= object.getPaymentMethod() %></td>
                 <td><%= object.getApproval() %></td>
                 <td><%=object.getPaymentStatus() %></td>
             </tr>
             
         <%
             }
            %>
     
    </tbody>
</table>
<a href="SellerWelcomePage.jsp"><button>Back to home</button></a>
</body>
</html>
