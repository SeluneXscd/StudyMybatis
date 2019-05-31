package com.selune.mybatis.test;

import com.selune.mybatis.dao.UserDao;
import com.selune.mybatis.dao.impl.UserDaoImpl;
import com.selune.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * @Author: Selune
 * @Date: 5/31/19 9:05 PM
 */

public class UserDaoTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void findUserByIdTest() throws Exception {
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = userDao.findUserById(1);
        Assert.assertEquals("张三", user.getUsername());
        System.out.println(user);
    }

    @Test
    public void insertUser() throws Exception {
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = new User();
        user.setUsername("wang5");
        userDao.insertUser(user);
    }

    @Test
    public void updateUser() throws Exception {
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = new User();
        user.setId(15);
        user.setUsername("li4");
        userDao.updateUser(user);
    }

    @Test
    public void deleteUser() throws Exception {
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        userDao.deleteUser(15);
    }
}
