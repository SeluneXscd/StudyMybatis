package com.selune.mybatis.pojo;

import java.util.List;

/**
 * 定义包装类
 * @Author: Selune
 * @Date: 2019/6/1 16:47
 */

public class UserQueryVO {

    // 包装所需要的查询条件
    // 传入多个id
    private List<Integer> ids;

    // 用户查询条件
    private UserCustom userCustom;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }


}
