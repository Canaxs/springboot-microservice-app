package com.microservice.userservice.converter;

import com.microservice.userservice.dto.UserDto;
import com.microservice.userservice.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User convertDto(UserDto userDto) {
        return User.builder()
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .image(userDto.getImage())
                .build();
    }
}
