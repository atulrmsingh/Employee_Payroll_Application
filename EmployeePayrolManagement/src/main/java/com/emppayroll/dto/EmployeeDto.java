package com.emppayroll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	private String name;
	private int age;
	private String email;
	private String department;
	private String role;
	private Double salary;

}
