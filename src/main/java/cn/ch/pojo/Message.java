package cn.ch.pojo;

import java.io.Serializable;

/**
 * @Classname Message
 * @Description
 * @create 2021/1/25
 * @Author random
 */

public class Message implements Serializable{

    private static final long serialVersionUID = 1L;

    private String aaa;

    private String MessageId;

    private String MessageData;

    private String createTime;

    public static final String AAA = "aaa";

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMessageId() {
        return MessageId;
    }

    public void setMessageId(String messageId) {
        MessageId = messageId;
    }

    public String getMessageData() {
        return MessageData;
    }

    public void setMessageData(String messageData) {
        MessageData = messageData;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getAaa() {
        return aaa;
    }

    public void setAaa(String aaa) {
        this.aaa = aaa;
    }

    public static String getAAA() {
        return AAA;
    }
}
