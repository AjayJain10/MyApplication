package com.example.ajayj.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RhomeActivity extends AppCompatActivity {
    Button rlogintext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rhome);

        rlogintext= (Button) findViewById(R.id.rlogintxt);

        rlogintext.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent rhomepage9=new Intent(RhomeActivity.this,RloginActivity.class);
                startActivity(rhomepage9);
            }
        });


    }
}
