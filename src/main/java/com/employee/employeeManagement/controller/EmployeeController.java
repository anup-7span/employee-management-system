package com.employee.employeeManagement.controller;

import com.employee.employeeManagement.entity.Employee;
import com.employee.employeeManagement.service.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
public class EmployeeController {

    @Autowired
    ServiceImpl service;

    @PostMapping("/emp")
    public Employee addEmployee(@RequestBody Employee employee){
        log.info("start inserted employee record");
        service.addEmployee(employee);
        return employee;
    }
    @GetMapping("/get")
    public List<Employee> getAll(){
        return service.findAll();
    }
    @GetMapping("/{employeeId}")
    public Employee getById(@PathVariable Integer employeeId){
        return service.findById(employeeId);
    }
    @PutMapping("/update")
    public Employee update(@RequestBody Employee employee){
        return service.update(employee);
    }
    @DeleteMapping("/{employeeId}")
    public void delete(@PathVariable Integer employeeId){
        service.deleteEmp(employeeId);
    }
}
