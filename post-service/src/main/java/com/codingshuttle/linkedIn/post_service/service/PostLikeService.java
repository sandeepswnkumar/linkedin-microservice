package com.codingshuttle.linkedIn.post_service.service;

import com.codingshuttle.linkedIn.post_service.entity.Post;
import com.codingshuttle.linkedIn.post_service.entity.PostLike;
import com.codingshuttle.linkedIn.post_service.repository.PostLikeRepository;
import com.codingshuttle.linkedIn.post_service.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostLikeService {


    private final PostLikeRepository postLikeRepository;
    private final PostRepository postRepository;
    private final Long userId = 1L;

    @Transactional
    public void likePost(Long postId) {
        log.info("Attempting to like postId={} by userId={}", postId, userId);
        postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        Boolean isUserAlreadyLiked = postLikeRepository.existsByUserIdAndUserId(postId, userId);
        if(isUserAlreadyLiked){
            log.warn("User {} already liked post {}", userId, postId);
            throw new RuntimeException("User is already liked");
        }

        PostLike  postLike = new PostLike();
        postLike.setUserId(userId);
        postLike.setPostId(postId);
        postLikeRepository.save(postLike);
        log.info("Post {} liked successfully by user {}", postId, userId);
        //TODO:send notification to owner of the post
    }

    @Transactional
    public void unlikePost(Long postId) {
        log.info("Attempting to unlike postId={} by userId={}", postId, userId);
        postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        Boolean isUserAlreadyLiked = postLikeRepository.existsByUserIdAndUserId(postId, userId);
        if(!isUserAlreadyLiked){
            log.warn("User {} cannot unlike post {} because they haven't liked it", userId, postId);
            throw new RuntimeException("You cannot unlike this post");
        }
        postLikeRepository.deleteByUserIdAndUserId(postId, userId) ;
        log.info("Post {} unliked successfully by user {}", postId, userId);
        //TODO:send notification to owner of the post

    }
}
