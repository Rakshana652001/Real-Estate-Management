<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.chainsys.model.RealEstatePropertyRegister" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Properties Registration Details</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
        background-color: #f9f9f9;
    }
    h4 {
        text-align: center;
        color: #333;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin: 20px 0;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    th, td {
        padding: 12px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    th {
        background-color: #f2f2f2;
        color: #333;
        text-transform: uppercase;
    }
    tr:hover {
        background-color: #f1f1f1;
    }
    form {
        margin: 0;
    }
    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        border: none;
        padding: 8px 16px;
        cursor: pointer;
        text-transform: uppercase;
    }
    input[type="submit"]:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
<h4>Property Details</h4>
<table>
    <thead>
        <tr>
            <th>Seller ID</th>
            <th>Property Name</th>
            <th>Property ID</th>
            <th>Property Price</th>
            <th>Property Address</th>
            <th>Property Images</th>
            <th>Property District</th>
            <th>Property State</th>
            <th>Delete</th>
        </tr>
    </thead>
    <tbody>
        <% 
        ArrayList<RealEstatePropertyRegister> list = (ArrayList<RealEstatePropertyRegister>) request.getAttribute("list");
        if (list != null) {
            for (RealEstatePropertyRegister object : list) {
                byte[] images = object.getPropertyImages();
                String getImage = "";
                if (images != null) {
                    getImage = Base64.getEncoder().encodeToString(images);
                }
        %>
            <tr>
                <td><%= object.getSellerId() %></td>
                <td><%= object.getPropertyName() %></td>
                <td><%= object.getPropertyId() %></td>
                <td><%= object.getPropertyPrice() %></td>
                <td><%= object.getPropertyAddress() %></td>
                <td> 
                    <% if (!getImage.isEmpty()) { %>
                        <img alt="images" src="data:image/*;base64,<%= getImage %> ">
                    <% } else { %>
                        No Image
                    <% } %>
                </td>
                <td><%= object.getPropertyDistrict() %></td>
                <td><%= object.getPropertyState() %></td>
                <td>
                    <form action="UserServlet" method="post">
                        <input type="hidden" name="deleteId" value="<%= object.getPropertyId() %>">
                        <input type="submit" name="delete" value="Delete">
                    </form>
                </td>
            </tr>
        <% 
            }
        } else { 
        %>
            <tr>
                <td colspan="9">No properties found</td>
            </tr>
        <% 
        } 
        %>
    </tbody>
</table>
</body>
</html>
