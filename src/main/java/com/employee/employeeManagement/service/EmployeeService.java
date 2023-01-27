package com.employee.employeeManagement.service;

import com.employee.employeeManagement.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee);
    List<Employee> findAll();

    Employee findById(Integer employeeId);

    Employee update(Employee employee);

    String deleteEmp(Integer employeeId);
}
