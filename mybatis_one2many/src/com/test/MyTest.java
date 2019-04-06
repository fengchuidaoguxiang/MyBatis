package com.test;

import com.domain.Department;
import com.domain.Employee2;
import com.mapper.DepartmentMapper;
import com.mapper.Employee2Mapper;
import com.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.nio.channels.SeekableByteChannel;
import java.util.List;

public class MyTest {

    //查询10号部门的信息和包含的员工信息
    @Test
    public void testGet(){
        SqlSession session = MyBatisUtils.getSession();
        DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
        Department department = departmentMapper.get(10L);
        System.out.println(department);
        System.out.println(department.getEmployee2s());
        session.close();
    }

    @Test
    public void testEGet(){
        SqlSession session = MyBatisUtils.getSession();
        Employee2Mapper employee2Mapper = session.getMapper(Employee2Mapper.class);
        List<Employee2> employee2s = employee2Mapper.get(10L);
        for(Employee2 employee2 : employee2s ){
            System.out.println(employee2);
        }
        session.close();
    }
}
