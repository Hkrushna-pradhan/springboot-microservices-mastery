//CourseCatalog.java
package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.ToString;

@Component("catalog")
@ToString
@Getter
public class CourseCatalog {
	@Value("${course.catalog.javaprice}")
	private double javaRate;
	@Value("${course.catalog.advjavaprice}")
	private double advjavaRate;
	@Value("${course.catalog.spbmsprice}")
	private double spbmsRate;
	@Value("${course.catalog.devopsprice}")
	private double devopsRate;
	@Value("${course.catalog.awsprice}")
	private double awsRate;
	@Value("${course.catalog.oracleprice}")
	private double oracleRate;
	@Value("${course.catalog.reactjsprice}")
	private double reactjsRate;
	
	
	
	
	

}
