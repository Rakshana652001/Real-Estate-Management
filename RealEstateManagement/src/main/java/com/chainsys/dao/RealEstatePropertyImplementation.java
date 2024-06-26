package com.chainsys.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.model.RealEstatePropertyRegister;
import com.chainsys.util.ConnectionJdbc;

public class RealEstatePropertyImplementation
{
	RealEstatePropertyRegister estatePropertyRegister = new RealEstatePropertyRegister();

	public void saveProperties(RealEstatePropertyRegister estatePropertyRegister) throws ClassNotFoundException, SQLException
	{
		
		Connection getConnection = ConnectionJdbc.getConnection();
		String saveProperties = "insert into property_registration (seller_id,property_name,property_id,property_price, property_images,property_document,property_address, property_district,property_state, approval, register_status, payment_status, registered_date, customer_id) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement insertStatement = getConnection.prepareStatement(saveProperties);
		insertStatement.setString(1, estatePropertyRegister.getSellerId());
		insertStatement.setString(2, estatePropertyRegister.getPropertyName());
		insertStatement.setString(3, estatePropertyRegister.getPropertyId());
		insertStatement.setLong(4, estatePropertyRegister.getPropertyPrice());
		insertStatement.setBytes(5, estatePropertyRegister.getPropertyImages());
		insertStatement.setBytes(6, estatePropertyRegister.getPropertyDocument());
		insertStatement.setString(7, estatePropertyRegister.getPropertyAddress());
		insertStatement.setString(8, estatePropertyRegister.getPropertyDistrict());
		insertStatement.setString(9, estatePropertyRegister.getPropertyState());
		insertStatement.setString(10, "Not Approved");
		insertStatement.setString(11, "Not Registered");
		insertStatement.setString(12, "Not Paid");
		insertStatement.setString(13, estatePropertyRegister.getRegisteredDate());
		insertStatement.setString(14, "Not Registered");
		
		insertStatement.executeUpdate();
		getConnection.close();		
	}

	public List<RealEstatePropertyRegister> retriveDetails(String sellerId)
	{
		List<RealEstatePropertyRegister> list = new ArrayList<RealEstatePropertyRegister>();
		try
		{
			Connection getConnection = ConnectionJdbc.getConnection();
			String retriveProperties = "select seller_id,property_name,property_id,property_price, property_images,property_document, property_address, property_district,property_state,approval, register_status,payment_status, customer_id, registered_date, purchased_date from property_registration where payment_status='Not Paid' and  seller_id = ? and deleted_User = 0";
			PreparedStatement preparedStatement = getConnection.prepareStatement(retriveProperties);
			preparedStatement.setString(1, sellerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				RealEstatePropertyRegister estatePropertyRegister = new RealEstatePropertyRegister();
				
				estatePropertyRegister.setSellerId(resultSet.getString(1));
				estatePropertyRegister.setPropertyName(resultSet.getString(2));
				estatePropertyRegister.setPropertyId(resultSet.getString(3));
				estatePropertyRegister.setPropertyPrice(resultSet.getLong(4));
				estatePropertyRegister.setPropertyImages(resultSet.getBytes(5));
				estatePropertyRegister.setPropertyDocument(resultSet.getBytes(6));
				estatePropertyRegister.setPropertyAddress(resultSet.getString(7));
				estatePropertyRegister.setPropertyDistrict(resultSet.getString(8));
				estatePropertyRegister.setPropertyState(resultSet.getString(9));
				estatePropertyRegister.setApproval(resultSet.getString(10));
				estatePropertyRegister.setRegistered(resultSet.getString(11));
				estatePropertyRegister.setPayment(resultSet.getString(12));
				estatePropertyRegister.setCustomerId(resultSet.getString(13));
				estatePropertyRegister.setRegisteredDate(resultSet.getString(14));
				estatePropertyRegister.setPurchasedDate(resultSet.getString(15));
				
				list.add(estatePropertyRegister);
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	
		
	}
	
	public List<RealEstatePropertyRegister> retriveAllSellerDetails(String sellerId)
	{
		List<RealEstatePropertyRegister> list = new ArrayList<RealEstatePropertyRegister>();
		try
		{
			Connection getConnection = ConnectionJdbc.getConnection();
			String retriveProperties = "select seller_id,property_name,property_id,property_price, property_images,property_document, property_address, property_district,property_state,approval, registered_date,purchased_date from property_registration where approval='Not Approved' and deleted_User = 0";
			PreparedStatement preparedStatement = getConnection.prepareStatement(retriveProperties);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				
				RealEstatePropertyRegister estatePropertyRegister = new RealEstatePropertyRegister();
				
				estatePropertyRegister.setSellerId(resultSet.getString(1));
				estatePropertyRegister.setPropertyName(resultSet.getString(2));
				estatePropertyRegister.setPropertyId(resultSet.getString(3));
				estatePropertyRegister.setPropertyPrice(resultSet.getLong(4));
				estatePropertyRegister.setPropertyImages(resultSet.getBytes(5));
				estatePropertyRegister.setPropertyDocument(resultSet.getBytes(6));
				estatePropertyRegister.setPropertyAddress(resultSet.getString(7));
				estatePropertyRegister.setPropertyDistrict(resultSet.getString(8));
				estatePropertyRegister.setPropertyState(resultSet.getString(9));
				estatePropertyRegister.setApproval(resultSet.getString(10));
				estatePropertyRegister.setRegisteredDate(resultSet.getString(11));
				estatePropertyRegister.setPurchasedDate(resultSet.getString(12));
				
				list.add(estatePropertyRegister);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}
	

	public void deleteDetails(RealEstatePropertyRegister estatePropertyRegister)
	{
		String name = "update property_registration set deleted_User = true where property_id=?";
		try 
		{
			Connection getConnection = ConnectionJdbc.getConnection();
			PreparedStatement preparedStatement = getConnection.prepareStatement(name);
			preparedStatement.setString(1, estatePropertyRegister.getPropertyId());
			preparedStatement.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}


	public List<RealEstatePropertyRegister> retriveResidential(String getId)
	{
		List<RealEstatePropertyRegister> list = new ArrayList<RealEstatePropertyRegister>();
		try
		{
			Connection getConnection = ConnectionJdbc.getConnection();
			String retriveProperties = "select seller_id,property_name,property_id,property_price,property_images ,property_address, property_district,property_state, registered_date,purchased_date from property_registration where property_name = 'Residential' and deleted_User=0 and approval='Approved' and register_status='Not Registered'";
			PreparedStatement preparedStatement = getConnection.prepareStatement(retriveProperties);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				
				RealEstatePropertyRegister estatePropertyRegister = new RealEstatePropertyRegister();
				estatePropertyRegister.setSellerId(resultSet.getString(1));
				estatePropertyRegister.setPropertyName(resultSet.getString(2));
				estatePropertyRegister.setPropertyId(resultSet.getString(3));
				estatePropertyRegister.setPropertyPrice(resultSet.getLong(4));
				estatePropertyRegister.setPropertyImages(resultSet.getBytes(5));
				estatePropertyRegister.setPropertyAddress(resultSet.getString(6));
				estatePropertyRegister.setPropertyDistrict(resultSet.getString(7));
				estatePropertyRegister.setPropertyState(resultSet.getString(8));
				estatePropertyRegister.setRegisteredDate(resultSet.getString(9));
				estatePropertyRegister.setPurchasedDate(resultSet.getString(10));
				
				list.add(estatePropertyRegister);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}

	public List<RealEstatePropertyRegister> retriveLand(String getId)
	{
		List<RealEstatePropertyRegister> list = new ArrayList<RealEstatePropertyRegister>();
		try
		{
			Connection getConnection = ConnectionJdbc.getConnection();
			String retriveProperties = "select seller_id,property_name,property_id,property_price, property_images ,property_address, property_district,property_state, registered_date,purchased_date from property_registration where property_name = 'Land' and deleted_User=0 and approval='Approved' and register_status='Not Registered'";
			PreparedStatement preparedStatement = getConnection.prepareStatement(retriveProperties);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				RealEstatePropertyRegister estatePropertyRegister = new RealEstatePropertyRegister();
				
				estatePropertyRegister.setSellerId(resultSet.getString(1));
				estatePropertyRegister.setPropertyName(resultSet.getString(2));
				estatePropertyRegister.setPropertyId(resultSet.getString(3));
				estatePropertyRegister.setPropertyPrice(resultSet.getLong(4));
				estatePropertyRegister.setPropertyImages(resultSet.getBytes(5));
				estatePropertyRegister.setPropertyAddress(resultSet.getString(6));
				estatePropertyRegister.setPropertyDistrict(resultSet.getString(7));
				estatePropertyRegister.setPropertyState(resultSet.getString(8));
				estatePropertyRegister.setRegisteredDate(resultSet.getString(9));
				estatePropertyRegister.setPurchasedDate(resultSet.getString(10));
				
				list.add(estatePropertyRegister);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}

	public List<RealEstatePropertyRegister> retriveIndustrial(String getId)
	{
		List<RealEstatePropertyRegister> list = new ArrayList<RealEstatePropertyRegister>();
		try
		{
			Connection getConnection = ConnectionJdbc.getConnection();
			String retriveProperties = "select seller_id,property_name,property_id,property_price, property_images, property_address, property_district,property_state,registered_date,purchased_date from property_registration where property_name = 'Industrial' and deleted_User=0 and approval='Approved' and register_status='Not Registered'";
			PreparedStatement preparedStatement = getConnection.prepareStatement(retriveProperties);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				RealEstatePropertyRegister estatePropertyRegister = new RealEstatePropertyRegister();
				
				estatePropertyRegister.setSellerId(resultSet.getString(1));
				estatePropertyRegister.setPropertyName(resultSet.getString(2));
				estatePropertyRegister.setPropertyId(resultSet.getString(3));
				estatePropertyRegister.setPropertyPrice(resultSet.getLong(4));
				estatePropertyRegister.setPropertyImages(resultSet.getBytes(5));
				estatePropertyRegister.setPropertyAddress(resultSet.getString(6));
				estatePropertyRegister.setPropertyDistrict(resultSet.getString(7));
				estatePropertyRegister.setPropertyState(resultSet.getString(8));
				estatePropertyRegister.setRegisteredDate(resultSet.getString(9));
				estatePropertyRegister.setPurchasedDate(resultSet.getString(10));
				
				list.add(estatePropertyRegister);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}

	public List<RealEstatePropertyRegister> retriveCommercial(String getId) 
	{
		List<RealEstatePropertyRegister> list = new ArrayList<RealEstatePropertyRegister>();
		try
		{
			Connection getConnection = ConnectionJdbc.getConnection();
			String retriveProperties = "select seller_id,property_name,property_id,property_price,property_images, property_address, property_district,property_state,registered_date,purchased_date from property_registration where property_name = 'Commercial' and deleted_User=0 and approval='Approved' and register_status='Not Registered'";
			PreparedStatement preparedStatement = getConnection.prepareStatement(retriveProperties);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				
				RealEstatePropertyRegister estatePropertyRegister = new RealEstatePropertyRegister();
				
				estatePropertyRegister.setSellerId(resultSet.getString(1));
				estatePropertyRegister.setPropertyName(resultSet.getString(2));
				estatePropertyRegister.setPropertyId(resultSet.getString(3));
				estatePropertyRegister.setPropertyPrice(resultSet.getLong(4));
				estatePropertyRegister.setPropertyImages(resultSet.getBytes(5));
				estatePropertyRegister.setPropertyAddress(resultSet.getString(6));
				estatePropertyRegister.setPropertyDistrict(resultSet.getString(7));
				estatePropertyRegister.setPropertyState(resultSet.getString(8));
				estatePropertyRegister.setRegisteredDate(resultSet.getString(9));
				estatePropertyRegister.setPurchasedDate(resultSet.getString(10));
				
				list.add(estatePropertyRegister);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}

	

	public List<RealEstatePropertyRegister> retriveDetailsAfterUpdate(String id) 
	{
		List<RealEstatePropertyRegister> list = new ArrayList<RealEstatePropertyRegister>();
		try
		{
			Connection getConnection = ConnectionJdbc.getConnection();
			String retriveProperties = "select seller_id,property_name,property_id,property_price,property_images,property_document, property_address, property_district,property_state, approval, registered_date,registered_date,purchased_date  from property_registration where deleted_User=0 and approval='Approved' and register_status='Not Registered'";
			PreparedStatement preparedStatement = getConnection.prepareStatement(retriveProperties);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				
				RealEstatePropertyRegister estatePropertyRegister = new RealEstatePropertyRegister();
				
				estatePropertyRegister.setSellerId(resultSet.getString(1));
				estatePropertyRegister.setPropertyName(resultSet.getString(2));
				estatePropertyRegister.setPropertyId(resultSet.getString(3));
				estatePropertyRegister.setPropertyPrice(resultSet.getLong(4));
				estatePropertyRegister.setPropertyImages(resultSet.getBytes(5));
				estatePropertyRegister.setPropertyDocument(resultSet.getBytes(6));
				estatePropertyRegister.setPropertyAddress(resultSet.getString(7));
				estatePropertyRegister.setPropertyDistrict(resultSet.getString(8));
				estatePropertyRegister.setPropertyState(resultSet.getString(9));
				estatePropertyRegister.setApproval(resultSet.getString(10));
				estatePropertyRegister.setRegisteredDate(resultSet.getString(11));
				estatePropertyRegister.setRegisteredDate(resultSet.getString(12));
				estatePropertyRegister.setPurchasedDate(resultSet.getString(13));
				
				list.add(estatePropertyRegister);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	
		
		
	}
	public List<RealEstatePropertyRegister> updateApproval(String address, String approval)
	{
		List<RealEstatePropertyRegister> list = new ArrayList<RealEstatePropertyRegister>();
		try
		{
			Connection getConnection = ConnectionJdbc.getConnection();
			String update = "update property_registration set approval = ? where property_address = ?";
			PreparedStatement preparedStatement = getConnection.prepareStatement(update);
			preparedStatement.setString(1, approval);
			preparedStatement.setString(2, address);
			
			preparedStatement.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}

	public List<RealEstatePropertyRegister> updateRegister(String address, String registered)
	{
		List<RealEstatePropertyRegister> list = new ArrayList<RealEstatePropertyRegister>();
		try
		{
			Connection getConnection = ConnectionJdbc.getConnection();
			String update = "update property_registration set register_status = ? where property_address = ?";
			PreparedStatement preparedStatement = getConnection.prepareStatement(update);
			preparedStatement.setString(1, registered);
			preparedStatement.setString(2, address);
			
			preparedStatement.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}

	public List<RealEstatePropertyRegister> retriveRegistered(String getId)
	{
		List<RealEstatePropertyRegister> list = new ArrayList<RealEstatePropertyRegister>();
		try
		{
			Connection getConnection = ConnectionJdbc.getConnection();
			String retriveProperties = "select seller_id,property_name,property_id,property_price,property_images,property_document, property_address, property_district,property_state, approval, register_status, payment_status,registered_date,purchased_date from property_registration where deleted_User=0 and approval='Approved' and register_status='Registered' and payment_status='Paid'";
			PreparedStatement preparedStatement = getConnection.prepareStatement(retriveProperties);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				
				RealEstatePropertyRegister estatePropertyRegister = new RealEstatePropertyRegister();
				
				estatePropertyRegister.setSellerId(resultSet.getString(1));
				estatePropertyRegister.setPropertyName(resultSet.getString(2));
				estatePropertyRegister.setPropertyId(resultSet.getString(3));
				estatePropertyRegister.setPropertyPrice(resultSet.getLong(4));
				estatePropertyRegister.setPropertyImages(resultSet.getBytes(5));
				estatePropertyRegister.setPropertyDocument(resultSet.getBytes(6));
				estatePropertyRegister.setPropertyAddress(resultSet.getString(7));
				estatePropertyRegister.setPropertyDistrict(resultSet.getString(8));
				estatePropertyRegister.setPropertyState(resultSet.getString(9));
				estatePropertyRegister.setApproval(resultSet.getString(10));
				estatePropertyRegister.setRegistered(resultSet.getString(11));
				estatePropertyRegister.setPayment(resultSet.getString(12));
				estatePropertyRegister.setRegisteredDate(resultSet.getString(13));
				estatePropertyRegister.setPurchasedDate(resultSet.getString(14));
				
				list.add(estatePropertyRegister);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	
	}

	public List<RealEstatePropertyRegister> updateRegistered(String address, String registerStatus)
	{
		List<RealEstatePropertyRegister> list = new ArrayList<RealEstatePropertyRegister>();
		try
		{
			Connection getConnection = ConnectionJdbc.getConnection();
			String update = "update property_registration set register_status = ? where property_address = ?";
			PreparedStatement preparedStatement = getConnection.prepareStatement(update);
			preparedStatement.setString(1, registerStatus);
			preparedStatement.setString(2, address);
			
			preparedStatement.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}

	public List<RealEstatePropertyRegister> retriveBuyedProperties(String propertyAddress)
	{
		List<RealEstatePropertyRegister> list = new ArrayList<RealEstatePropertyRegister>();
		try
		{
			Connection getConnection = ConnectionJdbc.getConnection();
			String retriveProperties = "select seller_id,property_name,property_id,property_price, property_images, property_document,property_address, property_district,property_state, approval, register_status, payment_status,registered_date,purchased_date from property_registration where seller_id=? and deleted_User=0 and approval='Approved' and register_status='Registered'";
			PreparedStatement preparedStatement = getConnection.prepareStatement(retriveProperties);
			preparedStatement.setString(1, propertyAddress);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				RealEstatePropertyRegister estatePropertyRegister = new RealEstatePropertyRegister();
				
				estatePropertyRegister.setSellerId(resultSet.getString(1));
				estatePropertyRegister.setPropertyName(resultSet.getString(2));
				estatePropertyRegister.setPropertyId(resultSet.getString(3));
				estatePropertyRegister.setPropertyPrice(resultSet.getLong(4));
				estatePropertyRegister.setPropertyImages(resultSet.getBytes(5));
				estatePropertyRegister.setPropertyDocument(resultSet.getBytes(6));				
				estatePropertyRegister.setPropertyAddress(resultSet.getString(7));
				estatePropertyRegister.setPropertyDistrict(resultSet.getString(8));
				estatePropertyRegister.setPropertyState(resultSet.getString(9));
				estatePropertyRegister.setApproval(resultSet.getString(10));
				estatePropertyRegister.setRegistered(resultSet.getString(11));
				estatePropertyRegister.setPayment(resultSet.getString(12));
				estatePropertyRegister.setRegisteredDate(resultSet.getString(13));
				estatePropertyRegister.setPurchasedDate(resultSet.getString(14));
				
				list.add(estatePropertyRegister);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}

	public  List<RealEstatePropertyRegister> updateCustomerId(String customerId, String propertyAddress) 
	{
		List<RealEstatePropertyRegister> list = new ArrayList<RealEstatePropertyRegister>();
		try
		{
			Connection getConnection = ConnectionJdbc.getConnection();
			String update = "update property_registration set customer_id = ? where property_address = ?";
			PreparedStatement preparedStatement = getConnection.prepareStatement(update);
			preparedStatement.setString(1, customerId);
			preparedStatement.setString(2, propertyAddress);
			
			preparedStatement.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
		
	}

	public void updatePaid(String customerId, String purchasedDate)
	{
		try
		{
			Connection getConnection = ConnectionJdbc.getConnection();
			String update = "update property_registration set payment_status = ?, purchased_date = ? where customer_id = ?";
			PreparedStatement preparedStatement = getConnection.prepareStatement(update);
			preparedStatement.setString(1, "Paid");
			preparedStatement.setString(2, purchasedDate);
			preparedStatement.setString(3, customerId);
			
			preparedStatement.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

	public List<RealEstatePropertyRegister> search(String id) 
	{
		List<RealEstatePropertyRegister> list = new ArrayList<RealEstatePropertyRegister>();
		try
		{
			Connection getConnection = ConnectionJdbc.getConnection();
			String retriveProperties = "select seller_id,property_name,property_id,property_price, property_images,property_document, property_address, property_district,property_state,approval, register_status,payment_status,registered_date,purchased_date from property_registration where seller_id = ? and payment_status='Paid' and deleted_User = 0";
			PreparedStatement preparedStatement = getConnection.prepareStatement(retriveProperties);
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				RealEstatePropertyRegister estatePropertyRegister = new RealEstatePropertyRegister();
				
				estatePropertyRegister.setSellerId(resultSet.getString(1));
				estatePropertyRegister.setPropertyName(resultSet.getString(2));
				estatePropertyRegister.setPropertyId(resultSet.getString(3));
				estatePropertyRegister.setPropertyPrice(resultSet.getLong(4));
				estatePropertyRegister.setPropertyImages(resultSet.getBytes(5));
				estatePropertyRegister.setPropertyDocument(resultSet.getBytes(6));
				estatePropertyRegister.setPropertyAddress(resultSet.getString(7));
				estatePropertyRegister.setPropertyDistrict(resultSet.getString(8));
				estatePropertyRegister.setPropertyState(resultSet.getString(9));
				estatePropertyRegister.setApproval(resultSet.getString(10));
				estatePropertyRegister.setRegistered(resultSet.getString(11));
				estatePropertyRegister.setPayment(resultSet.getString(12));
				estatePropertyRegister.setRegisteredDate(resultSet.getString(13));
				estatePropertyRegister.setPurchasedDate(resultSet.getString(14));
				
				list.add(estatePropertyRegister);
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;		
	}

	

}
