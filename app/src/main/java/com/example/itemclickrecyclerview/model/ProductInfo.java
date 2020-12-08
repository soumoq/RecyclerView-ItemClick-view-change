package com.example.itemclickrecyclerview.model;

public class ProductInfo {
    private String price;
    private String qty;


    public ProductInfo(String price, String qty) {
        this.price = price;
        this.qty = qty;
    }

    public String getPrice() {
        return price;
    }


    public String getQty() {
        return qty;
    }


}
