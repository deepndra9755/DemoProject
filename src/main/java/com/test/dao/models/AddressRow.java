package com.test.dao.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@Getter
@ToString
public class AddressRow {
    UUID uuid;
    UUID uid;
    Integer houseNumber;
    String street;
    String landmark;
    String city;
    String state;
    Integer zipcode;


    public AddressRow(UUID uuid, Integer house_number, String street, String landmark, String city, String state, Integer zipcode) {
        this.uuid = uuid;
        this.houseNumber = house_number;
        this.street = street;
        this.landmark = landmark;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }


}
