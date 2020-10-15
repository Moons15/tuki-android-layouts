package com.tuki.data.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Notification {

    @PrimaryKey
    private int id;
    private byte type;
    private String message;
    private String backgroundUrl;

    public Notification(byte type, String message, String backgroundUrl) {
        this.type = type;
        this.message = message;
        this.backgroundUrl = backgroundUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }
}

