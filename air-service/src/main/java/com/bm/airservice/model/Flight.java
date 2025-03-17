package com.bm.airservice.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false, length = 255)
    private String code;

    @Column(name = "airline", nullable = false, length = 255)
    private String airline;

    @Column(name = "departure", length = 255)
    private String departure;

    @Column(name = "arrival", length = 255)
    private String arrival;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "std")
    private LocalDateTime std; // Scheduled Time of Departure

    @Column(name = "sta")
    private LocalDateTime sta; // Scheduled Time of Arrival

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "number", length = 255)
    private String number;

    @Column(name = "duration")
    private Integer duration; // in minutes

    @Column(name = "group_class", length = 255)
    private String groupClass;

    @Column(name = "fare_class", length = 255)
    private String fareClass;

    @Column(name = "promo")
    private Boolean promo;

    @Column(name = "segments", columnDefinition = "LONGTEXT")
    private String segments;

    @Column(name = "hand_baggage", length = 255)
    private String handBaggage;

    @Column(name = "allowance_baggage", length = 255)
    private String allowanceBaggage;

    @Column(name = "operating", length = 255)
    private String operating;

    // Constructors
    public Flight() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getStd() {
        return std;
    }

    public void setStd(LocalDateTime std) {
        this.std = std;
    }

    public LocalDateTime getSta() {
        return sta;
    }

    public void setSta(LocalDateTime sta) {
        this.sta = sta;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getGroupClass() {
        return groupClass;
    }

    public void setGroupClass(String groupClass) {
        this.groupClass = groupClass;
    }

    public String getFareClass() {
        return fareClass;
    }

    public void setFareClass(String fareClass) {
        this.fareClass = fareClass;
    }

    public Boolean getPromo() {
        return promo;
    }

    public void setPromo(Boolean promo) {
        this.promo = promo;
    }

    public String getSegments() {
        return segments;
    }

    public void setSegments(String segments) {
        this.segments = segments;
    }

    public String getHandBaggage() {
        return handBaggage;
    }

    public void setHandBaggage(String handBaggage) {
        this.handBaggage = handBaggage;
    }

    public String getAllowanceBaggage() {
        return allowanceBaggage;
    }

    public void setAllowanceBaggage(String allowanceBaggage) {
        this.allowanceBaggage = allowanceBaggage;
    }

    public String getOperating() {
        return operating;
    }

    public void setOperating(String operating) {
        this.operating = operating;
    }
}
