package net.fernando.employeeservice.mapper;

import net.fernando.employeeservice.dto.EmployeeDto;
import net.fernando.employeeservice.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        EmployeeDto dto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );
        return dto;
    }

    public static Employee mapToEmployee(EmployeeDto dto){
        Employee employee = new Employee(
                dto.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmail(),
                dto.getDepartmentCode()
        );
        return employee;
    }
}
