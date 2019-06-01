package com.selune.mybatis.pojo;

import java.util.Date;

/**
 * @Author: Selune
 * @Date: 5/31/19 1:38 PM
 */

public class User {

    private int id;

    private String username;

    private String sex;

    private Date bir;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBir() {
        return bir;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", bir=" + bir +
                '}';
    }
}
