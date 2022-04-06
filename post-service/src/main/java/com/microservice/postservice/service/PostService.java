package com.microservice.postservice.service;

import com.microservice.postservice.dto.PostDto;
import com.microservice.postservice.model.Post;

import java.util.List;

public interface PostService {

    Post create(PostDto postDto);
    void delete(long id);
    Post update(long id,PostDto postDto);
    Post getPost(long id);
    List<Post> getPosts();

}
