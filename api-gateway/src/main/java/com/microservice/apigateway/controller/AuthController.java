package com.microservice.apigateway.controller;


import com.microservice.apigateway.model.UserAuthRes;
import com.microservice.apigateway.service.AuthService;
import com.microservice.userservice.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping
    private UserAuthRes authenticate(@RequestBody UserDto userDto) throws Exception {
        return authService.authenticate(userDto);
    }

}
