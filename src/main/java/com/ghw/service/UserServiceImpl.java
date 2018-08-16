package com.ghw.service;

import com.ghw.mapper.UserMapper;
import com.ghw.pojo.Page;
import com.ghw.pojo.UserOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    //注解注入UserMapper
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserOld> findUserByName(String name) {
        return userMapper.findUserByName(name);
    }

    //列出所有用户
    @Override
    public List<UserOld> list() {
        return userMapper.list();
    }

    //添加用户
    @Override
    public void addUser(UserOld userOld) {
        userMapper.addUser(userOld);
    }

    //删除用户
    @Override
    public void delete(int id) {
        userMapper.delete(id);
    }

    //编辑用户
    @Override
    public void editUser(UserOld userOld) {
        userMapper.editUser(userOld);
    }

    //获取用户
    @Override
    public UserOld getUser(int id) {
        return userMapper.getUser(id);
    }

    @Override
    public int total() {
        return userMapper.total();
    }

    @Override
    public List<UserOld> listUsersByPage(Page page) {
        return userMapper.listUsersByPage(page);
    }

}
