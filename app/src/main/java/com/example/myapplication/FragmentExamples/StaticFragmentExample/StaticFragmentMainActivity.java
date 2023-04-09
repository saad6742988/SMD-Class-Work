package com.example.myapplication.FragmentExamples.StaticFragmentExample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.R;

public class StaticFragmentMainActivity extends AppCompatActivity implements contactsFragment.ListSelectionListener {

    public static String[] contactsArray,detailsArray;
    public DetailsFragment detailsFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_fragment_main);
        contactsArray = getResources().getStringArray(R.array.contacts_array);
        detailsArray = getResources().getStringArray(R.array.details_array);
        detailsFragment= (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
    }

    @Override
    public void onSelection(int position) {
        if(detailsFragment.getShownIndex()!=position)
        {
            detailsFragment.ContactIndex(position);
        }
    }
}