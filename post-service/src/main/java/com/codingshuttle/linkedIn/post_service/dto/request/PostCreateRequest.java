package com.codingshuttle.linkedIn.post_service.dto.request;

import jakarta.persistence.Column;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

public record PostCreateRequest(
        String title,
        String content
) {
}
