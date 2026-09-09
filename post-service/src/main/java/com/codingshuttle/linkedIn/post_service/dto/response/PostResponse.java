package com.codingshuttle.linkedIn.post_service.dto.response;

import java.time.LocalDateTime;

public record PostResponse(
        Long id,
        String title,
        String content,
        LocalDateTime createdAt
) {
}
