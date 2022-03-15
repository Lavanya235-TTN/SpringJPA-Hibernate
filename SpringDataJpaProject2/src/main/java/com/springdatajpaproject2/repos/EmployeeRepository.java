package com.springdatajpaproject2.repos;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springdatajpaproject2.entities.Employee;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    @Query("select e.firstName, e.lastName, e.salary from Employee e where e.salary>(select AVG(salary) from Employee)")
    List<Object[]> findAndSortBySalaryAndAge(Sort sort);

    @Query("select avg(salary) from Employee")
    double avgSalary();

    @Modifying
    @Query("update Employee set salary =:salary where salary<:avgSalary")
    void updateSalary(@Param("salary") double salary, @Param("avgSalary") double avgSalary);

    @Query("select min(salary) from Employee")
    double minSalary();

    @Modifying
    @Query("delete from Employee where salary=:minSalary")
    void deleteEmployeeWithMinSalary(@Param("minSalary") double minSalary);

    @Query(value = "select e.empid, e.empFirstName, e.empAge from employeeTable e where e.empLastName LIKE 'Singh'", nativeQuery = true)
    List<Object[]> getEmployeeWithLastNameAs();

    @Modifying
    @Query(value = "delete from employeeTable where empAge > 45",nativeQuery = true)
    void deleteEmployeeAboveAge();
}
