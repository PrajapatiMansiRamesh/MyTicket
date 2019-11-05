package com.example.mytiket;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHalper extends SQLiteOpenHelper {

    public DatabaseHalper(Context context) {
        super(context, "Theatre.db", null, 1);
    }
    public static final String table1="Create table user(u_id INTEGER primary key AUTOINCREMENT,email text,password text) ";
    public static final String table2="Create table movie_details(m_id INTEGER primary key AUTOINCREMENT,movie_name text,date text,time text,totalseat INTEGER  DEFAULT 60, amount INTEGER)";
    public static final String table3="Create table theatre(t_id INTEGER primary key AUTOINCREMENT,theatre_name text,location text)";


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(table1);
        db.execSQL(table2);
        db.execSQL(table3);
       // db.execSQL("Create table booking_details(b_id INTEGER primary key AUTOINCREMENT,email text,password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
        db.execSQL("drop table if exists theatre");
        db.execSQL("drop table if exists movie_details");

    }
    public boolean insert(String email,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long ins=db.insert("user",null,contentValues);
        if(ins==-1)return false;
        else return true;
    }
    public Boolean chkemail(String email){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from user where email=?",new String[]{email});
        if(cursor.getCount()>0) return false;
        else return true;
    }
}
