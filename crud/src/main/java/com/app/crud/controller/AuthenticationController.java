package com.app.crud.controller;

import com.app.crud.configuration.UserDetailService;
import com.app.crud.dto.AuthLoginRequest;
import com.app.crud.dto.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class AuthenticationController {

    @Autowired
    private UserDetailService userDetailService;

    @PostMapping("/log-in")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthLoginRequest request) {
        return new ResponseEntity<>(this.userDetailService.login(request), HttpStatus.OK);
    }
}
