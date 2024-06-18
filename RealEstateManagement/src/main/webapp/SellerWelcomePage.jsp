<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="xml:lang">
<head>
<meta charset="ISO-8859-1">
<title>Seller Page</title>
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
        font-size: 18px;
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
        <a href="SellerProfileServlet">Profile</a>
        <a href="PropertyRegistration.jsp">Register a property</a>
        <a href="PropertyTableServlet">Registered Properties</a>
        <a href="PaidServlet">Paid Properties</a>
        <a href="WelcomePage.jsp">Logout</a>
    </div>
    <div class="content">
        <h1>Welcome to the Seller Dashboard</h1>
    </div>
</body>
<body>
</html>