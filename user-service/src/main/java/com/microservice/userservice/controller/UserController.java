package com.microservice.userservice.controller;

import com.microservice.userservice.dto.UserDto;
import com.microservice.userservice.model.User;
import com.microservice.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public User create(UserDto userDto) {
        return userService.create(userDto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        userService.delete(id);
        return "Delete By Id: "+id;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id) {
        return userService.getUser(id);
    }

}
