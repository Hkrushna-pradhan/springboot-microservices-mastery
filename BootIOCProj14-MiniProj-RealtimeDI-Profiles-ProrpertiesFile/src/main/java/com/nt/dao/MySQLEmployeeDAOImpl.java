//MySQL DAO Impl class
package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empDAO-mysql")
@Profile({"dev","test","default"})
public class MySQLEmployeeDAOImpl implements IEmployeeDAO {
	private  static final String GET_EMPS_BY_DESGS="SELECT ENO,ENAME,DESG,SALARY  FROM EMPLOYEE WHERE DESG IN(?,?,?) ORDER BY DESG";
	private  static final String INSERT_EMP_QUERY="INSERT INTO EMPLOYEE(ENAME,DESG,SALARY) VALUES(?,?,?)";
	
	@Autowired
	private  DataSource ds;
	
	public MySQLEmployeeDAOImpl() {
		System.out.println("MysqlEmployeeDAOImpl:: 0-param constructor");
	}

	@Override
	public List<Employee> getEmpsByDesgs(String desg1, String desg2, String desg3) throws Exception {
		System.out.println("MySQLEmployeeDAOImpl.getEmpsByDesgs()--> ds obj class name::"+ds.getClass());
		 List<Employee>  list=null;
		try(// get pooled jdbc con 
				   Connection con=ds.getConnection();
				  //create PreparedStatement object
				   PreparedStatement ps=con.prepareStatement(GET_EMPS_BY_DESGS);
				){
			    //set  the values to query params
			    ps.setString(1, desg1);ps.setString(2, desg2); ps.setString(3, desg3);
			    //execute the SElect Query  and get ResultSet object
			    try(ResultSet rs=ps.executeQuery()){
			    	   //copy  the records of ResultSet object to  List collection  as the  Java Bean class objs
			    	list=new ArrayList<Employee>();
			    	  while(rs.next()) {
			    		  //copy  each  record to JAva Bean class obj
			    		  Employee  emp=new Employee();
			    		  emp.setEno(rs.getInt(1));
			    		  emp.setEname(rs.getString(2));
			    		  emp.setDesg(rs.getString(3));
			    		  emp.setSalary(rs.getDouble(4));
			    		  //add Each Java Bean class obj (model obj) to List Collection
			    		  list.add(emp);
			    	  }//while
			    }//try2
		}//try1
		catch(SQLException se) {  //for handling known exceptions
			throw se; // Exception rethrowing for  exception propagation
		}
		catch(Exception e) {
			throw e; // Exception rethrowing for  exception propagation
		}
		return list;
	}//method
	
	@Override
	public int insert(Employee emp) throws Exception {
		   try(//get pooled jdbc con object
	    		 Connection con=ds.getConnection();
	    		//create PreparedStatement object
	    		PreparedStatement ps=con.prepareStatement(INSERT_EMP_QUERY);
	    		){
	    	    //set the values to query params
	    	     ps.setString(1, emp.getEname()); ps.setString(2,emp.getDesg());
	    	     ps.setDouble(3, emp.getSalary());
	    	     //execute the Query (non-select SQL Query)
	    	     int count=ps.executeUpdate();
	    	     return count;
	    }
	    catch(SQLException se) {
	    	throw se; //Exception rethrowing
	    }
	    catch(Exception e) {
	    	throw e;  //Exception rethrowing
	    }
	}

}//class
