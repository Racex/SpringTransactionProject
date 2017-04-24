package com.springcsvproject.model;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Maciej Kulikiewicz on 23.04.2017.
 */
public class TransactionSummary {

    private List<ObjectCsv> objectCSVToSummaryList;

    private final String currency;
    private final String type;
    private Integer price = 0;
    private Integer commission = 0;
    private Integer toChargeValue = 0;
    private Integer settlementValue = 0;

    public TransactionSummary(String currency, String type) {
        this.currency = currency;
        this.type = type;
    }


    public TransactionSummary getSummary(List<ObjectCsv> listOfTransactions) {
        if(listOfTransactions != null) {
            objectCSVToSummaryList = listOfTransactions.stream().filter(x -> x.getCurrency().equals(currency) && x.getType().equals(type)).collect(Collectors.toList());
            setPrice();
            setCommission();
            setToChargeValue();
            setSettlementValue();
        }
        return this;
    }

    private void setSettlementValue() {
        settlementValue = price - commission - toChargeValue;
    }

    private void setToChargeValue() {
        toChargeValue = objectCSVToSummaryList.stream().filter(x -> !x.getIs_paid()).mapToInt(ObjectCsv::getPrice).sum();
    }

    private void setCommission() {
        commission = objectCSVToSummaryList.stream().mapToInt(ObjectCsv::getCommission).sum();
    }

    private void setPrice() {
        price = objectCSVToSummaryList.stream().mapToInt(ObjectCsv::getPrice).sum();
    }

    public String getCurrency() {
        return currency;
    }

    public String getType() {
        return type;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getCommission() {
        return commission;
    }

    public Integer getToChargeValue() {
        return toChargeValue;
    }

    public Integer getSettlementValue() {
        return settlementValue;
    }

    @Override
    public String toString() {
        return "currency:" + currency + "\ntype:" + type + "\nprice:" + price + "\ncommission:" + commission + "\nto_charge_value:" + toChargeValue + "\nsettlement_value:" + settlementValue;
    }


}
