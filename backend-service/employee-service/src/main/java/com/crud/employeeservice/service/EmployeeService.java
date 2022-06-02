package com.crud.employeeservice.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crud.employeeservice.builder.JsonResponseBuilder;
import com.crud.employeeservice.employee.Employee;
import com.crud.employeeservice.repository.EmployeeRepository;

@Service
public class EmployeeService
{

    EmployeeRepository repository;
    LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern( "dd-MM-yyyy HH:mm:ss" );
    String formattedDate = myDateObj.format( myFormatObj );
    JsonResponseBuilder builder = new JsonResponseBuilder();

    @Autowired
    public EmployeeService ( EmployeeRepository repository )
    {
        this.repository = repository;
    }

    public ResponseEntity<Object> createEmployee ( Employee employee )
    {
        if ( employee.getName() == null )
        {
            return builder.responseBuilder( "Employee name cannot be null", HttpStatus.BAD_REQUEST,
              employee );
        }
        else if ( employee.getEmail() == null )
        {
            return builder.responseBuilder( "Employee email cannot be null", HttpStatus.BAD_REQUEST,
              employee );
        }
        else if ( employee.getDepartment() == null )
        {
            return builder.responseBuilder( "Employee department cannot be null",
              HttpStatus.BAD_REQUEST, employee );
        }
        else if ( employee.getAge() == 0 )
        {
            return builder.responseBuilder( "Employee Age cannot be 0", HttpStatus.BAD_REQUEST,
              employee );
        }
        else
        {
            employee.getAge();
        }
        repository.save( employee );
        return builder.responseBuilder( "Succesfully added employee", HttpStatus.OK, employee );
    }

    public ResponseEntity<Object> getEmployeeById ( long id )
    {

        Optional<Employee> employee = repository.findById( id );
        if ( employee.isPresent() )
        {
            return builder.responseBuilder( "As requested", HttpStatus.OK, employee );
        }

        return builder.responseBuilder( "Employee Cannot be found", HttpStatus.NOT_FOUND, employee );
    }

    public ResponseEntity<Object> deleteEmployeeByid ( long id )
    {
        Optional<Employee> employee = repository.findById( id );
        if (  ! employee.isPresent() )
        {
            return builder.responseBuilder( "Employee does not exsist", HttpStatus.NOT_FOUND, null );
        }

        repository.deleteById( id );

        return builder.responseBuilder( "Employee deleted succesfully", HttpStatus.OK, employee );
    }

    public ResponseEntity<Object> updateEmployee ( Long id, Employee employee )
    {
        Optional<Employee> employeeOptional = repository.findById( id );
        if (  ! employeeOptional.isPresent() )
        {
            return builder.responseBuilder( "Employee does not exsist", HttpStatus.NOT_FOUND, null );
        }

        employeeOptional.get().setName( employee.getName() );
        employeeOptional.get().setEmail( employee.getEmail() );
        employeeOptional.get().setDepartment( employee.getDepartment() );
        employeeOptional.get().setAge( employee.getAge() );

        repository.save( employeeOptional.get() );

        return builder.responseBuilder( "Employee Update Successfully", HttpStatus.OK,
          employeeOptional.get() );
    }

    public ResponseEntity<Object> getAllEmployees ()
    {
        List<Employee> employeeList = repository.findAll();

        return builder.responseBuilder( "As requested", HttpStatus.OK, employeeList );
    }
}
