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
        height: 100%;
        overflow: hidden;
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
        font-size: 17px;
        margin: 0 10px;
    }
    .navbar a:hover {
        background-color: #ddd;
        color: black;
    }
    .dropdown {
        position: relative;
        display: inline-block;
    }
    .dropdown-content {
        display: none;
        position: absolute;
        background-color: #f9f9f9;
        min-width: 160px;
        box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        z-index: 1;
    }
    .dropdown-content a {
        color: white;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
    }
    .dropdown:hover .dropdown-content {
        display: block;
        background: #333;
    }
    .dropdown:hover .dropbtn {
        background-color: #ddd;
        color: black;
    }
    .content {
        display: flex;
        justify-content: center;
        align-items: center;
        height: calc(100vh - 50px); /* Adjusted to account for navbar height */
    }
    h1 {
        font-family: "Times New Roman", Times, serif;
        color: white;
        display: flex;
        justify-content: center;
        align-items: center;
        font-size: 2rem;
    }
</style>
</head>
<body>
<section id="home" class="container mt-5">
    <h1 class="text-center">Urban Nest Realty</h1>
</section>
<div class="navbar">
    <a href="AdminProfileServlet">Profile</a>
    <div class="dropdown">
        <a href="javascript:void(0)" class="dropbtn">Clients</a>
        <div class="dropdown-content">
            <a href="SellerCustomerServlet">Seller</a>
            <a href="CustomersServlet">Customer</a>
        </div>
    </div>
    <div class="dropdown">
        <a href="javascript:void(0)" class="dropbtn">Seller Properties</a>
        <div class="dropdown-content">
            <a href="ApprovedServlet">Authorized</a>
            <a href="AllPropertyServlet">Pending</a>
        </div>
    </div>
    <a href="ApproveToBuyServlet">Payment Approval</a>
    <a href="RegisteredPropertiesServlet">Closed Deals</a>
    <a href="WelcomePage.jsp">Logout</a>
</div>
<div class="content">
    <h1>Welcome to the Admin Dashboard</h1>
</div>
</body>
</html>
