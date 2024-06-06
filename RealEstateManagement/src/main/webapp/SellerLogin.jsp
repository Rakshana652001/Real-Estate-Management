<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="SellerServlet" method="get">
	<h4>Seller Login</h4>
	<label>ID: <input type="text" name="id" placeholder="Enter the code given by the company" required/></label><br><br>
	<label>Password: <input type="password" name="password" placeholder="Rakshana@12" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required/></label><br><br>
	<button>Login</button>
</form>
</body>
</html>