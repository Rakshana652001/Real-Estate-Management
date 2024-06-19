
package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.model.RealEstateUserRegister;
import com.chainsys.util.ConnectionJdbc;

public class RealEstateImplementation implements RealEstateInterface
{
	
	RealEstateUserRegister estateUserRegister =new RealEstateUserRegister();
	
	public void userRegistration(RealEstateUserRegister estateUserRegister) throws ClassNotFoundException, SQLException 
	{		
		Connection getConnection = ConnectionJdbc.getConnection();
		String insert = "insert into user_registration (id, name, designation, phone_number, email_id, password, address, district, state)values(?,?,?,?,?,?,?,?,?) ";
		PreparedStatement insertStatement = getConnection.prepareStatement(insert);
		insertStatement.setString(1, estateUserRegister.getGeneratedUserID());
		insertStatement.setString(2, estateUserRegister.getName());	
		insertStatement.setString(3, estateUserRegister.getDesignation());
		insertStatement.setLong(4, estateUserRegister.getPhoneNumber());
		insertStatement.setString(5, estateUserRegister.getEmailID());
		insertStatement.setString(6, estateUserRegister.getPassword());
		insertStatement.setString(7, estateUserRegister.getAddress());	
		insertStatement.setString(8, estateUserRegister.getDistrict());	
		insertStatement.setString(9, estateUserRegister.getState());	
		
		insertStatement.executeUpdate();
		System.out.println("Inserted");
		getConnection.close();
	}

	public List<RealEstateUserRegister> retriveUserDetails(RealEstateUserRegister estateUserRegister)
	{
		ArrayList<RealEstateUserRegister> arrayList = new ArrayList<RealEstateUserRegister>();
		try
		{
			Connection getConnection = ConnectionJdbc.getConnection();
			String retriveDetails = "select id, name, designation, phone_number, email_id, address, district, state from user_registration where (designation = 'Seller' or designation = 'Customer') and deleted_User=0";
			PreparedStatement preparedStatement = getConnection.prepareStatement(retriveDetails);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				RealEstateUserRegister estateUserRegister2 = new RealEstateUserRegister();
				
				estateUserRegister2.setGeneratedUserID(resultSet.getString(1));
				estateUserRegister2.setName(resultSet.getString(2));
				estateUserRegister2.setDesignation(resultSet.getString(3));
				estateUserRegister2.setPhoneNumber(resultSet.getLong(4));
				estateUserRegister2.setEmailID(resultSet.getString(5));
				estateUserRegister2.setAddress(resultSet.getString(6));
				estateUserRegister2.setDistrict(resultSet.getString(7));
				estateUserRegister2.setState(resultSet.getString(8));
				
				arrayList.add(estateUserRegister2);
			}
			getConnection.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return arrayList;
	}

	public void updateDetails(RealEstateUserRegister estateUserRegister) throws ClassNotFoundException, SQLException
	{
		Connection getConnection = ConnectionJdbc.getConnection();
		String updateDetails = "update user_registration set phone_number=?,password=?,address=? where name=?";
		PreparedStatement preparedStatement = getConnection.prepareStatement(updateDetails);
		
		preparedStatement.setLong(1, estateUserRegister.getPhoneNumber());
		preparedStatement.setString(2, estateUserRegister.getPassword());
		preparedStatement.setString(3, estateUserRegister.getAddress());
		
		preparedStatement.setString(4, estateUserRegister.getName());
		
		int executeUpdate = preparedStatement.executeUpdate();
		System.out.println(executeUpdate);
		
	}

	public void deleteDetails(RealEstateUserRegister estateUserRegister) throws ClassNotFoundException, SQLException
	{
		
		String name = "update user_registration set deleted_User = true where name=?";
		try 
		{
			Connection getConnection = ConnectionJdbc.getConnection();
			PreparedStatement preparedStatement = getConnection.prepareStatement(name);
			preparedStatement.setString(1, estateUserRegister.getName());
			preparedStatement.executeUpdate();
		}
		catch(Exception e)
		{
			throw new SQLException("Error while performing soft delete", e);
		}
				
	}

	@SuppressWarnings("unused")
	public Object getAdminId(String id) throws ClassNotFoundException, SQLException
	{
		Connection getConnection = ConnectionJdbc.getConnection();
		String selectId = "select id from user_registration where id=? and (designation = 'Admin') and deleted_User=0"; // allow only admin id's
		PreparedStatement preparedStatement = getConnection.prepareStatement(selectId);
		preparedStatement.setString(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next())
		{
			selectId = resultSet.getString(1);
			RealEstateUserRegister userPojo = new RealEstateUserRegister(selectId);
			userPojo.getGeneratedUserID();
			List<RealEstateUserRegister> list = new ArrayList<RealEstateUserRegister>();
			RealEstateUserRegister admin = new RealEstateUserRegister(selectId);
		}
		return selectId;
	}
	
	@SuppressWarnings("unused")
	public Object getGeneratedSellerId(String id) throws ClassNotFoundException, SQLException
	{
		Connection getConnection = ConnectionJdbc.getConnection();
		String selectId = "select id from user_registration where id=? and (designation = 'Seller') and deleted_User=0";
		PreparedStatement preparedStatement = getConnection.prepareStatement(selectId);
		preparedStatement.setString(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next())
		{
			selectId = resultSet.getString(1);
			RealEstateUserRegister userPojo = new RealEstateUserRegister(selectId);
			userPojo.getGeneratedUserID();
			List<RealEstateUserRegister> list = new ArrayList<RealEstateUserRegister>();
			RealEstateUserRegister admin = new RealEstateUserRegister(selectId);
		}
		return selectId;		
	}
	
	
	@SuppressWarnings("unused")
	public String getAdminpassword(String id) throws ClassNotFoundException, SQLException
	{
		Connection getConnection = ConnectionJdbc.getConnection();
		String password = "select password from user_registration where id=? and (designation = 'Admin') and deleted_User=0"; 
		PreparedStatement passwordStatement = getConnection.prepareStatement(password);
		passwordStatement.setString(1, id);
		ResultSet resultSet = passwordStatement.executeQuery();
		while(resultSet.next())
		{
			password = resultSet.getString(1);
			RealEstateUserRegister passwordselect = new RealEstateUserRegister(password);
			passwordselect.getPassword();
			List<RealEstateUserRegister> password1  = new ArrayList<RealEstateUserRegister>();
			RealEstateUserRegister admin = new RealEstateUserRegister(password);
		}
		getConnection.close();
		return password;
	}
	
	@SuppressWarnings("unused")
	public String getsellerPassword(String id) throws ClassNotFoundException, SQLException
	{
		Connection getConnection = ConnectionJdbc.getConnection();
		String password = "select password from user_registration where id=? and (designation = 'Seller') and deleted_User=0";
		PreparedStatement passwordStatement = getConnection.prepareStatement(password);
		passwordStatement.setString(1, id);
		ResultSet resultSet = passwordStatement.executeQuery();
		while(resultSet.next())
		{
			password = resultSet.getString(1);
			RealEstateUserRegister passwordselect = new RealEstateUserRegister(password);
			passwordselect.getPassword();
			List<RealEstateUserRegister> password1  = new ArrayList<RealEstateUserRegister>();
			RealEstateUserRegister admin = new RealEstateUserRegister(password);
		}
		getConnection.close();
		return password;
	}

	public List<RealEstateUserRegister> retriveAdminDetails1(String name)
	{
		ArrayList<RealEstateUserRegister> arrayList1 = new ArrayList<RealEstateUserRegister>();
		
		try
		{
			
			Connection getConnection = ConnectionJdbc.getConnection();
			String retriveDetails = "select id, name, designation, phone_number, email_id, address, district, state from user_registration where name=? and (designation = 'Admin')";
			PreparedStatement preparedStatement = getConnection.prepareStatement(retriveDetails);
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				
				RealEstateUserRegister estateUserRegister2 = new RealEstateUserRegister();
				
				estateUserRegister2.setGeneratedUserID(resultSet.getString(1));
				estateUserRegister2.setName(resultSet.getString(2));
				estateUserRegister2.setDesignation(resultSet.getString(3));
				estateUserRegister2.setPhoneNumber(resultSet.getLong(4));
				estateUserRegister2.setEmailID(resultSet.getString(5));
				estateUserRegister2.setAddress(resultSet.getString(6));
				estateUserRegister2.setDistrict(resultSet.getString(7));
				estateUserRegister2.setState(resultSet.getString(8));
				
				arrayList1.add(estateUserRegister2);
			}
			getConnection.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return arrayList1;
		
	}
	
	
	public List<RealEstateUserRegister> retriveSellerCustomerDetails(String id)
	{
		ArrayList<RealEstateUserRegister> arrayList1 = new ArrayList<RealEstateUserRegister>();
		
		try
		{
			
			Connection getConnection = ConnectionJdbc.getConnection();
			String retriveDetails = "select id, name, designation, phone_number, email_id, address, district, state from user_registration where deleted_User=0 and (designation = 'Seller' or designation = 'Customer')";
			PreparedStatement preparedStatement = getConnection.prepareStatement(retriveDetails);
		
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				
				RealEstateUserRegister estateUserRegister2 = new RealEstateUserRegister();
				
				estateUserRegister2.setGeneratedUserID(resultSet.getString(1));
				estateUserRegister2.setName(resultSet.getString(2));
				estateUserRegister2.setDesignation(resultSet.getString(3));
				estateUserRegister2.setPhoneNumber(resultSet.getLong(4));
				estateUserRegister2.setEmailID(resultSet.getString(5));
				estateUserRegister2.setAddress(resultSet.getString(6));
				estateUserRegister2.setDistrict(resultSet.getString(7));
				estateUserRegister2.setState(resultSet.getString(8));
				
				arrayList1.add(estateUserRegister2);
			}
			getConnection.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return arrayList1;
		
	}

	public List<RealEstateUserRegister> retriveSellerDetails(String getsellerId)
	{
		ArrayList<RealEstateUserRegister> arrayList1 = new ArrayList<RealEstateUserRegister>();
		
		try
		{
			
			Connection getConnection = ConnectionJdbc.getConnection();
			String retriveDetails = "select id, name, designation, phone_number, email_id, address, district, state from user_registration where id=? and (designation = 'Seller') and deleted_User = 0";
			PreparedStatement preparedStatement = getConnection.prepareStatement(retriveDetails);
			preparedStatement.setString(1, getsellerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				
				RealEstateUserRegister estateUserRegister2 = new RealEstateUserRegister();
				
				estateUserRegister2.setGeneratedUserID(resultSet.getString(1));
				estateUserRegister2.setName(resultSet.getString(2));
				estateUserRegister2.setDesignation(resultSet.getString(3));
				estateUserRegister2.setPhoneNumber(resultSet.getLong(4));
				estateUserRegister2.setEmailID(resultSet.getString(5));
				estateUserRegister2.setAddress(resultSet.getString(6));
				estateUserRegister2.setDistrict(resultSet.getString(7));
				estateUserRegister2.setState(resultSet.getString(8));
				
				arrayList1.add(estateUserRegister2);
			}
			getConnection.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return arrayList1;
	}

	@SuppressWarnings("unused")
	public Object getCustomerGeneratedId(String id) throws ClassNotFoundException, SQLException
	{
		Connection getConnection = ConnectionJdbc.getConnection();
		String selectId = "select id from user_registration where id=? and (designation = 'Customer') and deleted_User=0";
		PreparedStatement preparedStatement = getConnection.prepareStatement(selectId);
		preparedStatement.setString(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next())
		{
			selectId = resultSet.getString(1);
			RealEstateUserRegister userPojo = new RealEstateUserRegister(selectId);
			userPojo.getGeneratedUserID();
			List<RealEstateUserRegister> list = new ArrayList<RealEstateUserRegister>();
			RealEstateUserRegister admin = new RealEstateUserRegister(selectId);
		}
		getConnection.close();
		return selectId;
	}

	@SuppressWarnings("unused")
	public Object getCustomerPassword(String id) throws ClassNotFoundException, SQLException 
	{
		Connection getConnection = ConnectionJdbc.getConnection();
		String password = "select password from user_registration where id=? and (designation = 'Customer') and deleted_User=0";
		PreparedStatement passwordStatement = getConnection.prepareStatement(password);
		passwordStatement.setString(1, id);
		ResultSet resultSet = passwordStatement.executeQuery();
		while(resultSet.next())
		{
			password = resultSet.getString(1);
			RealEstateUserRegister passwordselect = new RealEstateUserRegister(password);
			passwordselect.getPassword();
			List<RealEstateUserRegister> password1  = new ArrayList<RealEstateUserRegister>();
			RealEstateUserRegister admin = new RealEstateUserRegister(password);
		}
		getConnection.close();
		return password;
	}

	public List<RealEstateUserRegister> retriveCustomerDetails(String getCustomerId)
	{
		ArrayList<RealEstateUserRegister> arrayList1 = new ArrayList<RealEstateUserRegister>();
		
		try
		{
			
			Connection getConnection = ConnectionJdbc.getConnection();
			String retriveDetails = "select id, name, designation, phone_number, email_id, address, district, state from user_registration where id=? and (designation = 'Customer')";
			PreparedStatement preparedStatement = getConnection.prepareStatement(retriveDetails);
			preparedStatement.setString(1, getCustomerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				
				RealEstateUserRegister estateUserRegister2 = new RealEstateUserRegister();
				
				estateUserRegister2.setGeneratedUserID(resultSet.getString(1));
				estateUserRegister2.setName(resultSet.getString(2));
				estateUserRegister2.setDesignation(resultSet.getString(3));
				estateUserRegister2.setPhoneNumber(resultSet.getLong(4));
				estateUserRegister2.setEmailID(resultSet.getString(5));
				estateUserRegister2.setAddress(resultSet.getString(6));
				estateUserRegister2.setDistrict(resultSet.getString(7));
				estateUserRegister2.setState(resultSet.getString(8));
				
				arrayList1.add(estateUserRegister2);
			}
			getConnection.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return arrayList1;
	}

	
	public void approveProperty(String propertyId) throws ClassNotFoundException 
	{
	    String query = "UPDATE properties SET status = 'approved' WHERE property_id = ?";
	    try 
	    {
	    	Connection getConnection = ConnectionJdbc.getConnection();
	    	PreparedStatement preparedStatement = getConnection.prepareStatement(query);
	    	preparedStatement.setString(1, propertyId);
	    	preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public List<RealEstateUserRegister> retriveAdminDetails(String getId)
	{
ArrayList<RealEstateUserRegister> arrayList1 = new ArrayList<RealEstateUserRegister>();
		
		try
		{
			
			Connection getConnection = ConnectionJdbc.getConnection();
			String retriveDetails = "select id, name, designation, phone_number, email_id, address, district, state from user_registration where id=? and (designation = 'Admin')";
			PreparedStatement preparedStatement = getConnection.prepareStatement(retriveDetails);
			preparedStatement.setString(1, getId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				
				RealEstateUserRegister estateUserRegister2 = new RealEstateUserRegister();
				
				estateUserRegister2.setGeneratedUserID(resultSet.getString(1));
				estateUserRegister2.setName(resultSet.getString(2));
				estateUserRegister2.setDesignation(resultSet.getString(3));
				estateUserRegister2.setPhoneNumber(resultSet.getLong(4));
				estateUserRegister2.setEmailID(resultSet.getString(5));
				estateUserRegister2.setAddress(resultSet.getString(6));
				estateUserRegister2.setDistrict(resultSet.getString(7));
				estateUserRegister2.setState(resultSet.getString(8));
				
				arrayList1.add(estateUserRegister2);
			}
			getConnection.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return arrayList1;
	}

	public List<RealEstateUserRegister> retriveSellerDetails1(String name1) 
	{
		ArrayList<RealEstateUserRegister> arrayList1 = new ArrayList<RealEstateUserRegister>();
		
		try
		{
			
			Connection getConnection = ConnectionJdbc.getConnection();
			String retriveDetails = "select id, name, designation, phone_number, email_id, address, district, state from user_registration where name=? and (designation = 'Seller') and deleted_User = 0";
			PreparedStatement preparedStatement = getConnection.prepareStatement(retriveDetails);
			preparedStatement.setString(1, name1);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				
				RealEstateUserRegister estateUserRegister2 = new RealEstateUserRegister();
				
				estateUserRegister2.setGeneratedUserID(resultSet.getString(1));
				estateUserRegister2.setName(resultSet.getString(2));
				estateUserRegister2.setDesignation(resultSet.getString(3));
				estateUserRegister2.setPhoneNumber(resultSet.getLong(4));
				estateUserRegister2.setEmailID(resultSet.getString(5));
				estateUserRegister2.setAddress(resultSet.getString(6));
				estateUserRegister2.setDistrict(resultSet.getString(7));
				estateUserRegister2.setState(resultSet.getString(8));
				
				arrayList1.add(estateUserRegister2);
			}
			getConnection.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return arrayList1;
	}

	@SuppressWarnings("rawtypes")
	public List retriveCustomerDetails1(String name1) 
	{
ArrayList<RealEstateUserRegister> arrayList1 = new ArrayList<RealEstateUserRegister>();
		
		try
		{
			
			Connection getConnection = ConnectionJdbc.getConnection();
			String retriveDetails = "select id, name, designation, phone_number, email_id, address, district, state from user_registration where name=? and (designation = 'Customer')";
			PreparedStatement preparedStatement = getConnection.prepareStatement(retriveDetails);
			preparedStatement.setString(1, name1);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				
				RealEstateUserRegister estateUserRegister2 = new RealEstateUserRegister();
				
				estateUserRegister2.setGeneratedUserID(resultSet.getString(1));
				estateUserRegister2.setName(resultSet.getString(2));
				estateUserRegister2.setDesignation(resultSet.getString(3));
				estateUserRegister2.setPhoneNumber(resultSet.getLong(4));
				estateUserRegister2.setEmailID(resultSet.getString(5));
				estateUserRegister2.setAddress(resultSet.getString(6));
				estateUserRegister2.setDistrict(resultSet.getString(7));
				estateUserRegister2.setState(resultSet.getString(8));
				
				arrayList1.add(estateUserRegister2);
			}
			getConnection.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return arrayList1;
	}

	public List<RealEstateUserRegister> search(String id)
	{
		ArrayList<RealEstateUserRegister> arrayList = new ArrayList<RealEstateUserRegister>();
		try
		{
			Connection getConnection = ConnectionJdbc.getConnection();
			String retriveDetails = "select id, name, designation, phone_number, email_id, address, district, state from user_registration where  id=? and (designation = 'Seller' or designation = 'Customer') and deleted_User=0";
			PreparedStatement preparedStatement = getConnection.prepareStatement(retriveDetails);
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				RealEstateUserRegister estateUserRegister = new RealEstateUserRegister();
				
				estateUserRegister.setGeneratedUserID(resultSet.getString(1));
				estateUserRegister.setName(resultSet.getString(2));
				estateUserRegister.setDesignation(resultSet.getString(3));
				estateUserRegister.setPhoneNumber(resultSet.getLong(4));
				estateUserRegister.setEmailID(resultSet.getString(5));
				estateUserRegister.setAddress(resultSet.getString(6));
				estateUserRegister.setDistrict(resultSet.getString(7));
				estateUserRegister.setState(resultSet.getString(8));
				
				arrayList.add(estateUserRegister);
			}
			getConnection.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return arrayList;
	}

	
}



