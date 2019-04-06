package com.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter@Setter
public class Teacher implements Serializable {
    private Long id;
    private String name;

    @Override
    public String toString() {
        return "Teacher{" + "id=" + id + ", name=" + name + '}';
    }
}
