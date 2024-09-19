package com.ems.service;

import java.util.List;

import com.ems.dto.EmployeeDto;

public interface EmployeeService {
	
	  EmployeeDto createEmployee(EmployeeDto empDto);
	  
	  EmployeeDto getEmployeeById(Long empId);

	  List<EmployeeDto>getAllEmployee();
}
