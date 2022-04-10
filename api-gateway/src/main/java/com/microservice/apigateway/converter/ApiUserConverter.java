package com.microservice.apigateway.converter;

import com.microservice.apigateway.model.ApiUser;
import com.microservice.userservice.model.User;
import org.springframework.stereotype.Component;

@Component
public class ApiUserConverter {

    public ApiUser getUser(User user) {
       return ApiUser.builder()
                        .username(user.getUsername())
                                .password(user.getPassword())
                                        .id(user.getId())
                .build();
    }

}
