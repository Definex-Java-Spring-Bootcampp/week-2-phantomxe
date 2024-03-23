package com.patika.kredinbizdeservice.dto;

import java.time.LocalDateTime;

import com.patika.kredinbizdeservice.enums.ApplicationStatus;
import com.patika.kredinbizdeservice.model.Loan;

public class LoanResponse {
    private Loan loan;
    private ApplicationStatus applicationStatus;
    private LocalDateTime applicationDate;

    public LoanResponse(Loan loan, ApplicationStatus applicationStatus, LocalDateTime applicationDate) {
        this.loan = loan;
        this.applicationStatus = applicationStatus;
        this.applicationDate = applicationDate;
    }

    public Loan getLoan() {
        return loan;
    }
    public void setLoan(Loan loan) {
        this.loan = loan;
    }
    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }
    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
    public LocalDateTime getApplicationDate() {
        return applicationDate;
    }
    public void setApplicationDate(LocalDateTime applicationDate) {
        this.applicationDate = applicationDate;
    } 
}
