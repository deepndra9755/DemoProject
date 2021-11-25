package com.test.api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Map;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestParse {
   @Getter @NonNull Map<String,Object> meta;
}
