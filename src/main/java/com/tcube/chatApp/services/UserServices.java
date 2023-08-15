package com.tcube.chatApp.services;

import com.tcube.chatApp.model.User;
import com.tcube.chatApp.repository.UserRepository;
import com.tcube.chatApp.utils.AESGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    AESGenerator aesGenerator = new AESGenerator();

    public UserServices() throws NoSuchAlgorithmException {
    }

    public ResponseEntity createUser(String emailId, String password) {
        System.out.println("Find User by Email Id "+ emailId);
        User existingUser = userRepository.findUserByEmailId(emailId);
        if (existingUser != null) {
            System.out.println("User already exists");
            return new ResponseEntity("Email Id already exists", HttpStatus.BAD_REQUEST);
        }
        System.out.println("New User");
        User user = new User();
        user.setPassword(password);
        user.setEmailId(emailId);
        user.setCreatedAt(System.currentTimeMillis() / 1000L);
        userRepository.save(user);
        return new ResponseEntity("User Created", HttpStatus.CREATED);
    }

    public User getUserById(String userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElse(null);
    }

    public User updateUserById(User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(String userId) {
        userRepository.deleteById(userId);
    }


    public ResponseEntity validateUser(String emailId, String password)  {
        User user = userRepository.findUserByEmailId(emailId);
        if (user.getPassword().equals(password)) {
            System.out.println("Valid User");
            return new ResponseEntity("User Logged In", HttpStatus.OK);
        } else {
            return new ResponseEntity("Invalid Creds", HttpStatus.BAD_REQUEST);
        }
    }
}
