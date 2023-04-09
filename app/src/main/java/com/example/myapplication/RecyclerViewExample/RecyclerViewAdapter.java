package com.example.myapplication.RecyclerViewExample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private ArrayList<Mobile> mobileArrayList;

    public RecyclerViewAdapter(ArrayList<Mobile> mobileArrayList) {
        this.mobileArrayList = mobileArrayList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mobile_row,parent,false);
//        ViewHolder obj = new ViewHolder(view);
//        return obj;
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mobile mobile = mobileArrayList.get(position);
        holder.mobileName.setText(mobile.getName());
        holder.mobileCompany.setText(mobile.getCompany());
        holder.mobilePrice.setText(String.valueOf(mobile.getPrice()));

    }


    @Override
    public int getItemCount() {
        return mobileArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView mobileName,mobileCompany,mobilePrice;
        public ViewHolder(@NonNull View v) {
            super(v);
            mobileName = v.findViewById(R.id.txtmobileName);
            mobileCompany = v.findViewById(R.id.txtmobileCompany);
            mobilePrice = v.findViewById(R.id.txtmobilePrice);
        }
    }
}
