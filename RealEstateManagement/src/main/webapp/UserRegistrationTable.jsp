<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import=" com.chainsys.model.RealEstateUserRegister" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="xml:lang">
<head>
<meta charset="ISO-8859-1">
<title>User Registration Details</title>

</head>
<body>
<h4>User Details</h4>
<table border="1">
	<thead>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Phone Number</th>
			<th>Email Id</th>
			<th>Address</th>
			<th>District</th>
			<th>State</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
	</thead>
	<%ArrayList<RealEstateUserRegister> list = (ArrayList<RealEstateUserRegister>)request.getAttribute("list");
	for(RealEstateUserRegister object:list)
	{
	%>
		<tr>
			<td><%=object.getGeneratedUserID() %></td>
			<td><%=object.getName() %></td>
			<td><%=object.getPhoneNumber() %></td>
			<td><%=object.getEmailID() %></td>
			<td><%=object.getAddress() %></td>
			<td><%=object.getDistrict() %></td>
			<td><%=object.getState() %></td>
			<td><input type="hidden" value="<%=object.getName() %>" name="name"><a href="UpdateUserDetails.jsp?editName=<%=object.getName() %>"><button>Update</button></a></td>
			<td>
			<input type="hidden" name="customerId" value="<%=object.getGeneratedUserID() %>">
		<form action="UserServlet" method="post">
  		<input type="hidden" name="deleteName" value="<%= object.getName()%>">
  		<input type="hidden" name="id" value="<%=object.getGeneratedUserID()%>"> 
  		<input type="submit" name="delete" value="Delete">
  		</form>
  		</td>  		
		</tr>
	<%
	}
	  %>
</table>
</body>
</html>