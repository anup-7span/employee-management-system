package com.employee.employeeManagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Employee {

    @Id
    private Integer employeeId;
    private String employeeName;
    private String designation;
    private Integer salary;
}
