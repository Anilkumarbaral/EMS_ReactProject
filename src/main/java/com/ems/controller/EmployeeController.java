package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.dto.EmployeeDto;
import com.ems.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto empDto) {
		EmployeeDto savedEmployee = empService.createEmployee(empDto);

		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto>getEmployeeByid(@PathVariable("id") Long empId){
		EmployeeDto empDto = empService.getEmployeeById(empId);
		return new ResponseEntity<EmployeeDto>(empDto,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeDto>>getAllEmployee(){
		List<EmployeeDto> allEmployee = empService.getAllEmployee();
		return ResponseEntity.ok(allEmployee);
	}
	
	
	
	
	
	
	
}
