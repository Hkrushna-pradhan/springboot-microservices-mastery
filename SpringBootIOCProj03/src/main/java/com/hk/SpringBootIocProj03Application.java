package com.hk;

import com.hk.sbeans.Cricketer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("cfgs/applicationContext.xml")
public class SpringBootIocProj03Application {


	public static void main(String[] args) {
		  //get access to IOC container
		try(ConfigurableApplicationContext  ctx=SpringApplication.run(SpringBootIocProj03Application.class, args);){
			   //get access to  target spring bean class obj ref
			   Cricketer  cktr=ctx.getBean("cktr",Cricketer.class);
			    //invoke the b.methods
			   System.out.println("Batting Score ::"+cktr.batting("kohli"));
			   System.out.println("Bowling Score ::"+cktr.bowlingInfo("bumra"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
