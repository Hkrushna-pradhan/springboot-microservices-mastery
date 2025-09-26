package com.hk; 

import java.time.LocalDate;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.hk.sbeans.SeasonFinder;
 
@SpringBootApplication
public class BootIoCproj01DependencyInjectionApplication {
	
	@Bean(name= "ldate")
	public LocalDate createDate() {
		System.out.println("BootIoCproj01DependencyInjectionApplication.createDate()");
		
		return LocalDate.now();
	}

	public static void main(String[] args) {
		//create the IOC Container
		try(ConfigurableApplicationContext ctx= SpringApplication.run(BootIoCproj01DependencyInjectionApplication.class, args)){
			//get spring bean class obj ref
			SeasonFinder finder = ctx.getBean("sf",SeasonFinder.class);
			System.out.println("Season :: "+finder.showSeasonName());
			
			//invoke the business method
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
