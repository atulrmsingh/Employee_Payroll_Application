package com.emppayroll.service;

import java.util.List;

import com.emppayroll.dto.EmployeeDto;
import com.emppayroll.entity.EmployeeEntity;

public interface EmployeeService {

	public EmployeeEntity addEmployee(EmployeeDto emp);

	public EmployeeEntity updateEmployee(Long empId, EmployeeDto emp);

	public EmployeeEntity getEmployeeById(Long empId);

	public void deleteEmployee(Long empId);

	public List<EmployeeEntity> getAllEmployees();

}
