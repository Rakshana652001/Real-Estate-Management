<%@page import="java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.chainsys.model.RealEstatePropertyRegister" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Properties Registration Details</title>

</head>
<body>
<h4>Property Details</h4>
<table border="1">
    <thead>
        <tr>
            <th>Seller ID</th>
            <th>Property Name</th>
            <th>Property ID</th>
            <th>Property Price</th>
            <th>Property Address</th>
            <th>Property Images</th>
            <th>Property District</th>
            <th>Property State</th>
            <!-- <th>Approval</th> -->
        </tr>
    </thead>
    <tbody>
        <% 
        ArrayList<RealEstatePropertyRegister> list = (ArrayList<RealEstatePropertyRegister>) request.getAttribute("list");
       	for (RealEstatePropertyRegister object : list)
             {
                 byte[] images = object.getPropertyImages();
                 String getImage;
                 getImage = Base64.getEncoder().encodeToString(images);
             
         %>
             <tr>
                 <td><%= object.getSellerId() %></td>
                 <td><%= object.getPropertyName() %></td>
                 <td><%= object.getPropertyId() %></td>
                 <td><%= object.getPropertyPrice() %></td>
                 <td><%= object.getPropertyAddress() %></td>
                 <td> 
                	<img alt="images" src="data:image/jpeg;base64,<%= getImage %> ">      
                 </td>
                 <td><%= object.getPropertyDistrict() %></td>
                 <td><%=object.getPropertyState() %></td>
                 <%-- <td>
                      <form action="ApprovalServlet" method="post">
                         <input type="hidden" name="sellerId" value="<%= object.getSellerId() %>">
                         <select name="approvalStatus">
                             <option value="Select">Select</option>
                             <option value="Approved">Approved</option>
                             <option value="Not Approved">Not Approved</option>
                         </select>
                         <input type="submit" value="Submit">
                     </form>
                 </td> --%>
             </tr>
         <%
             }
            
   
            %>
     
    </tbody>
</table>
<script type="text/javascript">
function approveSelection() 
{
	var selectApproval = document.getElementById('approveSelect');
	var selected = selectApproval.options[selectApproval.selectedIndex];
	
	var approve = selected.getAttribute('data-name');
	
	document.getElementById('approval').value = approve;
	
}
</script>
</body>
</html>
