package com.employee.employeeManagement.service;

import com.employee.employeeManagement.entity.Employee;
import com.employee.employeeManagement.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    //find by name
    @Override
    public List<Employee> findByName(String employeeName) {
        List<Employee> emp=employeeRepo.findByEmployeeName(employeeName);
        return emp;
    }

    @Override
    public List<Employee> findByEmployeeNameAndDesignation(String employeeName, String designation) {
        return employeeRepo.findByEmployeeNameAndDesignation(employeeName,designation);
    }

    @Override
    public List<Employee> findBySalaryGreaterThan(Integer salary) {
        return employeeRepo.findBySalaryGreaterThan(salary);
    }

    @Override
    public List<Employee> findByDesignationContains(String designation) {
        return employeeRepo.findByDesignationContains(designation);
    }

    @Override
    public List<Employee> findBySalaryBetween(Integer salary1, Integer salary2) {
        return employeeRepo.findBySalaryBetween(salary1,salary2);
    }

    @Override
    public List<Employee> findByEmployeeNameLike(String employeeName) {
        return employeeRepo.findByEmployeeNameLike(employeeName);
    }

    @Override
    public Page<Employee> pageable(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return employeeRepo.findAll(pageable);
    }

    @Override
    public Page<Employee> pageableSort(Integer page, Integer size) {
        //Ass
        //Sort sort=Sort.by("salary");
        //Dec
        //single sort properties
        //Sort sort=Sort.by("salary").descending();
        //Multiple sort properties
        // Sort sort=Sort.by("employeeName","salary").descending();
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC,"employeeName");
        return employeeRepo.findAll(pageable);
    }

    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepo.findAllEmployee();
    }

    @Override
    public List<Object[]> findByName() {
        return employeeRepo.findByName();
    }

    @Override
    public List<Employee> findAllEmployeeByName(String employeeName) {
        return employeeRepo.findAllEmployeeByName(employeeName);
    }

    @Override
    public List<Employee> minMaxSalary(Integer min, Integer max) {
        return employeeRepo.findMinMaxSalary(min,max);
    }

    @Override
    public List<Employee> findAllEmployeeByNameNativeQuery(String employeeName) {
        return employeeRepo.findAllEmployeeByNameNativeQuery(employeeName);
    }

}
