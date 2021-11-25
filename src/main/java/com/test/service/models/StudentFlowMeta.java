package com.test.service.models;


import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;

import java.util.Map;
import java.util.UUID;

@Value
@ToString

public class StudentFlowMeta {

        @NonNull UUID uuid;
        @NonNull String name;
        @NonNull  String city;
        @NonNull Integer phone;
        @NonNull Map<String,Object> marks;



}
