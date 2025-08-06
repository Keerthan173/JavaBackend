package com.keer.ems.controller;

import com.keer.ems.dto.EmployeeDto;
import com.keer.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")               // All endpoints will start with this path
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    // Add Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    /*
    | Part                                | Explanation                                      |
    | ----------------------------------- | ------------------------------------------------ |
    | `@RestController`                   | Makes it a REST API class                        |
    | `@PostMapping`                      | Handles HTTP POST requests                       |
    | `@RequestBody`                      | Converts JSON in request to `EmployeeDto`        |
    | `ResponseEntity`                    | Sends back proper HTTP response with status code |
    */



    // Get employee by ID
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }


    // Get all employees REST API
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }


    // Update Employee
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,
                                                      @RequestBody EmployeeDto updatedEmployee){
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }


    // Delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee with ID " + employeeId + " deleted successfully!");
    }
}
