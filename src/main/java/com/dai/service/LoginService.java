package com.dai.service;

import com.dai.dao.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/19 0019.
 */
@Service
public class LoginService {
    @Autowired
    private LoginMapper loginMapper;

    private List<String> getAllUser() {
        List<String> users = new ArrayList<>();
        users = loginMapper.findAllUser();
        return users;
    }


    public boolean isLogin(String username, String password) {
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println("loginMapper.findPwdByUsername(username) = " + loginMapper.findPwdByUsername(username));

        return password.equals(loginMapper.findPwdByUsername(username));
    }

}
