package com.test.dao.models;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
public class StudentRowGen {

    @NonNull UUID uuid;
    @NonNull String name;
    @NonNull  String city;
    @NonNull Integer phone;
    @NonNull Date dates;
    @NonNull String marks;




}
