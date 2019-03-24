package com.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class User {
    private long id;
    private String name;
    private BigDecimal salary;
}
