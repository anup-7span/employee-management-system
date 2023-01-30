package com.employee.employeeManagement.repo;

import com.employee.employeeManagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    List<Employee> findByEmployeeName(String employeeName);

    List<Employee> findByEmployeeNameAndDesignation(String employeeName,String designation);

    List<Employee> findBySalaryGreaterThan(Integer salary);

    List<Employee> findByDesignationContains(String designation);

    List<Employee> findBySalaryBetween(Integer salary1,Integer salary2);

    List<Employee> findByEmployeeNameLike(String employeeName);
}
