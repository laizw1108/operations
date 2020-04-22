package com.zoe.operations.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserLogin {

    @RequestMapping("index")
    public String login() {
        return "index";
    }

    @RequestMapping("navigation")
    public String navigation() {
        return "navigation";
    }

    @RequestMapping("webcome")
    public String webcome() {
        return "webcome";
    }

    @RequestMapping("project1")
    public String project1() {
        return "project1";
    }

    @RequestMapping("project2")
    public String project2() {
        return "project2";
    }

//    @RequestMapping("userlist")
//    public String userList() {
//        return "userlist";
//    }
}
