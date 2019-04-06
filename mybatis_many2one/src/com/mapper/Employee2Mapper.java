package com.mapper;

import com.domain.Employee2;

import java.util.List;

public interface Employee2Mapper {
    void save(Employee2 e);
    Employee2 get(long id);
    List<Employee2> getAll();
}
