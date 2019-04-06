package com.service;

import com.domain.Employee;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.EmployeeMapper;
import com.utils.MyBatisUtil;

import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {
    private EmployeeMapper employeeMapper = MyBatisUtil.getSession().getMapper(EmployeeMapper.class);

    @Override
    public PageInfo<Employee> query(QueryObject queryObject) {
        PageHelper.startPage(queryObject.getCurrentPage(),queryObject.getPageSize());
        List list = employeeMapper.queryForList(queryObject);
        return new PageInfo<>(list);
    }
}
