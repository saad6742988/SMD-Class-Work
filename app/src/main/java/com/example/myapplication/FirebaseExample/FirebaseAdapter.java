package com.example.myapplication.FirebaseExample;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.CardViewExample.CardViewAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;

public class FirebaseAdapter extends RecyclerView.Adapter<FirebaseAdapter.ViewHolder> {
    ArrayList<Fast_student> studentArrayList;
    Context context;

    public FirebaseAdapter(ArrayList<Fast_student> studentArrayList, Context context) {
        this.studentArrayList = studentArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fast_student student = studentArrayList.get(position);
        holder.textView.setText(student.getName());
        Glide.with(context).load(student.getUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return studentArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;
        public ViewHolder(@NonNull View view) {
            super(view);
            textView = view.findViewById(R.id.firebasetextview);
            imageView = view.findViewById(R.id.firebaseimageview);
        }
    }
}
