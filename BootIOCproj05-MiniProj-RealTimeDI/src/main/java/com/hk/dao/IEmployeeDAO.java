//IEmployeeDAO.java

package com.hk.dao;

import java.util.List;

import com.hk.model.Employee;

public interface IEmployeeDAO {
	
	public List<Employee> getEmpsByDesgs(String desg1,String desg2,String desg3)throws Exception;

}
