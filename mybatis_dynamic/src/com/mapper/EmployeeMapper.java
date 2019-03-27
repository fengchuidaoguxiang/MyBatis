package com.mapper;

import com.domain.Employee;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeMapper {

    public List<Employee> query(@Param("minSalary") BigDecimal minSalary);

    public List<Employee> query2(@Param("minSalary") BigDecimal minSalary,@Param("maxSalary") BigDecimal maxSalary);

    public List<Employee> query3(@Param("deptId") Long deptId);

    public List<Employee> query4(@Param("minSalary") BigDecimal minSalary,
                          @Param("maxSalary") BigDecimal maxSalary,@Param("deptId") Long deptId);

    public void batchDelete(@Param("ids") List<Long> ids);

    public void batchSave(@Param("ems") List<Employee> ems);
}
