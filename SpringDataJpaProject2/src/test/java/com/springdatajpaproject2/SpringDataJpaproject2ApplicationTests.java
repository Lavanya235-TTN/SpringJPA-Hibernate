package com.springdatajpaproject2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;

import com.springdatajpaproject2.entities.*;
import com.springdatajpaproject2.repos.*;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
class SpringDataJpaproject2ApplicationTests {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void create(){
        Employee employee = new Employee();
        employee.setFirstName("Amandeep");
        employee.setLastName("Singh");
        employee.setSalary(35000d);
        employee.setAge(50);
        employeeRepository.save(employee);
        
        Employee employee2 = new Employee();
        employee2.setFirstName("Lavanya");
        employee2.setLastName("Tyagi");
        employee2.setSalary(40000d);
        employee2.setAge(22);
        employeeRepository.save(employee2);
        
        Employee employee3 = new Employee();
        employee3.setFirstName("Varun");
        employee3.setLastName("Dhawan");
        employee3.setSalary(50000d);
        employee3.setAge(35);
        employeeRepository.save(employee3);
        
        Employee employee4 = new Employee();
        employee4.setFirstName("Amit");
        employee4.setLastName("Kumar");
        employee4.setSalary(20000d);
        employee4.setAge(60);
        employeeRepository.save(employee4);

    }
/*
    @Test
    public void findAllBySortOfAgeAndSalary(){
        List<Object[]> result = employeeRepository.findAndSortBySalaryAndAge(Sort.by(Sort.Order.by("age"), new Sort.Order(Direction.DESC, "salary")));
        for (Object[] objects: result){
            System.out.println(objects[0] + " " + objects[1] + " " + objects[2]);
        }
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void updateSalary(){
        employeeRepository.updateSalary(300d, employeeRepository.avgSalary());
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void deleteEmployeeWithMinSalary(){
        employeeRepository.deleteEmployeeWithMinSalary(employeeRepository.minSalary());
    }

    @Test
    public void getByLastName(){
        List<Object[]> result = employeeRepository.getEmployeeWithLastNameAs();
        for (Object[] obj: result){
            System.out.println(obj[0] + " " + obj[1] + " " + obj[2]);
        }
    }


    @Test
    @Transactional
    @Rollback(value = false)
    public void deleteEmpAboveAge(){
        employeeRepository.deleteEmployeeAboveAge();
    }

    //Inheritance Mapping
    @Autowired
    PaymentRepository paymentRepository;

    @Test
    public void createPayment() {
        CreditCard cc = new CreditCard();
        cc.setId(123);
        cc.setAmount(1000);
        cc.setCardnumber("1234567890");
        paymentRepository.save(cc);
    }

    @Test
    public void createCheckPayment() {
        Check ch = new Check();
        ch.setId(124);
        ch.setAmount(1000);
        ch.setChecknumber("1234567890");
        paymentRepository.save(ch);
    }

    //ComponentMapping

    @Autowired
    EmployeeComponentRepository employeeComponentRepository;
    @Test
    public void createEmp(){
        EmployeeComponent emp = new EmployeeComponent();
        emp.setId(1);
        emp.setFirstName("Lavanya");
        emp.setLastName("Tyagi");
        emp.setAge(22);
        Salary salary = new Salary();
        salary.setBasicSalary(20000d);
        salary.setBonusSalary(15000d);
        salary.setTaxAmount(20000d);
        salary.setSpecialAllowanceSalary(15000d);
        emp.setSalary(salary);
        employeeComponentRepository.save(emp);
    }*/

}
