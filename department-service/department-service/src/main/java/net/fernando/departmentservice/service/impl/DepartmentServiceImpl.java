package net.fernando.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import net.fernando.departmentservice.dto.DepartmentDto;
import net.fernando.departmentservice.entity.Department;
import net.fernando.departmentservice.mapper.DepartmentMapper;
import net.fernando.departmentservice.repository.DepartmentRepository;
import net.fernando.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {


    private DepartmentRepository repository;


    @Override
    public DepartmentDto saveDepartment(DepartmentDto dto) {

         // Convert Department Dto to Department entity
        Department department = DepartmentMapper.maptoDepartment(dto);

        Department savedDepartment = repository.save(department);

        // Convert saved Department object to Department Dto
        DepartmentDto savedDepartmentDto = DepartmentMapper.maptoDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }
}
