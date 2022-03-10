package com.lavanya.springdata.employee.repos;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.lavanya.springdata.employee.entities.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
	
	List<Employee> findByName(String name);
	
	List<Employee> findByNameLike(String string);
	
	List<Employee> findByAgeBetween(double a, double b);

}
