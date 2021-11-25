package com.test.service.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class UserFlowMeta {
    UUID uuid;
    String first_name;
    String last_name;
    String phone;
    String hobbies;
    String description;
    Instant created_at;
    Instant Updated_at;
}
