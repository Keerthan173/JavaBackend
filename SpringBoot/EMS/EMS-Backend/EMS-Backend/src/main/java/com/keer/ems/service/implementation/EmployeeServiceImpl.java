package com.keer.ems.service.implementation;

import com.keer.ems.dto.EmployeeDto;
import com.keer.ems.entity.Employee;
import com.keer.ems.exception.ResourceNotFoundException;
import com.keer.ems.mapper.EmployeeMapper;
import com.keer.ems.repository.EmployeeRepository;
import com.keer.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;


    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }


    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Employee with " + employeeId + " ID does not exist."));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }


    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employee ->
            EmployeeMapper.mapToEmployeeDto(employee))
                .toList();
    }


    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Employee with " + employeeId + " ID does not exist."));

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }


    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Employee with " + employeeId + " ID does not exist."));

        employeeRepository.deleteById(employeeId);
    }
}