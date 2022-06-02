package com.crud.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.employeeservice.employee.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}