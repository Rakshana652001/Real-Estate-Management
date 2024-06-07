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
            <label for="fullName">Full Name <input type="text" id="fullName" name="fullName" required></label><br><br>
            <label for="contactNumber">Contact Number <input type="text" id="contactNumber" name="contactNumber" required></label><br><br>
            <label for="email">Email Address <input type="email" id="email" name="email" required></label><br><br>
            <label for="address">Current Address <textarea id="address" name="address" rows="3" required></textarea></label><br><br>
            <label for="governmentId">Government ID  <input type="text" id="governmentId" name="governmentId" required></label><br><br>
            <label for="propertyId">Property ID <input type="text" id="propertyId" name="propertyId" value="<%= request.getParameter("propertyId") %>" readonly></label><br><br>
            <label for="propertyName">Property Name <input type="text" id="propertyName" name="propertyName" value="<%= request.getParameter("propertyName") %>" readonly></label><br><br>
            <label for="propertyAddress">Property Address <input type="text" id="propertyAddress" name="propertyAddress" value="<%= request.getParameter("propertyAddress") %>" readonly></label><br><br>
        	<label for="propertyPrice">Property Price <input type="text" id="propertyPrice" name="propertyPrice" value="<%= request.getParameter("propertyPrice") %>" readonly></label><br><br>
            <label for="paymentMethod">Payment Method</label>
            <select id="paymentMethod" name="paymentMethod" required>
                <option value="bankTransfer">Bank Transfer</option>
                <option value="creditCard">Credit/Debit Card</option>
            </select>
        	<label for="amount">Amount</label>
            <input type="text" id="amount" name="amount" value="<%= request.getParameter("propertyPrice") %>" readonly>
      		<input type="checkbox" id="terms" name="terms" required>
            <label for="terms">I agree to the terms and conditions</label>
            <input type="checkbox" id="privacyPolicy" name="privacyPolicy" required>
            <label for="privacyPolicy">I agree to the privacy policy</label>
            <label for="comments">Comments or Special Instructions</label>
            <textarea id="comments" name="comments" rows="3"></textarea>
            <button type="submit">Submit</button>
        </div>
    </form>
</div>
</body>
</html>
