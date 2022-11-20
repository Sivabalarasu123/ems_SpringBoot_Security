package com.springboot.javaguides.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.javaguides.ems.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
