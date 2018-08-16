package com.ucl.service;

import com.ucl.mapper.OrdersCustomMapper;
import com.ucl.pojo.Orders;
import com.ucl.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hongwei.gao
 */
@Service
public class OrderCustomServiceImpl implements OrderCustomService {
    @Autowired
    OrdersCustomMapper ordersCustomMapper;

    @Override
    public List<Orders> findOrdersUser() {
        return ordersCustomMapper.findOrdersUser();
    }

    @Override
    public List<Orders> findOrdersAndOrderDetailResultMap() {
        return ordersCustomMapper.findOrdersAndOrderDetailResultMap();
    }

    @Override
    public List<User> findUserAndItemsResultMap() {
        return ordersCustomMapper.findUserAndItemsResultMap();
    }
}
