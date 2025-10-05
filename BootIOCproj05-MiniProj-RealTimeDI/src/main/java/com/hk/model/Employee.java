package com.hk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Employee {
	
	private Integer eno;
	@NonNull
	private String ename;
	@NonNull
	private String desg;
	@NonNull
	private Double salary;
	private Double grossSalary;
	private Double netSalary;

	public Employee() {
		System.out.println("Employee:: 0-param constructor");
	}
}
