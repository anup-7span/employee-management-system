package com.employee.employeeManagement.service;

import com.employee.employeeManagement.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee);
    List<Employee> findAll();

    Employee findById(Integer employeeId);

    Employee update(Employee employee);

    String deleteEmp(Integer employeeId);

    List<Employee> findByName(String employeeName);
    List<Employee> findByEmployeeNameAndDesignation(String employeeName,String designation);

    List<Employee> findBySalaryGreaterThan(Integer salary);

    List<Employee> findByDesignationContains(String designation);

    List<Employee> findBySalaryBetween(Integer salary1,Integer salary2);

    List<Employee> findByEmployeeNameLike(String employeeName);

    Page<Employee> pageable(Integer page,Integer size);

    Page<Employee> pageableSort(Integer page, Integer size);

}
