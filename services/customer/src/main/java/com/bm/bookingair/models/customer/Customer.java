package com.bm.bookingair.models.customer;

import com.bm.bookingair.commons.enums.Gender;
import com.bm.bookingair.models.address.Address;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document
public class Customer {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String email;
    private String phone;
    private Address address;
}
