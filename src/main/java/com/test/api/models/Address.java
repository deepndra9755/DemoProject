package com.test.api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Address {
public Address()
{
    super();
}
    Integer house_number;
    String street;
    String city;
    String landmark;
    String state;
    Integer zipcode;
}
