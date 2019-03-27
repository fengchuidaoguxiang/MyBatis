package com.service.impl;

import com.domain.Employee;
import com.mapper.EmployeeMapper;
import com.query.EmployeeQueryObject;
import com.query.PageResult;
import com.query.QueryObject;
import com.service.IEmployeeService;
import com.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Collections;
import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService{
    private SqlSession session = MyBatisUtil.getSession();
    private EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
    @Override
    public PageResult query(QueryObject eq) {
        int rows = employeeMapper.queryForCount(eq);
        if(rows == 0){
            return new PageResult(Collections.emptyList(),0,1, eq.getPageSize());
        }
        List<Employee> employees =  employeeMapper.queryForList(eq);
        return new PageResult(employees, rows,eq.getCurrentPage(),eq.getPageSize());
    }
}
