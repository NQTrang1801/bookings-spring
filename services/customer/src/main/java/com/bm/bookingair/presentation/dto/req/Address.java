package com.bm.bookingair.presentation.dto.req;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record Address(
        String street,
        String city,
        String country
) {
}
