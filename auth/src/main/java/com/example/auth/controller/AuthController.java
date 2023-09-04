package com.example.auth.controller;

import com.example.auth.config.TokenInfo;
import com.example.auth.request.LoginRequest;
import com.example.auth.request.SignupRequest;
import com.example.auth.response.LoginResponse;
import com.example.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        return authService.login(loginRequest);
    }
    @PostMapping("/signup")
    public void signup(@RequestBody SignupRequest signupRequest)
    {
        authService.signUp(signupRequest);
    }
    @GetMapping("/me")
    public TokenInfo me(@AuthenticationPrincipal TokenInfo tokenInfo){
        return tokenInfo;
    }

}
