package com.test.dao.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.Valid;
import java.util.UUID;
@Valid
@AllArgsConstructor
@Getter
@Setter
public class StudentRow {

    @NonNull UUID uuid;
    @NonNull String name;
    @NonNull  String city;
    @NonNull Integer phone;
    @NonNull String marks;

}
