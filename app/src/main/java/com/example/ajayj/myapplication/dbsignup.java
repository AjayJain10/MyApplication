package com.example.ajayj.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ajayj on 01-07-2017.
 */

public class dbsignup extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "sql.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Signup";

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (id integer primary key autoincrement,firstname text,lastname text,username text,password text,cnfrmpassword text,code text,mobilenumber text,emailaddress text,date text,securityanstxt text,address text)";
    public static final String DROP_TABLE = "drop table if exists " + TABLE_NAME;


    public dbsignup(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);

    }

    public void savenewUSerDetails(String Firstname, String Lastname, String Username,String Password,String Cnfrmpassword,String Code,String Mobilenumber,String Emailaddress,String Date,String Securityanstxt,String Address,SQLiteDatabase sqlitedatabase)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("firstname", Firstname);
        contentvalues.put("lastname", Lastname);
        contentvalues.put("username", Username);
        contentvalues.put("password", Password);
        contentvalues.put("cnfrmpassword", Cnfrmpassword);
        contentvalues.put("code", Code);
        contentvalues.put("mobilenumber", Mobilenumber);
        contentvalues.put("emailaddress", Emailaddress);
        contentvalues.put("date", Date);
        contentvalues.put("securityanstxt", Securityanstxt);
        contentvalues.put("address", Address);
        sqlitedatabase.insert(TABLE_NAME, null, contentvalues);
    }

    public Cursor readRFields(SQLiteDatabase sqLiteDatabase) {
        String[] projections = {"id","Firstname", "Lastname","Username","Password","Cnfrmpassword","Code","Mobilenumber","Emailaddress","Date","Securityanstxt","Address"};
        return (sqLiteDatabase.query(TABLE_NAME, projections, null, null, null, null, null));
    }


}