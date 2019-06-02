package com.selune.mybatis.mapper;

import com.selune.mybatis.pojo.User;
import com.selune.mybatis.pojo.UserCustom;
import com.selune.mybatis.pojo.UserQueryVO;

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

    /** 查询所有 */
    public List<UserCustom> findUserList(UserQueryVO userQueryVO) throws Exception;

    /** 查询所有数量 */
    public int findUserCount(UserQueryVO userQueryVO) throws Exception;

    /** 根据id查询，通过resultMap输出 */
    public User findUserByIdResultMap(int id) throws Exception;

    /** 传入多个ids */
    public List<UserCustom> findUserListByIds(UserQueryVO userQueryVO) throws Exception;

}
