<%@page import="java.util.Base64" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="com.chainsys.model.RealEstatePropertyRegister" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Properties Details</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: grey;
        margin: 0;
        padding: 0;
    }
    h3 {
        text-align: center;
        margin-top: 20px;
        color: white;
    }
    .container {
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        padding: 20px;
    }
    .card {
        background-color: white;
        border: 1px solid #ddd;
        border-radius: 8px;
        box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        margin: 15px;
        padding: 20px;
        width: 300px;
        box-sizing: border-box;
    }
    .details {
        margin-bottom: 20px;
    }
    .details p {
        margin: 5px 0;
        color: black;
    }
    .details img {
        max-width: 100%;
        height: auto;
        border-radius: 5px;
    }
    .actions {
        text-align: center;
    }
    .actions form {
        margin: 0;
    }
    .btn-buy {
        background-color: black;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
        margin-top: 10px;
    }
    .btn-buy:hover {
        background-color: grey;
    }
    .no-properties {
        text-align: center;
        color: #999;
        font-size: 18px;
        margin-top: 20px;
    }
    form[action="WelcomePage.jsp"] {
        display: flex;
        justify-content: center;
        margin: 20px 0;
    }
    form[action="WelcomePage.jsp"] button {
        background-color: black;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
    }
</style>
</head>
<body>
<h3>Property Details</h3>
<form action="WelcomePage.jsp" style="flex: 1;">
   <button>Back to Home</button>
</form>
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
                    <img alt="img" src="data:image/jpg;base64,<%= getImage %> ">
                <% } else { %>
                    No Image
                <% } %>
                </p>
                <p><strong>Property Address:</strong> <%= object.getPropertyAddress() %></p>
                <p><strong>Property District:</strong> <%= object.getPropertyDistrict() %></p>
                <p><strong>Property State:</strong> <%= object.getPropertyState() %></p>
            </div>
            <div class="actions">
                <form action="BuyNowForm.jsp" method="post" style="flex: 1;">
                	<input type="hidden" name="sellerId" value="<%= object.getSellerId()%>">
                    <input type="hidden" name="propertyId" value="<%= object.getPropertyId() %>">
                    <input type="hidden" name="propertyName" value="<%= object.getPropertyName() %>">
                    <input type="hidden" name="propertyAddress" value="<%= object.getPropertyAddress() %>">
                    <input type="hidden" name="propertyPrice" value="<%= object.getPropertyPrice() %>">
                    <input type="submit" class="btn-buy" name="buy" value="Register">
                </form>
            </div>
        </div>
    <% 
        }
    } else { 
    %>
        <p class="no-properties">No properties found</p>
    <% 
    } 
    %>
</div>
</body>
</html>
