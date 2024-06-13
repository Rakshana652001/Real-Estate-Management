<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="xml:lang">
<head>
<meta charset="ISO-8859-1">
<title>Admin Welcome Page</title>
<style>
    body {
    font-family: Arial, sans-serif;
    background-color: grey;
    background-position: center;
    position: relative;
    color: #333;
    justify-content: center;
    display: flex;
    align-items: center;
    height: 100vh;
	}
    form {
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    .btn {
        width: 300px;
        margin: 10px;
        padding: 10px 20px;
        font-size: 16px;
        cursor: pointer;
        text-align: center;
    }
</style>
</head>
<body>
    <form>
        <button type="button" class="btn" onclick="location.href='AdminProfileServlet'">Profile</button>
        <button type="button" class="btn" onclick="location.href='SellerCustomerServlet'">Users</button>
        <button type="button" class="btn" onclick="location.href='AllPropertyServlet'">Seller Properties(Unapproved)</button>
        <button type="button" class="btn" onclick="location.href='ApprovedServlet'">Seller Properties(Approved)</button>
        <button type="button" class="btn" onclick="location.href='ApproveToBuyServlet'">Customer Properties(Unapprove)</button>
        <button type="button" class="btn" onclick="location.href='ApprovedPropertiesServlet'">Customer Properties(Approved and Payment Status)</button>
        <button type="button" class="btn" onclick="location.href='RegisteredPropertiesServlet'">Registered Properties</button>
        <button type="button" class="btn" onclick="location.href='WelcomePage.jsp'">Logout</button>
    </form>
</body>
</html>
