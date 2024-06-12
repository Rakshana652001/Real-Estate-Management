<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.chainsys.model.RealEstatePropertyRegister" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Approved Properties</title>

</head>
<body>
<h4>Property Details</h4>
<a href="SellerWelcomePage.jsp"><button>Back to home</button></a>
<table border="1">
    <thead>
        <tr>
            <th>Seller ID</th>
            <th>Property Name</th>
            <th>Property ID</th>
            <th>Property Price</th>
            <th>Property Address</th>
            <th>Property Images</th>
            <th>Property Document Photo Copy</th>
            <th>Property District</th>
            <th>Property State</th>
            <th>Approval</th>
        </tr>
    </thead>
    <tbody>
        <% 
        ArrayList<RealEstatePropertyRegister> list = (ArrayList<RealEstatePropertyRegister>) request.getAttribute("list");
       	for (RealEstatePropertyRegister object : list)
             {
                 byte[] images = object.getPropertyImages();
                 String getImage;
                 getImage = Base64.getEncoder().encodeToString(images);
                 
                 byte[] document = object.getPropertyDocument();
                 String getDocument = Base64.getEncoder().encodeToString(document);
             
         %>
             <tr>
                 <td><%= object.getSellerId() %></td>
                 <td><%= object.getPropertyName() %></td>
                 <td><%= object.getPropertyId() %></td>
                 <td><%= object.getPropertyPrice() %></td>
                 <td><%= object.getPropertyAddress() %></td>
                 <td> 
                	<img alt="images" src="data:image/jpeg;base64,<%= getImage %> ">
                 </td>
                 <td>
                 	<img alt="document" src="data:image/jpeg;base64, <%=getDocument %>">
                 </td>
                 <td><%= object.getPropertyDistrict() %></td>
                 <td><%=object.getPropertyState() %></td>
                 <td><%=object.getApproval() %></td>
             </tr>
             
         <%
             }
            
   
            %>
     
    </tbody>
</table>
</body>
</html>
