package com.selune.mybatis.dao.impl;

import com.selune.mybatis.dao.UserDao;
import com.selune.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @Author: Selune
 * @Date: 5/31/19 8:48 PM
 */

public class UserDaoImpl implements UserDao {

    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findUserById(int id) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("test.findUserById", id);
        sqlSession.close();
        return user;
    }

    @Override
    public List<User> findUserByName(String name) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList = sqlSession.selectList("test.findUserByName", name);
        sqlSession.close();
        return userList;
    }

    @Override
    public void insertUser(User user) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("test.insertUser", user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateUser(User user) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("test.updateUser", user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteUser(int id) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("test.deleteUser", id);
        sqlSession.commit();
        sqlSession.close();
    }
}
