<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.chainsys.model.CustomerPurchasedProperty" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="xml:lang">
<head>
<meta charset="ISO-8859-1">
<title>Registered Properties Still Not Approved</title>
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
<h3>Customer Registered Properties(Unapproved)</h3>
<a href="AdminWelcomePage.jsp"><button>Back to home</button></a>

<table border="1">
    <thead>
        <tr>
            <th>Customer ID</th>
            <th>Property Address</th>
            <th>Government Id</th>
            <th>Property Total Amount</th>
            <th>Payable Amount</th>
            <th>Payment Method</th>
            <th>Approval Status</th>
            <th>Approval</th>
            
            
        </tr>
    </thead>
    <tbody>
        <% 
        ArrayList<CustomerPurchasedProperty> list = (ArrayList<CustomerPurchasedProperty>) request.getAttribute("list");
       	for (CustomerPurchasedProperty object : list)
             {
                 byte[] images = object.getGovernmentId();
                 String getImage;
                 getImage = Base64.getEncoder().encodeToString(images);
             
         %>
             <tr>
                 <td><%= object.getCustomerId() %></td>
                 <td><%=object.getPropertyAddress() %></td>
                 <td> 
                	<img alt="Residential" src="data:image/jpeg;base64,<%= getImage %> ">      
                 </td>
                 <td><%= object.getPropertyPrice() %></td>
              	 <td><%=object.getPayableAmount() %></td>
                 <td><%= object.getPaymentMethod() %></td>
                 <td><%= object.getApproval() %></td>
                 
                 <td>
                      <form action="ApprovalToBuyServlet" method="post">
                         <input type="hidden" name="customerId" value="<%=object.getCustomerId() %>">
                         <select name="approvalStatus">
                             <option value="Select">Select</option>
                             <option value="Approved">Approved</option>
                             <option value="Not Approved">Not Approved</option>
                         </select>
                         <input type="submit" value="Submit">
                     </form>
                     
                 </td>
                 
              </tr>
             
         <%
             }
            
   
            %>
     
    </tbody>
</table>
</body>
</html>
