package com.nt;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import com.nt.sbeans.StudentInfo;

@SpringBootApplication
//@PropertySource("com/nt/commons/myfile.properties")
public class BootIocProj09ValueAnnotationSpelApplication {

	@Bean
	public   LocalDateTime  createDateTime() {
		return  LocalDateTime.now();
	}
	
	
	public static void main(String[] args) {
		
		
		try(ConfigurableApplicationContext ctx=
				    SpringApplication.run(BootIocProj09ValueAnnotationSpelApplication.class, args)){
			  //get access to Spring Bean class obj ref
			  StudentInfo  info=ctx.getBean("studInfo",StudentInfo.class);
			  System.out.println(info);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//main

}//class
