package com.example.myapplication.ServiceExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class ServiceExampleOneMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_example_one_main);
    }

    public void start_Service(View view) {
        Intent intent=new Intent(this,MyServiceExampleOne.class);
        startService(intent);
    }

    public void stop_Service(View view) {
        Intent intent=new Intent(this,MyServiceExampleOne.class);
        stopService(intent);
    }
}