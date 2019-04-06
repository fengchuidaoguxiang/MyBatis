package com.service;

import com.domain.Employee;
import com.github.pagehelper.PageInfo;

public interface IEmployeeService {
    PageInfo<Employee> query(QueryObject queryObject);
}
