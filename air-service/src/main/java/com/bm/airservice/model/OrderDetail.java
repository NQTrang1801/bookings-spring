package com.bm.airservice.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "booking_code", nullable = false)
    private String bookingCode;

    @Column(name = "order_id", nullable = false)
    private Integer orderId;

    @Column(name = "flight_value", nullable = false)
    private String flightValue;

    @Column(name = "number_flight", nullable = false)
    private Integer numberFlight = 1;

    @Column(name = "status", nullable = false)
    private Short status = 1;

    @Column(name = "is_cancel", nullable = false)
    private Boolean isCancel = true;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "number_adt", nullable = false)
    private Integer numberAdt = 0;

    @Column(name = "number_chd", nullable = false)
    private Integer numberChd = 0;

    @Column(name = "number_inf", nullable = false)
    private Integer numberInf = 0;

    @Column(name = "fare_adt", nullable = false)
    private Double fareAdt = 0.0;

    @Column(name = "fare_chd", nullable = false)
    private Double fareChd = 0.0;

    @Column(name = "fare_inf", nullable = false)
    private Double fareInf = 0.0;

    @Column(name = "tax_adt", nullable = false)
    private Double taxAdt = 0.0;

    @Column(name = "tax_chd", nullable = false)
    private Double taxChd = 0.0;

    @Column(name = "tax_inf", nullable = false)
    private Double taxInf = 0.0;

    @Column(name = "fee_adt", nullable = false)
    private Double feeAdt = 0.0;

    @Column(name = "fee_chd", nullable = false)
    private Double feeChd = 0.0;

    @Column(name = "fee_inf", nullable = false)
    private Double feeInf = 0.0;

    @Column(name = "service_fee_adt", nullable = false)
    private Double serviceFeeAdt = 0.0;

    @Column(name = "service_fee_chd", nullable = false)
    private Double serviceFeeChd = 0.0;

    @Column(name = "service_fee_inf", nullable = false)
    private Double serviceFeeInf = 0.0;

    @Column(name = "total_net_price", nullable = false)
    private Double totalNetPrice = 0.0;

    @Column(name = "total_service_fee", nullable = false)
    private Double totalServiceFee = 0.0;

    @Column(name = "total_discount", nullable = false)
    private Double totalDiscount = 0.0;

    @Column(name = "total_commission", nullable = false)
    private Double totalCommission = 0.0;

    @Column(name = "total_price", nullable = false)
    private Double totalPrice = 0.0;

    @Column(name = "currency", nullable = false)
    private String currency = "0.00";

    @Column(name = "promo", nullable = false)
    private Boolean promo = false;

    @Column(name = "airline", nullable = false)
    private String airline;

    @Column(name = "expiry_date", nullable = false)
    private LocalDateTime expiryDate = LocalDateTime.of(2025, 3, 17, 1, 21, 29);

    @Column(name = "session")
    private String session;

    @Column(name = "booking_image", columnDefinition = "LONGTEXT")
    private String bookingImage;

    @Column(name = "issued_by")
    private Integer issuedBy;

    @Column(name = "commission_adt", nullable = false)
    private Double commissionAdt = 0.0;

    @Column(name = "commission_chd", nullable = false)
    private Double commissionChd = 0.0;

    @Column(name = "commission_inf", nullable = false)
    private Double commissionInf = 0.0;

    @Column(name = "commission_total", nullable = false)
    private Double commissionTotal = 0.0;

    @Column(name = "system_commission_adt", nullable = false)
    private Double systemCommissionAdt = 0.0;

    @Column(name = "system_commission_chd", nullable = false)
    private Double systemCommissionChd = 0.0;

    @Column(name = "system_commission_inf", nullable = false)
    private Double systemCommissionInf = 0.0;

    @Column(name = "system_commission_total", nullable = false)
    private Double systemCommissionTotal = 0.0;

    @Column(name = "leg", nullable = false)
    private Integer leg = 0;

    // Getters and Setters

    public OrderDetail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getFlightValue() {
        return flightValue;
    }

    public void setFlightValue(String flightValue) {
        this.flightValue = flightValue;
    }

    public Integer getNumberFlight() {
        return numberFlight;
    }

    public void setNumberFlight(Integer numberFlight) {
        this.numberFlight = numberFlight;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Boolean getCancel() {
        return isCancel;
    }

    public void setCancel(Boolean cancel) {
        isCancel = cancel;
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

    public Integer getNumberAdt() {
        return numberAdt;
    }

    public void setNumberAdt(Integer numberAdt) {
        this.numberAdt = numberAdt;
    }

    public Integer getNumberChd() {
        return numberChd;
    }

    public void setNumberChd(Integer numberChd) {
        this.numberChd = numberChd;
    }

    public Integer getNumberInf() {
        return numberInf;
    }

    public void setNumberInf(Integer numberInf) {
        this.numberInf = numberInf;
    }

    public Double getFareAdt() {
        return fareAdt;
    }

    public void setFareAdt(Double fareAdt) {
        this.fareAdt = fareAdt;
    }

    public Double getFareChd() {
        return fareChd;
    }

    public void setFareChd(Double fareChd) {
        this.fareChd = fareChd;
    }

    public Double getFareInf() {
        return fareInf;
    }

    public void setFareInf(Double fareInf) {
        this.fareInf = fareInf;
    }

    public Double getTaxAdt() {
        return taxAdt;
    }

    public void setTaxAdt(Double taxAdt) {
        this.taxAdt = taxAdt;
    }

    public Double getTaxChd() {
        return taxChd;
    }

    public void setTaxChd(Double taxChd) {
        this.taxChd = taxChd;
    }

    public Double getTaxInf() {
        return taxInf;
    }

    public void setTaxInf(Double taxInf) {
        this.taxInf = taxInf;
    }

    public Double getFeeAdt() {
        return feeAdt;
    }

    public void setFeeAdt(Double feeAdt) {
        this.feeAdt = feeAdt;
    }

    public Double getFeeChd() {
        return feeChd;
    }

    public void setFeeChd(Double feeChd) {
        this.feeChd = feeChd;
    }

    public Double getFeeInf() {
        return feeInf;
    }

    public void setFeeInf(Double feeInf) {
        this.feeInf = feeInf;
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

    public Double getTotalNetPrice() {
        return totalNetPrice;
    }

    public void setTotalNetPrice(Double totalNetPrice) {
        this.totalNetPrice = totalNetPrice;
    }

    public Double getTotalServiceFee() {
        return totalServiceFee;
    }

    public void setTotalServiceFee(Double totalServiceFee) {
        this.totalServiceFee = totalServiceFee;
    }

    public Double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public Double getTotalCommission() {
        return totalCommission;
    }

    public void setTotalCommission(Double totalCommission) {
        this.totalCommission = totalCommission;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getPromo() {
        return promo;
    }

    public void setPromo(Boolean promo) {
        this.promo = promo;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getBookingImage() {
        return bookingImage;
    }

    public void setBookingImage(String bookingImage) {
        this.bookingImage = bookingImage;
    }

    public Integer getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(Integer issuedBy) {
        this.issuedBy = issuedBy;
    }

    public Double getCommissionAdt() {
        return commissionAdt;
    }

    public void setCommissionAdt(Double commissionAdt) {
        this.commissionAdt = commissionAdt;
    }

    public Double getCommissionChd() {
        return commissionChd;
    }

    public void setCommissionChd(Double commissionChd) {
        this.commissionChd = commissionChd;
    }

    public Double getCommissionInf() {
        return commissionInf;
    }

    public void setCommissionInf(Double commissionInf) {
        this.commissionInf = commissionInf;
    }

    public Double getCommissionTotal() {
        return commissionTotal;
    }

    public void setCommissionTotal(Double commissionTotal) {
        this.commissionTotal = commissionTotal;
    }

    public Double getSystemCommissionAdt() {
        return systemCommissionAdt;
    }

    public void setSystemCommissionAdt(Double systemCommissionAdt) {
        this.systemCommissionAdt = systemCommissionAdt;
    }

    public Double getSystemCommissionChd() {
        return systemCommissionChd;
    }

    public void setSystemCommissionChd(Double systemCommissionChd) {
        this.systemCommissionChd = systemCommissionChd;
    }

    public Double getSystemCommissionInf() {
        return systemCommissionInf;
    }

    public void setSystemCommissionInf(Double systemCommissionInf) {
        this.systemCommissionInf = systemCommissionInf;
    }

    public Double getSystemCommissionTotal() {
        return systemCommissionTotal;
    }

    public void setSystemCommissionTotal(Double systemCommissionTotal) {
        this.systemCommissionTotal = systemCommissionTotal;
    }

    public Integer getLeg() {
        return leg;
    }

    public void setLeg(Integer leg) {
        this.leg = leg;
    }
}
