<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.chainsys.model.RealEstateUserRegister" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Admin Profile</title>
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
    
    form[action="WelcomePage.jsp"] {
        display: flex;
        justify-content: center;
        margin: 20px 0;
    }
    
</style>
</head>
<body>
<h3>Profile</h3>
<div class="container">
	<% 
    ArrayList<RealEstateUserRegister> list = (ArrayList<RealEstateUserRegister>)request.getAttribute("list");
    for (RealEstateUserRegister object : list) { 
    %>
    <div class="card">
            	<p><strong>ID: </strong><%= object.getGeneratedUserID() %></p>
            	<p><strong>Name: </strong><%= object.getName() %></p>
            	<p><strong>Phone Number: </strong><%= object.getPhoneNumber() %></p>
            	<p><strong>Email ID: </strong><%= object.getEmailID() %></p>
            	<p><strong>Address: </strong><%= object.getAddress() %></p>
            	<p><strong>District: </strong><%= object.getDistrict() %></p>
            	<p><strong>State: </strong><%= object.getState() %></p>    
            	<input type="hidden" value="<%=object.getName() %>" name="name"><a href="UpdateAdminDetails.jsp?editName=<%=object.getName() %>"><button>Update</button></a>
            	<form action="UserServlet" method="post">
  				<input type="hidden" name="deleteName" value="<%= object.getName()%>">
  				<input type="submit" name="delete" value="Delete">
  				</form>
				<form action="AdminWelcomePage.jsp"><button>Back to Home</button></form>        	
   	</div>
	<% 
    } 
    %>
</div>
</body>
</html>
