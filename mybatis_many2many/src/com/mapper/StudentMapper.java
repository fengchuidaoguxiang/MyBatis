package com.mapper;

import com.domain.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    void save(Student student);
    void insertRelationWithTeacher(@Param("studentId") Long studentId, @Param("teacherId") Long teacherId);
    void delete(long id);
    void deleteRelationWithTeacher(long studentId);
    Student get(Long id);
}
