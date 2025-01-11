package net.fernando.departmentservice.controller;

import lombok.AllArgsConstructor;
import net.fernando.departmentservice.dto.DepartmentDto;
import net.fernando.departmentservice.service.DepartmentService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService service;

    // Build save department REST API
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){

        DepartmentDto savedDepartment = service.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    // Get department by department code
    @GetMapping("{departmentCode}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("departmentCode") String departmentCode){

        DepartmentDto departmentDto = service.getDepartment(departmentCode);
        return new ResponseEntity<>(departmentDto,HttpStatus.ACCEPTED);
    }

}
