package com.codingshuttle.linkedIn.user_service.dto.response;

public record SignupResponse(
        Long id,
        String name,
        String email,
        String password
) {}
