package com.bm.bookingair.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Airline {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @Column(unique = true, nullable = false)
    private String code;
    private String logo;
}
