package com.tcube.chatApp.repository;

import com.tcube.chatApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    public User findUserByEmailId(String emailId);
}
