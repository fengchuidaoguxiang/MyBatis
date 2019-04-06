package com.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter@Setter
public class Department {
    private long id;
    private String name;
    //一个部门关联多个员工
    private List<Employee2> employee2s = new ArrayList<>();

    @Override
    public String toString() {
        return "Department{" + "id=" + id + ", name=" + name + '}';
    }
}
