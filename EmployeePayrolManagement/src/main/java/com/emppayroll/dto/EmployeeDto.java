package com.emppayroll.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	@NotEmpty(message = "enter a valid name")
	private String name;
	//private varb profileImage;
	@NotEmpty
	private String gender;
	private double salary;
	private Date startDate;
	private Date entryDate;
	@NotEmpty
	private String notes;
	@NotNull
	private List<DepartmentDto> department;

}
