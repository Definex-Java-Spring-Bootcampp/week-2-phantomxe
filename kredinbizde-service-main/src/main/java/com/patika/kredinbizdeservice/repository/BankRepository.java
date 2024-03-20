package com.patika.kredinbizdeservice.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.patika.kredinbizdeservice.enums.SectorType;
import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.Campaign;
import com.patika.kredinbizdeservice.model.CreditCard;

public class BankRepository {
    private List<Bank> bankList;

    public BankRepository() {
        bankList = new ArrayList<>();

        List<Campaign> campaignList = new ArrayList<>();
        campaignList.add(new Campaign("New Year Shop Campaign", "demo campaign", LocalDate.of(2021, 1, 5), LocalDate.of(2021, 1, 30), LocalDate.of(2021, 1, 30), SectorType.MARKET));
        campaignList.add(new Campaign("New Year Shop Campaign2", "demo campaign2", LocalDate.of(2021, 1, 9), LocalDate.of(2021, 1, 30), LocalDate.of(2021, 1, 30), SectorType.MARKET));
        
        List<Campaign> campaignList2 = new ArrayList<>();
        campaignList2.add(new Campaign("New Year Shop Campaign3", "demo campaign", LocalDate.of(2023, 5, 1), LocalDate.of(2023, 5, 20), LocalDate.of(2023, 5, 20), SectorType.MARKET));

        List<Campaign> campaignList3 = new ArrayList<>();
        campaignList3.add(new Campaign("New Year Shop Campaign3", "demo campaign", LocalDate.of(2010, 1, 1), LocalDate.of(2020, 1, 20), LocalDate.of(2020, 1, 20), SectorType.MARKET));
        campaignList3.add(new Campaign("New Year Shop Campaign4", "demo campaign", LocalDate.of(2021, 2, 1), LocalDate.of(2021, 2, 20), LocalDate.of(2021, 2, 20), SectorType.MARKET));
        campaignList3.add(new Campaign("New Year Shop Campaign5", "demo campaign2", LocalDate.of(2021, 5, 23), LocalDate.of(2021, 10, 20), LocalDate.of(2021, 10, 20), SectorType.MARKET));
        campaignList3.add(new Campaign("New Year Shop Campaign6", "demo campaign3", LocalDate.of(2021, 11, 11), LocalDate.of(2021, 12, 1), LocalDate.of(2021, 12, 1), SectorType.MARKET));

        List<Campaign> campaignList4 = new ArrayList<>();
        campaignList4.add(new Campaign("Electronics Campaign", "demo campaign", LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 31), LocalDate.of(2022, 1, 31), SectorType.OTHERS));

        Bank isBank = new Bank();
        isBank.setName("Isbank");
        isBank.setCreditCards(List.of(
            new CreditCard(BigDecimal.valueOf(150), campaignList, isBank.getName()) 
        )); 
         
        Bank akBank = new Bank();
        akBank.setName("Akbank");
        akBank.setCreditCards(List.of(
            new CreditCard(BigDecimal.valueOf(200), campaignList2, akBank.getName()),
            new CreditCard(BigDecimal.valueOf(250), campaignList3, akBank.getName())
        ));

        Bank garantiBank = new Bank();
        garantiBank.setName("Garanti Bankasi");
        garantiBank.setCreditCards(List.of(
            new CreditCard(BigDecimal.valueOf(110), campaignList4, garantiBank.getName())
        ));

        bankList.addAll(List.of(isBank, akBank, garantiBank));
    }

    public List<Bank> getAll() {
        return bankList;
    }
}
