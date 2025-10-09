package com.hk.factory;

import org.springframework.beans.factory.FactoryBean;

import com.hk.dao.IEmployeeDAO;

public class DAOFactory implements FactoryBean<IEmployeeDAO> {

	@Override
	public IEmployeeDAO getObject() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return null;
	}


}
