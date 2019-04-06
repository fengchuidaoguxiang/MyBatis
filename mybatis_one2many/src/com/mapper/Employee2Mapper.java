package com.mapper;

import com.domain.Employee2;

import java.util.List;

public interface Employee2Mapper {
    void save(Employee2 employee2);
    List<Employee2> get(Long deptId);
}
