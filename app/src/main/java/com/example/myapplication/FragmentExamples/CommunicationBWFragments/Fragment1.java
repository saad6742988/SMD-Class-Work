package com.example.myapplication.FragmentExamples.CommunicationBWFragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;


public class Fragment1 extends Fragment {

    ButtonPressListener.OnButtonPressListener buttonPressListener;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        buttonPressListener= (ButtonPressListener.OnButtonPressListener) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_1, container, false);
        myFunction(viewGroup);
        return viewGroup;
    }

    private void myFunction(ViewGroup viewGroup) {
        TextView textView = viewGroup.findViewById(R.id.fragmrntonetextview);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonPressListener.onButtonPressed("message from fragment one");
            }
        });
    }
}