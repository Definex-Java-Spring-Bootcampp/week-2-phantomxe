package com.patika.kredinbizdeservice.model;

import com.patika.kredinbizdeservice.enums.LoanType;
import java.math.BigDecimal;

public class LoanRequest {
    private BigDecimal amount;
    private LoanType loanType;
    private Integer installment;

    public LoanRequest(BigDecimal amount, LoanType loanType, Integer installment) {
        this.amount = amount;
        this.loanType = loanType;
        this.installment = installment;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    public Integer getInstallment() {
        return installment;
    }

    public void setInstallment(Integer installment) {
        this.installment = installment;
    }

    
}
