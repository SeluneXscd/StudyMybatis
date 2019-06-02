package com.selune.mybatis.pojo;

import java.util.Date;
import java.util.List;

/**
 * @Author: Selune
 * @Date: 2019/6/2 16:54
 */


public class Orders {

    private User user;

    private List<Orderdetail> orderdetailList;

    private Integer id;

    /**
    * 下单用户id
    */
    private Integer userId;

    /**
    * 订单号
    */
    private String number;

    /**
    * 创建订单时间
    */
    private Date createtime;

    /**
    * 备注
    */
    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", number=").append(number);
        sb.append(", createtime=").append(createtime);
        sb.append(", note=").append(note);
        sb.append("]");
        return sb.toString();
    }
}