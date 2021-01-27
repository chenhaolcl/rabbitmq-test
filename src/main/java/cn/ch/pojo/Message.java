package cn.ch.pojo;

import java.io.Serializable;

/**
 * @Classname Message
 * @Description
 * @create 2021/1/25
 * @Author random
 */

public class Message implements Serializable{

    private String MessageId;

    private String MessageData;

    private String createTime;

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
}
