package com.lavanya.springdata.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import com.lavanya.springdata.employee.entities.Employee;
import com.lavanya.springdata.employee.repos.EmployeeRepository;

@SpringBootTest
class EmployeedataApplicationTests {
	
	@Autowired
	EmployeeRepository repository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCreate() {
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("Lavanya Tyagi");
		employee.setAge(22d);
		employee.setLocation("Ghaziabad, Uttar Pradesh, India");

		repository.save(employee);
	}
	
	@Test
	public void testCreateWithoutId() {
		Employee employee = new Employee();
		//employee.setId(1);
		employee.setName("Arnav Tyagi");
		employee.setAge(18d);
		employee.setLocation("Ghaziabad, Uttar Pradesh, India");

		repository.save(employee);
	}
	
	
	@Test
	public void testUpdate() {
		if(repository.existsById(1)) {
			Employee employee = repository.findById(1).get();
			employee.setLocation("Wichita, Kansas, USA");
			repository.save(employee);
		}
	}
	
	@Test
	public void testRead() {
		if(repository.existsById(1)) {
			Employee employee = repository.findById(1).get();
			assertNotNull(employee);
			assertEquals("Lavanya Tyagi", employee.getName());
		}
	}
	
	@Test
	public void testDelete() {
		if (repository.existsById(1)) {
			System.out.println("Deleting an employee");
			repository.deleteById(1);
		}
	}

	@Test
	public void testCount() {
		System.out.println("Total Employees ============================> " + repository.count());

	}
	
	@Test
	public void testFindByName() {
		List<Employee> employees = repository.findByName("Lavanya Tyagi");
		employees.forEach(e -> System.out.println(e.toString()));
	}
	
	@Test
	public void testFindByAgeBetween() {
		List<Employee> employees = repository.findByAgeBetween(28d, 32d);
		employees.forEach(e -> System.out.println(e.getName()));
	}

	@Test
	public void testFindByDescLike() {
		List<Employee> employees = repository.findByNameLike("A%");
		employees.forEach(e -> System.out.println(e.getName()));
	}

	@Test
	public void testFindAllPagingAndSorting() {
		Pageable pageable = PageRequest.of(0, 2, Direction.ASC, "age");
		repository.findAll(pageable).forEach(e -> System.out.println(e.toString()));

	}

}
