package com.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee2 {
    private long id;
    private String name;
    private Department dept;//员工所在部门对象

    @Override
    public String toString() {
        return "Employee2{" + "id=" + id + ", name=" + name + '}';
    }
}
