package com.crud.employeeservice.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "department")
    private String department;
    @Column(name = "email")
    private String email;
    @Column(name = "age")
    private int age;

    public Employee(String name, String department, String email, int age) {
        this.name = name;
        this.department = department;
        this.email = email;
        this.age = age;
    }

}
