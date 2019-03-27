package com.service;

import com.domain.Employee;
import com.query.EmployeeQueryObject;
import com.query.PageResult;
import com.query.QueryObject;

public interface IEmployeeService {

    PageResult query(QueryObject eq);
}
