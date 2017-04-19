package com.dai.controller;

import com.dai.bean.User;
import com.dai.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/10 0010.
 */
@Controller
@RequestMapping("/mobile")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/name")
    @ResponseBody
    public Object findUserName() {
        Map<String, Object> result = new HashMap<>();
        List<User> users = userService.findUsername();
        result.put("data", users);
        result.put("status", 0);
        return result;
    }

//    @RequestMapping(value = "/all")
//    @ResponseBody
//    public List findAll() {
//        return userService.findAll();
//    }


    @RequestMapping(value = "/list")
    @ResponseBody
    public Object getList() {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("测试数据" + i);
        }
        return list;
    }

}
