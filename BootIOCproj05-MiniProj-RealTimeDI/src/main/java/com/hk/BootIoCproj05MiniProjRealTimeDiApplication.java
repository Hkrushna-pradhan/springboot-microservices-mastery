package com.hk;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.hk.controller.EmployeeOperationsController;
import com.hk.model.Employee;

@SpringBootApplication
public class BootIoCproj05MiniProjRealTimeDiApplication {

	public static void main(String[] args) {
		try(ConfigurableApplicationContext ctx = SpringApplication.run(BootIoCproj05MiniProjRealTimeDiApplication.class, args);
				Scanner sc = new Scanner(System.in);
				){
			//read the desgs from enduser
			System.out.println("Enter Desg1::");
			String desg1 = sc.next();
			
			System.out.println("Enter Desg2::");
			String desg2 = sc.next();
			
			System.out.println("Enter Desg3::");
			String desg3 = sc.next();
			
			//get Controller class obj
			EmployeeOperationsController controller = ctx.getBean("empController", EmployeeOperationsController.class);
			
			//invoke the b.method
			List<Employee> list = controller.showEmployeesByDesgs(desg1, desg2, desg3);
			
			//process the result
			
			System.out.println("Employees having "+desg1+"..."+desg2+"..."+desg3);
			list.forEach(emp->{
				System.out.println(emp);
			});
			
		}
		catch (Exception e) {
			System.out.println("Internal Problem:: "+e.getMessage());
			e.printStackTrace();
		}
	}

}
