package com.microservice.apigateway.service;

import com.microservice.apigateway.converter.ApiUserConverter;
import com.microservice.apigateway.model.ApiUser;
import com.microservice.userservice.model.User;
import com.microservice.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ApiUserConverter apiUserConverter;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User inDB = userRepository.findByUsername(username);
        if(inDB == null)
            throw new UsernameNotFoundException("User not found");

        ApiUser apiUser = apiUserConverter.getUser(inDB);
        return apiUser;
    }
}
