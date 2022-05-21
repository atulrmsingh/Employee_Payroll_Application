package com.emppayroll.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emppayroll.dto.EmployeeDto;
import com.emppayroll.entity.EmployeeEntity;
import com.emppayroll.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService empService;

	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody EmployeeEntity entity) {
		JSONObject response = new JSONObject();
		EmployeeEntity empEntity = empService.addEmployee(entity);
		response.put("status", "sucess");
		response.put("message", "employee added");
		response.put("data", empEntity);
		return response.toString();

	}

	@GetMapping("/getEmployee/{id}")
	public String getEmployeeById(@PathVariable Long id) {
		JSONObject response = new JSONObject();
		EmployeeEntity empEntity = empService.getEmployeeById(id);
		response.put("status", "sucess");
		response.put("message", "Employee Details");
		response.put("data", empEntity);
		return response.toString();

	}

	@PutMapping("/updateEmployee/{id}")
	public String updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto emp) {
		JSONObject response = new JSONObject();
		EmployeeEntity empEntity = empService.updateEmployee(id, emp);
		response.put("status", "sucess");
		response.put("message", "Employee Details Updated");
		response.put("data", empEntity);
		return response.toString();

	}
	
	@GetMapping("/getAllEmployees")
	public String getAllEmployee() {
		JSONObject response = new JSONObject();
		List<EmployeeEntity> empEntity = empService.getAllEmployees();
		response.put("status", "sucess");
		response.put("message", "All Employee Details ");
		response.put("data", empEntity);
		return response.toString();

	}
	
	@DeleteMapping("/deleteEmployeeById")
	public String deleteEmployeeById(@RequestParam ("id") Long id) {
		JSONObject response = new JSONObject();
		empService.deleteEmployee(id);
		response.put("status", "sucess");
		response.put("message", "Employee Deleted ");
		return response.toString();

	}

}
