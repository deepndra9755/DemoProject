package com.test.service.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserAddressMeta {

  //  UUID uuid;
    Integer house_number;
    String street;
    String landmark;
    String city;
    String state;
    Integer zipcode;
}
