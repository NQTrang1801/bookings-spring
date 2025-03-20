package com.bm.bookingair.presentation.dto.res;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResDTO {
    private UUID customerId;
    private String firstName;
    private String lastName;
    private Sex sex;
    private String email;
    private String phone;
    private Address address;
}
