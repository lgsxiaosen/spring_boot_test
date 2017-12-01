package com.spring_boot.spring_boot_test.controller;


import com.spring_boot.spring_boot_test.po.User;
import com.spring_boot.spring_boot_test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/list")
    public String getUserList(Model model){
        List<User> userList = userService.userList();
        model.addAttribute("userList", userList);
        return "user/userList";
    }

    @RequestMapping("/list_")
    @ResponseBody //只提供接口
    public List<User> getUserLis(Model model){
        List<User> userList = userService.userList();
        model.addAttribute("userList", userList);
        return userList;
    }

    @RequestMapping("/userInfo/{id}")
    public String getUserInfo(@PathVariable Integer id, Model model){
        User userDetail = userService.getUserDetail(id);
        model.addAttribute("userInfo", userDetail);
        return "user/userDetail";
    }

    @RequestMapping("userUpdate")
    public String toUserUpdate(){
        return "user/userUpdate";
    }

    @RequestMapping("userAdd")
    public String toUserAdd(){
        return "user/userAdd";
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public String updateUserInfo(User user){
         userService.updateUserDetail(user);
        return "user/userList";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public void addUser(User user){
        userService.addUser(user);
    }
}
