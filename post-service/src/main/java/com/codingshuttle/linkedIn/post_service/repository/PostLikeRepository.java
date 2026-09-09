package com.codingshuttle.linkedIn.post_service.repository;

import com.codingshuttle.linkedIn.post_service.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    Boolean existsByUserIdAndUserId(Long postId, Long userId);

    void deleteByUserIdAndUserId(Long postId, Long userId);
}