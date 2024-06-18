<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="xml:lang">
<head>
<meta charset="ISO-8859-1">
<title>Customer Welcome Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: grey;
        background-position: center;
        margin: 0;
        padding: 0;
    }
    .navbar {
        display: flex;
        justify-content: center;
        align-items: center;
        background-color: #333;
        padding: 10px;
    }
    .navbar a {
        color: white;
        text-align: center;
        padding: 14px 20px;
        text-decoration: none;
        font-size: 20px;
        margin: 0 10px;
    }
    .navbar a:hover {
        background-color: #ddd;
        color: black;
    }
    .content {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    h1{
    color:white;
    }
</style>
</head>
<body>
	<div class="navbar">
		<a href="CustomerProfileServlet">Profile</a>
		<a href="RegisterdPropertiesServlet">Properties Registered to Buy</a>
		<a href="RegisterBuyPropertiesServlet">Approved Properties to Buy</a>
		<a href="BuyedPropertiesServlet">Buyed Properties</a>
		<a href="WelcomePage.jsp">Go to Home Page</a>
		<a href="WelcomePage.jsp">Log Out</a>
	</div>
    <div class="content">
    	<h1>Welcome to Customer Dashboard</h1>
    </div>
</body>
</html>