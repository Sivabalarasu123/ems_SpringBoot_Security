package com.springboot.javaguides.ems.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.springboot.javaguides.ems.exception.ResourceNotFoundException;
import com.springboot.javaguides.ems.model.Employee;
import com.springboot.javaguides.ems.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundException("Employee", "Id", id);
//		}
		return employeeRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Employee", "id", id));
	}

	@Override
	public Employee updateEmployee(Employee employee,long id) {
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Employee", "id", id));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
//		save existing employee to DB
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
//		check whether an employee exist in DB or not
		employeeRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Employee", "id", id));
		employeeRepository.deleteById(id);
		
	}	

}
