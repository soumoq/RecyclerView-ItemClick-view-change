package com.example.itemclickrecyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.itemclickrecyclerview.model.ProductInfo;
import com.example.itemclickrecyclerview.R;
import com.example.itemclickrecyclerview.adapter.ProductInfoAdapter;
import com.example.itemclickrecyclerview.viewmodel.MainActivityViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MainActivityViewModel mainActivityViewModel;
    private ProductInfoAdapter productInfoAdapter;
    private Button add;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        add = findViewById(R.id.button);

        productInfoAdapter = new ProductInfoAdapter(this);
        recyclerView.setAdapter(productInfoAdapter);

        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        mainActivityViewModel.getProductInfoList().observe(this, new Observer<ArrayList<ProductInfo>>() {
            @Override
            public void onChanged(ArrayList<ProductInfo> productInfoList) {
                if (productInfoList != null) {
                    productInfoAdapter.updateData(productInfoList);
                }
            }
        });


        mainActivityViewModel.fetchProductInfoList();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<ProductInfo> temp = new ArrayList<>();
                temp.addAll(mainActivityViewModel.getProductInfoList().getValue());
                temp.add(new ProductInfo(250.5, 5));
                temp.add(new ProductInfo(250.7, 10));
                mainActivityViewModel.getProductInfoList().setValue(temp);
            }
        });
    }

    public void toast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    public void changeData(int position) {
        ArrayList<ProductInfo> temp = new ArrayList<>();
        temp.addAll(mainActivityViewModel.getProductInfoList().getValue());
        temp.get(position).setPrice(4598.2);
        mainActivityViewModel.getProductInfoList().setValue(temp);
    }

    public void changeBackGround(int position) {
        ArrayList<ProductInfo> temp = new ArrayList<>();
        temp.addAll(mainActivityViewModel.getProductInfoList().getValue());
        temp.get(position).setBackgroundChange(true);
        mainActivityViewModel.getProductInfoList().setValue(temp);
    }


}