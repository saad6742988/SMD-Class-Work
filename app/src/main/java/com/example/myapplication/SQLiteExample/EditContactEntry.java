package com.example.myapplication.SQLiteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.HashMap;

public class EditContactEntry extends AppCompatActivity {

    EditText edtfirstname,edtsecondname,edtphonenumber,edtemail,edthomeaddress;
    DBQueries dbQueries;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact_entry);

        ///binding
        edtfirstname=findViewById(R.id.editfirstname);
        edtsecondname=findViewById(R.id.editsecondname);
        edtphonenumber=findViewById(R.id.editphonenumber);
        edtemail=findViewById(R.id.editemailaddress);
        edthomeaddress=findViewById(R.id.edithomeaddress);

        dbQueries = new DBQueries(getApplicationContext());

        Intent intent = getIntent();
        id = intent.getExtras().getString("id");
        HashMap<String,String> singleContact = dbQueries.getSingleContact(id);
        setValues(singleContact);
        Log.d("TAG", "onCreate: ");
    }

    private void setValues(HashMap<String, String> singleContact) {
        edtfirstname.setText(singleContact.get("firstName"));
        edtsecondname.setText(singleContact.get("secondName"));
        edtphonenumber.setText(singleContact.get("phoneNumber"));
        edtemail.setText(singleContact.get("emailAddress"));
        edthomeaddress.setText(singleContact.get("homeAddress"));
    }

    public void updateContact(View view) {
        HashMap<String,String> contact = new HashMap<String,String>();
        contact.put("firstName",edtfirstname.getText().toString());
        contact.put("secondName",edtsecondname.getText().toString());
        contact.put("phoneNumber",edtphonenumber.getText().toString());
        contact.put("emailAddress",edtemail.getText().toString());
        contact.put("homeAddress",edthomeaddress.getText().toString());
        dbQueries.updateContact(id,contact);
        Toast.makeText(this, "Contact Updated", Toast.LENGTH_SHORT).show();
        EditContactEntry.this.finish();
    }

    public void deleteContact(View view) {
        dbQueries.deleteContact(id);
        Toast.makeText(this, "Contact Deleted", Toast.LENGTH_SHORT).show();
        EditContactEntry.this.finish();
    }
}