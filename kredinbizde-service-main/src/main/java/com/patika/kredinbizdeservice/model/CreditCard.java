package com.patika.kredinbizdeservice.model;

import java.math.BigDecimal;
import java.util.List;

public class CreditCard implements Product{

    private BigDecimal fee;
    private List<Campaign> campaignList;
    private String bank;

    public CreditCard(BigDecimal fee, List<Campaign> campaignList, String bank) {
        this.fee = fee;
        this.campaignList = campaignList;
        this.bank = bank;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public List<Campaign> getCampaignList() {
        return campaignList;
    }

    public void setCampaignList(List<Campaign> campaignList) {
        this.campaignList = campaignList;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "fee=" + fee +
                ", campaignList=" + campaignList +
                ", bank=" + bank +
                '}';
    }
}
