package com.employee.employeeManagement.controller;

import com.employee.employeeManagement.entity.Employee;
import com.employee.employeeManagement.service.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

    //finder methods
    @GetMapping("/employeeName/{employeeName}")
    public List<Employee> findByName(@PathVariable String employeeName){
        return service.findByName(employeeName);
    }

    //using requestParam
    /*
        @GetMapping("/employeeName")
        public List<Employee> findByName(@RequestParam String employeeName){
        return service.findByName(employeeName);
    }
    */
    @GetMapping("/employeeName/designation")
    public List<Employee> findByNameAndDes(@RequestParam String employeeName,String designation){
        return service.findByEmployeeNameAndDesignation(employeeName,designation);
    }
    @GetMapping("/salary")
    public List<Employee> findBySalary(@RequestParam Integer salary){
        return service.findBySalaryGreaterThan(salary);
    }
    @GetMapping("/designation")
    public List<Employee> findByContains(@RequestParam String designation){
        return service.findByDesignationContains(designation);
    }
    @GetMapping("/salaryBetween")
    public List<Employee> findBySalaryBetween(@RequestParam Integer salary1, Integer salary2) {
        return service.findBySalaryBetween(salary1,salary2);
    }
    @GetMapping("/employeeNameLike/{employeeName}")
    public List<Employee> findByEmployeeNameLike(@PathVariable String employeeName) {
        return service.findByEmployeeNameLike(employeeName);
    }

    //pageable
    @GetMapping("/pageable")
    public Page<Employee> pageRecords(@RequestParam Integer page, Integer size){
        return service.pageable(page,size);
    }

    //sorting
    @GetMapping("/pageableSort")
    public Page<Employee> pageableSort(@RequestParam Integer page, Integer size){
        return service.pageableSort(page,size);
    }

    //JPQL
    @GetMapping("/JPQL")
    public List<Employee> findAllEmployee(){
        return service.findAllEmployee();
    }
    @GetMapping("/JPQL/name")
    public List<Object[]> findByName(){
        return service.findByName();
    }
    @GetMapping("/JPQL/findByName")
    public List<Employee> findByEmployeeName(@RequestParam String name){
        return service.findAllEmployeeByName(name);
    }

    @GetMapping("/JPQL/salary")
    public List<Employee> findMinMaxSalary(@RequestParam Integer s1,Integer s2){
        return service.minMaxSalary(s1,s2);
    }
    //native sql
    @GetMapping("/JPQL/findByName/native")
    public List<Employee> findByEmployeeNameNative(@RequestParam String name) {
        return service.findAllEmployeeByNameNativeQuery(name);
    }
}
