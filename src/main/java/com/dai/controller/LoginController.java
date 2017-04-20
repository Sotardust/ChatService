package com.dai.controller;

import com.dai.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/19 0019.
 */
@Controller
@RequestMapping("/mobile")
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object getResult(@RequestParam(value = "username", required = true) String username,
                            @RequestParam(value = "password", required = true) String password) {
        System.out.println("getResult username = " + username);
        Map<String, String> value = new HashMap<>();
        if (loginService.isLogin(username, password)) {
            value.put("success", "1");
            value.put("error", "");
        } else {
            value.put("success", "0");
            value.put("error", "登录失败");
        }
        return value;
    }

}
