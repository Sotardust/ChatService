package com.dai.service;

import com.dai.bean.ReceivedMessage;
import com.dai.dao.ChatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/4/19 0019.
 */
@Service("chatService")
public class ChatService {

    @Autowired
    private ChatMapper chatMapper;

    public List<ReceivedMessage> getReceived() {
        return chatMapper.findALl();
    }

    public void insert(ReceivedMessage receivedMessage) {
        System.out.println("receivedMessage = " + receivedMessage);
        chatMapper.insert(receivedMessage);
        System.out.println("receivedMessage111 = " + receivedMessage);
    }

}
