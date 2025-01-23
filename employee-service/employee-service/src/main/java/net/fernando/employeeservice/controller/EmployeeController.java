package net.fernando.employeeservice.controller;

import lombok.AllArgsConstructor;
import net.fernando.employeeservice.dto.APIResponseDto;
import net.fernando.employeeservice.dto.EmployeeDto;
import net.fernando.employeeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employee")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService service;

    // save Employee
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedDto = service.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
    }

    // get employee by user id
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long id){
        APIResponseDto apiResponseDto = service.getEmployee(id);
        return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
    }
}
