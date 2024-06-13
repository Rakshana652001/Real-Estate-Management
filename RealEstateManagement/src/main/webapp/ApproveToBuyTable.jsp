<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.chainsys.model.CustomerPurchasedProperty" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registered Properties Still Not Approved</title>

</head>
<body>
<h4>Registered Properties to Buy</h4>
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
                	<img alt="images" src="data:image/jpeg;base64,<%= getImage %> ">      
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
