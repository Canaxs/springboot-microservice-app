package com.microservice.postservice.converter;

import com.microservice.postservice.dto.PostDto;
import com.microservice.postservice.model.Post;
import org.springframework.stereotype.Component;

@Component
public class PostConverter {

    public Post getPostConvert(PostDto postDto) {
        Post post = Post.builder()
                .username(postDto.getUsername())
                        .text(postDto.getText())
                                .image(postDto.getImage())
                .build();
        return post;
    }
}
