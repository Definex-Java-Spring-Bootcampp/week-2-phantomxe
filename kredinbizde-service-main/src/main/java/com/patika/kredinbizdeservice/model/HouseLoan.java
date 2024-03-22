package com.patika.kredinbizdeservice.model;

import com.patika.kredinbizdeservice.enums.LoanType;

import java.math.BigDecimal;

public class HouseLoan extends Loan {

    private LoanType loanType = LoanType.KONUT_KREDISI;

    public HouseLoan() {

    }

    public HouseLoan(BigDecimal amount, Integer installment, Double interestRate, String bank) {
        super(amount, installment, interestRate, bank);
    }

    public LoanType getLoanType() {
        return loanType;
    }

    @Override
    void calculate(BigDecimal amount, int installment) {

    }
}
