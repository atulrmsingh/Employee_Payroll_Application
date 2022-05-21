package com.emppayroll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emppayroll.dao.EmployeeRepo;
import com.emppayroll.dto.EmployeeDto;
import com.emppayroll.entity.EmployeeEntity;

@Service

public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepo employeeRepo;

	@Override
	public EmployeeEntity addEmployee(EmployeeEntity emp) {
		return employeeRepo.save(emp);
	}

	@Override
	public EmployeeEntity updateEmployee(Long empId, EmployeeDto emp) {
		EmployeeEntity empEntity = employeeRepo.getById(empId);
		empEntity.setAge(emp.getAge() == 0? empEntity.getAge() : emp.getAge());
		empEntity.setEmail(emp.getEmail() == null? empEntity.getEmail() : emp.getEmail());
		empEntity.setName(emp.getName() == null? empEntity.getName() : emp.getName());
		empEntity.setDepartment(emp.getDepartment() == null? empEntity.getDepartment() : emp.getDepartment());
		empEntity.setRole(emp.getRole() == null? empEntity.getRole() : emp.getRole());
		empEntity.setSalary(emp.getSalary() == 0.0? empEntity.getSalary() : emp.getSalary());
		
		return employeeRepo.save(empEntity);
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
