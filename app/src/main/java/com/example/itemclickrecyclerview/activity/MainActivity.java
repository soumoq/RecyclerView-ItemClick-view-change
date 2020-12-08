package com.example.itemclickrecyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.itemclickrecyclerview.model.ProductInfo;
import com.example.itemclickrecyclerview.R;
import com.example.itemclickrecyclerview.adapter.PackOffRecycler;
import com.example.itemclickrecyclerview.viewmodel.MainActivityViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PackOffRecycler.ItemClickListener {

    private RecyclerView recyclerView;
    private MainActivityViewModel mainActivityViewModel;
    private PackOffRecycler exampleAdapter;
    private Button add;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mainActivityViewModel.init();
        mainActivityViewModel.getProductInfo().observe(this, new Observer<ArrayList<ProductInfo>>() {
            @Override
            public void onChanged(ArrayList<ProductInfo> productInfos) {
                exampleAdapter.notifyDataSetChanged();
            }
        });

        mainActivityViewModel.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    progressBar.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.GONE);
                    recyclerView.smoothScrollToPosition(mainActivityViewModel.getProductInfo().getValue().size() - 1);
                }
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivityViewModel.addNewValue(new ProductInfo("320", "10"));
            }
        });

        View view = getWindow().getDecorView().findViewById(android.R.id.content);


        exampleAdapter = new PackOffRecycler(MainActivity.this, mainActivityViewModel.getProductInfo().getValue());
        exampleAdapter.setClickListener(MainActivity.this);
        recyclerView.setAdapter(exampleAdapter);




        /*exampleAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getApplicationContext(), position + "", Toast.LENGTH_LONG).show();
            }
        });*/

    }


    private void init() {
        recyclerView = findViewById(R.id.recycler_view);
        add = findViewById(R.id.button);
        progressBar = findViewById(R.id.progress_ber);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(MainActivity.this, position + "abc", Toast.LENGTH_LONG).show();
    }
}