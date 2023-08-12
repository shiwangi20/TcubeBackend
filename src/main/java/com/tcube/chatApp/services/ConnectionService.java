package com.tcube.chatApp.services;

import com.tcube.chatApp.model.Connection;
import com.tcube.chatApp.model.User;
import com.tcube.chatApp.utils.GenerateMockData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConnectionService {

    public Connection addContact(String userId, User user) {
        // todo
        return null;
    }

    public List<Connection> getConnections(String userId) {
        return GenerateMockData.getConnections(userId);
    }
}
