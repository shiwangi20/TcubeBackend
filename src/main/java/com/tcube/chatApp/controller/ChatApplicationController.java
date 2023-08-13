package com.tcube.chatApp.controller;

import com.tcube.chatApp.model.Connection;
import com.tcube.chatApp.model.ProfileInfo;
import com.tcube.chatApp.services.ConnectionService;
import com.tcube.chatApp.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ChatApplicationController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private ConnectionService connectionService;

    private String userId = "tcube_test_user_1";

    @GetMapping("/")
    public String defaultView() {
        return "Hello Tcube";
    }

    @GetMapping("/profile")
    @CrossOrigin
    public ProfileInfo getProfile() {
        System.out.println("Get Profile for user id: " + userId);
        return userServices.getUserById(userId);
    }

    @GetMapping("/connections")
    @CrossOrigin
    public List<Connection> getConnections() {
        System.out.printf("Get Connections for user id: " + userId);
        return connectionService.getConnections(userId);
    }

    @GetMapping("/chatHistory/{connectionId}")
    @CrossOrigin
    public String getChatHistory() {
        System.out.printf("Get Chat History for user id: " + userId);
        return "Chat History";
    }

}
