package com.example.client.data;

import com.example.client.entities.Address;
import com.example.client.entities.UserGroup;

import java.time.LocalDate;
import java.util.List;

public class UserDTO {

    private String fullName;
    private String username;
    private String uid;
    private String password;
    private String email;
    private String gender;

    private String phoneNumber;

    private String avatar;

    private String id;
    private String firstName;
    private String lastName;
    private List<UserGroup> userGroups;

    private LocalDate birthdate;

    private Address address;

    public UserDTO(String fullName, String username, String uid, String password, String email, String gender, String phoneNumber, String avatar, LocalDate birthdate) {
        this.fullName = fullName;
        this.username = username;
        this.uid = uid;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.avatar = avatar;
        this.birthdate = birthdate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(List<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
