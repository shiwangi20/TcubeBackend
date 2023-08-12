package com.tcube.chatApp.services;

import com.tcube.chatApp.model.Group;
import com.tcube.chatApp.utils.GenerateMockData;
import org.springframework.stereotype.Service;

@Service
public class GroupServices {

    public Group createGroup(Group group) {
        // todo
        return GenerateMockData.createGroup();
    }

    public Group getGroupById(String groupId) {
        return GenerateMockData.getGroupById(groupId);
    }

}
