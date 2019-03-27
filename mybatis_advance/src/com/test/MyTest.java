package com.test;

import com.domain.Employee;
import com.mapper.EmployeeMapper;
import com.query.EmployeeQueryObject;
import com.query.PageResult;
import com.service.IEmployeeService;
import com.service.impl.EmployeeServiceImpl;
import com.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class MyTest {
    @Test
    public void test1(){
        SqlSession session = MyBatisUtil.getSession();
        EmployeeMapper dao = session.getMapper(EmployeeMapper.class);
        List<Employee> employees = dao.getAll();
        for(Employee temp : employees){
            System.out.println(temp);
        }
        session.close();
    }

    //需求：按照员工的关键字，工资范围，所属部门来查询
    @Test
    public void test2(){
        SqlSession session = MyBatisUtil.getSession();
        EmployeeMapper dao = session.getMapper(EmployeeMapper.class);
        EmployeeQueryObject eq = new EmployeeQueryObject();
//        eq.setKeyword("");
//        eq.setMinSalary(new BigDecimal("1000"));
//        eq.setMaxSalary(new BigDecimal("1100"));
        eq.setDeptId(10L);
        List<Employee> employees = dao.queryForList(eq);
        session.close();
        for(Employee temp :employees){
            System.out.println(temp);
        }
    }

    @Test
    public void test3(){
        SqlSession session = MyBatisUtil.getSession();
        EmployeeMapper dao = session.getMapper(EmployeeMapper.class);
        EmployeeQueryObject eq = new EmployeeQueryObject();
        eq.setMinSalary(new BigDecimal("1000"));
        int count = dao.queryForCount(eq);
        System.out.println(count);
        session.close();
    }

    @Test
    public void test4(){
        IEmployeeService service = new EmployeeServiceImpl();
        EmployeeQueryObject eqo = new EmployeeQueryObject();
        eqo.setMinSalary(new BigDecimal("800"));
        eqo.setMaxSalary(new BigDecimal("1000"));
        eqo.setKeyword("一");
        PageResult pageResult = service.query(eqo);
        System.out.println(pageResult.getTotalCount());
        for (Object o : pageResult.getResult()) {
            System.out.println(o);
        }
    }


}
