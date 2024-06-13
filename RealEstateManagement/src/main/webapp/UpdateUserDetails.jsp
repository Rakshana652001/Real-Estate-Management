<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="xml:lang">
<head>
<meta charset="ISO-8859-1">
<title>Update User Details</title>

</head>
<body>
<form action="UpdateServlet">
	<label for="name">Name: <input type="text" id="name" name="name" placeholder="Rakshana" required/></label>
	<label for="phoneNumber">Phone Number: <input type="tel" id="phoneNumber" name="phoneNumber" placeholder="7339263883" pattern="[789][0-9]{9}" required/></label>
    <label for="emailID">EmailID: <input type="email" id="emailID" name="emailID" placeholder="raksha@gmail.com" required/></label>
    <label for="password">Password: <input type="password" id="password" name="password" placeholder="Rakshana@12" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required/></label>
    <label for="address">Address: <textarea id="address" name="address" rows="4" cols="50"></textarea></label>
    <label for="district">District: <input type="text" id="district" name="district" placeholder="Madurai" required/></label>
    <label for="state">State: <input type="text" id="state" name="state" placeholder="Tamil Nadu" required/></label>
    
    <input type="hidden" name="name" value="<%=request.getParameter("editName") %>">
    <button>Update</button>
</form>
</body>
</html>