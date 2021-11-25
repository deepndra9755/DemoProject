package com.test.api.models;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;
import java.util.UUID;

@EqualsAndHashCode
@ToString
@Getter
public class StudentResponse {
        private final UUID uuid;
        private final String name;
        private final String city;
        private final Integer phone;
        private final Map<String, Object> meta;

        public StudentResponse(UUID uuid, String name, String city, Integer phone, Map<String, Object> meta) {
                this.uuid = uuid;
                this.name = name;
                this.city = city;
                this.phone = phone;
                this.meta = meta;
        }
}
