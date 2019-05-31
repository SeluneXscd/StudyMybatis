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
}
