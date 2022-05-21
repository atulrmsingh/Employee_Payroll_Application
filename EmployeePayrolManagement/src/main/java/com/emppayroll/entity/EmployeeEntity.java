package com.emppayroll.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	@Column
	private String name;
	@Column
	private int age;
	@Column
	private String email;
	@Column
	private String gender;
	@Column
	private String department;
	@Column
	private String role;
	@Column
	private Double salary;
	@Column
	private Date startDate;
	@Column
	private String employeeType;
	

    
}
