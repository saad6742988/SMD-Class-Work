package com.example.myapplication.CardViewExample;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.RecyclerViewExample.RecyclerViewAdapter;

import java.util.ArrayList;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<My_model> modelArrayList;

    public CardViewAdapter(Context context, ArrayList<My_model> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_card,parent,false);
//        ViewHolder obj = new ViewHolder(view);
//        return obj;
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        My_model my_model = modelArrayList.get(position);
        holder.name.setText(my_model.getName());
        holder.count.setText(String.valueOf(my_model.getCount()));
        Glide.with(context).load(my_model.getThumbnail()).into(holder.thumbnail);

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView thumbnail;
        TextView name,count;

        public ViewHolder(@NonNull View v) {
            super(v);
            thumbnail = v.findViewById(R.id.imgCardView);
            name=v.findViewById(R.id.txt1_cardview);
            count=v.findViewById(R.id.txt2_cardview);
        }
    }
}
