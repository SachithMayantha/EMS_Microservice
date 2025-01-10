package net.fernando.departmentservice.mapper;

import net.fernando.departmentservice.dto.DepartmentDto;
import net.fernando.departmentservice.entity.Department;

public class DepartmentMapper {

    public static Department maptoDepartment(DepartmentDto dto){

        Department department = new Department(
                dto.getId(),
                dto.getDepartmentName(),
                dto.getDepartmentDescription(),
                dto.getDepartmentCode()
        );

        return department;
    }

    public static DepartmentDto maptoDepartmentDto(Department department){

        DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );

        return departmentDto;
    }
}
