<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.chainsys.model.RealEstatePropertyRegister" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Approved Properties</title>
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
</head>
<body>
<h3>Your Properties</h3>
<a href="CustomerWelcomePage.jsp"><button>Back to home</button></a>

<table border="1">
    <thead>
        <tr>
            <th>Seller ID</th>
            <th>Property Name</th>
            <th>Property ID</th>
            <th>Property Price</th>
            <th>Property Address</th>
            <th>Property Images</th>
            <th>Property Document Photo Copy</th>
            <th>Property District</th>
            <th>Property State</th>
            <th>Approval Status</th>
            <th>Register Status</th>
            <th>Payment Status</th>
            <th>Download Receipt</th>
        </tr>
    </thead>
    <tbody>
        <% 
        ArrayList<RealEstatePropertyRegister> list = (ArrayList<RealEstatePropertyRegister>) request.getAttribute("list");
        for (RealEstatePropertyRegister object : list) {
            byte[] images = object.getPropertyImages();
            String getImage = Base64.getEncoder().encodeToString(images);
            
            byte[] documents = object.getPropertyDocument();
            String getDocuments = Base64.getEncoder().encodeToString(documents);
        %>
            <tr>
                <td><%= object.getSellerId() %></td>
                <td><%= object.getPropertyName() %></td>
                <td><%= object.getPropertyId() %></td>
                <td><%= object.getPropertyPrice() %></td>
                <td><%= object.getPropertyAddress() %></td>
                <td>
                    <img class="property-image" alt="Residential" src="data:image/jpeg;base64,<%= getImage %> ">      
                </td>
                <td>
                    <img class="document-image" alt="documents" src="data:image/jpeg;base64,<%= getDocuments %> ">      
                </td>
                <td><%= object.getPropertyDistrict() %></td>
                <td><%= object.getPropertyState() %></td>
                <td><%= object.getApproval() %></td>
                <td><%= object.getRegistered() %></td>
                <td><%= object.getPayment() %></td>
                <td>
                    <button onclick="generateReceipt('<%= object.getSellerId()%>', '<%= object.getPropertyName()%>', '<%= object.getPropertyPrice()%>', '<%= object.getPropertyAddress()%>', '<%= object.getPropertyDistrict()%>', '<%= object.getPropertyState() %>', '<%= object.getApproval() %>', '<%= object.getPayment() %>')">Generate Receipt</button>
                </td>
            </tr>
        <% } %>
    </tbody>
</table>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.3.1/jspdf.umd.min.js"></script>
<script type="text/javascript">
    function generateReceipt(sellerId, propertyName, propertyPrice, propertyAddress, propertyDistrict, propertyState, approval, payment) 
    {
/*         console.log("Generating receipt for:", sellerId, propertyName, propertyPrice, propertyAddress, propertyDistrict, propertyState, approval, payment);
 */        
        const { jsPDF } = window.jspdf;
        const doc = new jsPDF();
        
        doc.text("Payment Receipt", 10, 10);
        doc.text("Seller ID: " + sellerId, 10, 20);
        doc.text("Property Name: " + propertyName, 10, 30);
        doc.text("Property Price: " + propertyPrice, 10, 40);
        doc.text("Property District: " + propertyDistrict, 10, 50);
        doc.text("Property State: " + propertyState, 10, 60);
        doc.text("Approval Status: " + approval, 10, 70);
        doc.text("Payment: " + payment, 10, 80);
        
        /* // Add property image
        const propertyImg = new Image();
        propertyImg.src = getImage;
        doc.addImage(propertyImg, 'JPEG', 10, 90, 100, 60); // Adjust coordinates and dimensions as needed
        
        // Add document image
        const documentImg = new Image();
        documentImg.src = getDocument;
        doc.addImage(documentImg, 'JPEG', 120, 90, 100, 60); // Adjust coordinates and dimensions as needed
         */
        doc.save("receipt_" + sellerId + ".pdf");
    }
</script>
</body>
</html>
