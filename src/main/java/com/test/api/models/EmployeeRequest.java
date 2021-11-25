package com.test.api.models;

import lombok.*;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public final class EmployeeRequest {
    @Getter @NonNull String name;
    @Getter @NonNull String city;
    @Getter @NonNull Integer phone;
    @Getter @NonNull Map<String, Object> meta;

}

