package com.selune.mybatis.mapper;

import com.selune.mybatis.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: Selune
 * @Date: 5/31/19 9:15 PM
 */

public interface UserMapper {

    /** 根据id查询用户 */
    public User findUserById(int id) throws Exception;

    /** 根据用户名查询用户 */
    public List<User> findUserByName(String name) throws Exception;

    /** 增加用户 */
    public void insertUser(User user) throws Exception;

    /** 删除用户 */
    public void deleteUser(int id) throws Exception;

    /** 更新用户 */
    public void updateUser(User user) throws Exception;
}
