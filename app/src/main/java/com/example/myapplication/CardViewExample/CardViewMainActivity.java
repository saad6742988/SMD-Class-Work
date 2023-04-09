package com.example.myapplication.CardViewExample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.R;

import java.util.ArrayList;

public class CardViewMainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<My_model> arrayList=new ArrayList<>();
    CardViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_main);
        recyclerView=findViewById(R.id.myCardViewRecycylerView);
        adapter = new CardViewAdapter(this,arrayList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        insertData();
    }
    public void insertData()
    {
        int[] img = {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,
                R.drawable.five,R.drawable.six,R.drawable.seven};
        My_model obj = new My_model("First",40,img[0]);
        arrayList.add(obj);
        obj = new My_model("Second",40,img[1]);
        arrayList.add(obj);
        obj = new My_model("Third",40,img[2]);
        arrayList.add(obj);
        obj = new My_model("Forth",40,img[3]);
        arrayList.add(obj);
        obj = new My_model("Fifth",40,img[4]);
        arrayList.add(obj);
        obj = new My_model("Sixth",40,img[5]);
        arrayList.add(obj);
        obj = new My_model("Seventh",40,img[6]);
        arrayList.add(obj);
    }
}