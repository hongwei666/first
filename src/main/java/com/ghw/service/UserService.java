package com.ghw.service;

import com.ghw.pojo.Page;
import com.ghw.pojo.UserOld;

import java.util.List;


public interface UserService {

    //根据用户名模糊查询
    List<UserOld> findUserByName(String name);

    //列出所有用户
    List<UserOld> list();

    //添加用户
    void addUser(UserOld userOld);

    //删除用户
    void delete(int id);

    //编辑用户
    void editUser(UserOld userOld);

    //获取用户
    UserOld getUser(int id);

    //查询用户总数
    int total();

    //分页查询用户
    List<UserOld> listUsersByPage(Page page);
}
