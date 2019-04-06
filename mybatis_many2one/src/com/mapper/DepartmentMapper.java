package com.mapper;

import com.domain.Department;
import com.domain.Employee2;

public interface DepartmentMapper {
    void save(Department d);
    Department get(long deptId);
}
