<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.chainsys.model.RealEstatePropertyRegister" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Properties Registration Details</title>
</head>
<body>
<h4>Property Details</h4>
<table border="1">
    <thead>
        <tr>
            <th>Seller ID</th>
            <th>Property Name</th>
            <th>Property ID</th>
            <th>Property Price</th>
            <th>Property Address</th>
            <th>Property District</th>
            <th>Property State</th>
            <th>Delete</th>
            <th>Approve</th>
        </tr>
    </thead>
    <tbody>
        <% 
        ArrayList<RealEstatePropertyRegister> list = (ArrayList<RealEstatePropertyRegister>) request.getAttribute("list");
        for (RealEstatePropertyRegister object : list) {
        %>
        <tr>
            <td><%= object.getSellerId() %></td>
            <td><%= object.getPropertyName() %></td>
            <td><%= object.getPropertyId() %></td>
            <td><%= object.getPropertyPrice() %></td>
            <td><%= object.getPropertyAddress() %></td>
            <td><%= object.getPropertyDistrict() %></td>
            <td><%= object.getPropertyState() %></td>
            <td>
                <form action="UserServlet" method="post">
                    <input type="hidden" name="deleteId" value="<%= object.getPropertyId() %>">
                    <input type="submit" name="delete" value="Delete">
                </form>
            </td>
            <td>
                <form action="Servlet" method="post">
                    <input type="hidden" name="approveId" value="<%= object.getPropertyId() %>">
                    <input type="submit" name="approve" value="Approve">
                </form>
            </td>
        </tr>
        <% 
        } 
        %>
    </tbody>
</table>
</body>
</html>
 --%>