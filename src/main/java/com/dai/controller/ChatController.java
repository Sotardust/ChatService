/*
package com.dai.controller;

import com.dai.bean.ReceivedMessage;
import com.dai.service.ChatService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

*/
/**
 * Created by Administrator on 2017/4/25 0025.
 *//*

@Controller
public class ChatController {

    @Resource
    private ChatService webSocket;
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    public void insert(ReceivedMessage receivedMessage) {
        chatService.insert(receivedMessage);
        System.out.println("receivedMessage = " + receivedMessage);
    }

    public ChatService getWebSocket() {
        return webSocket;
    }
}
*/
