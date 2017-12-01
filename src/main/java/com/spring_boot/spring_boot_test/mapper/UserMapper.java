package com.spring_boot.spring_boot_test.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.spring_boot.spring_boot_test.po.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> queryAll();

    User queryById(@Param("id")Integer id);

    void updateById(User user);

    void insertUser(User user);





}
