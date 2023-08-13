package com.tcube.chatApp.services;

import com.tcube.chatApp.model.User;
import com.tcube.chatApp.repository.UserRepository;
import com.tcube.chatApp.utils.GenerateMockData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public User createUser(String name, String password, String emailId) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmailId(emailId);
        user.setCreatedAt(System.currentTimeMillis() / 1000L);
        userRepository.save(user);
        return user;
    }

    public User getUserById(String userId) {
        // todo : integrate with DB
        return GenerateMockData.getUserById(userId);
    }

    public User updateUserById(User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(String userId) {
        userRepository.deleteById(userId);
    }


    public void validateUser(String name, String password) {

    }
}
