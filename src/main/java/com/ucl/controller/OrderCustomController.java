package com.ucl.controller;

import com.ucl.pojo.Orders;
import com.ucl.pojo.User;
import com.ucl.service.OrderCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author hongwei.gao
 */
@Controller
public class OrderCustomController {

    @Autowired
    OrderCustomService orderCustomService;

    /**
     * 一对一查询
     *
     * @return List<Orders>
     */
    @RequestMapping("/findOrdersUser")
    @ResponseBody
    public List<Orders> findOrdersUser() {
        return orderCustomService.findOrdersUser();
    }

    /**
     * 一对多查询
     */
    @RequestMapping("/findOrderUserDetials")
    @ResponseBody
    public List<Orders> findOrderUserDetials() {
        return orderCustomService.findOrdersAndOrderDetailResultMap();
    }

    /**
     * 多对多查询
     */

    @RequestMapping("/findUserAndItemsResultMap")
    @ResponseBody
    public List<User> findUserAndItemsResultMap() {
        System.out.println("helloworld");
        return orderCustomService.findUserAndItemsResultMap();
    }
}
