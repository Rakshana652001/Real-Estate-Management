package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.model.CustomerPurchasedProperty;
import com.chainsys.model.RealEstatePropertyRegister;
import com.chainsys.util.ConnectionJdbc;

public class RealEstateCustomerImplementation 
{
	CustomerPurchasedProperty customerPurchasedProperty = new CustomerPurchasedProperty();

	public void saveProperties(CustomerPurchasedProperty customerPurchasedProperty) throws ClassNotFoundException, SQLException
	{
		Connection getConnection = ConnectionJdbc.getConnection();
		String insert = "insert into customer_registered_property (customer_id,seller_id, total_amount, payment_method, approval,property_address, government_id, payabel_amount, payed_status) values (?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement preparedStatement = getConnection.prepareStatement(insert);
		
		preparedStatement.setString(1, customerPurchasedProperty.getCustomerId());
		preparedStatement.setString(2, customerPurchasedProperty.getSellerId());
		preparedStatement.setLong(3, customerPurchasedProperty.getPropertyPrice());
		preparedStatement.setString(4, customerPurchasedProperty.getPaymentMethod());
		preparedStatement.setString(5, "Not Approved");
		preparedStatement.setString(6, customerPurchasedProperty.getPropertyAddress());
		preparedStatement.setBytes(7, customerPurchasedProperty.getGovernmentId());
		preparedStatement.setDouble(8, customerPurchasedProperty.getPayableAmount());
		preparedStatement.setString(9, "Not Payed");
		
		preparedStatement.executeUpdate();
		getConnection.close();
	}

	public List<CustomerPurchasedProperty> registeredProperty(String getCustomerId)
	{
		ArrayList<CustomerPurchasedProperty> arrayList1 = new ArrayList<CustomerPurchasedProperty>();
		
		try
		{
			Connection getConnection = ConnectionJdbc.getConnection();
			String retrive = "select customer_id,property_address, total_amount, payment_method, approval, government_id, payabel_amount from customer_registered_property where payed_status='Not Payed' and customer_id=? and approval='Approved' and deleted_User=0";
			PreparedStatement preparedStatement = getConnection.prepareStatement(retrive);
			preparedStatement.setString(1, getCustomerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				CustomerPurchasedProperty customerPurchasedProperty = new CustomerPurchasedProperty();
				customerPurchasedProperty.setCustomerId(resultSet.getString(1));
				customerPurchasedProperty.setPropertyAddress(resultSet.getString(2));
				customerPurchasedProperty.setPropertyPrice(resultSet.getLong(3));
				customerPurchasedProperty.setPaymentMethod(resultSet.getString(4));
				customerPurchasedProperty.setApproval(resultSet.getString(5));
				customerPurchasedProperty.setGovernmentId(resultSet.getBytes(6));
				customerPurchasedProperty.setPayableAmount(resultSet.getDouble(7));
				
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
			String retrive = "select customer_id,property_address, total_amount, payment_method, approval, government_id, payabel_amount from customer_registered_property where approval='Not Approved' and deleted_User=0";
			PreparedStatement preparedStatement = getConnection.prepareStatement(retrive);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				CustomerPurchasedProperty customerPurchasedProperty = new CustomerPurchasedProperty();
				customerPurchasedProperty.setCustomerId(resultSet.getString(1));
				customerPurchasedProperty.setPropertyAddress(resultSet.getString(2));
				customerPurchasedProperty.setPropertyPrice(resultSet.getLong(3));
				customerPurchasedProperty.setPaymentMethod(resultSet.getString(4));
				customerPurchasedProperty.setApproval(resultSet.getString(5));
				customerPurchasedProperty.setGovernmentId(resultSet.getBytes(6));
				customerPurchasedProperty.setPayableAmount(resultSet.getDouble(7));
				
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

	public List<CustomerPurchasedProperty> ApprovedProperties(String id) 
	{
		List<CustomerPurchasedProperty> list = new ArrayList<CustomerPurchasedProperty>();
		try
		{
			Connection getConnection = ConnectionJdbc.getConnection();
			String select = "select customer_id,property_address, total_amount, payment_method, approval, government_id, payabel_amount, payed_status from customer_registered_property where payed_status='Paid'";
			PreparedStatement preparedStatement = getConnection.prepareStatement(select);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				CustomerPurchasedProperty customerPurchasedProperty = new CustomerPurchasedProperty();
				customerPurchasedProperty.setCustomerId(resultSet.getString(1));
				customerPurchasedProperty.setPropertyAddress(resultSet.getString(2));
				customerPurchasedProperty.setPropertyPrice(resultSet.getLong(3));
				customerPurchasedProperty.setPaymentMethod(resultSet.getString(4));
				customerPurchasedProperty.setApproval(resultSet.getString(5));
				customerPurchasedProperty.setGovernmentId(resultSet.getBytes(6));
				customerPurchasedProperty.setPayableAmount(resultSet.getDouble(7));
				customerPurchasedProperty.setPaymentStatus(resultSet.getString(8));
				
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
			String select = "select customer_id,property_address, total_amount, payment_method, approval, government_id, payabel_amount,payed_status from customer_registered_property where approval='Not Approved' and customer_id = ? and deleted_User=0";
			PreparedStatement preparedStatement = getConnection.prepareStatement(select);
			preparedStatement.setString(1, getCustomerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				CustomerPurchasedProperty customerPurchasedProperty = new CustomerPurchasedProperty();
				customerPurchasedProperty.setCustomerId(resultSet.getString(1));
				customerPurchasedProperty.setPropertyAddress(resultSet.getString(2));
				customerPurchasedProperty.setPropertyPrice(resultSet.getLong(3));
				customerPurchasedProperty.setPaymentMethod(resultSet.getString(4));
				customerPurchasedProperty.setApproval(resultSet.getString(5));
				customerPurchasedProperty.setGovernmentId(resultSet.getBytes(6));
				customerPurchasedProperty.setPayableAmount(resultSet.getDouble(7));
				customerPurchasedProperty.setPaymentStatus(resultSet.getString(8));
				
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
			preparedStatement.setString(2, propertyAddress);
			
			preparedStatement.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}

	public List<CustomerPurchasedProperty> updatePayment(long accountNumber1, long accountNumber2, String customerId)
	{
		List<CustomerPurchasedProperty> list = new ArrayList<CustomerPurchasedProperty>();
		try
		{
			Connection getConnection = ConnectionJdbc.getConnection();
			String update = "update customer_registered_property set customer_account=?, seller_account=?, payed_status = ? where customer_id = ?";
			PreparedStatement preparedStatement = getConnection.prepareStatement(update);
			preparedStatement.setLong(1, accountNumber1);
			preparedStatement.setLong(2,accountNumber2);
			preparedStatement.setString(3, "Paid");
			preparedStatement.setString(4, customerId);
			preparedStatement.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}

	public List<RealEstatePropertyRegister> retriveBuyedProperties(String customerId)
	{
		List<RealEstatePropertyRegister> list = new ArrayList<RealEstatePropertyRegister>();
		try
		{
			Connection getConnection = ConnectionJdbc.getConnection();
			String retriveProperties = "select seller_id, property_name,property_id,property_price, property_images,property_document, property_address, property_district,property_state,approval, register_status,payment_status from property_registration where customer_id = ? and deleted_User = 0";
			PreparedStatement preparedStatement = getConnection.prepareStatement(retriveProperties);
			preparedStatement.setString(1, customerId);
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
				
				list.add(estatePropertyRegister);
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}

	public List<CustomerPurchasedProperty> paidProperties(String getAddress)
	{
		List<CustomerPurchasedProperty> list = new ArrayList<CustomerPurchasedProperty>();
		try
		{
			Connection getConnection = ConnectionJdbc.getConnection();
			String select = "select customer_id,property_address, total_amount, payment_method, approval,customer_account,seller_account, payabel_amount,payed_status from customer_registered_property where property_address = ? and deleted_User=0 and payed_status='Paid'";
			PreparedStatement preparedStatement = getConnection.prepareStatement(select);
			preparedStatement.setString(1, getAddress);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				CustomerPurchasedProperty customerPurchasedProperty = new CustomerPurchasedProperty();
				customerPurchasedProperty.setCustomerId(resultSet.getString(1));
				customerPurchasedProperty.setPropertyAddress(resultSet.getString(2));
				customerPurchasedProperty.setPropertyPrice(resultSet.getLong(3));
				customerPurchasedProperty.setPaymentMethod(resultSet.getString(4));
				customerPurchasedProperty.setApproval(resultSet.getString(5));
				customerPurchasedProperty.setYourAccountNumber(resultSet.getLong(6));
				customerPurchasedProperty.setSenderAccountNumber(resultSet.getLong(7));
				customerPurchasedProperty.setPayableAmount(resultSet.getDouble(8));
				customerPurchasedProperty.setPaymentStatus(resultSet.getString(9));
				customerPurchasedProperty.setPropertyAddress(resultSet.getString(10));
				
				list.add(customerPurchasedProperty);
			}		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}

	public List<CustomerPurchasedProperty> retriveProperties(String getAddress)
	{
		List<CustomerPurchasedProperty> list = new ArrayList<CustomerPurchasedProperty>();
		try
		{
			Connection getConnection = ConnectionJdbc.getConnection();
			String select = "select customer_id,property_address, total_amount, payment_method, approval, government_id, payabel_amount, payed_status from customer_registered_property where seller_id=? and payed_status='Paid'";
			PreparedStatement preparedStatement = getConnection.prepareStatement(select);
			preparedStatement.setString(1, getAddress);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				CustomerPurchasedProperty customerPurchasedProperty = new CustomerPurchasedProperty();
				customerPurchasedProperty.setCustomerId(resultSet.getString(1));
				customerPurchasedProperty.setPropertyAddress(resultSet.getString(2));
				customerPurchasedProperty.setPropertyPrice(resultSet.getLong(3));
				customerPurchasedProperty.setPaymentMethod(resultSet.getString(4));
				customerPurchasedProperty.setApproval(resultSet.getString(5));
				customerPurchasedProperty.setGovernmentId(resultSet.getBytes(6));
				customerPurchasedProperty.setPayableAmount(resultSet.getDouble(7));
				customerPurchasedProperty.setPaymentStatus(resultSet.getString(8));
				
				list.add(customerPurchasedProperty);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}
	
}
