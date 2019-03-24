package com.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;

@Data
public class User {
    private Long id;
    private String name;
    private BigDecimal salary;
}
