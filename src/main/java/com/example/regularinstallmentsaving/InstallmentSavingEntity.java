package com.example.regularinstallmentsaving;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "installment_saving")
public class InstallmentSavingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer tenor;
    private BigDecimal firstDepositAmount;
    private BigDecimal monthlyDepositAmount;
    private String purpose;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Instant creationDate;

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTenor() {
        return tenor;
    }

    public void setTenor(Integer tenor) {
        this.tenor = tenor;
    }

    public BigDecimal getFirstDepositAmount() {
        return firstDepositAmount;
    }

    public void setFirstDepositAmount(BigDecimal firstDepositAmount) {
        this.firstDepositAmount = firstDepositAmount;
    }

    public BigDecimal getMonthlyDepositAmount() {
        return monthlyDepositAmount;
    }

    public void setMonthlyDepositAmount(BigDecimal monthlyDepositAmount) {
        this.monthlyDepositAmount = monthlyDepositAmount;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }



}
