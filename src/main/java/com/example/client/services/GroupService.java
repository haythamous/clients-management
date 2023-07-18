package com.example.client.services;

import com.example.client.entities.Group;

import java.util.List;
import java.util.Optional;

public interface GroupService {
    List<Group> getAllGroups();
    Group saveGroup(Group group);
    void deleteGroup(Long groupId);
    Optional<Group> getGroupById(Long groupId);
}
