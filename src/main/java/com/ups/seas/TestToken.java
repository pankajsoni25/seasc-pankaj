package com.ups.seas;

import java.io.IOException;

public class TestToken {

    public static void main(String args[]){

        String token = null;
        try {
            token = TokenUtil.generateJwt("gcp-emp-ep-dev-57529f70cb68.json",
                    "emp-ep-apigateway-admin@gcp-emp-ep-dev.iam.gserviceaccount.com", "",3600);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Token : "+ token);
    }
}
