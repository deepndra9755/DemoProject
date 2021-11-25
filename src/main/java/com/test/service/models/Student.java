package com.test.service.models;

import lombok.*;

import javax.validation.Valid;
import java.util.UUID;

@Valid
@AllArgsConstructor
@Getter
@ToString
public class  Student {
        @NonNull UUID uuid;
        @NonNull String name;
        @NonNull  String city;
        @NonNull Integer phone;
        @NonNull String marks;
    }


