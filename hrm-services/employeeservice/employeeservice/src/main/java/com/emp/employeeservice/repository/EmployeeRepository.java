package com.emp.employeeservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.employeeservice.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Optional<Employee> findByUsername(String username);

}
