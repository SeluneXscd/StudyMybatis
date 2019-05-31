package com.selune.mybatis.test;

import com.selune.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: Selune
 * @Date: 5/31/19 2:02 PM
 */

public class MybatisUserTest {

    /**
     * 根据id查询用户
     * @throws Exception
     */
    @Test
    public void findUserByIdTest() throws Exception {
        // mybatis config
        String resource = "SqlMapConfig.xml";
        // config -> file stream
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 通过SqlSession操作数据库
        // 第一个参数：映射文件中statement的id，等于=namespace+"."+statement的id
        // 第二个参数：指定和映射文件中所匹配的parameterType类型的参数
        // sqlSession.selectOne结果 是与映射文件中所匹配的resultType类型的对象
        // selectOne查询出一条记录
        User user1 = sqlSession.selectOne("findUserById", 1);
        System.out.println(user1);

        User user2 = sqlSession.selectOne("test.findUserById", 2);
        System.out.println(user2);

        // close
        sqlSession.close();
    }

    /**
     * 根据用户名查询用户
     * @throws Exception
     */
    @Test
    public void findUserByName() throws Exception {
        // mybatis config
        String resource = "SqlMapConfig.xml";
        // config -> file stream
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> userList = sqlSession.selectList("findUserByName", "四");
        System.out.println(userList);
        sqlSession.close();
    }

    /**
     * 添加用户
     * @throws Exception
     */
    @Test
    public void insertUser() throws Exception {
        // mybatis config
        String resource = "SqlMapConfig.xml";
        // config -> file stream
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setUsername("li4");

        sqlSession.insert("insertUser", user);
        sqlSession.commit();

        System.out.println(user.getId());
        sqlSession.close();
    }

    /**
     * 删除用户
     * @throws Exception
     */
    @Test
    public void deleteUser() throws Exception {
        // mybatis config
        String resource = "SqlMapConfig.xml";
        // config -> file stream
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.delete("test.deleteUser", 14);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 修改用户
     * @throws Exception
     */
    @Test
    public void updateUser() throws Exception {
        // mybatis config
        String resource = "SqlMapConfig.xml";
        // config -> file stream
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setId(13);
        user.setUsername("li4");


        sqlSession.update("test.updateUser", user);
        sqlSession.commit();
        sqlSession.close();
    }
}
