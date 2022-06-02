package com.emppayroll.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emppayroll.dao.EmployeeRepo;
import com.emppayroll.dto.EmployeeDto;
import com.emppayroll.entity.EmployeeEntity;

@Service

public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepo employeeRepo;
	ModelMapper map = new ModelMapper();

	@Override
	public EmployeeEntity addEmployee(EmployeeDto emp) {
		EmployeeEntity emp1 = map.map(emp, EmployeeEntity.class);
		System.out.println(emp1.toString());
		emp1 = employeeRepo.save(emp1);
		return emp1;
	}

	@Override
	public EmployeeEntity updateEmployee(Long empId, EmployeeDto emp) {
		EmployeeEntity emp1 = employeeRepo.findById(empId).get();
		emp1 = map.map(emp, EmployeeEntity.class);
		emp1 = employeeRepo.save(emp1);
		return emp1;

	}

	@Override
	public EmployeeEntity getEmployeeById(Long empId) {
		return employeeRepo.findById(empId).get();
	}

	@Override
	public void deleteEmployee(Long empId) {
		employeeRepo.deleteById(empId);
		System.out.println("employee deleted");
	}

	@Override
	public List<EmployeeEntity> getAllEmployees() {
		return employeeRepo.findAll();
	}

}
