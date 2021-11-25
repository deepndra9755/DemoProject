package com.test.api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class User {

    UUID uuid;
    String firstName;
    String lastLame;
    String phone;
    String hobbies ;
    String description;
    Instant createdAt;
    Instant UpdatedAt;
    List<Address> address;


}
