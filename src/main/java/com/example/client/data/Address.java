package com.example.client.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

    private String city;
    private String street_name;
    private String street_address;
    private String zip_code;
    private String state;
    private String country;
}
