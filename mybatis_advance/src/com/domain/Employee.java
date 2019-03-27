package com.domain;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class Employee {
    private long id;
    private String name;
    private BigDecimal salary;
    private String sn;
    private long deptId;
}
