package com.bm.airservice.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "commissions")
public class Commission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "airport_group_id", nullable = false)
    private AirportGroup airportGroup;

    @ManyToOne
    @JoinColumn(name = "airline_id", nullable = false)
    private Airline airline;

    @Column(name = "agency_id", nullable = false)
    private Integer agencyId;

    @Column(name = "service_fee_adt", nullable = false)
    private Double serviceFeeAdt = 0.0;

    @Column(name = "service_fee_chd", nullable = false)
    private Double serviceFeeChd = 0.0;

    @Column(name = "service_fee_inf", nullable = false)
    private Double serviceFeeInf = 0.0;

    @Column(name = "self_service_fee_adt", nullable = false)
    private Double selfServiceFeeAdt = 0.0;

    @Column(name = "self_service_fee_chd", nullable = false)
    private Double selfServiceFeeChd = 0.0;

    @Column(name = "self_service_fee_inf", nullable = false)
    private Double selfServiceFeeInf = 0.0;

    @Column(name = "created_by", nullable = false)
    private Integer createdBy;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT NULL")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT NULL")
    private LocalDateTime updatedAt;

    @Column(name = "last_updated_role", nullable = false)
    private Integer lastUpdatedRole;

    // Constructors
    public Commission() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AirportGroup getAirportGroup() {
        return airportGroup;
    }

    public void setAirportGroup(AirportGroup airportGroup) {
        this.airportGroup = airportGroup;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Integer getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }

    public Double getServiceFeeAdt() {
        return serviceFeeAdt;
    }

    public void setServiceFeeAdt(Double serviceFeeAdt) {
        this.serviceFeeAdt = serviceFeeAdt;
    }

    public Double getServiceFeeChd() {
        return serviceFeeChd;
    }

    public void setServiceFeeChd(Double serviceFeeChd) {
        this.serviceFeeChd = serviceFeeChd;
    }

    public Double getServiceFeeInf() {
        return serviceFeeInf;
    }

    public void setServiceFeeInf(Double serviceFeeInf) {
        this.serviceFeeInf = serviceFeeInf;
    }

    public Double getSelfServiceFeeAdt() {
        return selfServiceFeeAdt;
    }

    public void setSelfServiceFeeAdt(Double selfServiceFeeAdt) {
        this.selfServiceFeeAdt = selfServiceFeeAdt;
    }

    public Double getSelfServiceFeeChd() {
        return selfServiceFeeChd;
    }

    public void setSelfServiceFeeChd(Double selfServiceFeeChd) {
        this.selfServiceFeeChd = selfServiceFeeChd;
    }

    public Double getSelfServiceFeeInf() {
        return selfServiceFeeInf;
    }

    public void setSelfServiceFeeInf(Double selfServiceFeeInf) {
        this.selfServiceFeeInf = selfServiceFeeInf;
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

    public Integer getLastUpdatedRole() {
        return lastUpdatedRole;
    }

    public void setLastUpdatedRole(Integer lastUpdatedRole) {
        this.lastUpdatedRole = lastUpdatedRole;
    }
}