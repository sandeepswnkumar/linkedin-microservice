package com.codingshuttle.linkedIn.user_service.dto.request;

public record SignupRequest(
    String name,
    String email,
    String password
) {}
