package com.microservice.userservice.repository;

import com.microservice.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository  extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
