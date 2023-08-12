package com.tcube.chatApp.services;

import com.tcube.chatApp.model.User;
import com.tcube.chatApp.utils.GenerateMockData;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    public User createUser(User user) {
        // todo
        return GenerateMockData.createUser();
    }

    public User getUserById(String userId) {
        // todo : integrate with DB
        return GenerateMockData.getUserById(userId);
    }

    public User updateUserById(User user) {
        // todo
        return null;
    }

    public String deleteUserById(String userId) {
        // todo
        return "User - " + userId + " deleted";
    }


}
