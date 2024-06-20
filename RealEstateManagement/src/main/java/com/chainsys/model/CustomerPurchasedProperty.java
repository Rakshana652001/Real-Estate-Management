package com.chainsys.model;

import java.util.Arrays;

public class CustomerPurchasedProperty 
{
	String customerId;
	String customerName;
	long contactNumber;
	String customerAddress;
	String customerDistrict;
	String customerState;
	byte[] governmentId;
    String propertyId;
    String propertyName;
    String propertyAddress;
    long propertyPrice;  //total amount
    String paymentMethod;
    Double payableAmount; //first pay amount
    String approval;
    String registered;
    String paymentStatus;
    long yourAccountNumber;
    long senderAccountNumber;
    Double amount;
    String sellerId;
    String purchasedDate;
    String registeredDate;
    
    
	public CustomerPurchasedProperty()
	{
		
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public long getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getCustomerAddress() {
		return customerAddress;
	}


	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}


	public String getCustomerDistrict() {
		return customerDistrict;
	}


	public void setCustomerDistrict(String customerDistrict) {
		this.customerDistrict = customerDistrict;
	}


	public String getCustomerState() {
		return customerState;
	}


	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}


	public byte[] getGovernmentId() {
		return governmentId;
	}


	public void setGovernmentId(byte[] governmentId) {
		this.governmentId = governmentId;
	}


	public String getPropertyId() {
		return propertyId;
	}


	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}


	public String getPropertyName() {
		return propertyName;
	}


	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}


	public String getPropertyAddress() {
		return propertyAddress;
	}


	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}


	public long getPropertyPrice() {
		return propertyPrice;
	}


	public void setPropertyPrice(long propertyPrice) {
		this.propertyPrice = propertyPrice;
	}


	public String getPaymentMethod() {
		return paymentMethod;
	}


	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}


	public Double getPayableAmount() {
		return payableAmount;
	}


	public void setPayableAmount(Double payableAmount) {
		this.payableAmount = payableAmount;
	}


	public String getApproval() {
		return approval;
	}


	public void setApproval(String approval) {
		this.approval = approval;
	}


	public String getRegistered() {
		return registered;
	}


	public void setRegistered(String registered) {
		this.registered = registered;
	}


	public String getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	public long getYourAccountNumber() {
		return yourAccountNumber;
	}


	public void setYourAccountNumber(long yourAccountNumber) {
		this.yourAccountNumber = yourAccountNumber;
	}


	public long getSenderAccountNumber() {
		return senderAccountNumber;
	}


	public void setSenderAccountNumber(long senderAccountNumber) {
		this.senderAccountNumber = senderAccountNumber;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public String getSellerId() {
		return sellerId;
	}


	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}


	public String getPurchasedDate() {
		return purchasedDate;
	}


	public void setPurchasedDate(String purchasedDate) {
		this.purchasedDate = purchasedDate;
	}


	public String getRegisteredDate() {
		return registeredDate;
	}


	public void setRegisteredDate(String registeredDate) {
		this.registeredDate = registeredDate;
	}


	@Override
	public String toString() {
		return "CustomerPurchasedProperty [customerId=" + customerId + ", customerName=" + customerName
				+ ", contactNumber=" + contactNumber + ", customerAddress=" + customerAddress + ", customerDistrict="
				+ customerDistrict + ", customerState=" + customerState + ", governmentId="
				+ Arrays.toString(governmentId) + ", propertyId=" + propertyId + ", propertyName=" + propertyName
				+ ", propertyAddress=" + propertyAddress + ", propertyPrice=" + propertyPrice + ", paymentMethod="
				+ paymentMethod + ", payableAmount=" + payableAmount + ", approval=" + approval + ", registered="
				+ registered + ", paymentStatus=" + paymentStatus + ", yourAccountNumber=" + yourAccountNumber
				+ ", senderAccountNumber=" + senderAccountNumber + ", amount=" + amount + ", sellerId=" + sellerId
				+ ", purchasedDate=" + purchasedDate + ", registeredDate=" + registeredDate + "]";
	}



}
