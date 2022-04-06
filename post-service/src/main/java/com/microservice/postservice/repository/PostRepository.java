package com.microservice.postservice.repository;

import com.microservice.postservice.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository  extends JpaRepository<Post,Long> {
}
