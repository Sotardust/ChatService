package com.dai.bean;

/**
 * Created by Administrator on 2017/4/23 0023.
 */
public class SendMessage {
    private String Appid;
    private String Uid;
    private String Psw;
    private String Time;
    private String Tag;
    private String Sign;

    public SendMessage() {

    }

    public String getAppid() {
        return Appid;
    }

    public void setAppid(String appid) {
        Appid = appid;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    public String getPsw() {
        return Psw;
    }

    public void setPsw(String psw) {
        Psw = psw;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String tag) {
        Tag = tag;
    }

    public String getSign() {
        return Sign;
    }

    public void setSign(String sign) {
        Sign = sign;
    }
}
