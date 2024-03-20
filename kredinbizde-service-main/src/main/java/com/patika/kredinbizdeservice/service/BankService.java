package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.Campaign;
import com.patika.kredinbizdeservice.model.CreditCard;

import org.springframework.stereotype.Service;
import com.patika.kredinbizdeservice.repository.BankRepository;
import java.util.List;
import java.util.ArrayList;

@Service
public class BankService {
    private BankRepository bankRepository = new BankRepository();
      
    public List<Bank> getBankDetails() {
        return bankRepository.getAll();
    }

    public List<CreditCard> getCreditCards() { 
        List<Bank> banks = bankRepository.getAll(); 
        List<CreditCard> creditCards = new ArrayList<>();

        for (Bank bank : banks) {
            creditCards.addAll(bank.getCreditCards());
        }

        return creditCards;
    }

    public List<Campaign> getCampaignsAndSort() {
        List<Bank> banks = bankRepository.getAll();
        List<Campaign> campaigns = new ArrayList<>();

        for (Bank bank : banks) {
            for (CreditCard creditCard : bank.getCreditCards()) {
                campaigns.addAll(creditCard.getCampaignList());
            }
        }

        campaigns.sort((c1, c2) -> c2.getCreateDate().compareTo(c1.getCreateDate()));

        return campaigns;
    }
}
