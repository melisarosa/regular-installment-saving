package com.example.regularinstallmentsaving;

import java.math.BigDecimal;

public class SavingAccountDTO {

    private BigDecimal estimatedFinalAmount;
    private Status status;
    private Integer tenor;
    private BigDecimal firstAmount;
    private BigDecimal monthlyAmount;
    private Integer savingId;

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
