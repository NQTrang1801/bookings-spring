package com.bm.bookingair.application.dataModel.customer;

import com.bm.bookingair.common.enums.Gender;
import com.bm.bookingair.application.dataModel.address.AddressData;

import lombok.*;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerData {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String email;
    private String phone;
    private AddressData address;
}
