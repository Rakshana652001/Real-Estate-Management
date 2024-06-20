<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.chainsys.model.RealEstatePropertyRegister" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Authorized Properties</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: grey;
    margin: 0;
    padding: 20px;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    color: #333;
    width: 100%;
}

h3 {
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

button, .btn-action, input[type="submit"] {
    padding: 10px;
    border: none;
    border-radius: 4px;
    background-color: #000100;
    color: white;
    cursor: pointer;
    margin: 5px;
}

button:hover, .btn-action:hover, input[type="submit"]:hover {
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
<h3>Authorized Properties</h3>
<a href="AdminWelcomePage.jsp"><button>Back to home</button></a>

<table border="1">
    <thead>
        <tr>
            <th>Seller ID</th>
            <th>Registered Date</th>
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
        </tr>
    </thead>
    <tbody>
        <% 
        ArrayList<RealEstatePropertyRegister> list = (ArrayList<RealEstatePropertyRegister>) request.getAttribute("list");
       	for (RealEstatePropertyRegister object : list)
             {
                 byte[] images = object.getPropertyImages();
                 String getImage = Base64.getEncoder().encodeToString(images);
                 
                 byte[] documents = object.getPropertyDocument();
                 String getDocuments = Base64.getEncoder().encodeToString(documents);
              
             
         %>
             <tr>
                 <td><%= object.getSellerId() %></td>
                 <td><%=object.getRegisteredDate() %></td>
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
                 <td><%=object.getPropertyState() %></td>
                 <td><%=object.getApproval() %></td>
                 <td>
                 	<form action="RegisterStatusUpdateServlet">
                 	<input type="hidden" name="address" value="<%=object.getPropertyAddress() %>">
                 		<select name="registerStatus">
                 		
                             <option value="Select">Select</option>
                             <option value="Registered">Registered</option>
                             <option value="Not Registered">Not Registered</option>
                         </select>
                         <input type="submit" value="Submit">
                 	</form>
                 </td>
             </tr>
             
         <% } %>
    </tbody>
</table>
</body>
</html>
