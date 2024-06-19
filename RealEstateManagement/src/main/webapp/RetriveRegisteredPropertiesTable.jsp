<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.chainsys.model.RealEstatePropertyRegister" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="xml:lang">
<head>
<meta charset="ISO-8859-1">
<title>Closed Deals</title>
<style>
body 
{
    font-family: Arial, sans-serif;
    background-color: grey;
    margin: 0;
    padding: 20px;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    color: #333;
    width: 110%;
}

h3 
{
    text-align: center;
    margin-bottom: 20px;
    color: white;
}

.table-container {
    margin: 10px;
}

table {
    width: 100%;
    max-width: 1000px;
    border-collapse: collapse;
    background-color: white;
    border-radius: 8px;
    overflow: hidden;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

th, td {
    padding: 10px;
    text-align: left;
    border: 1px solid #ddd;
}

th {
    background-color: #f4f4f4;
}

td img {
    max-width: 100px;
    height: auto;
    display: block;
}

button, .btn-action, input {
    padding: 10px;
    border: none;
    border-radius: 4px;
    background-color: #000100;
    color: white;
    cursor: pointer;
    margin: 5px;
}
label{
color: white;
}
button:hover, .btn-action:hover, input:hover {
    background-color: #333;
}

.actions {
    display: flex;
    gap: 10px;
    justify-content: center;
}
</style>
</head>
<body>
<h3>Closed Deals</h3>
<a href="AdminWelcomePage.jsp"><button>Back to home</button></a>
<form action="SearchServlet" method="post">
	<label>Search <input type="text" name="id" placeholder="Search By Id"></label>
</form>
<table border="1">
    <thead>
        <tr>
            <th>Seller ID</th>
            <th>Registered Date</th>
            <th>Purchased Date</th>
            <th>Property Name</th>
            <th>Property ID</th>
            <th>Property Price</th>
            <th>Property Address</th>
            <th>Property Images</th>
            <th>Property Document Photo Copy</th>
            <th>Property District</th>
            <th>Property State</th>
            <th>Approval Status</th>
            <th>Register Status</th>
            <th>Payment Status</th>
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
                 
                 byte[] documents = object.getPropertyDocument();
                 String getDocuments = Base64.getEncoder().encodeToString(documents);
         %>
             <tr>
                 <td><%= object.getSellerId() %></td>
                 <td><%=object.getRegisteredDate() %></td>
                 <td><%=object.getPurchasedDate() %></td>
                 <td><%= object.getPropertyName() %></td>
                 <td><%= object.getPropertyId() %></td>
                 <td><%= object.getPropertyPrice() %></td>
                 <td><%= object.getPropertyAddress() %></td>
                 <td> 
                	<img alt="Residential" src="data:image/jpeg;base64,<%= getImage %> ">      
                 </td>
                 <td> 
                	<img alt="documents" src="data:image/jpeg;base64,<%= getDocuments %> ">      
                 </td>
                 <td><%= object.getPropertyDistrict() %></td>
                 <td><%= object.getPropertyState() %></td>
                 <td><%= object.getApproval() %></td>
                 <td><%= object.getRegistered() %></td>
                 <td><%=object.getPayment() %></td>
             </tr>
             
         <%
             }
            %>
     
    </tbody>
</table>
</body>
</html>
