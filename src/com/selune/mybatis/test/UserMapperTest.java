package com.selune.mybatis.test;

import com.selune.mybatis.mapper.UserMapper;
import com.selune.mybatis.pojo.User;
import com.selune.mybatis.pojo.UserCustom;
import com.selune.mybatis.pojo.UserQueryVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Selune
 * @Date: 5/31/19 9:25 PM
 */

public class UserMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void findUserById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(1);
        Assert.assertEquals("王五", user.getUsername());
        System.out.println(user);
    }

    @Test
    public void findUserByName() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findUserByName("三");
        System.out.println(userList);
        Assert.assertNull(userList.size());
    }

    @Test
    public void insertUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("zhang3");
        userMapper.insertUser(user);
    }

    @Test
    public void deleteUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser(13);
    }

    @Test
    public void updateUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(13);
        user.setUsername("new name");

        userMapper.updateUser(user);
    }
    @Test
    public void testFindUserList() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserQueryVO userQueryVO = new UserQueryVO();
        UserCustom userCustom = new UserCustom();
//        userCustom.setUsername("张三");
        userCustom.setSex("男");

        userQueryVO.setUserCustom(userCustom);

//        List<UserCustom> userCustomList = userMapper.findUserList(userQueryVO);
        List<UserCustom> userCustomList = userMapper.findUserList(null);
        System.out.println(userCustomList);
    }

    @Test
    public void testFindUserCount() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserQueryVO userQueryVO = new UserQueryVO();
        UserCustom userCustom = new UserCustom();
        userCustom.setSex("男");
//        userCustom.setUsername("");
        userQueryVO.setUserCustom(userCustom);

        int count = userMapper.findUserCount(userQueryVO);
        System.out.println(count);
    }

    @Test
    public void testFindUserByIdResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserByIdResultMap(1);
        System.out.println(user);
    }

    @Test
    public void testFindUserListByIds() throws Exception {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(10);
        ids.add(16);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserQueryVO userQueryVO = new UserQueryVO();
        userQueryVO.setIds(ids);
        List<UserCustom> userCustomList = userMapper.findUserListByIds(userQueryVO);
        System.out.println(userCustomList);
    }

}
