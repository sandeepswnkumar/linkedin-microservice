package com.codingshuttle.linkedIn.post_service.controller;

import com.codingshuttle.linkedIn.post_service.service.PostLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/likes")
public class PostLikeController {

    private final PostLikeService postLikeService;

    @PostMapping("/{postId}")
    public ResponseEntity<Void> likePost(@PathVariable Long postId) {
        postLikeService.likePost(postId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{postId}")
    public ResponseEntity<Void> unLikePost(@PathVariable Long postId) {
        postLikeService.unlikePost(postId);
        return ResponseEntity.noContent().build();
    }


}
