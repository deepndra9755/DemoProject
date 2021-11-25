package com.test.api.models;

import lombok.*;

import java.util.Map;
import java.util.UUID;

@EqualsAndHashCode
@AllArgsConstructor
@ToString
@Getter
public class EmployeeResponse {
    private final UUID uuid;
    private final String name;
    private final String city;
    private final Integer phone;
    private final Map<String, Object> meta;
}
