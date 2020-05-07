package com.zoe.operations.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserLogin {

    @RequestMapping("/setsession")
    public @ResponseBody String setSession(HttpServletRequest request){
        String aaa = "dsfsdfsd";
        request.getSession().setAttribute("user",aaa);
        return "user is " + aaa;
    }

    @RequestMapping("/getsession")
    public @ResponseBody String getSession(HttpServletRequest request){
        return request.getSession().getAttribute("user").toString();
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/user/login")
    public String login(HttpServletRequest request){
        return "navigation";
    }

    @RequestMapping("/navigation")
    public String navigation() {
        return "navigation";
    }

    @RequestMapping("/welcome")
    public String webcome() {
        return "welcome";
    }

    @RequestMapping("/project1")
    public String project1() {
        return "project1";
    }

    @RequestMapping("/project2")
    public String project2() {
        return "project2";
    }

//    @RequestMapping("userlist")
//    public String userList() {
//        return "userlist";
//    }
}
