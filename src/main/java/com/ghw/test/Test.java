package com.ghw.test;

import com.ghw.pojo.UserOld;
import com.ghw.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//注解实现事务，回滚数据测试
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test {

    @Autowired
    private UserService userService;

    @org.junit.Test
    @Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = "Exception")
    public void testAddTwo() {
        UserOld userOld2 = userService.getUser(1);
        userOld2.setSex("dddd");
        userService.editUser(userOld2);
        System.out.println("修改");

        UserOld userOld1 = new UserOld();
        userOld1.setName("新增用户1");
        userOld1.setSex("男1");
        userOld1.setAddress("陕西西安陕西西安陕西西安陕西西安1");
        userService.addUser(userOld1);
        System.out.println("新增");
    }

    //批量添加测试数据
    @org.junit.Test
    public void adds() {
        int n = 0;
        for (int i = 10; i < n; i++) {
            UserOld userOld1 = new UserOld();
            userOld1.setName("姓名" + i);
            userOld1.setSex("男" + i);
            userOld1.setAddress("地址" + i);
            userService.addUser(userOld1);
        }
    }
}