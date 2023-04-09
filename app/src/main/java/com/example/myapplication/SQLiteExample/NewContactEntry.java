package com.example.myapplication.SQLiteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.HashMap;

public class NewContactEntry extends AppCompatActivity {

    EditText edtfirstname,edtsecondname,edtphonenumber,edtemail,edthomeaddress;
    DBQueries dbQueries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact_entry);
        edtfirstname=findViewById(R.id.edtfirstname);
        edtsecondname=findViewById(R.id.edtsecondname);
        edtphonenumber=findViewById(R.id.edtphonenumber);
        edtemail=findViewById(R.id.edtemail);
        edthomeaddress=findViewById(R.id.edthomeaddress);
        dbQueries = new DBQueries(getApplicationContext());
    }

    public void SaveContact(View view) {
        HashMap<String,String> contact = new HashMap<String,String>();
        contact.put("firstName",edtfirstname.getText().toString());
        contact.put("secondName",edtsecondname.getText().toString());
        contact.put("phoneNumber",edtphonenumber.getText().toString());
        contact.put("emailAddress",edtemail.getText().toString());
        contact.put("homeAddress",edthomeaddress.getText().toString());
        dbQueries.AddContact(contact);
        Toast.makeText(this, "Contact Saved", Toast.LENGTH_SHORT).show();
        edtfirstname.setText("");
        edtsecondname.setText("");
        edtphonenumber.setText("");
        edtemail.setText("");
        edthomeaddress.setText("");
    }
}