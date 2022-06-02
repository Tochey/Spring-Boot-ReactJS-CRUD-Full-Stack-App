package com.crud.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.employeeservice.employee.Employee;
import com.crud.employeeservice.service.EmployeeService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/v1")
public class EmployeeController {
    EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getEmployee(@PathVariable Long id) {
        return service.getEmployeeById(id);

    }

    @GetMapping("/get/all")
    public ResponseEntity<Object> getAllEmployees() {
        return service.getAllEmployees();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
        return service.createEmployee(employee);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return service.updateEmployee(id, employee);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable long id) {
        return service.deleteEmployeeByid(id);

    }

}
