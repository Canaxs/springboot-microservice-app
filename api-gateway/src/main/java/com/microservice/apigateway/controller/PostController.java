package com.microservice.apigateway.controller;


import com.microservice.apigateway.feign.PostServiceClient;
import com.microservice.postservice.dto.PostDto;
import com.microservice.postservice.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    PostServiceClient postServiceClient;

    @PostMapping
    Post create(@RequestBody PostDto postDto) {
        postDto.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        return postServiceClient.create(postDto);
    }

    @DeleteMapping("/{id}")
    String delete(@PathVariable long id) {
        return postServiceClient.delete(id);
    }

    @PutMapping("/{id}")
    Post update(@PathVariable long id,@RequestBody PostDto postDto) {
        postDto.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        return postServiceClient.update(id,postDto);
    }

    @GetMapping("/{id}")
    Post getPost(@PathVariable long id) {
        return  postServiceClient.getPost(id);
    }

    @GetMapping
    List<Post> getPosts() {
        return postServiceClient.getPosts();
    }



}
