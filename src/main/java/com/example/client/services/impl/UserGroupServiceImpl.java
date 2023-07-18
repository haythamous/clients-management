package com.example.client.services.impl;

import com.example.client.entities.UserGroup;
import com.example.client.repositories.UserGroupRepository;
import com.example.client.services.UserGroupService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserGroupServiceImpl implements UserGroupService {
    private final UserGroupRepository userGroupRepository;

    public UserGroupServiceImpl(UserGroupRepository userGroupRepository) {
        this.userGroupRepository = userGroupRepository;
    }

    public List<UserGroup> getAllUserGroups() {
        return userGroupRepository.findAll();
    }

    public UserGroup saveUserGroup(UserGroup userGroup) {
        return userGroupRepository.save(userGroup);
    }

    public void deleteUserGroup(Long groupId) {
        UserGroup userGroup= userGroupRepository.findById(groupId).orElseThrow(RuntimeException::new);
        userGroupRepository.delete(userGroup);
    }

    public Optional<UserGroup> getUserById(Long groupId) {
        return userGroupRepository.findById(groupId);
    }
}
