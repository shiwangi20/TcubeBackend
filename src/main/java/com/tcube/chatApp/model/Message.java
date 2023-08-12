package com.tcube.chatApp.model;

public class Message {

    private String messageId;
    private String content;
    private String sentFromId;
    private String sentToId;
    private String createAt;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSentFromId() {
        return sentFromId;
    }

    public void setSentFromId(String sentFromId) {
        this.sentFromId = sentFromId;
    }

    public String getSentToId() {
        return sentToId;
    }

    public void setSentToId(String sentToId) {
        this.sentToId = sentToId;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
}
