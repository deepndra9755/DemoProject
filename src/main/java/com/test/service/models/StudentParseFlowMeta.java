package com.test.service.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class StudentParseFlowMeta {

@NonNull UUID uuid;
@NonNull Map<String,Object> marks;

}
