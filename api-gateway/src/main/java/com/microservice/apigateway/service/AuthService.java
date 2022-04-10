package com.microservice.apigateway.service;

import com.microservice.apigateway.model.UserAuthRes;
import com.microservice.userservice.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthService {
    UserAuthRes authenticate(UserDto userDto) throws Exception;
    UserDetails getUserDetails(String token);
}
