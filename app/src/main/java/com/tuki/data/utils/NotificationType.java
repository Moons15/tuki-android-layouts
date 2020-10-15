package com.tuki.data.utils;

public enum NotificationType {

    CHALLENGE_APPROVED((byte)1),
    CHALLENGE_REJECTED((byte)2),
    CHALLENGE_RETRY((byte)3);

    public final byte id;

    NotificationType(byte id) {
        this.id = id;
    }


}
