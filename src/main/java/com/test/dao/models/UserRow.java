package com.test.dao.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;
import java.time.Instant;
import java.util.UUID;


@AllArgsConstructor
@Valid
@Getter
@ToString
@Setter
public class UserRow {
    UUID uuid;
    String firstName;
    String lastName;
    String phone;
    String hobbies;
    String description;
    Instant createdAt;
    Instant updatedAt;

}
