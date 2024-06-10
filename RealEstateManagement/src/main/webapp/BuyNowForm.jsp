<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buy Now</title>

</head>
<body>
<div class="container">
    <h3>Buy Now Form</h3>
    <form action="ProcessPurchaseServlet" method="post">
            <label for="fullName">Full Name <input type="text" id="fullName" name="fullName" placeholder="Rakshana" required></label><br><br>
            <label for="contactNumber">Contact Number <input type="text" id="contactNumber" name="contactNumber" placeholder="7229364774" required></label><br><br>
            <label for="address">Current Address <textarea id="address" name="address" rows="3" placeholder="Door No, Street name, Landmark, city" required></textarea></label><br><br>
            <label for="governmentId">Government ID  <input type="text" id="governmentId" name="governmentId" placeholder="PAN/Aadhar Card" required></label><br><br>
            <label for="propertyId">Property ID <input type="text" id="propertyId" name="propertyId" value="<%= request.getParameter("propertyId") %>" readonly></label><br><br>
            <label for="propertyName">Property Name <input type="text" id="propertyName" name="propertyName" value="<%= request.getParameter("propertyName") %>" readonly></label><br><br>
            <label for="propertyAddress">Property Address <input type="text" id="propertyAddress" name="propertyAddress" value="<%= request.getParameter("propertyAddress") %>" readonly></label><br><br>
        	<label for="propertyPrice">Property Price <input type="text" id="propertyPrice" name="propertyPrice" value="<%= request.getParameter("propertyPrice") %>" readonly></label><br><br>
            <label for="paymentMethod">Payment Method</label>
            <select id="paymentMethod" name="paymentMethod" required>
                <option value="bankTransfer">Bank Transfer</option>
                <option value="UPI">UPI</option>
                <option value="QR">QR</option>
                <option value="creditCard">Credit/Debit Card</option>
            </select>
        	<label for="amount">Amount</label>
            <input type="text" id="amount" name="amount" value="<%= request.getParameter("propertyPrice") %>" readonly>
      		<input type="checkbox" id="terms" name="terms" required>
            <label for="terms">I agree to the terms and conditions</label>
            <label for="privacyPolicy">I agree to the privacy policy</label>
            <button type="submit">Submit</button>
    </form>
</div>
</body>
</html>
