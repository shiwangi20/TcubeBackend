package com.tcube.chatApp.controller;

import com.tcube.chatApp.model.LoginRequest;
import com.tcube.chatApp.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserServices userServices;

    @PostMapping(path = "/signup",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity signUp(@RequestBody LoginRequest signUpRequest) {
        System.out.println("Sign Up email:" + signUpRequest.getEmailId());
        return userServices.createUser(signUpRequest.getEmailId(), signUpRequest.getPassword());
    }

    @PostMapping(path = "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity login(@RequestBody LoginRequest loginRequest) {
        System.out.println("Login");
        return userServices.validateUser(loginRequest.getEmailId(), loginRequest.getPassword());
    }

}
