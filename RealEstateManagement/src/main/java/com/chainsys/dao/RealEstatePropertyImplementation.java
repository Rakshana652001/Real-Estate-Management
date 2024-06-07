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
		String saveProperties = "insert into property_registration (seller_id,property_name,property_id,property_price, property_images,property_address, property_district,property_state) values (?,?,?,?,?,?,?,?)";
		PreparedStatement insertStatement = getConnection.prepareStatement(saveProperties);
		insertStatement.setString(1, estatePropertyRegister.getSellerId());
		insertStatement.setString(2, estatePropertyRegister.getPropertyName());
		insertStatement.setString(3, estatePropertyRegister.getPropertyId());
		insertStatement.setLong(4, estatePropertyRegister.getPropertyPrice());
		insertStatement.setBytes(5, estatePropertyRegister.getPropertyImages());
		insertStatement.setString(6, estatePropertyRegister.getPropertyAddress());
		insertStatement.setString(7, estatePropertyRegister.getPropertyDistrict());
		insertStatement.setString(8, estatePropertyRegister.getPropertyState());
		
		insertStatement.executeUpdate();
		getConnection.close();		
	}

	public List<RealEstatePropertyRegister> retriveDetails(String sellerId)
	{
		List<RealEstatePropertyRegister> list = new ArrayList<RealEstatePropertyRegister>();
		try
		{
			System.out.println("Inside method");
			Connection getConnection = ConnectionJdbc.getConnection();
			String retriveProperties = "select seller_id,property_name,property_id,property_price, property_images,property_address, property_district,property_state from property_registration where seller_id = ?";
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
				estatePropertyRegister.setPropertyAddress(resultSet.getString(6));
				estatePropertyRegister.setPropertyDistrict(resultSet.getString(7));
				estatePropertyRegister.setPropertyState(resultSet.getString(8));
				
				list.add(estatePropertyRegister);
			}
		}
		catch(Exception e)
		{
			
		}
		return list;
	
		
	}
	
	public List<RealEstatePropertyRegister> retriveAllSellerDetails(String sellerId)
	{
		List<RealEstatePropertyRegister> list = new ArrayList<RealEstatePropertyRegister>();
		try
		{
			System.out.println("Inside method");
			Connection getConnection = ConnectionJdbc.getConnection();
			String retriveProperties = "select seller_id,property_name,property_id,property_price, property_images, property_address, property_district,property_state from property_registration";
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
			System.out.println("Inside method");
			Connection getConnection = ConnectionJdbc.getConnection();
			String retriveProperties = "select seller_id,property_name,property_id,property_price,property_images ,property_address, property_district,property_state from property_registration where property_name = 'Residential' and deleted_User=0";
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
				System.out.println(resultSet.getBytes(5));
				estatePropertyRegister.setPropertyAddress(resultSet.getString(6));
				estatePropertyRegister.setPropertyDistrict(resultSet.getString(7));
				estatePropertyRegister.setPropertyState(resultSet.getString(8));
				
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
			System.out.println("Inside method");
			Connection getConnection = ConnectionJdbc.getConnection();
			String retriveProperties = "select seller_id,property_name,property_id,property_price, property_images ,property_address, property_district,property_state from property_registration where property_name = 'Land' and deleted_User=0";
			PreparedStatement preparedStatement = getConnection.prepareStatement(retriveProperties);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				System.out.println("Inside while");
				RealEstatePropertyRegister estatePropertyRegister = new RealEstatePropertyRegister();
				
				estatePropertyRegister.setSellerId(resultSet.getString(1));
				estatePropertyRegister.setPropertyName(resultSet.getString(2));
				estatePropertyRegister.setPropertyId(resultSet.getString(3));
				estatePropertyRegister.setPropertyPrice(resultSet.getLong(4));
				estatePropertyRegister.setPropertyImages(resultSet.getBytes(5));
				estatePropertyRegister.setPropertyAddress(resultSet.getString(6));
				estatePropertyRegister.setPropertyDistrict(resultSet.getString(7));
				estatePropertyRegister.setPropertyState(resultSet.getString(8));
				
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
			System.out.println("Inside method");
			Connection getConnection = ConnectionJdbc.getConnection();
			String retriveProperties = "select seller_id,property_name,property_id,property_price, property_images, property_address, property_district,property_state from property_registration where property_name = 'Industrial' and deleted_User=0";
			PreparedStatement preparedStatement = getConnection.prepareStatement(retriveProperties);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				System.out.println("Inside while");
				RealEstatePropertyRegister estatePropertyRegister = new RealEstatePropertyRegister();
				
				estatePropertyRegister.setSellerId(resultSet.getString(1));
				estatePropertyRegister.setPropertyName(resultSet.getString(2));
				estatePropertyRegister.setPropertyId(resultSet.getString(3));
				estatePropertyRegister.setPropertyPrice(resultSet.getLong(4));
				estatePropertyRegister.setPropertyImages(resultSet.getBytes(5));
				estatePropertyRegister.setPropertyAddress(resultSet.getString(6));
				estatePropertyRegister.setPropertyDistrict(resultSet.getString(7));
				estatePropertyRegister.setPropertyState(resultSet.getString(8));
				
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
			System.out.println("Inside method");
			Connection getConnection = ConnectionJdbc.getConnection();
			String retriveProperties = "select seller_id,property_name,property_id,property_price,property_images, property_address, property_district,property_state from property_registration where property_name = 'Commercial' and deleted_User=0";
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
