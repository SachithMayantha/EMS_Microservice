package net.fernando.departmentservice.service;

import net.fernando.departmentservice.dto.DepartmentDto;
import org.springframework.stereotype.Service;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto dto);

    DepartmentDto getDepartment(String code);
}
