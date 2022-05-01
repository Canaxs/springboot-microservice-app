package com.microservice.userservice.service;

import com.microservice.userservice.converter.UserConverter;
import com.microservice.userservice.dto.UserDto;
import com.microservice.userservice.model.User;
import com.microservice.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;


    @Override
    public User create(UserDto userDto) {
        User user = userConverter.convertDto(userDto);
        return userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUser(long id) {
        return userRepository.getOne(id);
    }
}
