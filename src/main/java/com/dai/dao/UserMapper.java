package com.dai.dao;

import com.dai.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2017/4/13 0013.
 */
@Mapper
public interface UserMapper {

//    public List findAll();

    List<User> findUserName();
}
