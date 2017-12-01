package com.spring_boot.spring_boot_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultViewController{
    @RequestMapping("/")
    public String index() {
        return "index";
    }

}
