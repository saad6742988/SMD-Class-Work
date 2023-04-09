package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        String val1 = intent.getStringExtra("A1");
        String val2 = intent.getStringExtra("A2");
        textView=findViewById(R.id.tview);
        textView.setText(val1+" "+val2);
    }
}