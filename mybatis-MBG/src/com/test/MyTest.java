package com.test;

import com.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;

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
//    @Test
//    public void test2(){
//        SqlSession session = MyBatisUtils.getSession();
//        TUser2Mapper tUser2Mapper = session.getMapper(TUser2Mapper.class);
//        List<TUser2> tUser2s =  tUser2Mapper.selectAll();
//        for(TUser2 temp : tUser2s){
//            System.out.println(temp);
//        }
//        session.close();
//    }
}
