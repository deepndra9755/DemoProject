package com.test.dao.models;

import lombok.NonNull;
import lombok.Value;

import java.util.Map;
import java.util.UUID;

@Value
public class EmployeeRow {
    @NonNull UUID uuid;
    @NonNull String name;
    @NonNull  String city;
    @NonNull Integer phone;
    @NonNull String rowMeta;
}
