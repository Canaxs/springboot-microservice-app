package com.microservice.postservice.controller;

import com.microservice.postservice.dto.PostDto;
import com.microservice.postservice.model.Post;
import com.microservice.postservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping
    private Post create(@RequestBody PostDto postDto) {
        return postService.create(postDto);
    }
    @DeleteMapping("/{id}")
    private String delete(@PathVariable long id) {
        postService.delete(id);
        return "Delete Id: "+id;
    }
    @PutMapping("/{id}")
    private Post update(@PathVariable long id,@RequestBody PostDto postDto){
        return postService.update(id,postDto);
    }
    @GetMapping("/{id}")
    private Post getPost(@PathVariable long id) {
        return postService.getPost(id);
    }
    @GetMapping
    private List<Post> getPosts() {
        return postService.getPosts();
    }
}
