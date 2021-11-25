package com.test.api.models;

import com.test.api.mappers.Mapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import javax.validation.Valid;
import java.util.Map;
import java.util.UUID;

@Valid
@AllArgsConstructor
@Getter
public class EmployeeParseFlowMeta {

    @NonNull UUID uuid;
    @NonNull Map<String,Object> meta;
}
