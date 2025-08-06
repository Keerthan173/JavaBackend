package com.keer.ems.mapper;

import com.keer.ems.dto.EmployeeDto;
import com.keer.ems.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}


/*
🔹 1. mapToEmployeeDto(Employee employee)
Converts from Entity → DTO
Useful when sending data to the client

🔹 2. mapToEmployee(EmployeeDto dto)
Converts from DTO → Entity
Useful when receiving data from the client (POST/PUT)



Note: Both methods we created static.
 */
