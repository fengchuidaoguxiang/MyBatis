package com.test;
import com.domain.Teacher;
import com.mapper.TeacherMapper;
import com.mapper.UserMapper;
import com.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class MyTest {

    @Test
    public void test1(){
        SqlSession session = MyBatisUtils.getSession();
        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.get(1L);
        System.out.println(teacher);
        System.out.println("--------------------------------------");
        session.clearCache();//清空一级缓存
        Teacher teacher2 = teacherMapper.get(1L);
        System.out.println(teacher2);
        System.out.println("--------------------------------------");
        session.close();
    }

    //二级缓存：Mapper级别
    @Test
    public void testSecondLevelCache() throws InterruptedException {
        SqlSession session = MyBatisUtils.getSession();
        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.get(1L);
        System.out.println(teacher);
        session.close();
        System.out.println("--------------------------------");
        Thread.sleep(3000L);
        SqlSession session2 = MyBatisUtils.getSession();
        TeacherMapper teacherMapper2 = session2.getMapper(TeacherMapper.class);
        Teacher teacher2 = teacherMapper2.get(1L);
        System.out.println(teacher2);
        session.close();
    }

    @Test
    public void test3() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession session = factory.openSession();
        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.get(1L);
        System.out.println(teacher);
        session.close();
    }

    @Test
    public void test5() throws IOException {
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);
            SqlSession session = factory.openSession();
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<Map<String, Object>> maps = userMapper.listMap();
            for(Map<String,Object> temp : maps){
                System.out.println(temp);
            }
            session.close();
    }
}
