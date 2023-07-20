package com.example.client.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserData {

    private String id;
    private String first_name;
    private String last_name;
    private String email;
    private String username;
    private String password;
    private String uid;
    private String gender;
    private String avatar;
    private String phone_number;
    private String date_of_birth;
    private Subscription subscription;
    private Address address;
}
