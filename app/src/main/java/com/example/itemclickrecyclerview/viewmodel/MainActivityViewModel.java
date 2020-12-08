package com.example.itemclickrecyclerview.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.itemclickrecyclerview.model.ProductInfo;
import com.example.itemclickrecyclerview.repository.ProductInfoRepo;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<ArrayList<ProductInfo>> productInfoList = new MutableLiveData<>();

    public MutableLiveData<ArrayList<ProductInfo>> getProductInfoList() {
        return productInfoList;
    }

    public void fetchProductInfoList() {
        ArrayList<ProductInfo> tempProductInfo = new ArrayList<>();
        tempProductInfo.add(new ProductInfo(100.50, 5));
        tempProductInfo.add(new ProductInfo(107.50, 20));
        tempProductInfo.add(new ProductInfo(109.50, 40));

        productInfoList.setValue(tempProductInfo);
    }


}
