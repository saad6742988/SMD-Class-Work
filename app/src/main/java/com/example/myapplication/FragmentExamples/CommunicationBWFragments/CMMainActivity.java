package com.example.myapplication.FragmentExamples.CommunicationBWFragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.R;

public class CMMainActivity extends AppCompatActivity implements ButtonPressListener.OnButtonPressListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmmain);
    }

    @Override
    public void onButtonPressed(String message) {
        Fragment2 obj = (Fragment2) getSupportFragmentManager().findFragmentById(R.id.frag2);
        obj.onFragmentInteraction(message);
    }
}