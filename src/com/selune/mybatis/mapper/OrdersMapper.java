package com.selune.mybatis.mapper;

import com.selune.mybatis.pojo.Orders;
import com.selune.mybatis.pojo.OrdersCustom;

import java.util.List;

/**
 * @Author: Selune
 * @Date: 2019/6/2 16:54
 */


public interface OrdersMapper {

    /** 查询订单关联用户信息 */
    public List<OrdersCustom> findOrdersUser() throws Exception;

    /** 查询订单关联用户信息 resultMap */
    public List<OrdersCustom> findOrdersUserByResultMap() throws Exception;

    public List<OrdersCustom> findOrdersAndOrderDetailResultMap() throws Exception;
}