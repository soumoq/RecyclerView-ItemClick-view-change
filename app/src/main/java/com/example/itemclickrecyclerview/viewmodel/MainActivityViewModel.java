package com.example.itemclickrecyclerview.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.itemclickrecyclerview.PackOffRecycler;
import com.example.itemclickrecyclerview.ProductInfo;
import com.example.itemclickrecyclerview.repository.ProductInfoRepo;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<ArrayList<ProductInfo>> mProductInfo;
    private ProductInfoRepo productInfoRepo;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

    public void init() {
        if (mProductInfo != null) {
            return;
        }
        productInfoRepo = ProductInfoRepo.getInstance();
        mProductInfo = productInfoRepo.getProductInfo();

    }

    public void addNewValue(final ProductInfo productInfo) {
        mIsUpdating.setValue(true);
        ArrayList<ProductInfo> currentProduct = mProductInfo.getValue();
        currentProduct.add(productInfo);
        mProductInfo.postValue(currentProduct);
        mIsUpdating.postValue(false);

    }

    public LiveData<ArrayList<ProductInfo>> getProductInfo() {
        return mProductInfo;
    }


    public LiveData<Boolean> getIsUpdating(){
        return mIsUpdating;
    }
}
