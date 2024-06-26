<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="xml:lang">
<head>
<meta charset="ISO-8859-1">
<title>Seller Login</title>
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
    border: 12px solid white;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    box-sizing: border-box;
}

h3 {
    text-align: center;
    margin-bottom: 20px;
    color: black;
}

form {
    display: flex;
    flex-direction: column;
}

label {
    margin-bottom: 10px;
    color: black;
    display: block;
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
    background-color: #333;
}

</style>
</head>
<body>
<div class="container">
    <form action="SellerServlet" method="get">
        <h3>Seller Login</h3>
        <label for="id">ID:</label>
        <input type="text" id="id" name="id" placeholder="Enter the code given by the company" required/>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" placeholder="Rakshana@12" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required/>
        
        <button type="submit">Login</button>
    </form>
</div>
</body>
</html>
