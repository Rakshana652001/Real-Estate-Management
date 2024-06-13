<%@ page import="java.util.Base64" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="com.chainsys.model.RealEstatePropertyRegister" %>
<%@ page import="com.chainsys.model.RealEstateUserRegister" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="xml:lang">
<head>
<meta charset="ISO-8859-1">
<title>Properties Details</title>

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
                <form action="BuyNowForm.jsp" method="post">
                    <input type="hidden" name="propertyId" value="<%= object.getPropertyId() %>">
                    <input type="hidden" name="propertyName" value="<%= object.getPropertyName() %>">
                    <input type="hidden" name="propertyAddress" value="<%= object.getPropertyAddress() %>">
                    <input type="hidden" name="propertyPrice" value="<%= object.getPropertyPrice() %>">
            
                    <input type="submit" class="btn-buy" name="buy" value="Register"><br><br>
                </form>
                <form action="WelcomePage.jsp"><button>Back to Home</button></form>
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
