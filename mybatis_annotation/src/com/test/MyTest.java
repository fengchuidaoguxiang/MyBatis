package com.test;

import com.domain.User;
import com.mapper.UserMapper;
import com.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.nio.channels.SeekableByteChannel;
import java.util.List;

public class MyTest {

    @Test
    public void testGetAll(){
        SqlSession session = MyBatisUtils.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> users =  userMapper.getAll();
        session.close();
        System.out.println(users);
    }

    @Test
    public void testGet(){
        SqlSession sqlSession = MyBatisUtils.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.get(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testSave(){
        SqlSession session = MyBatisUtils.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = new User();
//        user.setId(19);
        user.setName("Tom");
        user.setSalary(new BigDecimal("400"));
        userMapper.save(user);
        session.commit();
        session.close();
    }
}
