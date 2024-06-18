<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Admin Welcome Page</title>
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
        <a href="AdminProfileServlet">Profile</a>
        <a href="SellerCustomerServlet">Users</a>
        <a href="AllPropertyServlet">Seller Properties (Unapproved)</a>
        <a href="ApprovedServlet">Seller Properties (Approved)</a>
        <a href="ApproveToBuyServlet">Customer Properties (Unapprove)</a>
        <a href="RegisteredPropertiesServlet">Saled Properties</a>
        <a href="WelcomePage.jsp">Logout</a>
    </div>
    <div class="content">
        <h1>Welcome to the Admin Dashboard</h1>
    </div>
</body>
</html>