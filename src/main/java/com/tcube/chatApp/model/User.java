package com.tcube.chatApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

@Table(name = "users")
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends ProfileInfo {

    @Id
    @GeneratedValue
    @Column(name = "userId")
    @JsonIgnore
    private String userId;

    @Column(name = "phone")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String phone;

    @Column(name = "emailId")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String emailId;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
