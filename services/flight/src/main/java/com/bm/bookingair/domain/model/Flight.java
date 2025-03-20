package com.bm.bookingair.domain.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Flight {

    @Id
    @GeneratedValue
    private Integer id;

    private String code;
    @ManyToOne
    @JoinColumn(name = "")
    private Airline airline;
}
