package com.microservice.userservice.dto;

import lombok.Data;

@Data
public class UserDto {
    String username;
    String password;
    String image;
}
