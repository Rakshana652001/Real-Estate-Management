<%@page import="com.chainsys.model.RealEstateUserRegister"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Login</title>
<style type="text/css">
body {
    font-family: Arial, sans-serif;
    background-color: grey;
    background-size: cover;
 	background-position: center;
  	position: relative;
    color: #333;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.container {
    max-width: 400px;
    width: 100%;
    padding: 20px;
    background: #fff;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h3 {
    text-align: center;
    margin-bottom: 20px;
    color: white;
}

form {
    display: flex;
    flex-direction: column;
    flex-direction: column;
}

label {
    margin-bottom: 10px;
    color: white;
}

input[type="text"], input[type="password"] {
    width: 100%;
    padding: 10px;
    margin-top: 5px;
    border: 1px solid #ddd;
    border-radius: 4px;
    background-color: #f4f4f4;
    box-sizing: border-box;
}

button {
    padding: 10px 20px;
    margin-top: 20px;
    border: none;
    border-radius: 4px;
    background-color: #000100;
    color: white;
    font-size: 16px;
    cursor: pointer;
}

button:hover {
    background-color: #000100;
}

</style>
</head>
<body>
<form action="CustomerServlet" method="post">
	<h3>Customer Login</h3>
	<label>ID: <input type="text" name="customerId" placeholder="Enter the code given by the company" required/></label><br><br>
	<label>Password: <input type="password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required/></label><br><br>
	<button>Login</button>
</form>
</body>
</html>