package com.jobs.firebase.example.modules.firebase.service;

import com.jobs.firebase.example.modules.firebase.Models.NotificationPushRequest;
import com.jobs.firebase.example.modules.firebase.Models.NotificationPushResponse;

import java.util.concurrent.ExecutionException;

public interface FireBaseService {

    NotificationPushResponse sendMessage(NotificationPushRequest notificationPushRequest) throws ExecutionException, InterruptedException;


}
