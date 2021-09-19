package com.example.regularinstallmentsaving;

import java.math.BigDecimal;

public class SavingAccountDTO {

    private BigDecimal estimatedFinalAmount;
    private Status status;
    private Integer tenor;
    private BigDecimal firstAmount;
    private BigDecimal monthlyAmount;
    private Integer savingId;
    private String purpose;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Integer getSavingId() {
        return savingId;
    }

    public void setSavingId(Integer savingId) {
        this.savingId = savingId;
    }

    public BigDecimal getEstimatedFinalAmount() {
        return estimatedFinalAmount;
    }

    public void setEstimatedFinalAmount(BigDecimal estimatedFinalAmount) {
        this.estimatedFinalAmount = estimatedFinalAmount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getTenor() {
        return tenor;
    }

    public void setTenor(Integer tenor) {
        this.tenor = tenor;
    }

    public BigDecimal getFirstAmount() {
        return firstAmount;
    }

    public void setFirstAmount(BigDecimal firstAmount) {
        this.firstAmount = firstAmount;
    }

    public BigDecimal getMonthlyAmount() {
        return monthlyAmount;
    }

    public void setMonthlyAmount(BigDecimal monthlyAmount) {
        this.monthlyAmount = monthlyAmount;
    }
}
