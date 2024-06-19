<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="xml:lang">
<head>
<meta charset="ISO-8859-1">
<title>Update Customer Details</title>
<style>
    body{
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
     margin-top: 8rem;
    }
    #UpdateForm {
        background-color: white;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
        width: 90%;
        max-width: 400px;
        box-sizing: border-box;
    }
    label {
        display: block;
        margin-bottom: 10px;
    }
    input[type="tel"],
    input[type="password"],
    textarea {
        width: 100%;
        padding: 8px;
        margin-top: 5px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }
    .dropdown {
        position: relative;
        display: inline-block;
        margin-bottom: 15px;
        width: 100%;
    }
    .dropbtn {
        background-color: #f9f9f9;
        color: black;
        padding: 8px;
        font-size: 16px;
        border: none;
        cursor: pointer;
        width: 100%;
        text-align: left;
        box-sizing: border-box;
    }
    .dropdown-content {
        display: none;
        position: absolute;
        background-color: white;
        min-width: 100%;
        box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
        z-index: 1;
        box-sizing: border-box;
    }
    .dropdown-content button {
        color: black;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
        border: none;
        background-color: white;
        text-align: left;
        box-sizing: border-box;
    }
    .dropdown-content button:hover {
        background-color: #ddd;
    }
    .dropdown:hover .dropdown-content {
        display: block;
    }
    .button-group {
        display: flex;
        justify-content: space-between;
    }
    button {
        background-color: black;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        width: 48%;
        margin-top: 10px;
    }
    button:hover {
        background-color: #333;
    }
</style>
</head>
<body>
<form action="UpdateCustomerServlet" id="UpdateForm">
	<label for="phoneNumber">Phone Number: <input type="tel" id="phoneNumber" name="phoneNumber" placeholder="7339263883" pattern="[789][0-9]{9}" required/></label>
    <label for="password">Password: <input type="password" id="password" name="password" placeholder="Rakshana@12" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required/></label>
    <label for="address">Address: <textarea id="address" name="address" rows="4" cols="50"></textarea></label>
    <input type="hidden" name="name" value="<%=request.getParameter("editName") %>">
    <button>Update</button>
</form>
</body>
</html>