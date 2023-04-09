package com.example.myapplication.SQLiteExample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class DBQueries extends SQLiteOpenHelper {
    public DBQueries(@Nullable Context context) {
        super(context, "ContactsDB", null,1);
        Log.d("constructor", "Database Created");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d("on_create", "onCreate: ");
        String query = "CREATE TABLE CONTACTS("+
                "_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "firstName TEXT,"+
                "secondName TEXT," +
                "phoneNumber TEXT," +
                "emailAddress TEXT," +
                "homeAddress TEXT)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<HashMap<String, String>> getAllContacts() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<HashMap<String,String>> contactList = new ArrayList<HashMap<String,String>>();
        String query = "SELECT * FROM CONTACTS";
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToNext()){
            do{
                HashMap<String,String> hashMap = new HashMap<String,String>();
                hashMap.put("_id",cursor.getString(0));
                hashMap.put("firstName",cursor.getString(1));
                hashMap.put("secondName",cursor.getString(2));
                hashMap.put("phoneNumber",cursor.getString(3));
                hashMap.put("emailAddress",cursor.getString(4));
                hashMap.put("homeAddress",cursor.getString(5));
                contactList.add(hashMap);
            }while (cursor.moveToNext());
        }
        return contactList;
    }

    public void AddContact(HashMap<String, String> contact) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id",contact.get("_id"));
        contentValues.put("firstName",contact.get("firstName"));
        contentValues.put("secondName",contact.get("secondName"));
        contentValues.put("phoneNumber",contact.get("phoneNumber"));
        contentValues.put("emailAddress",contact.get("emailAddress"));
        contentValues.put("homeAddress",contact.get("homeAddress"));
        long i = db.insert("CONTACTS",null,contentValues);
    }

    public HashMap<String, String> getSingleContact(String id) {
        SQLiteDatabase db = getReadableDatabase();
        HashMap<String,String> hashMap = new HashMap<String,String>();
        String query = "SELECT * FROM CONTACTS WHERE _id ="+id;
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            hashMap.put("_id",cursor.getString(0));
            hashMap.put("firstName",cursor.getString(1));
            hashMap.put("secondName",cursor.getString(2));
            hashMap.put("phoneNumber",cursor.getString(3));
            hashMap.put("emailAddress",cursor.getString(4));
            hashMap.put("homeAddress",cursor.getString(5));
        }
        return hashMap;
    }

    public void updateContact(String id, HashMap<String, String> contact) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("firstName",contact.get("firstName"));
        contentValues.put("secondName",contact.get("secondName"));
        contentValues.put("phoneNumber",contact.get("phoneNumber"));
        contentValues.put("emailAddress",contact.get("emailAddress"));
        contentValues.put("homeAddress",contact.get("homeAddress"));
        long i =db.update("CONTACTS",contentValues,"_id = "+id,null);
    }

    public void deleteContact(String id) {
        SQLiteDatabase db = getWritableDatabase();
        long i = db.delete("CONTACTS","_id = "+id,null);
    }
}
