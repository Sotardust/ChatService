package com.dai.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2017/4/19 0019.
 */
@Mapper
public interface LoginMapper {
    List<String> findAllUser();

    String findPwdByUsername(String string);
}
