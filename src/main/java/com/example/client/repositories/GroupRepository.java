package com.example.client.repositories;

import com.example.client.entities.Group;
import com.example.client.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    // Additional custom methods
    // ...
}