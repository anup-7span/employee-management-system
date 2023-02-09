package com.employee.employeeManagement.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "id")
//@DiscriminatorValue("emp")
public class Emp extends Employee {
/*    @Id
    public Integer id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)*/
    public String empName;
}
