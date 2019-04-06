package com.test;

import com.domain.Employee;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.EmployeeMapper;
import com.service.EmployeeQueryObject;
import com.service.EmployeeServiceImpl;
import com.service.IEmployeeService;
import com.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class MyTest {

    @Test
    public void testPageHelper(){
        SqlSession session = MyBatisUtil.getSession();
        //------------------------------------------
        //设置分页:
        PageHelper.startPage(2,3);
        //------------------------------------------
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        List<Employee> employees = employeeMapper.listAll();
        for(Employee temp : employees){
            System.out.println(temp);
        }

//        Page page = (Page) employees;
//        System.out.println(page.getTotal());
        PageInfo pageInfo = new PageInfo(employees);
        System.out.println(pageInfo.getTotal());
        System.out.println(pageInfo.getList());
        System.out.println(pageInfo.getPageNum()+"/"+pageInfo.getPages());
        System.out.println(pageInfo.getPrePage());
        System.out.println(pageInfo.getNextPage());

        session.close();
    }

    @Test
    public void test2(){
        EmployeeQueryObject employeeQueryObject = new EmployeeQueryObject();
        employeeQueryObject.setCurrentPage(1);
        employeeQueryObject.setPageSize(3);
        IEmployeeService service = new EmployeeServiceImpl();
        employeeQueryObject.setMinSalary(new BigDecimal("1000"));
//        employeeQueryObject.setKeyword("1");
        PageInfo pageInfo = service.query(employeeQueryObject);
        System.out.println(pageInfo.getTotal());
        for(Object o : pageInfo.getList()){
            System.out.println(o);
        }
    }

}
