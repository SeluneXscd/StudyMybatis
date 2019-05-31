package com.selune.mybatis.dao;

import com.selune.mybatis.pojo.User;

import java.util.List;

/**
 * @Author: Selune
 * @Date: 5/31/19 8:44 PM
 */

public interface UserDao {

    /** 根据id查找用户 */
    public User findUserById(int id) throws Exception;

    /** 根据用户名查找用户 */
    public List<User> findUserByName(String name) throws Exception;

    /** 添加用户 */
    public void insertUser(User user) throws Exception;

    /** 更新用户 */
    public void updateUser(User user) throws Exception;

    /** 删除用户 */
    public void deleteUser(int id) throws Exception;
}
