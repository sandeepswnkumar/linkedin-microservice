package com.codingshuttle.linkedIn.user_service.service;

import com.codingshuttle.linkedIn.user_service.dto.request.LoginRequest;
import com.codingshuttle.linkedIn.user_service.dto.request.SignupRequest;
import com.codingshuttle.linkedIn.user_service.dto.response.SignupResponse;
import com.codingshuttle.linkedIn.user_service.entity.User;
import com.codingshuttle.linkedIn.user_service.repository.UserRepository;
import com.codingshuttle.linkedIn.user_service.util.BCrypt;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final JwtService jwtService;

    public SignupResponse signup(SignupRequest signupRequest){
        Boolean isUserExists = userRepository.existsByEmail(signupRequest.email());
        if(isUserExists){
            throw new RuntimeException("User Already Exists");
        }
        User user = modelMapper.map(signupRequest, User.class);
        user.setPassword(BCrypt.hashString(signupRequest.password()));
        userRepository.save(user);
        return modelMapper.map(user, SignupResponse.class);
    }

    public String login(LoginRequest loginRequest) {
        User user  = userRepository.findByEmail(loginRequest.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if(BCrypt.match(loginRequest.email(), user.getPassword())){
            throw new RuntimeException("Invalid Cred");
        }
        return jwtService.generateAccessToken(user);
    }
}
