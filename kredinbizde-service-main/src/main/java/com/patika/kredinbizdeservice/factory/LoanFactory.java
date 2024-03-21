package com.patika.kredinbizdeservice.factory;

import com.patika.kredinbizdeservice.enums.LoanType;
import com.patika.kredinbizdeservice.model.ConsumerLoan;
import com.patika.kredinbizdeservice.model.HouseLoan;
import com.patika.kredinbizdeservice.model.Loan;
import com.patika.kredinbizdeservice.model.LoanLimit;
import com.patika.kredinbizdeservice.model.VechileLoan;

import java.math.BigDecimal;
import java.util.Map;
import java.util.List;

import java.util.HashMap;

public class LoanFactory {
    private Map<LoanType, List<LoanLimit>> interestRates = new HashMap<>();

    public LoanFactory() {
        interestRates.put(LoanType.ARAC_KREDISI, List.of(
            new LoanLimit(BigDecimal.valueOf(150000), BigDecimal.valueOf(200000), 1.99, 12),
            new LoanLimit(BigDecimal.valueOf(200000), BigDecimal.valueOf(400000), 2.49, 24),
            new LoanLimit(BigDecimal.valueOf(400000), BigDecimal.valueOf(690000), 3.10, 36)));
        
        interestRates.put(LoanType.IHTIYAC_KREDISI, List.of(
            new LoanLimit(BigDecimal.valueOf(20000), BigDecimal.valueOf(80000), 2.99, 12)));

        interestRates.put(LoanType.KONUT_KREDISI, List.of(
            new LoanLimit(BigDecimal.valueOf(300000), BigDecimal.valueOf(800000), 3.49, 12),
            new LoanLimit(BigDecimal.valueOf(800000), BigDecimal.valueOf(2000000), 3.99, 24),
            new LoanLimit(BigDecimal.valueOf(2000000), BigDecimal.valueOf(10000000), 5.12, 36),
            new LoanLimit(BigDecimal.valueOf(10000000), BigDecimal.valueOf(15000000), 6.55, 48)));
    }
    
    public Loan generateLoan(LoanType loanType, BigDecimal amount, Integer installment) throws Exception { 
        List<LoanLimit> allLimits = interestRates.get(loanType);

        if(allLimits == null) {
            throw new Exception("Loan type not found!");
        }

        List<LoanLimit> mylimits = allLimits.stream()
            .filter(limit -> limit.getInstallment().equals(installment))
            .toList();

        if(mylimits.size() == 0) {
            throw new Exception("Loan not found!");
        }

        for(LoanLimit limit : mylimits) {
            if(amount.compareTo(limit.getMinAmount()) >= 0 && amount.compareTo(limit.getMaxAmount()) <= 0) {
                if(loanType == LoanType.ARAC_KREDISI) {
                    return new VechileLoan(amount, installment, limit.getInterestRate());
                } else if(loanType == LoanType.IHTIYAC_KREDISI) {
                    return new ConsumerLoan(amount, installment, limit.getInterestRate());
                } else if(loanType == LoanType.KONUT_KREDISI) {
                    return new HouseLoan(amount, installment, limit.getInterestRate());
                }
            }
        }

        throw new Exception("There is no suitable loan!");
    }
}
