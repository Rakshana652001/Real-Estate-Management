<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import=" com.chainsys.model.RealEstateUserRegister" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration Details</title>
</head>
<body>
<h4>User Details</h4>
<table border="1">
	<thead>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>phone_number</th>
			<th>email_id</th>
			<th>address</th>
			<th>district</th>
			<th>state</th>
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
			<td>
		<form action="UserServlet" method="post">
  		<input type="hidden" name="deleteName" value="<%= object.getName()%>">
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