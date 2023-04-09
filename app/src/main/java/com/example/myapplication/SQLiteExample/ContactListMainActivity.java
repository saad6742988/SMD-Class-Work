package com.example.myapplication.SQLiteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;

public class ContactListMainActivity extends AppCompatActivity {
    DBQueries dbQueries;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list_main);
        dbQueries = new DBQueries(getApplicationContext());
        listView=findViewById(R.id.list);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ArrayList<HashMap<String,String>> contactList = dbQueries.getAllContacts();
        SimpleAdapter adapter = new SimpleAdapter(this,contactList,
                R.layout.sqlnewlayout,
                new String[]{"firstName","secondName","phoneNumber"},
                new int[]{R.id.txtFirstName,R.id.txtSecondName,R.id.txtPhoneNumber});
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ContactListMainActivity.this,EditContactEntry.class);
                intent.putExtra("id",String.valueOf(i+1));
                startActivity(intent);
            }
        });

    }

    public void AddContact(View view) {
        Intent intent= new Intent(this,NewContactEntry.class);
        startActivity(intent);
    }
}