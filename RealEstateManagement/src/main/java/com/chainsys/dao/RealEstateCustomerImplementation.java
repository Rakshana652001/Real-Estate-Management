package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.model.CustomerPurchasedProperty;
import com.chainsys.util.ConnectionJdbc;

public class RealEstateCustomerImplementation 
{
	CustomerPurchasedProperty customerPurchasedProperty = new CustomerPurchasedProperty();

	public void saveProperties(CustomerPurchasedProperty customerPurchasedProperty) throws ClassNotFoundException, SQLException
	{
		Connection getConnection = ConnectionJdbc.getConnection();
		String insert = "insert into customer_registered_property (customer_id, total_amount, payment_method, approval, government_id, payabel_amount) values (?,?,?,?,?,?)";
		
		PreparedStatement preparedStatement = getConnection.prepareStatement(insert);
		
		preparedStatement.setString(1, customerPurchasedProperty.getCustomerId());
		preparedStatement.setLong(2, customerPurchasedProperty.getPropertyPrice());
		preparedStatement.setString(3, customerPurchasedProperty.getPaymentMethod());
		preparedStatement.setString(4, "Not Approved");
		preparedStatement.setBytes(5, customerPurchasedProperty.getGovernmentId());
		preparedStatement.setDouble(6, customerPurchasedProperty.getPayableAmount());
		
		preparedStatement.executeUpdate();
		getConnection.close();
	}

	public List<CustomerPurchasedProperty> registeredProperty(String getCustomerId)
	{
		ArrayList<CustomerPurchasedProperty> arrayList1 = new ArrayList<CustomerPurchasedProperty>();
		
		try
		{
			Connection getConnection = ConnectionJdbc.getConnection();
			String retrive = "select customer_id, total_amount, payment_method, approval, government_id, payabel_amount from customer_registered_property where customer_id=? and approval='Approved'";
			PreparedStatement preparedStatement = getConnection.prepareStatement(retrive);
			preparedStatement.setString(1, getCustomerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				CustomerPurchasedProperty customerPurchasedProperty = new CustomerPurchasedProperty();
				customerPurchasedProperty.setCustomerId(resultSet.getString(1));
				customerPurchasedProperty.setPropertyPrice(resultSet.getLong(2));
				customerPurchasedProperty.setPaymentMethod(resultSet.getString(3));
				customerPurchasedProperty.setApproval(resultSet.getString(4));
				customerPurchasedProperty.setGovernmentId(resultSet.getBytes(5));
				customerPurchasedProperty.setPayableAmount(resultSet.getDouble(6));
				
				arrayList1.add(customerPurchasedProperty);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return arrayList1;
	}
	
	
	public List<CustomerPurchasedProperty> registeredPropertyToApprove(String getCustomerId)
	{
		ArrayList<CustomerPurchasedProperty> arrayList1 = new ArrayList<CustomerPurchasedProperty>();
		
		try
		{
			Connection getConnection = ConnectionJdbc.getConnection();
			String retrive = "select customer_id, total_amount, payment_method, approval, government_id, payabel_amount from customer_registered_property where approval='Not Approved'";
			PreparedStatement preparedStatement = getConnection.prepareStatement(retrive);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				CustomerPurchasedProperty customerPurchasedProperty = new CustomerPurchasedProperty();
				customerPurchasedProperty.setCustomerId(resultSet.getString(1));
				customerPurchasedProperty.setPropertyPrice(resultSet.getLong(2));
				customerPurchasedProperty.setPaymentMethod(resultSet.getString(3));
				customerPurchasedProperty.setApproval(resultSet.getString(4));
				customerPurchasedProperty.setGovernmentId(resultSet.getBytes(5));
				customerPurchasedProperty.setPayableAmount(resultSet.getDouble(6));
				
				arrayList1.add(customerPurchasedProperty);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return arrayList1;
	}

	public List<CustomerPurchasedProperty> updateApproval(String customerId, String approval)
	{
		List<CustomerPurchasedProperty> list = new ArrayList<CustomerPurchasedProperty>();
		try
		{
			Connection getConnection = ConnectionJdbc.getConnection();
			String update = "update customer_registered_property set approval = ? where customer_id = ?";
			PreparedStatement preparedStatement = getConnection.prepareStatement(update);
			preparedStatement.setString(1, approval);
			preparedStatement.setString(2, customerId);
			
			preparedStatement.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
		
	}

	public List<CustomerPurchasedProperty> ApprovedProperties(String customerId) 
	{
		List<CustomerPurchasedProperty> list = new ArrayList<CustomerPurchasedProperty>();
		try
		{
			Connection getConnection = ConnectionJdbc.getConnection();
			String select = "select customer_id, total_amount, payment_method, approval, government_id, payabel_amount from customer_registered_property where approval='Approved'";
			PreparedStatement preparedStatement = getConnection.prepareStatement(select);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				CustomerPurchasedProperty customerPurchasedProperty = new CustomerPurchasedProperty();
				customerPurchasedProperty.setCustomerId(resultSet.getString(1));
				customerPurchasedProperty.setPropertyPrice(resultSet.getLong(2));
				customerPurchasedProperty.setPaymentMethod(resultSet.getString(3));
				customerPurchasedProperty.setApproval(resultSet.getString(4));
				customerPurchasedProperty.setGovernmentId(resultSet.getBytes(5));
				customerPurchasedProperty.setPayableAmount(resultSet.getDouble(6));
				
				list.add(customerPurchasedProperty);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}

	public List<CustomerPurchasedProperty> retrivePropertyDetails(String getCustomerId)
	{
		List<CustomerPurchasedProperty> list = new ArrayList<CustomerPurchasedProperty>();
		try
		{
			Connection getConnection = ConnectionJdbc.getConnection();
			String select = "select customer_id, total_amount, payment_method, approval, government_id, payabel_amount from customer_registered_property where customer_id = ? and deleted_User=0";
			PreparedStatement preparedStatement = getConnection.prepareStatement(select);
			preparedStatement.setString(1, getCustomerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				CustomerPurchasedProperty customerPurchasedProperty = new CustomerPurchasedProperty();
				customerPurchasedProperty.setCustomerId(resultSet.getString(1));
				customerPurchasedProperty.setPropertyPrice(resultSet.getLong(2));
				customerPurchasedProperty.setPaymentMethod(resultSet.getString(3));
				customerPurchasedProperty.setApproval(resultSet.getString(4));
				customerPurchasedProperty.setGovernmentId(resultSet.getBytes(5));
				customerPurchasedProperty.setPayableAmount(resultSet.getDouble(6));
				
				list.add(customerPurchasedProperty);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}

	public List<CustomerPurchasedProperty> updateApproval(String propertyAddress, String approval,String registerStatus) 
	{
		List<CustomerPurchasedProperty> list = new ArrayList<CustomerPurchasedProperty>();
		try
		{
			Connection getConnection = ConnectionJdbc.getConnection();
			String update = "update customer_registered_property set approval = ? where property_address = ?";
			PreparedStatement preparedStatement = getConnection.prepareStatement(update);
			preparedStatement.setString(1, approval);
			preparedStatement.setString(2, registerStatus);
			preparedStatement.setString(3, propertyAddress);
			
			preparedStatement.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}

	
	
}
