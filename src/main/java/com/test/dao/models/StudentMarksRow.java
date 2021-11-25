package com.test.dao.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import javax.validation.Valid;
import java.util.UUID;

@Valid
@AllArgsConstructor
@Getter
public class StudentMarksRow {
    @NonNull UUID id;
    @NonNull String marks;
}
