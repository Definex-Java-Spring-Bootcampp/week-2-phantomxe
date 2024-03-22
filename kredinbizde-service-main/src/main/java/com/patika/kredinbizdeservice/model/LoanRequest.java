package com.patika.kredinbizdeservice.model;

import com.patika.kredinbizdeservice.enums.LoanType;
import java.math.BigDecimal;

public class LoanRequest {
    private BigDecimal amount;
    private Integer installment;

    public LoanRequest(BigDecimal amount, Integer installment) {
        this.amount = amount; 
        this.installment = installment;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getInstallment() {
        return installment;
    }

    public void setInstallment(Integer installment) {
        this.installment = installment;
    }
}
