<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.chainsys.model.CustomerPurchasedProperty" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Completed Deals</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: grey;
    margin: 0;
    padding: 20px;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    color: #333;
}

h3 {
    text-align: center;
    margin-bottom: 20px;
    color: white;
}

.table-container {
    margin: 10px;
}

table {
    width: 100%;
    max-width: 1000px;
    border-collapse: collapse;
    background-color: white;
    border-radius: 8px;
    overflow: hidden;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

th, td {
    padding: 10px;
    text-align: left;
    border: 1px solid #ddd;
}

th {
    background-color: #f4f4f4;
}

td img {
    max-width: 100px;
    height: auto;
    display: block;
}

button, .btn-action, input[type="submit"] {
    padding: 10px;
    border: none;
    border-radius: 4px;
    background-color: #000100;
    color: white;
    cursor: pointer;
    margin: 5px;
}

button:hover, .btn-action:hover, input[type="submit"]:hover {
    background-color: #333;
}

.actions {
    display: flex;
    gap: 10px;
    justify-content: center;
}
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.3.1/jspdf.umd.min.js"></script>
<script>
    function generateReceipt(customerId, purchasedDate, propertyAddress, propertyPrice, paymentMethod, approvalStatus, paymentStatus)
    {
        const { jsPDF } = window.jspdf;
        const doc = new jsPDF();

        doc.text("Payment Receipt", 10, 10);
        doc.text("Customer ID: " + customerId, 10, 20);
        doc.text("Purchased Date: "+ purchasedDate, 10, 30)
        doc.text("Property Address: " + propertyAddress, 10, 40);
        doc.text("Property Total Amount: " + propertyPrice, 10, 50);
        doc.text("Payment Method: " + paymentMethod, 10, 60);
        doc.text("Approval Status: " + approvalStatus, 10, 70);
        doc.text("Payment Status: " + paymentStatus, 10, 80);

        doc.save("receipt_" + customerId + ".pdf");
    }
</script>
</head>
<body>
<h3>Completed Deals</h3>
<a href="SellerWelcomePage.jsp"><button>Back to home</button></a>

<table border="1">
    <thead>
        <tr>
            <th>Customer ID</th>
            <th>Purchased Date</th>
            <th>Property Address</th>
            <th>Government Id</th>
            <th>Property Total Amount</th>
            <th>Payment Method</th>
            <th>Approval Status</th>
            <th>Payment Status</th>
            <th>Download Receipt</th>

        </tr>
    </thead>
    <tbody>
        <% 
        ArrayList<CustomerPurchasedProperty> list = (ArrayList<CustomerPurchasedProperty>) request.getAttribute("list");
        for (CustomerPurchasedProperty object : list) {
            byte[] images = object.getGovernmentId();
            String getImage = Base64.getEncoder().encodeToString(images);
        %>
        <tr>
            <td><%= object.getCustomerId() %></td>
            <td><%=object.getPurchasedDate() %></td>
            <td><%= object.getPropertyAddress() %></td>
            <td> 
                <img alt="Government ID" src="data:image/jpeg;base64,<%= getImage %>">      
            </td>
            <td><%= object.getPropertyPrice() %></td>
            <td><%= object.getPaymentMethod() %></td>
            <td><%= object.getApproval() %></td>
            <td><%= object.getPaymentStatus() %></td>
            <td>
                <button onclick="generateReceipt('<%= object.getCustomerId() %>',<%=object.getPurchasedDate() %>,'<%= object.getPropertyAddress() %>','<%= object.getPropertyPrice() %>', 
                    '<%= object.getPaymentMethod() %>','<%= object.getApproval() %>','<%= object.getPaymentStatus() %>')">
                Generate Receipt
                </button>
            </td>
        </tr>
        <% } %>
    </tbody>
</table>
</body>
</html>
