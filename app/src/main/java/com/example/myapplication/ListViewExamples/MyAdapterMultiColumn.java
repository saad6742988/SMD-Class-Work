package com.example.myapplication.ListViewExamples;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;

import java.util.jar.Attributes;

public class MyAdapterMultiColumn extends ArrayAdapter<String> {
    Activity activity;
    String[] name;
    String[] text;
    int image[];

    //constructor
    public MyAdapterMultiColumn(@NonNull Activity activity, String[] name, String[] text, int[] image) {
        super(activity,R.layout.image_and_text,text);
        this.activity = activity;
        this.name = name;
        this.text = text;
        this.image = image;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View viewHolder = inflater.inflate(R.layout.image_and_text,null);
        TextView nametv = viewHolder.findViewById(R.id.txtName);
        TextView texttv = viewHolder.findViewById(R.id.txtMessage);
        ImageView imageView = viewHolder.findViewById(R.id.imgListView);

        nametv.setText(name[position]);
        texttv.setText(text[position]);
        imageView.setImageResource(image[position]);

        return viewHolder;
    }
}
