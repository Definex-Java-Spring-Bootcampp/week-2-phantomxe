package com.patika.kredinbizdeservice.model;


import com.patika.kredinbizdeservice.enums.LoanType;

import java.math.BigDecimal;
import java.util.List;

public class ConsumerLoan extends Loan {

    private LoanType loanType = LoanType.IHTIYAC_KREDISI;
    private List<Integer> installmentOptions;

    public ConsumerLoan() {

    }

    public ConsumerLoan(BigDecimal amount, Integer installment, Double interestRate, String bank) {
        super(amount, installment, interestRate, bank);
    }

    public LoanType getLoanType() {
        return loanType;
    }

    @Override
    void calculate(BigDecimal amount, int installment) {
        //tc bul, maaşı bul
    }


}
