package com.employee.employeeManagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "id")
//@DiscriminatorValue("man")
public class Manager extends Employee {
/*    @Id
    public Integer id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)*/
    public String managerName;
}
