package com.dai.config;

import com.dai.bean.ReceivedMessage;
import com.dai.bean.SendMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by Administrator on 2017/4/22 0022.
 */
@ServerEndpoint("/websocket")
@Component
public class WebSocket {
    private static int onlineCount = 0;

    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<>();

    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        System.out.println("session.getRequestParameterMap() = " + session.getRequestParameterMap());
        System.out.println("session.getRequestURI() = " + session.getRequestURI());
        System.out.println("session.getPathParameters() = " + session.getPathParameters());
        webSocketSet.add(this);
        addOnlineCount();
        System.out.println("有新链接加入!当前在线人数为" + getOnlineCount());
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        subOnlineCount();
        System.out.println("有一链接关闭!当前在线人数为" + getOnlineCount());
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("来自客户端的消息:" + message);

        ObjectMapper objectMapper = new ObjectMapper();
        ReceivedMessage receivedMessage = objectMapper.readValue(message, ReceivedMessage.class);
        System.out.println("clientMessage.getCmd() = " + receivedMessage.getUserId());
        System.out.println("clientMessage.getCtime() = " + receivedMessage.getRoomId());
        System.out.println("clientMessage.getMsg() = " + receivedMessage.getTimeStamp());
        System.out.println("clientMessage.getPost() = " + receivedMessage.getMessage());

        SendMessage sendMessage = new SendMessage();
        sendMessage.setMessage(receivedMessage.getMessage());
        sendMessage.setRoomId(receivedMessage.getRoomId());
        sendMessage.setUserId(receivedMessage.getUserId());
        sendMessage.setTimeStamp(receivedMessage.getTimeStamp());
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(sendMessage);
        System.out.println("sendMessage = " + value);
        // 群发消息
        for (WebSocket item : webSocketSet) {
            item.sendMessage(value);
        }
    }

    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    public static synchronized int getOnlineCount() {
        return WebSocket.onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocket.onlineCount--;
    }


}
