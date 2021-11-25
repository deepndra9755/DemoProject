package com.test.api.models;

import lombok.Getter;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
public class UserRequest {
    String firstName;
    String lastName;
    String phone;
    List<String> hobbies;
    String description;
    List<UserAddressRequest> address;


}
