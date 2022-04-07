package com.jobs.firebase.example.modules.firebase.service.Impl;

import com.google.api.core.ApiFuture;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.jobs.firebase.example.common.constant.NotificationSentType;
import com.jobs.firebase.example.modules.firebase.Models.NotificationPushRequest;
import com.jobs.firebase.example.modules.firebase.Models.NotificationPushResponse;
import com.jobs.firebase.example.modules.firebase.service.FireBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class FireBaseServiceImpl implements FireBaseService {

    @Override
    public NotificationPushResponse sendMessage(NotificationPushRequest notificationPushRequest)
            throws ExecutionException, InterruptedException {
        Map<String, String> payload = new HashMap<>();
        payload.put("title", notificationPushRequest.getTitle());
        payload.put("message", notificationPushRequest.getMessage());
        try {
            if (notificationPushRequest.getType() == NotificationSentType.SEND_VIA_FCM.getCode()) {
                Message message = Message.builder().putAllData(payload)
                        .setToken(notificationPushRequest.getFcm_token())
                        .build();
                ApiFuture<String> response = FirebaseMessaging.getInstance().sendAsync(message);
                return NotificationPushResponse.builder().message(response.get()).build();
            } else  {
                String topics = "push";
                Message message = Message.builder().putAllData(payload)
                        .setTopic(topics)
                        .build();
                ApiFuture<String> response = FirebaseMessaging.getInstance().sendAsync(message);
                return NotificationPushResponse.builder().message(response.get()).build();
            }
        } catch (Exception e) {
            LOGGER.error(Arrays.toString(e.getStackTrace()));
            throw e;

        }

    }

}
