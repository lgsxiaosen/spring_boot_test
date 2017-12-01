package com.spring_boot.spring_boot_test.service;

import com.spring_boot.spring_boot_test.po.User;

import java.util.List;

public interface UserService {
    List<User> userList();

    User getUserDetail(Integer id);

    void updateUserDetail(User user);

    void addUser(User user);
}
