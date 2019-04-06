package com.mapper;

import com.domain.Employee;
import com.service.QueryObject;

import java.util.List;

public interface EmployeeMapper {
     List<Employee> listAll();
     List<Employee> queryForList(QueryObject eqo);
}
