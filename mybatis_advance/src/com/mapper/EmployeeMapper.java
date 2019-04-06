package com.mapper;

import com.domain.Employee;
import com.query.EmployeeQueryObject;
import com.query.QueryObject;

import java.util.List;

public interface EmployeeMapper {
     List<Employee> getAll();
     List<Employee> queryForList(QueryObject eqo);
     int queryForCount(QueryObject eqo);
}
