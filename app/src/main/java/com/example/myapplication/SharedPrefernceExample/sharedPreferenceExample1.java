package com.example.myapplication.SharedPrefernceExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class sharedPreferenceExample1 extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    TextView textView;
    ListView myListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference_example1);
        sharedPreferences = getSharedPreferences("MyFile",0);
        textView = findViewById(R.id.txtSharedPref);
        myListView = findViewById(R.id.myListViewSharedPref);
    }

    public void Save_My_Preference(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("A",100);
        editor.putString("B","Ali");
        editor.putString("C","Ahmed");
        editor.putString("D","Umair");
        editor.putString("E","Ammar");
        editor.commit();
        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();

    }

    public void Show_My_Preference(View view) {
        int a = sharedPreferences.getInt("A",0);
        String b = sharedPreferences.getString("B",null);
        String c = sharedPreferences.getString("C",null);
        String d = sharedPreferences.getString("D",null);
        String e = sharedPreferences.getString("E",null);
//        textView.setText(a+" "+b+" "+c+" "+d+" "+e);

        ArrayList<String> myNameList = new ArrayList<>();
        myNameList.add(String.valueOf(a));
        myNameList.add(b);
        myNameList.add(c);
        myNameList.add(d);
        myNameList.add(e);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,myNameList);
        myListView.setAdapter(arrayAdapter);



    }
}