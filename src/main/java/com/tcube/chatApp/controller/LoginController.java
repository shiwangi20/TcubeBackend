package com.tcube.chatApp.controller;

import com.tcube.chatApp.model.LoginRequest;
import com.tcube.chatApp.services.UserServices;
import com.tcube.chatApp.utils.AESGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserServices userServices;

    private final AESGenerator aesGenerator = new AESGenerator();

    public LoginController() throws NoSuchAlgorithmException {
    }

    @CrossOrigin
    @PostMapping(path = "/signup",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity signUp(@RequestBody LoginRequest signUpRequest) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        System.out.println("Sign Up email:" + signUpRequest.getEmailId());
        String password = aesGenerator.pEncrypt(signUpRequest.getPassword());
        System.out.println(aesGenerator.pDecrypt(password));
        return userServices.createUser(signUpRequest.getEmailId(), password);
    }

    @PostMapping(path = "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity login(@RequestBody LoginRequest loginRequest) {
        System.out.println("Login");
        return userServices.validateUser(loginRequest.getEmailId(), loginRequest.getPassword());
    }

}
