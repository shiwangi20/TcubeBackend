package com.tcube.chatApp.controller;

import com.tcube.chatApp.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestParam("username") String name, @RequestParam("password") String password, @RequestParam("emailId") String emailId) {
        System.out.printf("Sign Up username:" + name + " email:" + emailId + " emailId:" + emailId);
        userServices.createUser(name, password, emailId);
        return new ResponseEntity("User Added", HttpStatus.OK);
    }

    @PostMapping("/login")
    public void login(@RequestParam("username") String name, @RequestParam("password") String password) {
        System.out.printf("Login");
        userServices.validateUser(name, password);
    }

}
