package com.ucl.mapper;

import com.ucl.pojo.Orders;
import com.ucl.pojo.User;

import java.util.List;

public interface OrdersCustomMapper {
    /**
     * 查询订单，关联查询用户信息
     */
    List<Orders> findOrdersUser();

    /**
     * 查询订单表，关联查询用户和订单详细信息表
     *
     * @return
     */
    List<Orders> findOrdersAndOrderDetailResultMap();

    /**
     * 查询用户表，关联查询订单表，订单详情表和商品表
     *
     * @return
     */
    List<User> findUserAndItemsResultMap();
}