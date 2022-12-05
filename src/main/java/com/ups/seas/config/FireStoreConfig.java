package com.ups.seas.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.ups.seas.controller.UpsController.PROJECT_ID;

@Configuration
public class FireStoreConfig {

    @Bean
    public Firestore getFireStore() throws IOException {

//        InputStream serviceAccount = new FileInputStream("config/serviceAccount.json");
//        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);


        FirebaseOptions options = new FirebaseOptions.Builder()
                .setProjectId(PROJECT_ID)
//                .setCredentials(credentials)
                .setCredentials(GoogleCredentials.getApplicationDefault())
                .build();
        FirebaseApp.initializeApp(options);
        return FirestoreClient.getFirestore();
    }
}
