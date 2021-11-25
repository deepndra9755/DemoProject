package com.test.api.models;



import lombok.Value;

import java.util.Map;
import java.util.UUID;
@Value
public class WorkFlowResponse {
 UUID uuid;
   String name;
    String city;
   Integer phone;
   Map<String,Object>meta;

}
