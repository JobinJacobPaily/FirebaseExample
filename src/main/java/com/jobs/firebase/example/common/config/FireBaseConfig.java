package com.jobs.firebase.example.common.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

import static com.jobs.firebase.example.common.config.LoggerConfig.LOGGER;

@Configuration
public class FireBaseConfig {

    @Value("${firebase.test.config-file-name}")
    private String firebaseConfFile;

    @Bean
    public void initializeFirebase() {

        try {
            LOGGER.info("Firebase initialization start .");
            final FirebaseOptions firebaseOptions = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream( new ClassPathResource(firebaseConfFile)
                            .getInputStream())).build();
            if(FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp();
                LOGGER.info("Firebase initialized successfully .");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
