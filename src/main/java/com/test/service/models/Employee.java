package com.test.service.models;

import lombok.NonNull;
import lombok.Value;

import javax.validation.Valid;
import java.util.Map;
import java.util.UUID;

@Value
public class Employee {
    @NonNull UUID uuid;
    @NonNull String name;
    @NonNull  String city;
    @NonNull Integer phone;
    @NonNull String meta;
}
