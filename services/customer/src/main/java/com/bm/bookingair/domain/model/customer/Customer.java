package com.bm.bookingair.domain.model.customer;

import com.bm.bookingair.common.enums.Gender;
import com.bm.bookingair.domain.model.address.Address;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String email;
    private String phone;
    private Address address;
}
