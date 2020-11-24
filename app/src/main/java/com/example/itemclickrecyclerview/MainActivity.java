package com.example.itemclickrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PackOffRecycler.ItemClickListener {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        View view = getWindow().getDecorView().findViewById(android.R.id.content);

        recyclerView = findViewById(R.id.recycler_view);
        ArrayList<String> name = new ArrayList<>();
        name.add("123");
        name.add("123");
        name.add("123");
        name.add("123");

        PackOffRecycler exampleAdapter = new PackOffRecycler(MainActivity.this, name);
        exampleAdapter.setClickListener(MainActivity.this);
        recyclerView.setAdapter(exampleAdapter);

        /*exampleAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getApplicationContext(), position + "", Toast.LENGTH_LONG).show();
            }
        });*/

    }


    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(MainActivity.this, position + "abc", Toast.LENGTH_LONG).show();
    }
}