package com.microservice.userservice.service;


import com.microservice.userservice.dto.UserDto;
import com.microservice.userservice.model.User;

public interface UserService {
    User create(UserDto userDto);
    void delete(long id);
    User getUser(long id);

}
