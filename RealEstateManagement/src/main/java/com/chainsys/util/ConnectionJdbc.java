package com.chainsys.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJdbc 
{
	public static void main(String args []) throws ClassNotFoundException, SQLException
	{
		Connection getConnection = ConnectionJdbc.getConnection(); //connection call
		System.out.println(getConnection);	
		getConnection.close();
	}
	public static Connection getConnection() throws SQLException, ClassNotFoundException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/RealEstateManagement", "root", "Rakshana@1947");
		return connection;
	}

}
