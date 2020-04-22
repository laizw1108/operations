package com.zoe.operations.controller;

import com.zoe.operations.model.User;
import com.zoe.operations.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户展示页面
     * @param model
     * @param curPage
     * @return
     */
    @RequestMapping("/user/userlist")
    public String index(Model model, @RequestParam(value = "curPage",required = false) Integer curPage){

        //每页显示行数
        int pageSize = 10;

        //curPage 当前页的值.如果没传数据过来，则取默认值
        if(null == curPage || curPage < 1){
            curPage = 1;
        }

        //数据总量（单位 行）
        int totalRows = userService.getUserByTotal();

        //分页数量
        int totaPages = totalRows / pageSize;

        //分页后若有余数，则分页数加1
        int left = totalRows % pageSize;
        if (left > 0) {
            totaPages += 1;
        }

        if(curPage > totaPages) {
            curPage = totaPages;
        }

        //每页显示的数据的启示位置
        int startRow = (curPage - 1) * pageSize;

        //每个分页显示的数据
        Map<String,Object> paramMap = new ConcurrentHashMap<>();
        paramMap.put("startRow",startRow);
        paramMap.put("pageSize",pageSize);
        List<User> userList =  userService.getUserByPage(paramMap);

        model.addAttribute("userList",userList);
        model.addAttribute("curPage",curPage);
        model.addAttribute("totaPages",totaPages);

        //跳转到模板页面
        return "userlist";
    }

    /**
     * 添加用户页面
     * @return
     */
    @RequestMapping("/user/toAddUser")
    public String toAddUser(){
        return "toAddUser";
    }

    /**
     * 添加/修改 用户信息
     * @param user
     * @return
     */
    @RequestMapping("/user/addUser")
    public String addUser(User user){

        String id = user.getId();
        if("" == id){
            //添加用户
            userService.addUser(user);
        }else {
            userService.updateUser(user);
        }


        return "redirect:/user/userlist";
    }

    @RequestMapping("/user/toUpdateUser")
    public String toUpdateUser(Model model,@RequestParam("id") String id){

        User user = userService.getUserById(id);

        model.addAttribute("user",user);
        return "toAddUser";
    }

    @RequestMapping("/user/toDeleteUser")
    public String toDeleteUser(@RequestParam("id") String id){
        userService.deleteUser(id);
        return "redirect:/user/userlist";
    }




}
