package com.dai.controller;

import com.dai.bean.User;
import com.dai.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/15 0015.
 */
@Controller
@RequestMapping("/mobile")
public class RegisterController {

    private final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
//    public void insert(@PathVariable String username, @PathVariable String password, @PathVariable String email, @PathVariable String number) {
    public Object insert(@RequestBody User user) {
        //@PathVariable String username,@PathVariable String password, @PathVariable String email, @PathVariable String number
        int id = registerService.getIds();
        System.out.println("id = " + id);
        Map<String, String> value = new HashMap<>();
        value.put("success", "1");
        String error = "";
        try {
            registerService.insertData(user);
        } catch (Exception e) {
            error = e.getCause().toString();

        }
        value.put("error", error);
        return value;
    }
}
