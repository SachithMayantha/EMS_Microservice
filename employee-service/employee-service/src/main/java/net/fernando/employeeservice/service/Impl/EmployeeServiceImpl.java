package net.fernando.employeeservice.service.Impl;

import lombok.AllArgsConstructor;
import net.fernando.employeeservice.dto.APIResponseDto;
import net.fernando.employeeservice.dto.DepartmentDto;
import net.fernando.employeeservice.dto.EmployeeDto;
import net.fernando.employeeservice.entity.Employee;
import net.fernando.employeeservice.mapper.EmployeeMapper;
import net.fernando.employeeservice.repository.EmployeeRepository;
import net.fernando.employeeservice.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;

    private RestTemplate restTemplate;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = repository.save(employee);
        EmployeeDto savedDto = EmployeeMapper.mapToEmployeeDto(savedEmployee);
        return savedDto;
    }

    @Override
    public APIResponseDto getEmployee(Long employeeId) {
        Employee employee = repository.findById(employeeId).get();
        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(), DepartmentDto.class);

        DepartmentDto departmentDto = responseEntity.getBody();

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }
}
