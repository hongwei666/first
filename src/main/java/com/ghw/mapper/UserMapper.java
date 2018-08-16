package com.ghw.mapper;

import com.ghw.pojo.Page;
import com.ghw.pojo.UserOld;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //列出所有用户
    List<UserOld> list();

    //添加用户
    void addUser(UserOld userOld);

    //删除用户
    void delete(int id);

    //编辑用户
    void editUser(UserOld userOld);

    //获取单个用户
    UserOld getUser(int id);

    //获取用户总数
    int total();

    //分页列出用户
    List<UserOld> listUsersByPage(Page page);

    //根据用户名查询用户
    List<UserOld> findUserByName(@Param("username") String username);
}
