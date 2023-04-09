package com.example.myapplication.RecyclerViewExample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.R;

import java.util.ArrayList;

public class RecyclerViewMainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Mobile> arrayList = new ArrayList<>();
    RecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_main);
        recyclerView = findViewById(R.id.myrecyclerview1);
        adapter = new RecyclerViewAdapter(arrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        insertData();

    }

    public void insertData()
    {
        Mobile m = new Mobile("G20","Nokia",20000);
        arrayList.add(m);
        m = new Mobile("8t","OnePlus",80000);
        arrayList.add(m);
        m = new Mobile("Iphone12","Apple",90000);
        arrayList.add(m);
        m = new Mobile("7t","OnePlus",70000);
        arrayList.add(m);
        m = new Mobile("8t","OnePlus",80000);
        arrayList.add(m);
        m = new Mobile("Iphone12","Apple",90000);
        arrayList.add(m);
        m = new Mobile("7t","OnePlus",70000);
        arrayList.add(m);
        m = new Mobile("8t","OnePlus",80000);
        arrayList.add(m);
        m = new Mobile("Iphone12","Apple",90000);
        arrayList.add(m);
        m = new Mobile("7t","OnePlus",70000);
        arrayList.add(m);

    }
}