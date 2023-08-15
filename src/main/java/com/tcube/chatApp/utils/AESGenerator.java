package com.tcube.chatApp.utils;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AESGenerator{

    String pw;
    String algorithm;
    SecretKey encKey;
    GCMParameterSpec paramSpec;


    public AESGenerator() throws NoSuchAlgorithmException {
        encKey = EncryptionFields.generateKey(128);;
        paramSpec = EncryptionFields.generateIv();
        algorithm = "AES/GCM/NoPadding";
    }



    public String pEncrypt(String pwd) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {

        this.pw = pwd;

        String pass =  EncryptionFields.encrypt(algorithm, pw, encKey, paramSpec);
        System.out.println("length" + pass.length());
        return pass;
    }

    public String pDecrypt(String pw) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        return EncryptionFields.decrypt(algorithm, pw, encKey, paramSpec);
    }

}
