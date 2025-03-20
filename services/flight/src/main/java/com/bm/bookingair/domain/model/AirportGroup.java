package com.bm.bookingair.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class AirportGroup {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "airportGroup")
    private List<Airport> airports;

    @OneToMany(mappedBy = "airportGroup")
    private List<AirlineAirportGroupConfiguration> airportGroupConfigurations;
}
