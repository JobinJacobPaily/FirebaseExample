package com.jobs.firebase.example.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NotificationSentType {

    SEND_VIA_FCM(0 , "send message via fcm"),
    SEND_VIA_TOPICS(1, "send message via topics");

    private int code;
    private String dec;
}
