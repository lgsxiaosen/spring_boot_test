package com.spring_boot.spring_boot_test.service.impl;

import com.spring_boot.spring_boot_test.mapper.UserMapper;
import com.spring_boot.spring_boot_test.po.User;
import com.spring_boot.spring_boot_test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServicesImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> userList() {
        return userMapper.queryAll();
    }

    @Override
    public User getUserDetail(Integer id) {
        return userMapper.queryById(id);
    }

    @Override
    public void updateUserDetail(User user) {
        userMapper.updateById(user);
    }

    @Override
    public void addUser(User user) {
        userMapper.insertUser(user);
    }
}
