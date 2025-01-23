package net.fernando.employeeservice.service;

import net.fernando.employeeservice.dto.APIResponseDto;
import net.fernando.employeeservice.dto.EmployeeDto;
import net.fernando.employeeservice.entity.Employee;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployee(Long employeeId);
}
