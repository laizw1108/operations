package com.zoe.operations.service.impl;

import com.zoe.operations.mapper.UserMapper;
import com.zoe.operations.model.User;
import com.zoe.operations.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;



    @Override
    public List<User> getUserByPage(Map<String, Object> paramMap) {
        return userMapper.selectUserByPage(paramMap);
    }

    @Override
    public User getUserById(String id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public int getUserByTotal() {
        return userMapper.selectUserByTotal();
    }

    @Override
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimarySelective(user);
    }

    @Override
    public int deleteUser(String id) {
        return userMapper.deleteByPrimaryKey(id);
    }
}
