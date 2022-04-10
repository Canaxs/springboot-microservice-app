package com.microservice.apigateway.model;

import lombok.Data;

@Data
public class UserAuthRes {

    private String token;
    private String username;

}
