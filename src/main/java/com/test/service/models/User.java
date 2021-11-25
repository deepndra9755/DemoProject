package com.test.service.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.UUID;
@AllArgsConstructor
@Getter
@ToString
public class User {
    UUID uuid;
    String first_name;
    String last_name;
    String phone;
    String hobbies;
    String description;
    Instant created_at;
    Instant Updated_at;
    Integer house_number;
    String city;
    String street;
    String landmark;
    String state;
    Integer zipcode;

}
