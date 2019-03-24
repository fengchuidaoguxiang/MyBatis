package com.test;

import com.domain.Client;
import com.domain.Employee;
import com.mapper.ClientMapper;
import com.mapper.EmployeeMapper;
import com.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import javax.sound.midi.Soundbank;
import java.math.BigDecimal;
import java.util.List;

public class MyTest {

    //需求1：查询工资大于等于1000的员工
    @Test
    public void test1(){
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
//        List<Employee> employees = employeeMapper.query(new BigDecimal("1000"));
        List<Employee> employees = employeeMapper.query(null);
        System.out.println(employees);
        session.close();
    }
    //需求2：查询工资在900-1100之间的员工
    @Test
    public void test2(){
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
//        List<Employee> employees = mapper.query2(new BigDecimal("900"),new BigDecimal("1100"));
        List<Employee> employees = mapper.query2(null,new BigDecimal("1100"));
        System.out.println(employees);
        session.close();
    }
    //需求3：查询指定部门的员工信息
    @Test
    public void test3(){
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper employeeDAO = session.getMapper(EmployeeMapper.class);
        List<Employee> employees = employeeDAO.query3(10L);
        for (Employee employee : employees){
            System.out.println(employee);
        }
        session.close();
    }

    @Test
    public void test4(){
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper employeeDAO = session.getMapper(EmployeeMapper.class);
//        List<Employee> employees = employeeDAO.query4(new BigDecimal("800"),new BigDecimal("1000"),null);
        List<Employee> employees = employeeDAO.query4(null,null,null);
        for(Employee employee : employees){
            System.out.println(employee);
        }
    }

    @Test
    public void test5(){
        SqlSession session = MyBatisUtils.getSession();
        ClientMapper mapper = session.getMapper(ClientMapper.class);
        Client client = new Client();
        client.setId(2L);
        client.setUsername("hello2");
        mapper.update1(client);
        session.commit();
        session.close();
    }

    @Test
    public void test6(){
        SqlSession session = MyBatisUtils.getSession();
        ClientMapper mapper = session.getMapper(ClientMapper.class);
        Client client = new Client();
        client.setId(2L);
        client.setUsername("hello3");
        mapper.update2(client);
        session.commit();
        session.close();
    }

    @Test
    public void test7(){
        SqlSession session = MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        mapper.batchDelete(new Long[]{1L,2L,3L});
        session.commit();
        session.close();
    }
}
