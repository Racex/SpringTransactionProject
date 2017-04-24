package com.springcsvproject.model;


/**
 * Created by Maciej Kulikiewicz on 23.04.2017.
 */
public class ObjectCsv {
    private Integer id;
    private String type;
    private Integer price;
    private Integer commission;
    private String currency;
    private Boolean is_paid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type.replaceAll("’", "");
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCommission() {
        return commission;
    }

    public void setCommission(Integer commission) {
        this.commission = commission;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency.replaceAll("’", "");
    }

    public Boolean getIs_paid() {
        return is_paid;
    }

    public void setIs_paid(Boolean is_paid) {
        this.is_paid = is_paid;
    }

    public String toString() {
        return id + type + price + commission + currency + is_paid;
    }
}
