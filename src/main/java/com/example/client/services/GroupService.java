package com.example.client.services;

import com.example.client.entities.Group;
import com.example.client.entities.User;
import com.example.client.repositories.GroupRepository;
import com.example.client.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Group saveGroup(Group group) {
        return groupRepository.save(group);
    }

    public void deleteGroup(Long groupId) {
        Group group= groupRepository.findById(groupId).orElseThrow(RuntimeException::new);
        groupRepository.delete(group);
    }

    public Optional<Group> getGroupById(Long groupId) {
        return groupRepository.findById(groupId);
    }
}
