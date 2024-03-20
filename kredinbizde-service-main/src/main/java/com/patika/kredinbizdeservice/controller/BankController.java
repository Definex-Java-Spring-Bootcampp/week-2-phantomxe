package com.patika.kredinbizdeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patika.kredinbizdeservice.service.BankService;
import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.Campaign;
import com.patika.kredinbizdeservice.model.CreditCard;

import java.util.List;

@RestController
@RequestMapping("api/banks")
public class BankController {
    
    @Autowired
    private BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }
 
    @GetMapping
    public List<Bank> getAll() {
        return bankService.getBankDetails();
    }

    @GetMapping("/creditcards")
    public List<CreditCard> getCreditCards() {
        return bankService.getCreditCards();
    }

    @GetMapping("/campaigns")
    public List<Campaign> getCampaigns() {
        return bankService.getCampaignsAndSort();
    }
}
