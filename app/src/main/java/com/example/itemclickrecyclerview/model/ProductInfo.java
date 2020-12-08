package com.example.itemclickrecyclerview.model;

import android.content.Intent;

public class ProductInfo {
    private Double price;
    private Integer qty;
    private Boolean backgroundChange = false;

    public ProductInfo() {
    }

    public ProductInfo(Double price, Integer qty) {
        this.price = price;
        this.qty = qty;
    }

    public Boolean getBackgroundChange() {
        return backgroundChange;
    }

    public void setBackgroundChange(Boolean backgroundChange) {
        this.backgroundChange = backgroundChange;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
