package com.bm.airservice.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "airline_airport_group_configuration")
public class AirlineAirportGroupConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "airline_id", nullable = false)
    private Airline airline;

    @Column(name = "airport_group_id", nullable = false)
    private Integer airportGroupId;

    @Column(name = "created_by", nullable = false)
    private Integer createdBy;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "limit_fee_adt", nullable = false)
    private Double limitFeeAdt = 0.0;

    @Column(name = "limit_fee_chd", nullable = false)
    private Double limitFeeChd = 0.0;

    @Column(name = "limit_fee_inf", nullable = false)
    private Double limitFeeInf = 0.0;

    public AirlineAirportGroupConfiguration() {
    }

    public AirlineAirportGroupConfiguration(Airline airline, Integer airportGroupId, Double limitFeeAdt, Double limitFeeChd, Double limitFeeInf) {
        this.airline = airline;
        this.airportGroupId = airportGroupId;
        this.limitFeeAdt = limitFeeAdt;
        this.limitFeeChd = limitFeeChd;
        this.limitFeeInf = limitFeeInf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Integer getAirportGroupId() {
        return airportGroupId;
    }

    public void setAirportGroupId(Integer airportGroupId) {
        this.airportGroupId = airportGroupId;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Double getLimitFeeAdt() {
        return limitFeeAdt;
    }

    public void setLimitFeeAdt(Double limitFeeAdt) {
        this.limitFeeAdt = limitFeeAdt;
    }

    public Double getLimitFeeChd() {
        return limitFeeChd;
    }

    public void setLimitFeeChd(Double limitFeeChd) {
        this.limitFeeChd = limitFeeChd;
    }

    public Double getLimitFeeInf() {
        return limitFeeInf;
    }

    public void setLimitFeeInf(Double limitFeeInf) {
        this.limitFeeInf = limitFeeInf;
    }
}