package com.ups.seas.controller;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.ups.seas.model.Employees;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@Slf4j
public class UpsController {

    public static final String PROJECT_ID = "sound-bit-369201";

    @Autowired
    private Firestore firestoreDb;

    @GetMapping("/getByEmployeeId")
    public ResponseEntity<Employees> getEmployeeDetails(@RequestParam(name = "employeeId") String employeeId) throws Exception {
        log.info("[UpsController][getEmployeeDetails] is called, employeeId: {} ", employeeId);

//        InputStream serviceAccount = new FileInputStream("config/serviceAccount.json");
//        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
/*
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setProjectId(PROJECT_ID)
                .setCredentials(GoogleCredentials.getApplicationDefault())
                .build();
        FirebaseApp.initializeApp(options);
        Firestore db = FirestoreClient.getFirestore();
*/
        firestoreDb.listCollections().forEach(System.out::println);
        DocumentReference documentReference = firestoreDb.collection("employees").document(employeeId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot documentSnapshot = future.get();
        log.info("inside the FirebaseService method getEmployeeDetails() document : {}", documentSnapshot.exists());
//        db.close();
        Employees employee = null;
        if (documentSnapshot.exists()) {
            log.info("inside the FirebaseService came inside if");
            employee = documentSnapshot.toObject(Employees.class);
        }
        return ResponseEntity.ok(employee);

    }


}