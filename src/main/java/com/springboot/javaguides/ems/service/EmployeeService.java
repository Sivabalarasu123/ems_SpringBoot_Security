package com.springboot.javaguides.ems.service;

import java.util.List;

import com.springboot.javaguides.ems.model.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(long id);
	
	Employee updateEmployee(Employee employee,long id);
	
    void deleteEmployee(long id);

}
