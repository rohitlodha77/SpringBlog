package com.example.blog.Blog.controller;


import com.example.blog.Blog.dto.AuthRequest;
import com.example.blog.Blog.dto.AuthResponse;
import com.example.blog.Blog.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody AuthRequest authRequest) {
        authService.register(authRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
        AuthResponse authResponse = authService.login(authRequest);
        return new ResponseEntity(authResponse, HttpStatus.OK);
    }


}