package com.jobs.firebase.example.modules.firebase.controller;

import com.jobs.firebase.example.modules.firebase.Models.NotificationPushRequest;
import com.jobs.firebase.example.modules.firebase.Models.NotificationPushResponse;
import com.jobs.firebase.example.modules.firebase.service.FireBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.ExecutionException;

@RestController
@Slf4j
public class NotificationController {

    @Autowired
    private FireBaseService fireBaseService;

    @PostMapping("api/firebase/push")
    public ResponseEntity<NotificationPushResponse> send(
            @RequestBody
            @Valid NotificationPushRequest notificationPushRequest ,
            BindingResult bindingResult) throws ExecutionException, InterruptedException {

        if(bindingResult.hasErrors()) {
            LOGGER.error(bindingResult.toString());
            throw new RuntimeException();
        }

        return ResponseEntity.ok(fireBaseService.sendMessage(notificationPushRequest));

    }

}
