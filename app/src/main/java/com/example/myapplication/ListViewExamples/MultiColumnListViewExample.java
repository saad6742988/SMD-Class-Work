package com.example.myapplication.ListViewExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.R;

public class MultiColumnListViewExample extends AppCompatActivity {

    ListView myListView;
    String[] name = {"Ali","Bilal","Imran", "Saad","Hassaan"};
    String[] text = {"This is Ali","This is Bilal","This is Imran", "This is Saad","This is Hassaan"};
    int image[] = {R.drawable.avatar,R.drawable.avatar,R.drawable.avatar,R.drawable.avatar,R.drawable.avatar};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_column_list_view_example);
        myListView = findViewById(R.id.lstMultiColumn);
        MyAdapterMultiColumn adapterMultiColumn = new MyAdapterMultiColumn(this,name,text,image);
        myListView.setAdapter(adapterMultiColumn);
    }
}