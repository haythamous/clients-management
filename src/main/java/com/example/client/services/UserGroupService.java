package com.example.client.services;

import com.example.client.entities.UserGroup;

import java.util.List;
import java.util.Optional;

public interface UserGroupService {
    List<UserGroup> getAllUserGroups();
    UserGroup saveUserGroup(UserGroup userGroup);
    void deleteUserGroup(Long groupId);
    Optional<UserGroup> getUserById(Long groupId);
}
