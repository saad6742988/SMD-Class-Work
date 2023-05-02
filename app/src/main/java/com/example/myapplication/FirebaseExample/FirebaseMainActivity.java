package com.example.myapplication.FirebaseExample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.myapplication.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FirebaseMainActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference reference;
    TextView textView;
    ArrayList<Fast_student> studentsArrayList;
    RecyclerView recyclerView;
    FirebaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_main);
        recyclerView = findViewById(R.id.firebaseRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
//        textView = findViewById(R.id.textview1);
        database = FirebaseDatabase.getInstance("https://smd-class-4a013-default-rtdb.firebaseio.com/");
        reference = database.getReference("MyDatabase");
        studentsArrayList =new ArrayList<>();
        ReadDataFromFirebase();
//        reference.setValue("this is database");
//        String id = reference.push().getKey();
//        reference.child(id).setValue("ALi");
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                textView.setText(snapshot.getValue().toString());
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
    }

    private void ReadDataFromFirebase() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for (DataSnapshot snapshot:datasnapshot.getChildren())
                {
                    Log.d("data fetch", "onDataChange: ");
                    Fast_student student = new Fast_student();
                    student.setName(snapshot.child("Name").getValue().toString());
                    student.setUrl(snapshot.child("Picture").getValue().toString());
                    studentsArrayList.add(student);

                }
                adapter=new FirebaseAdapter(studentsArrayList,getApplicationContext());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}