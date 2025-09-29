package com.hk.model;

import lombok.Data;

@Data
public class Employee {
	private Integer eno;
	private String ename;
	private String desg;
	private Double salary;
	private Double grossSalary;
	private Double netSalary;

}
