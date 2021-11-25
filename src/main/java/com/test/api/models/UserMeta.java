package com.test.api.models;

import com.test.service.models.UserAddressMeta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class UserMeta {

    // UUID uuid;
    String firstName;
    String lastName;
    String phone;
    List<String> hobbies;
    String description;
    Instant createdAt;
    Instant UpdatedAt;
    List<UserAddressMeta> address;

}
