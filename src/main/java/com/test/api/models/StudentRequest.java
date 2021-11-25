package com.test.api.models;

import lombok.Getter;
import lombok.NonNull;

import java.util.Map;

public class StudentRequest {

    @Getter
    @NonNull String name;
    @Getter @NonNull String city;
    @Getter @NonNull Integer phone;
    @Getter @NonNull Map<String, Object> marks;

}
