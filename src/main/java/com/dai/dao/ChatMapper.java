package com.dai.dao;

import com.dai.bean.ReceivedMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2017/4/22 0022.
 */
@Mapper
public interface ChatMapper {

    List<ReceivedMessage> findALl();

    void insert(ReceivedMessage receivedMessage);


}
