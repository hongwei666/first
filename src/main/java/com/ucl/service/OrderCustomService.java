package com.ucl.service;

import com.ucl.pojo.Orders;
import com.ucl.pojo.User;

import java.util.List;

public interface OrderCustomService {
    List<Orders> findOrdersUser();

    List<Orders> findOrdersAndOrderDetailResultMap();

    List<User> findUserAndItemsResultMap();
}
