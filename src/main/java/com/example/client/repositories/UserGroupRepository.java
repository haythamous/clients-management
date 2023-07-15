package com.example.client.repositories;

import com.example.client.entities.Group;
import com.example.client.entities.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {
    // Additional custom methods
    // ...
}