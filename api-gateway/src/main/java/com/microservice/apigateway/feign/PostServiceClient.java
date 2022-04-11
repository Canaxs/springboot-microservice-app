package com.microservice.apigateway.feign;

import com.microservice.postservice.dto.PostDto;
import com.microservice.postservice.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("post-service")
public interface PostServiceClient {

    @PostMapping
    Post create(@RequestBody PostDto postDto);

    @DeleteMapping("/{id}")
    String delete(@PathVariable long id);

    @PutMapping("/{id}")
    Post update(@PathVariable long id,@RequestBody PostDto postDto);

    @GetMapping("/{id}")
    Post getPost(@PathVariable long id);

    @GetMapping
    List<Post> getPosts();
}
