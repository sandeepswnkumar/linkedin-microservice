package com.codingshuttle.linkedIn.post_service.service;

import com.codingshuttle.linkedIn.post_service.dto.request.PostCreateRequest;
import com.codingshuttle.linkedIn.post_service.dto.response.PostResponse;
import com.codingshuttle.linkedIn.post_service.entity.Post;
import com.codingshuttle.linkedIn.post_service.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    public PostResponse create(PostCreateRequest postCreateRequest, Long userId) {
        log.info("Creating post for userId={}", userId);
        Post post = modelMapper.map(postCreateRequest, Post.class);
        post.setUserId(userId);
        Post savedPost = postRepository.save(post);
        log.info("Post created successfully with postId={} for userId={}", savedPost.getId(), userId);
        return modelMapper.map(savedPost, PostResponse.class);
    }

    public PostResponse getPostById(Long postId) {
        log.info("Fetching post by postId={}", postId);
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("post not found"));
        log.info("Post found for postId={}", postId);
        return modelMapper.map(post, PostResponse.class);
    }

    public List<PostResponse> getPosts(Long UserId) {
        log.info("Fetching posts for userId={}", UserId);
        List<Post> posts = postRepository.findByUserId(UserId);
        log.info("Found {} posts for userId={}", posts.size(), UserId);
        return posts.stream().map(post -> modelMapper.map(post, PostResponse.class)).toList();
    }
}
