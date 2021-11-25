package com.test.api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AddressMeta {

    Integer house_number;
    String street;
    String landmark;
    String city;
    String state;
    Integer zipcode;
}
