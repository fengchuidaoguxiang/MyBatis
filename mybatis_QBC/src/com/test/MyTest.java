package com.test;


import com.domain.SystemUser2;
import com.domain.SystemUser2Example;
import com.mapper.SystemUser2Mapper;
import com.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

//    @Test
//    public void test1(){
//        SqlSession session = MyBatisUtils.getSession();
//        TUser2Mapper tUser2Mapper = session.getMapper(TUser2Mapper.class);
//        TUser2 tUser2 = new TUser2();
//        tUser2.setUserName("tom");
//        tUser2.setPassword("1122");
//        tUser2.setUsertype(1);
//        tUser2Mapper.insert(tUser2);
//        session.commit();
//        session.close();
//    }
//
    @Test
    public void test2(){
        SqlSession session = MyBatisUtils.getSession();
        SystemUser2Mapper systemUser2Mapper = session.getMapper(SystemUser2Mapper.class);
        //查询ID为2的数据
//        SystemUser2 systemUser2 = systemUser2Mapper.selectByPrimaryKey(3L);
//        System.out.println(systemUser2);

        //查询userType在1-1000之间的
        SystemUser2Example systemUser2Example = new SystemUser2Example();
        //封装查询条件
        SystemUser2Example.Criteria criteria = systemUser2Example.createCriteria();
        criteria.andUserTypeGreaterThan(2).andUserTypeLessThanOrEqualTo(100);
//        criteria.andUserTypeBetween(1,1000);
//        List<SystemUser2> systemUser2s = systemUser2Mapper.selectByExample(systemUser2Example);
//        for(SystemUser2 user2 : systemUser2s){
//            System.out.println(user2);
//        }
        criteria.andUser_nameLike("%m%");
        List<SystemUser2> systemUser2s = systemUser2Mapper.selectByExample(systemUser2Example);
        for(SystemUser2 user2 : systemUser2s){
            System.out.println(user2);
        }
        session.close();
    }
}
