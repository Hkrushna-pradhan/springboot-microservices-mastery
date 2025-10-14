//BootIocProj05MiniProjRealtimeDiApplication.java
package com.nt;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import com.nt.controller.EmployeeOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootIocProj15MiniProjProfiles {

	public static void main(String[] args) {
		System.out.println("start of  main(-) method");
		try(ConfigurableApplicationContext ctx=SpringApplication.run(BootIocProj15MiniProjProfiles.class, args); 
				Scanner sc=new Scanner(System.in);
				){
			  //read the desgs from  enduser
			  System.out.println("Enter  Desg1::");
			  String desg1=sc.next();
			  System.out.println("Enter  Desg2::");
			  String desg2=sc.next();
			  System.out.println("Enter  Desg3::");
			  String desg3=sc.next();
			  //get Controller class obj  
			  EmployeeOperationsController  controller=
					  ctx.getBean("empController",EmployeeOperationsController.class);
			  //invoke the  b.method
			  List<Employee> list=controller.showEmployeesByDesgs(desg1, desg2, desg3);
			  //process the result
			  System.out.println("Employees  having "+desg1+"...."+desg2+"...."+desg3);
			 if(list.size()!=0) {
			  list.forEach(emp->{
				  System.out.println(emp);
			  });
			 }
			 else {
				 System.out.println("No Employees found");
			 }
			 System.out.println("============================================");
			 System.out.println("Enter  emp name ::");
			 String name=sc.next();
			 System.out.println("Enter  emp desg ::");
			 String desg=sc.next();
			 System.out.println("Enter  emp salary ::");
			 double salary=sc.nextDouble();
			 //create Model class obj having inputs
			 Employee emp=new Employee(name,desg,salary);
			 //invoke the  b.method
			 String msg=controller.doRegisterEmployee(emp);
			 System.out.println(msg);
			 System.out.println("-----------------------------");
			 Environment env=ctx.getEnvironment();
			 System.out.println("Current active profile is ::"+Arrays.toString(env.getActiveProfiles()));
		}
		catch(Exception e) {
			System.out.println("Internal Problem ::"+e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("start of  main(-) method");
			
	}//main

}//class
