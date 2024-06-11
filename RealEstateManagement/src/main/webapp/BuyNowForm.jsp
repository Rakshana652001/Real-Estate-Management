<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buy Now</title>
</head>
<body>
<div class="container">
    <h3>Buy Now Form</h3>
    <form action="PurchaseServlet" method="post" enctype="multipart/form-data">
        <label for="customerId">Customer ID: <input type="text" name="customerId" placeholder="Enter the ID given when you registered" required/></label><br><br>
        <label for="governmentId">Government ID: <input type="file" id="governmentId" name="governmentId" required></label><br><br>
        <label for="propertyId">Property ID: <input type="text" id="propertyId" name="propertyId" value="<%= request.getParameter("propertyId") %>" readonly></label><br><br>
        <label for="propertyName">Property Name: <input type="text" id="propertyName" name="propertyName" value="<%= request.getParameter("propertyName") %>" readonly></label><br><br>
        <label for="propertyAddress">Property Address: <input type="text" id="propertyAddress" name="propertyAddress" value="<%= request.getParameter("propertyAddress") %>" readonly></label><br><br>
        <label for="propertyPrice">Property Price: <input type="text" id="propertyPrice" name="propertyPrice" value="<%= request.getParameter("propertyPrice") %>" readonly></label><br><br>
        <label for="paymentMethod">Payment Method</label>
        <select id="paymentMethod" name="paymentMethod" required>
            <option value="bankTransfer">Bank Transfer</option>
            <option value="UPI">UPI</option>
            <option value="QR">QR</option>
            <option value="creditCard">Credit/Debit Card</option>
        </select><br><br>
        <label for="monthlyEmi">Monthly EMI</label>
        <input type="text" id="monthlyEmi" name="monthlyEmi" required><br><br>
        <input type="checkbox" id="terms" name="terms" required>
        <label for="terms">I agree to the terms and conditions</label><br><br>
        
        <button type="submit">Submit</button>
    </form>
    <form action="WelcomePage.jsp">
        <button>Back to home</button>
    </form>
</div>
</body>
</html>
