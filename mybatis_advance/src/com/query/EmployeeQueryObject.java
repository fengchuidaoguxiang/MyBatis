package com.query;

import lombok.Data;

import java.math.BigDecimal;

//封装员工的高级查询信息
@Data
public class EmployeeQueryObject extends QueryObject {
    private String keyword;//关键字，员工的名字或员工的编号
    private BigDecimal minSalary;//最低工资
    private BigDecimal maxSalary;//最高工资
    private Long deptId = -1L;//部门ID,缺省为-1表示所有部门



    public String getKeyword(){
        return empty2null(keyword);
    }


}
