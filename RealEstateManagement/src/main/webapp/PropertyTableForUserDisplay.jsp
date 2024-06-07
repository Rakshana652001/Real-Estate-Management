<%@ page import="java.util.Base64" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="com.chainsys.model.RealEstatePropertyRegister" %>
<%@ page import="com.chainsys.model.RealEstateUserRegister" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Properties Details</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
        background-color: #f9f9f9;
    }
    .container {
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
    }
    .card {
        width: 300px;
        margin: 20px;
        padding: 15px;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
        text-align: left;
    }
    .card:hover {
        box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
    }
    h3 {
        text-align: center;
        color: #333;
    }
    .details {
        margin-bottom: 10px;
    }
    .actions {
        text-align: center;
    }
    .btn-buy {
        background-color: #4CAF50;
        color: white;
        border: none;
        padding: 8px 16px;
        cursor: pointer;
        text-transform: uppercase;
    }
    .btn-buy:hover {
        background-color: #45a049;
    }
    img {
        max-width: 100%;
        height: auto;
    }
</style>
</head>
<body>
<h3>Property Details</h3>
<div class="container">
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
        <div class="card">
            <div class="details">
                <p><strong>Seller ID:</strong> <%= object.getSellerId() %></p>
                <p><strong>Property Name:</strong> <%= object.getPropertyName() %></p>
                <p><strong>Property ID:</strong> <%= object.getPropertyId() %></p>
                <p><strong>Property Price:</strong> <%= object.getPropertyPrice() %></p>
                <p>
                <% if (!getImage.isEmpty()) { %>
                        <img alt="images" src="data:image/jpg;base64,<%= getImage %> ">
                    <% } else { %>
                        No Image
                    <% } %>
                </p> 
                <p><strong>Property Address:</strong> <%= object.getPropertyAddress() %></p>
                <p><strong>Property District:</strong> <%= object.getPropertyDistrict() %></p>
                <p><strong>Property State:</strong> <%= object.getPropertyState() %></p>
            </div>
            <div class="actions">
                <form action="BuyNowForm.jsp" method="post">
                    <input type="hidden" name="propertyId" value="<%= object.getPropertyId() %>">
                    <input type="hidden" name="propertyName" value="<%= object.getPropertyName() %>">
                    <input type="hidden" name="propertyAddress" value="<%= object.getPropertyAddress() %>">
                    <input type="hidden" name="propertyPrice" value="<%= object.getPropertyPrice() %>">
                    <input type="submit" class="btn-buy" name="buy" value="Buy Now">
                </form>
            </div>
        </div>
    <% 
        }
    } else { 
    %>
        <p>No properties found</p>
    <% 
    } 
    %>
</div>
</body>
</html>
