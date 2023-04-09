package com.example.myapplication.intentExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class IntentExampleOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_example_one);
    }

    public void GoToSecondActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("A1","FAST");
        intent.putExtra("A2","National");
        startActivity(intent);
    }
}