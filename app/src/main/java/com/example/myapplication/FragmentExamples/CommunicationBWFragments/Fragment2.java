package com.example.myapplication.FragmentExamples.CommunicationBWFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;


public class Fragment2 extends Fragment {

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_1, container, false);

        return view;
    }

    public void onFragmentInteraction(String message) {
        TextView textView = view.findViewById(R.id.fragmrntonetextview);
        textView.setText(message);
    }
}