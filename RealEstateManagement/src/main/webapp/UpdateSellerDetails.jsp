<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="UpdateSellerServlet" method="post">
<label>Name: <input type="text" name= "sellerName" placeholder="Rakshana"></label>
<label>Phone Number: <input type="tel" name="sellerPhoneNumber" placeholder="7339263883" pattern="[789][0-9]{9}"></label>
<label>EmailID: <input type="email" name="sellerEmailID" placeholder="raksha@gmail.com" pattern= "[a-z0-9_/-/.]+[@][a-z]+[/.][a-z]{2,3}"></label>
<label>Password: <input type="password" name="sellerPassword" placeholder="Rakshana@12" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"></label>
<label>Account Number: <input type="number" name="sellerAccountNumber" placeholder="67392537489" pattern="\d{11}"></label>

<input type="hidden" name="name" value="<%=request.getParameter("editName") %>">
<button>Update</button>
</form>

</body>
</html>