package com.dai.bean;

/**
 * Created by Administrator on 2017/4/22 0022.
 */
public class ClientMessage {

    private String cmd;
    private String roomid;
    private String msg;
    private String post;
    private String ctime;

    public ClientMessage() {
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public ClientMessage(String cmd, String roomid, String msg, String post, String ctime) {
        this.cmd = cmd;
        this.roomid = roomid;
        this.msg = msg;
        this.post = post;
        this.ctime = ctime;
    }
}
