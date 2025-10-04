package com.hk.service;

import java.util.List;

import com.hk.model.Employee;

public interface IEmployeeMgmtService {
	public List<Employee> fetchEmpsByDesgs(String desg1, String desg2, String desg3) throws Exception;

}
