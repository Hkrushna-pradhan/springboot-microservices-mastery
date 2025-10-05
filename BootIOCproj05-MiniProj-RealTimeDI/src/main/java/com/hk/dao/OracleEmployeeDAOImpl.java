package com.hk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;   // ✅ Add this
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.model.Employee;

@Repository("empDAO")
public class OracleEmployeeDAOImpl implements IEmployeeDAO {
	
	private static final String GET_EMPS_BY_DEGS =
		"SELECT EMPNO , ENAME, JOB, SAL FROM EMP WHERE JOB IN (?,?,?) ORDER BY JOB";
	
	@Autowired
	private DataSource ds;
	
	public OracleEmployeeDAOImpl() {
		System.out.println("EmployeeDAOImpl:: 0-param Constructor )");
	}

	@Override
	public List<Employee> getEmpsByDesgs(String desg1, String desg2, String desg3) throws Exception {
		System.out.println("EmployeeDAOImpl.getEmpsByDesgs()--> ds obj class name::"+ds.getClass());
		
		// ✅ Always initialize list
		List<Employee> list = new ArrayList<>();
		
		try (
			Connection connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement(GET_EMPS_BY_DEGS);
		) {
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Employee employee = new Employee();
					employee.setEno(rs.getInt(1));
					employee.setEname(rs.getString(2));
					employee.setDesg(rs.getString(3));
					employee.setSalary(rs.getDouble(4));
					
					list.add(employee);   // ✅ Safe now
				}
			}
		}
		catch (SQLException se) {
			throw se; // re-throwing
		}
		catch (Exception e) {
			throw e; // re-throwing
		}
		
		return list;
	}
}
