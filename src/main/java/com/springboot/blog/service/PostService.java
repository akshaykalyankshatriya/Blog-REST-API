package com.springboot.blog.service;

import com.springboot.blog.payload.PostDto;
import response.BaseResponse;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPost();
    PostDto getPostById(Long id);
    PostDto updatePost(long id, PostDto postDto);
    void deletePostById(long id);
}
