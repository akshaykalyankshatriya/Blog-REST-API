package com.springboot.blog.controller;

import com.springboot.blog.entity.Post;
import com.springboot.blog.payload.PostDto;
import com.springboot.blog.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.springboot.blog.utils.AppConstant.*;

@RestController
@RequestMapping(value =BASE_API_ROUTES)
public class PostController {

    private PostService postService;
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(value = POST_GETMAPPING)
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        logger.info("Create Post{}", postDto.getId());
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping(value = POST_GETMAPPING)
    public ResponseEntity<List<PostDto>> getAllPost(){
        logger.info("Get all post");
        return new  ResponseEntity<>(postService.getAllPost(), HttpStatus.OK);
    }

    @GetMapping(value =POST_GETBYID)
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id){
        logger.info("Get post by id");
        return  new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }

    @PutMapping(value = POST_UPDATEBYID)
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto post, @PathVariable(name = ID) long id){
        logger.info("update post");
        return new ResponseEntity<>(postService.updatePost(id, post), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deletePost(@PathVariable(name = ID) long id){
        postService.deletePostById(id);
        return new ResponseEntity<>("post entity deleted successfully", HttpStatus.OK);
    }

}
