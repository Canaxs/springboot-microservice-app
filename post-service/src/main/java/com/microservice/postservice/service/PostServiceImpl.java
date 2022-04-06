package com.microservice.postservice.service;

import com.microservice.postservice.converter.PostConverter;
import com.microservice.postservice.dto.PostDto;
import com.microservice.postservice.model.Post;
import com.microservice.postservice.repository.PostRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final PostConverter postConverter;


    @Override
    public Post create(PostDto postDto) {
        Post post = postConverter.getPostConvert(postDto);
       return postRepository.save(post);
    }

    @Override
    public void delete(long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Post update(long id,PostDto postDto) {
       Post post = postConverter.getPostConvert(postDto);
       post.setId(id);
        return postRepository.save(post);
    }

    @Override
    public Post getPost(long id) {
        return postRepository.getOne(id);
    }

    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }
}
