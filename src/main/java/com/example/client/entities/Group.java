package com.example.client.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "`GROUPS`")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GROUP_ID")
    private long id;
    private String name;

    @OneToMany(mappedBy = "group")
    @JsonBackReference
    private Set<UserGroup> userGroups = new HashSet<>();

    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(Set<UserGroup> groups) {
        this.userGroups = groups;
    }

    public void addUserGroup(UserGroup userGroup) {
        this.userGroups.add(userGroup);
    }

}