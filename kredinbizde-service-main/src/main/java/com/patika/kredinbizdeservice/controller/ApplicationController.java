package com.patika.kredinbizdeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.patika.kredinbizdeservice.service.ApplicationService;
import com.patika.kredinbizdeservice.factory.LoanFactory;
import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.model.Loan;
import com.patika.kredinbizdeservice.model.LoanRequest;

import java.util.List;

@RestController
@RequestMapping("api/applications")
public class ApplicationController {
    
    @Autowired
    private ApplicationService applicationService;

    private LoanFactory loanFactory = new LoanFactory();


    @GetMapping("/{email}")
    public List<Application> getApplications(String email) {
        return applicationService.getApplications(email);
    }

    @PostMapping("/{email}/apply/vehicle")
    public ResponseEntity<?> createVehicleLoan(@RequestParam String email, @RequestBody LoanRequest loanRequestBody) {
        try {
            Loan myloan = loanFactory.generateLoan(loanRequestBody.getLoanType(), loanRequestBody.getAmount(), loanRequestBody.getInstallment());
            Application myapp = applicationService.createNewLoanApplication(myloan, email);
            return new ResponseEntity<Application>(myapp, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
