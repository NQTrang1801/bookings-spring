package com.bm.bookingair.domain.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class AirlineAirportGroupConfiguration {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "airline_id")
    private Airline airline;

    @ManyToOne
    @JoinColumn(name = "airport_group_id")
    private AirportGroup airportGroup;

    private double limitFeeAdt;
    private double limitFeeChd;
    private double limitFeeInf;
}
