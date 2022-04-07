package com.jobs.firebase.example.modules.firebase.Models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationPushResponse {

    private int code;
    private String message;
}
