package com.tcube.chatApp.model;

public class Connection {

    private ConnectionType cType;
    private String id;

    public ConnectionType getcType() {
        return cType;
    }

    public void setcType(ConnectionType cType) {
        this.cType = cType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
