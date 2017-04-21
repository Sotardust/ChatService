package com.dai.service;

import com.dai.bean.User;
import com.dai.dao.RegisterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/4/15 0015.
 */
@Service
public class RegisterService {

    @Autowired
    private RegisterMapper registerMapper;

    public void insertData(User user) {
        registerMapper.insertData(user);
    }

    public int getIds() {
        return registerMapper.getIds();
    }
}
