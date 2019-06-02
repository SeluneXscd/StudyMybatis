package com.selune.mybatis.test;

import com.selune.mybatis.mapper.OrdersMapper;
import com.selune.mybatis.pojo.OrdersCustom;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @Author: Selune
 * @Date: 2019/6/2 17:05
 */

public class OrdersMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindOrdersUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<OrdersCustom> ordersCustomList = ordersMapper.findOrdersUser();
        System.out.println(ordersCustomList);

        sqlSession.close();

    }

    @Test
    public void testFindOrderAndOrderDetailResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<OrdersCustom> ordersCustomList = ordersMapper.findOrdersAndOrderDetailResultMap();
        System.out.println(ordersCustomList);
    }

}
