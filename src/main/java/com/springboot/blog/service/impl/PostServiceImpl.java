package com.springboot.blog.service.impl;

import com.springboot.blog.entity.Post;
import com.springboot.blog.exception.ResourceNotFoundException;
import com.springboot.blog.payload.PostDto;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.service.PostService;
import com.springboot.blog.utils.AppConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.springboot.blog.utils.AppConstant.*;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    private static final Logger logger = LoggerFactory.getLogger(PostServiceImpl.class);

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /**
     *  This method is for saving Post entity to database
     *  @param postDto
     *
     * @return postDto
     * */
    @Override
    public PostDto createPost(PostDto postDto) {
        logger.info("Create Post{}", postDto.getId());
        Post post = mapToEntity(postDto);

        Post newPost = postRepository.save(post);
        return mapToDto(newPost);
    }

    /**
     *  This method is for retrieving all Post from database
     *
     * @return postDto
     * */
    @Override
    public List<PostDto> getAllPost() {
        logger.info("get All Post");
        List<Post> postResponse = postRepository.findAll();
        return postResponse.stream().map(this::mapToDto).toList();
    }

    /**
     *  This method is for get Post entity by id to database
     *  @param id
     *
     * @return postDto
     * */
    @Override
    public PostDto getPostById(Long id) {
        logger.info("get post by id {}", id);
        Post postResponse = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(POST, ID, id));
        return mapToDto(postResponse);
    }

    /**
     *  This method is for updating Post entity to database
     *  @param postDto
     *
     * @return postDto
     * */
    @Override
    public PostDto updatePost(long id, PostDto postDto) {
        logger.info("update post {}", id);
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(POST, ID, id));
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post updatePost = postRepository.save(post);
        return mapToDto(updatePost);
    }

    /**
     * @param id
     */
    @Override
    public void deletePostById(long id) {
        logger.info("update post {}", id);
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(POST, ID, id));
        postRepository.delete(post);
    }

    /**
     *   This method is for converting Post Entity to DTO
     *  @param post - Post Entity
     *
     * @return postDto - Post DTO
     * */
    private PostDto mapToDto(Post post) {
        logger.info("Map to Dto{}", post.getId());
        PostDto postDto = new PostDto();
         BeanUtils.copyProperties(post, postDto);
         return postDto;
    }

    /**
     *   This method is for converting Post DTO to Entity
     *  @param postDto - Post DTO
     *
     * @return post - Post Entity
     * */
    private Post mapToEntity(PostDto postDto) {
        logger.info("Map to Entity{}", postDto.getId());
        Post post = new Post();
        BeanUtils.copyProperties(postDto, post);
        return post;
    }
}
