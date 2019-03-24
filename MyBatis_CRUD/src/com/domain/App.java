package com.domain;

import com.alibaba.fastjson.JSON;
import com.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;
import sun.rmi.server.UnicastServerRef;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

public class App {

    private static Logger log = Logger.getLogger(App.class);

    //查询ID为1的用户信息
    @Test
    public void testGet() throws IOException {
        //1:从classpath路径去加载MyBatis全局配置文件：mybatis-config.xml
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //2:创建SqlSessionFactory对象，好比是DataSource
        SqlSessionFactory factory = builder.build(inputStream);
        //3:创建SqlSession对象，好比是Connection
        SqlSession session = factory.openSession();
        //4:具体的操作（增删改查）
        User user =session.selectOne("com.domain.UserMapper.get",2L);
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getSalary());
        //5:关闭SqlSession
        session.close();
    }

    @Test
    public void testGetAll() throws IOException {
        //1:从classpath路径去加载MyBatis全局配置文件：mybatis-config.xml
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //2:创建SqlSessionFactory对象，好比是DataSource
        SqlSessionFactory factory = builder.build(inputStream);
        //3:创建SqlSession对象，好比是Connection
        SqlSession session = factory.openSession();
        //4:具体的操作（增删改查）
        List<User> users = session.selectList("com.domain.UserMapper.listAll");
        //5:关闭SqlSession
        session.close();
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void testLogger(){
        //如果日志级别是INFO，就输出
        if( log.isInfoEnabled() ){
            log.info("银行转账操作");
        }
        if( log.isDebugEnabled() ){
            log.debug("查询数据库");
        }
        if( log.isTraceEnabled()){
            log.trace("获取连接对象");
        }
        if( log.isTraceEnabled()){
            log.trace("执行SQL语句");
        }
        if( log.isDebugEnabled()){
            log.debug("转账。。。");
        }
        if( log.isInfoEnabled()){
            log.info("银行转账成功");
        }
    }

    @Test
    public void testMyBatisUtils(){
        try(   SqlSession session = MyBatisUtils.getSession()) {
            List<User> users = session.selectList("listAll");
            System.out.println(users);
        }
    }

    @Test
    public void testUpdate(){
        User u = new User();
        u.setName("叶孤城");
        u.setSalary(new BigDecimal("900"));
        u.setId(3L);
        SqlSession session = MyBatisUtils.getSession();
        log.info(session.update("com.domain.UserMapper.myupdate",u));
        session.commit();
        session.close();
    }

    @Test
    public void testDelete(){
        SqlSession session = MyBatisUtils.getSession();
        log.info(session.delete("com.domain.UserMapper.mydelete",3L));
        session.commit();
        session.close();
    }

    /**
     * 保存一条用户信息
     *
     * 在开发中，我们经常会有这么一个需求：
     *      保存一条数据后，需要得到刚刚保存数据生成的主键的值。
     */
    @Test
    public void testSave(){
        User u = new User();
        u.setName("楚留香");
        u.setSalary(new BigDecimal("800"));
        log.info(JSON.toJSONString(u));
        SqlSession session = MyBatisUtils.getSession();
        //具体操作
        int result = session.insert("com.domain.UserMapper.save",u);
        log.info(result);
        //提交事务
        session.commit();
        log.info(JSON.toJSONString(u));
        //是释放资源
        session.close();
    }
}
