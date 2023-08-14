package com.tcube.chatApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.persistence.Column;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfileInfo {
    @JsonInclude(Include.NON_NULL)
    private String username;

    @JsonInclude(Include.NON_NULL)
    private String status;

    @Column(name = "profile_image")
    @JsonInclude(Include.NON_NULL)
    private String profileImage;

    @Column(name = "created_at")
    @JsonInclude(Include.NON_NULL)
    private long createdAt;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "ProfileInfo{" +
                "username='" + username + '\'' +
                ", status='" + status + '\'' +
                ", profileImage='" + profileImage + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
