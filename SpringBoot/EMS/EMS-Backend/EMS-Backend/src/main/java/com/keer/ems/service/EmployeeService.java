package com.keer.ems.service;

import com.keer.ems.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);

    void deleteEmployee(Long employeeId);

}

/*
EmployeeService Interface:
“Any class implementing this must provide logic for:
creating, retrieving, updating, and deleting employees.”
 */

