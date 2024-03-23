package com.patika.kredinbizdeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.patika.kredinbizdeservice.service.ApplicationService;
import com.patika.kredinbizdeservice.dto.LoanRequest;
import com.patika.kredinbizdeservice.dto.LoanResponse;
import com.patika.kredinbizdeservice.enums.LoanType;
import com.patika.kredinbizdeservice.factory.LoanFactory;
import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.model.Loan;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/applications")
public class ApplicationController {
    
    @Autowired
    private ApplicationService applicationService;

    private LoanFactory loanFactory = new LoanFactory();
    private Map<String, LoanType> loanTypeMap = Map.of(
        "vehicle", LoanType.ARAC_KREDISI,
        "customer", LoanType.IHTIYAC_KREDISI,
        "house", LoanType.KONUT_KREDISI
    );


    @GetMapping("/loans/{email}")
    public List<LoanResponse> getLoanApplications(@PathVariable String email) {
        return applicationService.getApplications(email).stream()
            .filter(application -> application.getProduct() instanceof Loan)
            .map(application -> new LoanResponse((Loan) application.getProduct(), application.getApplicationStatus(), application.getLocalDateTime()))
            .collect(Collectors.toList());
    }

    @GetMapping("/loans/apply")
    public List<String> getAvailableLoanTypes() {
        return loanTypeMap.keySet().stream().collect(Collectors.toList());
    }

    @PostMapping("/loans/apply/{loanTypeName}/{email}")
    public ResponseEntity<?> createVehicleLoan(@PathVariable String email, @PathVariable String loanTypeName, @RequestBody LoanRequest loanRequestBody) {
        if(loanTypeName == null || loanTypeName.isEmpty() || loanTypeMap.get(loanTypeName) == null) {
            return new ResponseEntity<String>("Loan type name is required!", HttpStatus.BAD_REQUEST);
        }

        LoanType loanType = loanTypeMap.get(loanTypeName);
       
        try {
            Loan myloan = loanFactory.generateLoan(loanType, loanRequestBody.getAmount(), loanRequestBody.getInstallment());
            Application myapp = applicationService.createNewLoanApplication(myloan, email);
            LoanResponse loanResponse = new LoanResponse(myloan, myapp.getApplicationStatus(), myapp.getLocalDateTime());
            return new ResponseEntity<LoanResponse>(loanResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
