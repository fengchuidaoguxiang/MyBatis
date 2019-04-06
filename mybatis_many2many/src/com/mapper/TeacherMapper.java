package com.mapper;

import com.domain.Teacher;

import java.util.List;

public interface TeacherMapper {
    void save(Teacher teacher);
    List<Teacher> selectByStudentId(Long studentId);
}
