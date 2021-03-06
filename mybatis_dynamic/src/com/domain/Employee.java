package com.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Employee {
    private Long id;
    private String name;
    private String sn;
    private BigDecimal salary;
    private Long deptId;
}
