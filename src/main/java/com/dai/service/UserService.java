package com.dai.service;

import com.dai.bean.User;
import com.dai.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/4/14 0014.
 */
@Service
public class UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> findUsername() {
        return userMapper.findUserName();
    }

//    public List findAll() {
//        return userMapper.findAll();
//    }
}
