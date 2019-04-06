package com.test;

import com.domain.Department;
import com.domain.Employee2;
import com.mapper.DepartmentMapper;
import com.mapper.Employee2Mapper;
import com.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    /**
     * 保存一个部门和两个员工
     */
    @Test
    public void testSave(){
        Department d = new Department();
        d.setName("开发部");
        Employee2 e1 = new Employee2();
        e1.setName("张三");
        Employee2 e2 = new Employee2();
        e2.setName("李四");

        //维护对象关系
        e1.setDept(d);
        e2.setDept(d);
        SqlSession session = MyBatisUtils.getSession();
        DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
        Employee2Mapper employee2Mapper = session.getMapper(Employee2Mapper.class);
        departmentMapper.save(d);
        employee2Mapper.save(e1);
        employee2Mapper.save(e2);
        session.commit();
        session.close();
    }

    @Test
    public void testQuery(){
        SqlSession session = MyBatisUtils.getSession();
        Employee2Mapper employee2Mapper = session.getMapper(Employee2Mapper.class);
        Employee2 employee2 = employee2Mapper.get(1L);
//        DepartmentMapper departMapper = session.getMapper(DepartmentMapper.class);
//        System.out.println(employee2.toString());
//        System.out.println(employee2.getId());
//        System.out.println(employee2.getName());
        System.out.println(employee2.getDept());
        System.out.println(employee2.getClass());//动态代理类
//        现在已经拥有员工所在部门的id,但是期望得到的是Department对象
//        解决方案：根据部门的id,再额外的发送一条SQL语句，查询出部门对象，把部门对象设置给员工
//        long deptId = employee2.getDept().getId();
//        Department department = departMapper.get(deptId);
//        employee2.setDept(department);
//        System.out.println(employee2.getDept());
//        System.out.println(employee2);
        session.close();
    }

    @Test
    public void test1(){
        SqlSession session = MyBatisUtils.getSession();
        Employee2Mapper employee2Mapper = session.getMapper(Employee2Mapper.class);
        DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
        List<Employee2> employee2s = employee2Mapper.getAll();
        for(Employee2 temp : employee2s){
            System.out.println(temp+" "+temp.getDept());
        }
        session.close();
    }

    @Test
    public void test2(){
        SqlSession session = MyBatisUtils.getSession();
        DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
        System.out.println(departmentMapper.get(10L));
        session.close();
    }
}
