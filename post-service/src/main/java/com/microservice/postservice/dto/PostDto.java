package com.microservice.postservice.dto;

import lombok.Data;

import javax.persistence.Lob;

@Data
public class PostDto {

    String username;

    @Lob
    String text;

    String image;


}
