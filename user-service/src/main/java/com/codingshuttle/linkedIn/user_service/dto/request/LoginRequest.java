package com.codingshuttle.linkedIn.user_service.dto.request;

public record LoginRequest(
        String email,
        String password
) {
}
