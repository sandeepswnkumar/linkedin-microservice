package com.codingshuttle.linkedIn.post_service.controller;


import com.codingshuttle.linkedIn.post_service.dto.request.PostCreateRequest;
import com.codingshuttle.linkedIn.post_service.dto.response.PostResponse;
import com.codingshuttle.linkedIn.post_service.entity.Post;
import com.codingshuttle.linkedIn.post_service.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/core")
public class PostController {


    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostResponse> create(@RequestBody PostCreateRequest postCreateRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.create(postCreateRequest, 1L));
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostResponse> getById(@PathVariable("postId") Long postId){
        return ResponseEntity.status(HttpStatus.OK).body(postService.getPostById(postId));
    }

    @GetMapping("/users{userId}/posts")
    public ResponseEntity<List<PostResponse>> getAllPost(@PathVariable("userId") Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(postService.getPosts(userId));
    }
}
