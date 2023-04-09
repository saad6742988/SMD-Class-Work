package com.example.myapplication.FragmentExamples.StaticFragmentExample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class DetailsFragment extends Fragment {
    public TextView textView;
    int currentInd = -1, arrayLength;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.contact_detail,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView=getActivity().findViewById(R.id.contactDetailTextView);
        arrayLength = StaticFragmentMainActivity.detailsArray.length;
    }

    public int getShownIndex()
    {
        return currentInd;
    }
    public void ContactIndex(int position)
    {
        if(position<0||position>=arrayLength)
        {
            return;
        }
        currentInd  = position;
        textView.setText(StaticFragmentMainActivity.detailsArray[position]);
    }
}
