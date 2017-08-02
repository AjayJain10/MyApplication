package com.example.ajayj.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoggedinActivity extends AppCompatActivity {
    Button logouttxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggedin);


        logouttxt = (Button) findViewById(R.id.logout);

        myown dbhelper = new myown(LoggedinActivity.this);
        SQLiteDatabase database = dbhelper.getWritableDatabase();
        Cursor cursor = dbhelper.readFields(database);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String name, pass;
                int id;
                name = cursor.getString(cursor.getColumnIndex("Username"));
                pass = cursor.getString(cursor.getColumnIndex("Password"));
                id = cursor.getInt(cursor.getColumnIndex("id"));
                Toast.makeText(this,"id is "+id+"\t username is "+name+ " \t password is "+pass, Toast.LENGTH_SHORT).show();
            }
            cursor.close();
            database.close();
            dbhelper.close();
        }

        logouttxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(LoggedinActivity.this, "You are successfully Logged out...!!  ", Toast.LENGTH_SHORT).show();
                Toast.makeText(LoggedinActivity.this, "Please Login again to continue...  ", Toast.LENGTH_SHORT).show();
                Intent homepage2 = new Intent(LoggedinActivity.this, LoginActivity.class);
                startActivity(homepage2);
            }
        });
    }
}
