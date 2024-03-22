package com.patika.kredinbizdeservice.model;

import java.math.BigDecimal;

public class LoanLimit {
    private BigDecimal maxAmount;
    private BigDecimal minAmount;
    private Double interestRate;
    private Integer installment;
    private String bank;
 
    public LoanLimit(BigDecimal maxAmount, BigDecimal minAmount, Double interestRate, Integer installment, String bank) {
        this.maxAmount = maxAmount;
        this.minAmount = minAmount;
        this.interestRate = interestRate;
        this.installment = installment;
        this.bank = bank;
    }
    public BigDecimal getMaxAmount() {
        return maxAmount;
    }
    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }
    public BigDecimal getMinAmount() {
        return minAmount;
    }
    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }
    public Double getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }
    public Integer getInstallment() {
        return installment;
    }
    public void setInstallment(Integer installment) {
        this.installment = installment;
    }
    
    public String getBank() {
        return bank;
    }
    public void setBank(String bank) {
        this.bank = bank;
    }
}
