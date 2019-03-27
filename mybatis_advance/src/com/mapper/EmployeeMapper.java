package com.mapper;

import com.domain.Employee;
import com.query.EmployeeQueryObject;
import com.query.QueryObject;

import java.util.List;

public interface EmployeeMapper {
    public List<Employee> getAll();
    public List<Employee> queryForList(QueryObject eqo);
    public int queryForCount(QueryObject eqo);
}
