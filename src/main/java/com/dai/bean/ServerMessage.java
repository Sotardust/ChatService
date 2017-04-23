package com.dai.bean;

/**
 * Created by Administrator on 2017/4/22 0022.
 */
public class ServerMessage {


    public ServerMessage() {

    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    private String roomid;
    private String appid;
    private String cmd;
    private String msg;
    private String time;
    private String uid;

    @Override
    public String toString() {
        return "{\"roomid\":" + "\"" + roomid + "\","
                + "\"appid\":" + "\"" + appid + "\","
                + "\"cmd\":" + "\"" + cmd + "\","
                + "\"msg\":" + "\"" + msg + "\","
                + "\"time\":" + "\"" + time + "\","
                + "\"uid\":" + "\"" + uid + "\"}";
    }
}
