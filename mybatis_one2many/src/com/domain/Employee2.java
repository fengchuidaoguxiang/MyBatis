package com.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Employee2 {
    private long id;
    private String name;
    private long deptId;//员工所在部门的ID
}
