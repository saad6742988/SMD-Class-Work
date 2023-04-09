package com.example.myapplication.ListViewExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.R;

public class ListViewExample1 extends AppCompatActivity {

    ListView myListView;
    String[] myList = {"Samsung","Oppo","Apple","OnePlus","Redmi","Nokia","Google Pixel"};
    Integer[] mobileList = {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,
            R.drawable.five,R.drawable.six,R.drawable.seven};
    ImageView myImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_example1);
        myListView = findViewById(R.id.myListViewExample1);
        myImageView = findViewById(R.id.myLstImageView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,myList);
        myListView.setAdapter(arrayAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(ListViewExample1.this, "Cliked at "+myList[i]+" Position "+i+
//                        " id "+l, Toast.LENGTH_SHORT).show();

                myImageView.setImageResource(mobileList[i]);
            }
        });
    }
}