package com.chainsys.model;

import java.util.Arrays;

public class RealEstatePropertyRegister 
{
	String sellerId;
	String propertyId;
	String propertyName;
	long propertyPrice;
	byte[] propertyImages;
	String propertyAddress;
	String propertyDistrict;
	String	propertyState;
	
	public RealEstatePropertyRegister()
	{
		
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
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

	public long getPropertyPrice() {
		return propertyPrice;
	}

	public void setPropertyPrice(long propertyPrice) {
		this.propertyPrice = propertyPrice;
	}

	public byte[] getPropertyImages() {
		return propertyImages;
	}

	public void setPropertyImages(byte[] propertyImages) {
		this.propertyImages = propertyImages;
	}

	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public String getPropertyDistrict() {
		return propertyDistrict;
	}

	public void setPropertyDistrict(String propertyDistrict) {
		this.propertyDistrict = propertyDistrict;
	}

	public String getPropertyState() {
		return propertyState;
	}

	public void setPropertyState(String propertyState) {
		this.propertyState = propertyState;
	}

	@Override
	public String toString() {
		return "RealEstatePropertyRegister [sellerId=" + sellerId + ", propertyId=" + propertyId + ", propertyName="
				+ propertyName + ", propertyPrice=" + propertyPrice + ", propertyImages="
				+ Arrays.toString(propertyImages) + ", propertyAddress=" + propertyAddress + ", propertyDistrict="
				+ propertyDistrict + ", propertyState=" + propertyState + "]";
	}
	
}
