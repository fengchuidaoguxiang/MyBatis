package com.test;

import com.domain.Student;
import com.domain.Teacher;
import com.mapper.StudentMapper;
import com.mapper.TeacherMapper;
import com.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {

    @Test
    public void test1(){
        Teacher t1 = new Teacher();
        t1.setName("老师1");
        Teacher t2 = new Teacher();
        t2.setName("老师2");

        Student s1 = new Student();
        s1.setName("小明");
        Student s2 = new Student();
        s2.setName("小丽");

        //维护关系
        s1.getTeachers().add(t1);
        s1.getTeachers().add(t2);
        s2.getTeachers().add(t1);
        s2.getTeachers().add(t2);

        SqlSession session = MyBatisUtils.getSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);

        studentMapper.save(s1);
        studentMapper.save(s2);
        teacherMapper.save(t1);
        teacherMapper.save(t2);

        //s1学生来维护和老师的关系
        for(Teacher t: s1.getTeachers()){
            studentMapper.insertRelationWithTeacher(s1.getId(),t.getId());
        }
        //s2学生来维护和老师的关系
        for(Teacher t: s2.getTeachers()){
            studentMapper.insertRelationWithTeacher(s2.getId(),t.getId());
        }

        session.commit();
        session.close();
    }

    @Test
    public void testDelete(){
        SqlSession session = MyBatisUtils.getSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        //先删除中间表数据，然后再删除student表中数据
        studentMapper.deleteRelationWithTeacher(4L);
        studentMapper.delete(4L);
        session.commit();
        session.close();
    }

    @Test
    public void testGet(){
        SqlSession session = MyBatisUtils.getSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        Student student = studentMapper.get(1L);
        System.out.println(student);
//        System.out.println(student.getTeachers());
        session.close();
    }
}
