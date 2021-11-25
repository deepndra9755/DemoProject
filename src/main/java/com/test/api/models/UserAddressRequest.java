package com.test.api.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class UserAddressRequest {
    Integer house_number;
    String street;
    String landmark;
    String city;
    String state;
    Integer zipcode;
}
