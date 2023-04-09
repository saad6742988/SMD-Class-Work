package com.example.myapplication.intentExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class IntentExampleDailpad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_example_dailpad);
    }

    public void openDailPad(View view) {
//        Intent intent = new Intent(Intent.ACTION_DIAL);
//        intent.setData(Uri.parse("tel:+123456789"));
//        startActivity(intent);

//        Intent intent=new Intent(Intent.ACTION_VIEW);
//        intent.setData(Uri.parse("https://www.google.com"));
//        startActivity(intent);

    }
}