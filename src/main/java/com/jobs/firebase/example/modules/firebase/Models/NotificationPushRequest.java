package com.jobs.firebase.example.modules.firebase.Models;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class NotificationPushRequest {

    @NotBlank
    private String message;
    @NotBlank
    private String title;
    @NotNull
    @Min(0)
    @Max(1)
    private int type;
    private String fcm_token;
}
