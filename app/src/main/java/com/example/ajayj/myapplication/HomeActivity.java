package com.example.ajayj.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    Button logintxtbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        logintxtbtn = (Button) findViewById(R.id.logintxt);


        dbsignup dbhelper1 = new dbsignup(HomeActivity.this);
        SQLiteDatabase database1 = dbhelper1.getWritableDatabase();
        Cursor cursor1 = dbhelper1.readRFields(database1);
        if (cursor1.getCount() > 0) {
            while (cursor1.moveToNext()) {
                String fname, lname, uname, pass, cnpass, code, mobnum, email, date, secans, address;
                int id;
                fname = cursor1.getString(cursor1.getColumnIndex("firstname"));
                lname = cursor1.getString(cursor1.getColumnIndex("lastname"));
                uname = cursor1.getString(cursor1.getColumnIndex("username"));
                pass = cursor1.getString(cursor1.getColumnIndex("password"));
                cnpass = cursor1.getString(cursor1.getColumnIndex("cnfrmpassword"));
                code = cursor1.getString(cursor1.getColumnIndex("code"));
                mobnum = cursor1.getString(cursor1.getColumnIndex("mobilenumber"));
                email = cursor1.getString(cursor1.getColumnIndex("emailaddress"));
                date = cursor1.getString(cursor1.getColumnIndex("date"));
                secans = cursor1.getString(cursor1.getColumnIndex("securityanstxt"));
                address = cursor1.getString(cursor1.getColumnIndex("address"));
                id = cursor1.getInt(cursor1.getColumnIndex("id"));
                Toast.makeText(this, "id is " + id + "firstname is " + fname + "lastname is " + lname + "\t username is " + uname + " \t password is " + pass + "cnfrmpassword is " + cnpass + "code is " + code + "mobilenumber is " + mobnum + "emailaddress is " + email + "date is " + date + "securityanstxt is " + secans + "address is " + address, Toast.LENGTH_SHORT).show();
            }
            cursor1.close();
            database1.close();
            dbhelper1.close();


            logintxtbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent ah = new Intent(HomeActivity.this, LoginActivity.class);
                    startActivity(ah);
                }
            });


        }
    }
}
