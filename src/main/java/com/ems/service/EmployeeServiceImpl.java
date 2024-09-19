package com.ems.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.dto.EmployeeDto;
import com.ems.entity.Employee;
import com.ems.exception.ResourceNotFoundException;
import com.ems.mapper.EmployeeMapper;
import com.ems.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public EmployeeDto createEmployee(EmployeeDto empDto) {
		Employee employee = EmployeeMapper.mapToEmployee(empDto);
		Employee savedEmployee = empRepo.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long empId) {
		Employee emp=empRepo.findById(empId).orElseThrow(()->new ResourceNotFoundException("Given Id not exits in table"));
		return EmployeeMapper.mapToEmployeeDto(emp);
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
        List<Employee> allEmployees = empRepo.findAll();
		return allEmployees.stream().map((emp)->EmployeeMapper.mapToEmployeeDto(emp)).toList();
	}

}
