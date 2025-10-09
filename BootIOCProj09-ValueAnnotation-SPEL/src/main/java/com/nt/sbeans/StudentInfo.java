//StudentInfo.java
package com.nt.sbeans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.ToString;

@Component("studInfo")
@ToString
public class StudentInfo {
	@Value("1001")  //injecting the values directly
	private Integer sno;
	 //Injecting the values collected from properties file
	@Value("${stud.info.name}")
	private String  sname;
	@Value("${stud.info.addrs}")
	private  String  addrs;
	@Value("${stud.info.age}")
	private  Integer  age;
	//Injecting the  System property values
	@Value("${os.name}")
	private String osname;
	@Value("${user.name}")
	private  String  username;
	//Injecting the Env variable values
	@Value("${Path}")
	private  String  pathData;
	@Value("#{catalog.javaRate + catalog.advjavaRate + catalog.spbmsRate + catalog.devopsRate + catalog.awsRate + catalog.oracleRate + catalog.reactjsRate  }")
	private   Double  fullstackPrice;
	@Value("#{catalog.spbmsRate > 8000 }")
	private  boolean isSpbmsPriceHigh;
	
	/*@Value("#{studInfo.fullstackPrice - (studInfo.fullstackPrice * 0.3)}")
	private   double  fullstackFinalPrice;
	*/
	//@Autowired
	@Value("#{catalog}")
	private   CourseCatalog  catalog;
	@Value("#{createDateTime}")
	private  LocalDateTime  ldt;
	
	

}
