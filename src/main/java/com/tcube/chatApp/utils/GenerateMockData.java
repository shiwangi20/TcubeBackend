package com.tcube.chatApp.utils;

import com.tcube.chatApp.model.Connection;
import com.tcube.chatApp.model.ConnectionType;
import com.tcube.chatApp.model.Group;
import com.tcube.chatApp.model.User;

import java.util.ArrayList;
import java.util.List;

public class GenerateMockData {
    public static int USER_COUNT = 0;
    public static int GROUP_COUNT = 0;

    private static int CONTACT_CONNECTION_COUNT = 2;
    private static int GROUP_CONNECTION_COUNT = 2;

    private static List<User> userList = new ArrayList<>();
    private static List<Group> groupList = new ArrayList<>();

    public static User getUserById(String userID) {
        return userList.stream().filter(user -> user.getUserId().equals(userID)).findFirst().orElse(createUser());
    }

    public static Group getGroupById(String groupId) {
        return groupList.stream().filter(group -> group.getGroupId().equals(groupId)).findFirst().orElse(createGroup());
    }

    public static List<Connection> getConnections(String userId) {
        List<Connection> connectionList = new ArrayList<>();
        List<User> users = userList.stream().filter(user -> !user.getUserId().equals(userId)).toList();
        for (int i = 0; i < CONTACT_CONNECTION_COUNT - users.size(); i++) {
            createUser();
        }
        for (int i = 0; i < CONTACT_CONNECTION_COUNT; i++) {
            Connection connection = new Connection();
            connection.setcType(ConnectionType.CONTACT);
            connection.setId(users.get(i).getUserId());
            connectionList.add(connection);
        }
        int groupListSize = groupList.size();
        for (int i = 0; i < GROUP_CONNECTION_COUNT - groupListSize; i++) {
            createGroup();
        }
        for (int i = 0; i < GROUP_CONNECTION_COUNT; i++) {
            Connection connection = new Connection();
            connection.setcType(ConnectionType.GROUP);
            connection.setId(groupList.get(i).getGroupId());
            connectionList.add(connection);
        }
        return connectionList;
    }

    public static User createUser() {
        User user = new User();
        user.setName("Tcube Test User " + USER_COUNT);
        user.setPassword("pass123");
        user.setPhone("+918427816864");
        user.setEmailId("tcubeTestUser" + USER_COUNT + "@tcube.com");
        user.setUserId("tcube_test_user_" + USER_COUNT);
        user.setProfileImage("https://picsum.photos/200");
        user.setCreatedAt(System.currentTimeMillis() / 1000L);
        userList.add(user);
        USER_COUNT++;
        return user;
    }

    public static Group createGroup() {
        Group group = new Group();
        group.setGroupName("Tcube Test Group " + GROUP_COUNT);
        group.setGroupId("tcube_test_group_" + GROUP_COUNT);
        group.setGroupImage("https://picsum.photos/200");
        group.setCreatedAt(System.currentTimeMillis() / 1000L);
        if (userList.isEmpty()) {
            createUser();
        }
        group.setUserList(userList);
        groupList.add(group);
        GROUP_COUNT++;
        return group;
    }

}
