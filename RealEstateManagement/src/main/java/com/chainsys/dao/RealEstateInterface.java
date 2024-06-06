package com.chainsys.dao;

import java.sql.SQLException;

import com.chainsys.model.RealEstateUserRegister;

public interface RealEstateInterface 
{
	public void userRegistration(RealEstateUserRegister estateUserRegister) throws ClassNotFoundException, SQLException;
	
}
