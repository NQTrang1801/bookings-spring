package com.bm.bookingair.presentation.dto.res;

import lombok.*;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Validated
public class Address {
    private String street;
    private String city;
    private String country;
}

