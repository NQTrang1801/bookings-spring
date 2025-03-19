package com.bm.bookingair.data.address;

import lombok.*;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Validated
public class AddressData {
    private String street;
    private String city;
    private String country;
}
