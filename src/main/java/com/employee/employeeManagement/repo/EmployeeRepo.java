package com.employee.employeeManagement.repo;

import com.employee.employeeManagement.entity.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    List<Employee> findBySalaryGreaterThan(Integer salary, Pageable pageable);

    //JPQL
    @Query("from Employee")
    List<Employee>findAllEmployee();

    @Query("select e.employeeName from Employee e")
    List<Object[]>findByName();

    @Query("from Employee where employeeName=:employeeName")
    List<Employee>findAllEmployeeByName(@Param("employeeName") String employeeName);

    @Query("from Employee where salary>:min and salary<:max")
    List<Employee>findMinMaxSalary(@Param("min") Integer min,@Param("max") Integer max);

    @Query(value = "select * from employee where employee_name=:employeeName",nativeQuery = true)
    List<Employee>findAllEmployeeByNameNativeQuery(@Param("employeeName") String employeeName);
}
