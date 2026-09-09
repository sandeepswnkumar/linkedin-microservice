package com.codingshuttle.linkedIn.user_service.controller;

import com.codingshuttle.linkedIn.user_service.dto.request.LoginRequest;
import com.codingshuttle.linkedIn.user_service.dto.request.SignupRequest;
import com.codingshuttle.linkedIn.user_service.dto.response.SignupResponse;
import com.codingshuttle.linkedIn.user_service.service.AuthService;
import com.codingshuttle.linkedIn.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<SignupResponse> signup(@RequestBody SignupRequest signupRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.signup(signupRequest));
    }


    @PostMapping("/login")
    public ResponseEntity<String> signup(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.status(HttpStatus.OK).body(authService.login(loginRequest));
    }


}
