package com.example.itemclickrecyclerview.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.itemclickrecyclerview.model.ProductInfo;

import java.util.ArrayList;

public class ProductInfoRepo {
    private static ProductInfoRepo instance;
    private ArrayList<ProductInfo> dataSet = new ArrayList<>();

    public static ProductInfoRepo getInstance() {
        if (instance == null) {
            instance = new ProductInfoRepo();
        }
        return instance;
    }


    public MutableLiveData<ArrayList<ProductInfo>> getProductInfo() {
        setInstance();
        MutableLiveData<ArrayList<ProductInfo>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    private void setInstance() {

    }

}
