package com.dai.service;

import com.dai.dao.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Object loginResult(String username, String password) {
        Map<String, String> result = new HashMap<>();
        String queryPwd = loginMapper.findPwdByUsername(username);
        if (queryPwd == null) {
            result.put("success", "0");
            result.put("error", "用户名错误");
        } else if (!password.equals(queryPwd)) {
            result.put("success", "0");
            result.put("error", "密码错误");
        } else {
            result.put("success", "1");
            result.put("error", "");
        }
        return result;
    }

}
