package com.emppayroll.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.emppayroll.response.ResponseHandler;
import com.emppayroll.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Value("${emp_add}")
	private String empAdd;

	@Value("${emp_update}")
	private String empUpdate;

	@Value("${emp_delete}")
	private String empDelete;

	@Value("${emp_get}")
	private String empget;

	@Value("${userNotFound}")
	private String userNotFound;

	@Autowired
	EmployeeService empService;

	@PostMapping("/register")
	public ResponseEntity<Object> addEmployee(@Valid @RequestBody EmployeeDto entity) {
		try {
			empService.addEmployee(entity);
			return ResponseHandler.generateResponse(empAdd, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS);
		}
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Object> getEmployeeById(@PathVariable Long id) {
		try {
			EmployeeEntity empEntity = empService.getEmployeeById(id);
			return ResponseHandler.generateObjectResponse(empget, HttpStatus.OK, empEntity);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseHandler.generateResponse(userNotFound, HttpStatus.MULTI_STATUS);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto emp) {
		try {

			empService.updateEmployee(id, emp);
			return ResponseHandler.generateResponse(empUpdate, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseHandler.generateResponse(userNotFound, HttpStatus.MULTI_STATUS);
		}
	}

	@GetMapping("/allEmployees")
	public ResponseEntity<Object> getAllEmployee() {
		try {
			List<EmployeeEntity> empEntity = empService.getAllEmployees();
			return ResponseHandler.generateObjectResponse(empget, HttpStatus.OK, empEntity);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS);
		}
	}

	@DeleteMapping("/remove")
	public ResponseEntity<Object> deleteEmployeeById(@RequestParam("id") Long id) {
		try {
			empService.deleteEmployee(id);
			return ResponseHandler.generateResponse(empDelete, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseHandler.generateResponse(userNotFound, HttpStatus.MULTI_STATUS);
		}
	}

}
