package com.employee.employeeManagement.service;

import com.employee.employeeManagement.entity.Employee;
import com.employee.employeeManagement.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepo employeeRepo;
    @Override
    public Employee addEmployee(Employee employee) {
        employeeRepo.save(employee);
        return employee;
    }

    @Override
    public List<Employee> findAll() {
       List<Employee> list= employeeRepo.findAll();
        return list;
    }

    @Override
    public Employee findById(Integer employeeId) {
        return employeeRepo.findById(employeeId).get();
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public String deleteEmp(Integer employeeId) {
        employeeRepo.deleteById(employeeId);
        return "Employee Deleted:-"+employeeId;
    }
}
